package Autocares.data.Entities;

import java.util.List;

public class Autocar {
	
	private Long matricula;
	private Conductor conductor;
	private List<Usuario> listaUsuarios;
	private int numAsientos;
	
	public Autocar(Long matricula,Conductor conductor,Usuario user) {
		setMatricula(matricula);
		setConductor(conductor);
		setListaUsuarios(user);
	}
	
	public boolean validarMatricula(Long matricula) {
		return true;
	}
	
	public Long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Long matricula) {
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
	
	public void setListaUsuarios(Usuario user) {
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
