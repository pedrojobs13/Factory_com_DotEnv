package br.ufes.factory.factory;

import br.ufes.factory.dao.OracleProdutoDao;
import br.ufes.factory.dao.ProdutoDAO;

public class OracleFactory implements DataBaseTypeFactory {


  @Override
  public ProdutoDAO getProdutoDAO() {
    return new OracleProdutoDao();
  }
}
