package br.ufes.factory.factory;

import br.ufes.factory.dao.ProdutoDAO;

public interface DataBaseTypeFactory {
  ProdutoDAO getProdutoDAO();
}
