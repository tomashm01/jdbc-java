package UD2A7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Empleado {
	private String nombre;
	private int edad;
	private int telefono;

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hlc";
		String user = "root";
		String passwd = "";
		ResultSet rs = null;
		try (Connection conexion = DriverManager.getConnection(url, user, passwd)) {

			Empleado empleado = new Empleado();
			int opcion=0;
			Scanner s=new Scanner(System.in);
			String nombre;
			int edad=0;
			int telefono=0;
			int id=0;
			do {
				System.out.println("---MENU---");
				System.out.println("1.Insertar datos");
				System.out.println("2.Leer datos");
				System.out.println("3.Actualizar datos");
				System.out.println("4.Eliminar datos");
				System.out.println("5.Salir");
				opcion=s.nextInt();
				s.nextLine();
				switch(opcion) {
					case 1:// Inserción datos
						
						System.out.println("Introduce nombre: ");
						nombre=s.nextLine();
						System.out.println("Introduce edad");
						edad=s.nextInt();
						s.nextLine();
						System.out.println("Introduce telefono");
						telefono=s.nextInt();
						s.nextLine();
						
						if (empleado.create(conexion, nombre, edad, telefono)) {
							System.out.println("Registro añadido");
						}
						
						break;
					case 2://Lectura datos
			
						rs = empleado.read(conexion);
						while (rs.next()) {
							System.out.println("Id: " + rs.getInt("id") + "." + rs.getString("nombre") + " con edad "
									+ rs.getInt("edad") + " y telefono " + rs.getInt("telefono"));
						}
						
						break;
					case 3://Actualizar datos
						System.out.println("Introduce id");
						id=s.nextInt();
						s.nextLine();
						System.out.println("Introduce nombre: ");
						nombre=s.nextLine();
						System.out.println("Introduce edad");
						edad=s.nextInt();
						s.nextLine();
						System.out.println("Introduce telefono");
						telefono=s.nextInt();
						s.nextLine();
						
						if(empleado.update(conexion, id, nombre, edad, telefono)) {
							System.out.println("Actualización realizada correctamente");
						}else {
							System.out.println("Actualización no realizada correctamente");
						}
						
						break;
					case 4://Eliminar datos
						
						System.out.println("Introduce id");
						id=s.nextInt();
						s.nextLine();
						
						if(empleado.delete(conexion, id)) {
							System.out.println("Registro eliminado correctamente");
						}else {
							System.out.println("Registro no eliminado correctamente");
						}
						
						break;
					case 5://Salir
						System.out.println("Hasta luego");
						break;
					default:
						System.out.println("Elige una opcion entre 1 y 5");
						break;
				}
				
			}while(opcion!=5);			

		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}

	public boolean create(Connection connection, String nombre, int edad, int telefono) throws SQLException {
		// Si el telefono tiene menos de 9 digitos
		if (Integer.toString(telefono).length() < 9)
			return false;

		// Si el nombre tiene más de 30 caracteres
		if (nombre.length() > 30 || nombre.length() == 0)
			return false;

		// Si la edad es negativa o demasiado alta
		if (edad < 0 || edad > 130)
			return false;

		PreparedStatement statement = connection.prepareStatement("INSERT INTO Empleado values (null,?,?,?)");
		statement.setString(1, nombre);
		statement.setInt(2, edad);
		statement.setInt(3, telefono);

		int resultado = statement.executeUpdate();

		if (resultado != 1) {
			return false;
		}
		return true;
	}

	public ResultSet read(Connection conexion) throws SQLException {
		PreparedStatement statement = conexion.prepareStatement("select * from Empleado");
		ResultSet lista = statement.executeQuery();
		return lista;
	}

	public boolean update(Connection conexion,int id, String nombre, int edad, int telefono) throws SQLException {
		// Si el telefono tiene menos de 9 digitos
		if (Integer.toString(telefono).length() < 9)
			return false;

		// Si el nombre tiene más de 30 caracteres
		if (nombre.length() > 30 || nombre.length() == 0)
			return false;

		// Si la edad es negativa o demasiado alta
		if (edad < 0 || edad > 130)
			return false;
		
		PreparedStatement st=conexion.prepareStatement("Update Empleado SET nombre=? , edad=? , telefono=? where id=?");
		st.setString(1, nombre);
		st.setInt(2, edad);
		st.setInt(3, telefono);
		st.setInt(4, id);
		
		if(st.executeUpdate()!=1) {
			return false;
		}
		return true;
	}
	
	public boolean delete(Connection conexion,int id) throws SQLException {
		PreparedStatement st=conexion.prepareStatement("Delete from Empleado where id=?");
		st.setInt(1, id);
		if(st.executeUpdate()!=1) {
			return false;
		}
		return true;
		
	}
}
