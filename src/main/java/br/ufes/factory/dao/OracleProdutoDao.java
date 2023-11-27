package br.ufes.factory.dao;

import br.ufes.factory.model.Produto;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OracleProdutoDao implements ProdutoDAO {

  private Connection connection;
  private List<Produto> produtos = new ArrayList<>();

  public OracleProdutoDao() {
    try {
      connection = DriverManager.getConnection(
          Dotenv.configure().load().get("MY_ENV_ORACLE"));

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
    System.out.println("Esse é da oracle");
  }

  @Override
  public void atualizar(Produto produto, int id) {

  }

  @Override
  public void deletar(int id) {

  }

  @Override
  public List<Produto> listar() {
    return Collections.unmodifiableList(produtos);
  }
}
