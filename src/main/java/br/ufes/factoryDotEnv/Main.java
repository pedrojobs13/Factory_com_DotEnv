package br.ufes.factoryDotEnv;

import br.ufes.factoryDotEnv.service.ProdutoService;

public class Main {

  public static void main(String[] args) {
    ProdutoService produtoService = new ProdutoService("ORACLE");
    produtoService.adicionarProduto("camiseta", 20);
  }
}
