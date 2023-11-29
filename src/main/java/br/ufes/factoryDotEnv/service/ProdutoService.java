package br.ufes.factoryDotEnv.service;

import br.ufes.factoryDotEnv.dao.ProdutoDAO;
import br.ufes.factoryDotEnv.factory.DaoFactory;
import br.ufes.factoryDotEnv.model.Produto;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ProdutoService {

  private ProdutoDAO produtoDAO;
  private DaoFactory daoFactory = new DaoFactory();

  public ProdutoService()
      throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
    produtoDAO = daoFactory.getSqlType().getProdutoDAO();
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
