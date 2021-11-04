package UD2A4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotaMedia {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";

		try (Connection connection = DriverManager.getConnection(url, user, passwd)) {

			Statement statement = connection.createStatement();
			String query = "SELECT * FROM alumnos;";

			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("----DATOS DE ALUMNOS----");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "." + resultSet.getString("nombre") + ", nota media  "
						+ resultSet.getFloat("notaMedia") + " en curso " + resultSet.getInt("curso"));
			}
			System.out.println("");
			query = "SELECT * FROM alumnos ORDER BY notaMedia desc;";
			resultSet = statement.executeQuery(query);
			
			System.out.println("Alumno mejor nota: ");
			resultSet.absolute(1);
			System.out.println(resultSet.getInt("id") + "." + resultSet.getString("nombre") + ", nota media  "
					+ resultSet.getFloat("notaMedia") + " en curso " + resultSet.getInt("curso"));
			System.out.println("Alumno peor nota: ");
			resultSet.last();
			System.out.println(resultSet.getInt("id") + "." + resultSet.getString("nombre") + ", nota media  "
					+ resultSet.getFloat("notaMedia") + " en curso " + resultSet.getInt("curso"));
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}

}
