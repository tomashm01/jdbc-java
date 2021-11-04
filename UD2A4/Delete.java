package UD2A4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";

		try (Connection connection = DriverManager.getConnection(url, user, passwd)) {

			Statement statement = connection.createStatement();
			String query = "DELETE FROM alumnos where curso=2;";
			
			int regEliminados= statement.executeUpdate(query);
			System.out.println("Se han eliminado "+ regEliminados +" de la bbdd");
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}

}