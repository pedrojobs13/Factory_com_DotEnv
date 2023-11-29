package br.ufes.factoryDotEnv.dao;

import br.ufes.factoryDotEnv.model.Produto;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MysqlProdutoDao implements ProdutoDAO {

  private Connection connection;
  private List<Produto> produtos = new ArrayList<>();

  public MysqlProdutoDao() {
    try {
      connection = DriverManager.getConnection(
          Dotenv.configure().load().get("MY_ENV_MYSQL"));
      String sql =
          "CREATE TABLE IF NOT EXISTS produto (\n"
              + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
              + "	nome text NOT NULL,\n"
              + "	valor double NOT NULL\n"
              + ");";

      Statement stmt = connection.createStatement();
      stmt.execute(sql);
    } catch (SQLException e) {
      throw new IllegalArgumentException("Não foi possível conectar ao banco");
    }
  }

  @Override
  public void inserir(Produto produto) {
    if (produto == null) {
      throw new RuntimeException("Produto é nulo");
    }
    String sql = "INSERT INTO produto(nome, valor) VALUES (?, ?)";

    try {
      PreparedStatement pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, produto.getNome());
      pstmt.setDouble(2, produto.getValor());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException("não foi possível inserir");
    }
  }

  @Override
  public void atualizar(Produto produto, int id) {
    String sql = "UPDATE produto SET nome = ?, " + "valor = ? " + "WHERE id = ?";

    try {
      PreparedStatement pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, produto.getNome());
      pstmt.setDouble(2, produto.getValor());
      pstmt.setInt(3, id);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException("Não foi possível atualizar objeto, pois o mesmo não existe");
    }
  }

  @Override
  public void deletar(int id) {
    String sql = "DELETE FROM produto WHERE id = ?";

    try {
      PreparedStatement pstmt = connection.prepareStatement(sql);

      pstmt.setInt(1, id);
      pstmt.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public List<Produto> listar() {
    String sql = "SELECT * FROM produtos ";
    List<Produto> produtos = new ArrayList<>();
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        produtos.add(new Produto(rs.getString("nome"), rs.getDouble("valor")));
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return Collections.unmodifiableList(produtos);
  }
}
