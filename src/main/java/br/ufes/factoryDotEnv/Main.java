package br.ufes.factoryDotEnv;

import br.ufes.factoryDotEnv.model.Produto;
import br.ufes.factoryDotEnv.service.ProdutoService;
import java.lang.reflect.InvocationTargetException;

public class Main {

  public static void main(String[] args) {

    try {
      ProdutoService produtoService = new ProdutoService();
      produtoService.adicionarProduto("camiseta", 20);

      for (Produto produto: produtoService.listarTodosProdutos()) {
        System.out.println(produto.getNome());
      }

    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
             InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
    }

  }
}
