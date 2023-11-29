package br.ufes.factoryDotEnv.factory;

import io.github.cdimascio.dotenv.Dotenv;
import java.lang.reflect.InvocationTargetException;

public class DaoFactory {

  public DataBaseTypeFactory getSqlType()
      throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
    String dataBaseType = Dotenv.configure().load().get("MY_ENV_BD");

    dataBaseType = dataBaseType.substring(0, 1).toUpperCase() + dataBaseType.substring(1);
    Class<?> dataBaseTypeFactoryClass = Class.forName(
        "br.ufes.factoryDotEnv.factory." + dataBaseType + "Factory");

    return (DataBaseTypeFactory) dataBaseTypeFactoryClass.getConstructor().newInstance();
  }
}
