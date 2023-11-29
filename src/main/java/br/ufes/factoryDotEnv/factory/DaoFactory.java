package br.ufes.factoryDotEnv.factory;

import java.lang.reflect.InvocationTargetException;

public class DaoFactory {

  public DataBaseTypeFactory getSqlType(String dataBaseType) {
    if (dataBaseType == null) {
      throw new RuntimeException("");
    }

    if (dataBaseType.equalsIgnoreCase("MYSQL")) {
      return new MysqlFactory();
    } else if (dataBaseType.equalsIgnoreCase("ORACLE")) {
      return new OracleFactory();
    }
    throw new IllegalArgumentException("Nenhum SGBD escolhido");
  }
}
