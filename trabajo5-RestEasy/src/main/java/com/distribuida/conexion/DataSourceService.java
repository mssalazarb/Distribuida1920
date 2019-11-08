package com.distribuida.conexion;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceService{

    private static BasicDataSource basicDataSource=null;
    private String user = "postgres";
    private String pass = "Uce12394";

    public DataSourceService(){
         if (null==basicDataSource){
             basicDataSource = new BasicDataSource();
             basicDataSource.setDriverClassName("org.postgresql.Driver");
             basicDataSource.setUsername(user);
             basicDataSource.setPassword(pass);
             basicDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/tarea4CDI");
             basicDataSource.setMaxActive(200);
             basicDataSource.setMinIdle(50);
             basicDataSource.setMaxIdle(100);
         }
     }

     public BasicDataSource getDataSource(){
         return basicDataSource;
     }
}
