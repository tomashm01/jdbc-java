package Autocares.data.Entities;

public class Usuario {
	
	private String dni;
	private String nombreCompleto;
	private int edad;
	
	public Usuario(String dni,String nombreCompleto,int edad) {
		setDni(dni);
		setNombreCompleto(nombreCompleto);
		setEdad(edad);
	}
	
	public boolean validarDni(String dni) {
		return true;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if(validarDni(dni)) {
			this.dni=dni;
		}else {
			this.dni=null;
		}
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
