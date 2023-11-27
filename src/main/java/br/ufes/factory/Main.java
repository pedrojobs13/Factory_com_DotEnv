package br.ufes.factory;

import br.ufes.factory.dao.ProdutoDAO;
import br.ufes.factory.factory.OracleFactory;
import br.ufes.factory.factory.DataBaseTypeFactory;
import br.ufes.factory.model.Produto;
import br.ufes.factory.service.ProdutoService;

public class Main {

  public static void main(String[] args) {
    ProdutoService produtoService = new ProdutoService("MYSQL");
    produtoService.adicionarProduto("camiseta", 20);
  }
}
