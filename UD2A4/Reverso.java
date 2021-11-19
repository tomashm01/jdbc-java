package UD2A4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reverso {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";

		try (Connection connection = DriverManager.getConnection(url, user, passwd)) {

			Statement statement = connection.createStatement();
			String query = "SELECT * FROM alumnos;";

			ResultSet resultSet = statement.executeQuery(query);
			resultSet.afterLast();
			while (resultSet.previous()) {
				System.out.println(resultSet.getInt("id") + "." + resultSet.getString("nombre") + ", nota media  "
						+ resultSet.getFloat("notaMedia")+" en curso "+resultSet.getInt("curso"));
			}
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}

}
