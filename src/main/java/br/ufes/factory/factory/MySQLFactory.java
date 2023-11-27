package br.ufes.factory.factory;

import br.ufes.factory.dao.MySQLProdutoDao;
import br.ufes.factory.dao.ProdutoDAO;

public class MySQLFactory implements DataBaseTypeFactory {

  @Override
  public ProdutoDAO getProdutoDAO() {
    return new MySQLProdutoDao();
  }
}
