package br.ufes.factory.service;

import br.ufes.factory.dao.ProdutoDAO;
import br.ufes.factory.factory.DaoFactory;
import br.ufes.factory.model.Produto;
import java.util.List;

public class ProdutoService {

  private ProdutoDAO produtoDAO;
  private DaoFactory daoFactory = new DaoFactory();

  public ProdutoService(String dataBaseType) {
    String dataBase = "";
    produtoDAO = daoFactory.getSqlType(dataBaseType).getProdutoDAO();
    dataBase = daoFactory.getSqlType(dataBaseType).getProdutoDAO().getClass().getSimpleName();
    System.out.println(
        "O Banco de dados selecionado foi o " + dataBase.substring(0, dataBase.length() - 10));
  }

  public void adicionarProduto(String nome, double valor) {
    Produto produto = new Produto(nome, valor);
    produtoDAO.inserir(produto);
  }

  public List<Produto> listarTodosProdutos() {
    return produtoDAO.listar();
  }

  public void atualizarProduto(Produto produto, int id) {
    produtoDAO.atualizar(produto, id);
  }

  public void apagarProduto(int id) {
    produtoDAO.deletar(id);
  }
}
