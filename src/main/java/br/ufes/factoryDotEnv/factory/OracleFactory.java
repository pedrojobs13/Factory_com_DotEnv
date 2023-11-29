package br.ufes.factoryDotEnv.factory;

import br.ufes.factoryDotEnv.dao.OracleProdutoDao;
import br.ufes.factoryDotEnv.dao.ProdutoDAO;

public class OracleFactory implements DataBaseTypeFactory {


  @Override
  public ProdutoDAO getProdutoDAO() {
    return new OracleProdutoDao();
  }
}
