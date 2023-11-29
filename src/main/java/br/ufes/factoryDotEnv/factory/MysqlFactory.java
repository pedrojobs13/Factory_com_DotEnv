package br.ufes.factoryDotEnv.factory;

import br.ufes.factoryDotEnv.dao.MysqlProdutoDao;
import br.ufes.factoryDotEnv.dao.ProdutoDAO;

public class MysqlFactory implements DataBaseTypeFactory {

  @Override
  public ProdutoDAO getProdutoDAO() {
    return new MysqlProdutoDao();
  }
}
