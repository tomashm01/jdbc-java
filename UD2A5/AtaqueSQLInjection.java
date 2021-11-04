package UD2A5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AtaqueSQLInjection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";
		try (Connection connection = DriverManager.getConnection(url, user, passwd)) {

			Statement statement = connection.createStatement();
			String nombre="pepe";
			String clave="\"' or 0=0 #\"";
			String consulta = "delete from alumnos where nombre='"
					 + nombre + "' and '" + clave + "'";
			
			statement=connection.createStatement();
			int nombresEliminados=statement.executeUpdate(consulta);
			System.out.println("Se han eliminado "+nombresEliminados+" nombres");
			
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}

}
