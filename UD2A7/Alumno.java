package UD2A7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Alumno {
	private int id;
	private String nombre;
	private Date fechaNacimiento;
	private float notaMedia;
	private String curso;

	public static void main(String[] args) throws ParseException {
		String url = "jdbc:mysql://localhost:3306/Instituto";
		String user = "root";
		String passwd = "";
		ResultSet rs = null;
		try (Connection conexion = DriverManager.getConnection(url, user, passwd)) {

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			int opcion = 0;
			Scanner s = new Scanner(System.in);
			String nombre;
			String curso;
			String fechaNacim;
			float notaMedia;
			int id;

			do {
				System.out.println("---MENU---");
				System.out.println("1.Insertar datos");
				System.out.println("2.Leer datos");
				System.out.println("3.Actualizar datos");
				System.out.println("4.Eliminar datos");
				System.out.println("5.Salir");
				opcion = s.nextInt();
				s.nextLine();
				switch (opcion) {
				case 1:// Inserción datos

					System.out.println("Introduce nombre: ");
					nombre = s.nextLine();
					System.out.println("Introduce curso");
					curso = s.nextLine();
					System.out.println("Introduce fecha nacimiento(dd/MM/yyyy)");
					fechaNacim = s.nextLine();
					System.out.println("Introduce nota media: ");
					notaMedia = s.nextFloat();

					Date fecha = formato.parse(fechaNacim);
					Alumno alumno = new Alumno(nombre, fecha, notaMedia, curso);
					if (alumno.create(conexion)) {
						System.out.println("Registro añadido");
					}

					break;
				case 2:// Lectura datos

					rs = read(conexion);
					while (rs.next()) {
						System.out.println("Id: " + rs.getInt("id") + "." + rs.getString("nombre") + " con fecha "
								+ rs.getDate("fechaNacimiento") + ", nota media " + rs.getFloat("notaMedia")
								+ " y curso " + rs.getString("curso"));
					}

					break;
				case 3:// Actualizar datos

					System.out.println("Introduce id del alumno a modificar: ");
					id = s.nextInt();
					s.nextLine();
					System.out.println("Introduce nombre: ");
					nombre = s.nextLine();
					System.out.println("Introduce curso");
					curso = s.nextLine();
					System.out.println("Introduce fecha nacimiento(dd/MM/yyyy)");
					fechaNacim = s.nextLine();
					System.out.println("Introduce nota media: ");
					notaMedia = s.nextFloat();
					s.nextLine();

					fecha = formato.parse(fechaNacim);
					alumno = new Alumno(id, nombre, fecha, notaMedia, curso);

					if (alumno.update(conexion, alumno)) {
						System.out.println("Alumno correctamente actualizado");
					} else {
						System.out.println("Alumno no se ha actualizado correctamente ");
					}
					break;
				case 4:// Eliminar datos

					System.out.println("Introduce id");
					id = s.nextInt();
					s.nextLine();
					alumno = new Alumno(id);

					if (alumno.delete(conexion, alumno)) {
						System.out.println("Registro eliminado correctamente");
					} else {
						System.out.println("Registro no eliminado correctamente");
					}

					break;
				case 5:// Salir
					System.out.println("Hasta luego");
					break;
				default:
					System.out.println("Elige una opcion entre 1 y 5");
					break;
				}

			} while (opcion != 5);

		} catch (SQLException e) {
			System.out.println("Excepcion SQL: " + e.getMessage());
			System.out.println("Estado SQL: " + e.getSQLState());
			System.out.println("Código del Error: " + e.getErrorCode());
		}
	}
	// Getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean setNombre(String nombre) {
		if (nombre.length() > 30) {
			return false;
		}
		this.nombre = nombre;
		return true;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fecha) {
		this.fechaNacimiento = fecha;
	}

	public float getNotaMedia() {
		return notaMedia;
	}

	public boolean setNotaMedia(float notaMedia) {
		if (notaMedia < 0 || notaMedia > 10) {
			return false;
		}
		this.notaMedia = notaMedia;
		return true;
	}

	public String getCurso() {
		return curso;
	}

	public boolean setCurso(String curso) {
		if (!curso.equals("1A") && !curso.equals("2B") && !curso.equals("3C")) {
			return false;
		}
		this.curso = curso;
		return true;
	}

	/*
	 * Constructor
	 */

	public Alumno(int id, String nombre, Date fechaNacimiento, float notaMedia, String curso) {
		setId(id);
		setFechaNacimiento(fechaNacimiento);
		if (!setNotaMedia(notaMedia)) {
			this.notaMedia = 5;
		}
		if (!setNombre(nombre)) {
			this.nombre = nombre.substring(0, 31);
		}
		if (!setCurso(curso)) {
			this.curso = null;
		}
	}

	public Alumno(int id) {
		setId(id);
	}

	public Alumno(String nombre, Date fecha, float notaMedia, String curso) {
		setFechaNacimiento(fecha);
		if (!setNotaMedia(notaMedia)) {
			this.notaMedia = 5;
		}
		if (!setNombre(nombre)) {
			this.nombre = nombre.substring(0, 31);
		}
		if (!setCurso(curso)) {
			this.curso = null;
		}
	}

	/*
	 * @Override toString
	 */
	public String toString() {
		return this.getId() + "." + this.getNombre() + " nacido " + this.getFechaNacimiento() + " con nota media "
				+ this.getNotaMedia() + " y curso " + this.getCurso() + "\n";
	}

	public boolean create(Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("INSERT INTO alumnos values (null,?,?,?,?)");
		statement.setString(1, this.getNombre());
		statement.setDate(2, new java.sql.Date(this.getFechaNacimiento().getTime()));
		statement.setFloat(3, this.getNotaMedia());
		statement.setString(4, this.getCurso());

		int resultado = statement.executeUpdate();

		if (resultado != 1) {
			return false;
		}
		return true;
	}

	public static ResultSet read(Connection conexion) throws SQLException {
		PreparedStatement statement = conexion.prepareStatement("select * from alumnos");
		ResultSet lista = statement.executeQuery();
		return lista;
	}

	public boolean update(Connection conexion, Alumno alumno) throws SQLException {

		PreparedStatement st = conexion
				.prepareStatement("Update alumnos SET nombre=? , fechaNacimiento=? , notaMedia=?,curso=? where id=?");
		st.setString(1, alumno.getNombre());
		st.setDate(2, new java.sql.Date(this.getFechaNacimiento().getTime()));
		st.setFloat(3, alumno.getNotaMedia());
		st.setString(4, alumno.getCurso());
		st.setInt(5, alumno.getId());

		if (st.executeUpdate() != 1) {
			return false;
		}
		return true;
	}

	public boolean delete(Connection conexion, Alumno alumno) throws SQLException {
		PreparedStatement st = conexion.prepareStatement("Delete from alumnos where id=?");
		st.setInt(1, id);
		if (st.executeUpdate() != 1) {
			return false;
		}
		return true;

	}
}
