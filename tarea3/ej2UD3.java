package tarea3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ej2UD3 {
	public static void main(String[] args) throws ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";

		try (Connection connection = DriverManager.getConnection(url, user, passwd)) {

			Statement statement = connection.createStatement();
			String query = "SELECT * FROM usuario;";

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "." + resultSet.getString("nombre") + " "
						+ resultSet.getString("apellidos"));
			}
		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}
}