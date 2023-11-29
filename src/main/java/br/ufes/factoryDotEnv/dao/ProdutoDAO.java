package br.ufes.factoryDotEnv.dao;

import br.ufes.factoryDotEnv.model.Produto;
import java.util.List;

public interface ProdutoDAO {

  void inserir(Produto produto);

  void atualizar(Produto produto, int id);

  void deletar(int id);

  List<Produto> listar();
}
