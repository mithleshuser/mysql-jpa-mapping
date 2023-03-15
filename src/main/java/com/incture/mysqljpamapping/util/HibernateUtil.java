/*
package com.incture.mysqljpamapping.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
  private static SessionFactory sessionFactory;

  static {
    Configuration configuration = new Configuration();

    //configuration.addAnnotatedClass (com.incture.mysqljpamapping.Entity);
    configuration.setProperty("connection.driver_class","com.mysql.jdbc.Driver");
    configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/erp");
    configuration.setProperty("hibernate.connection.username", "root");     
    configuration.setProperty("hibernate.connection.password", "root");
    configuration.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
    configuration.setProperty("hibernate.hbm2ddl.auto", "update");
    configuration.setProperty("show_sql", "true");
    configuration.setProperty(" hibernate.connection.pool_size", "10");

    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    sessionFactory = configuration.buildSessionFactory(builder.build());
  }

  public static SessionFactory getSessionFactory() {
     return sessionFactory;
  }
}*/
