package com.distribuida.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

	public ConexionDB() {

	}

	public Connection getConexion() {

		Connection conexion = null;
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager
					.getConnection("jdbc:postgresql://127.0.0.1:5432/tarea4CDI", "postgres",
					"Uce12394");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public void cerrarConexion(Connection conexion) {
		
		try {
			if(conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
