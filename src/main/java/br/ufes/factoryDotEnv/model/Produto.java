package br.ufes.factoryDotEnv.model;

import java.util.Objects;

public class Produto {

  private String nome;
  private double valor;
  private static int count = 1;
  private int id;

  public Produto(String nome, double valor) {
    Objects.requireNonNull(nome);
    setId(count++);
    this.nome = nome;
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public double getValor() {
    return valor;
  }

  public int getId() {
    return id;
  }

  private void setId(int id) {
    this.id = id;
  }
}
