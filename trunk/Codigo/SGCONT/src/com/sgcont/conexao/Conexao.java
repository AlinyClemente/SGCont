package com.sgcont.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static String status="";

	public static Connection getConnection(){
		Connection conn = null;
		try{
			String url = "jdbc:postgresql://192.168.64.220:5432/sgcont";  
			String usuario = "sgcont";  
			String senha = "sg$cont";  

			Class.forName("org.postgresql.Driver");  

			conn = DriverManager.getConnection(url, usuario, senha);  

			System.out.println("Conexão realizada com sucesso.");

			status = "Connection opened";
		}catch (SQLException e) {
			status = e.getMessage();
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			status = e.getMessage();
			e.printStackTrace();
		}catch(Exception e){
			status = e.getMessage();
			e.printStackTrace();
		}

		return conn;
	}
}
