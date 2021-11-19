package Autocares.data.Entities;

import java.util.List;

public class Autocar {
	
	private String matricula;
	private Conductor conductor;
	private List<Usuario> listaUsuarios;
	private int numAsientos;
	
	public Autocar(String matricula,Conductor conductor,Usuario user) {
		setMatricula(matricula);
		setConductor(conductor);
		addUsuario(user);
	}
	
	public boolean validarMatricula(String matricula) {
		return true;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		if(validarMatricula(matricula)) {
			this.matricula=matricula;
		}else {
			this.matricula=null;
		}
	}
	
	public Conductor getConductor() {
		return conductor;
	}
	
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public void addUsuario(Usuario user) {
		int numAsientosActualizado=getNumAsientos() + 1 ;
		listaUsuarios.add(user);
		setNumAsientos(numAsientosActualizado);
	}
	
	public int getNumAsientos() {
		return numAsientos;
	}
	
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
}
