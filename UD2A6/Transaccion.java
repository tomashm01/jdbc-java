package UD2A6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaccion {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";

		try (Connection connection = DriverManager.getConnection(url, user, passwd)) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into alumnos(id,nombre,notaMedia,curso) values(null,\"Juan\",7,1)");
			statement.executeUpdate("insert into alumnos(id,nombre,notaMedia,curso) values(null,\"Pepe\",5,2)");
			statement.executeUpdate("insert into alumnos(id,nombre,notaMedia,curso) values(null,\"Pedro\",6,3)");
			statement.executeUpdate("insert into alumnos(id,nombre,notaMedia,curso) values(null,\"Sergio\",9,2)");
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}

}