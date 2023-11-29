package br.ufes.factoryDotEnv.factory;

import br.ufes.factoryDotEnv.dao.ProdutoDAO;

public interface DataBaseTypeFactory {
  ProdutoDAO getProdutoDAO();
}
