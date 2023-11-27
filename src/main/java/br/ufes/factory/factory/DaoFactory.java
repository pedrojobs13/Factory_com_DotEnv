package br.ufes.factory.factory;

public class DaoFactory {

  public DataBaseTypeFactory getSqlType(String dataBaseType) {
    if (dataBaseType == null) {
      throw new RuntimeException("");
    }

    if (dataBaseType.equalsIgnoreCase("MYSQL")) {
      return new MySQLFactory();
    } else if (dataBaseType.equalsIgnoreCase("ORACLE")) {
      return new OracleFactory();
    }
    throw new IllegalArgumentException("Nenhum SGBD escolhido");
  }
}
