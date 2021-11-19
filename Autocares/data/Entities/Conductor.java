package Autocares.data.Entities;

public class Conductor extends Usuario {

	private String matriculaAutocar;
	private String tipoJornada;
	
	public Conductor(String dni, String nombreCompleto,int edad,String tipoJornada) {
		super(dni, nombreCompleto,edad);
		setTipoJornada(tipoJornada);
	}

	public String getMatriculaAutocar() {
		return matriculaAutocar;
	}

	public void setMatriculaAutocar(String matriculaAutocar) {
		this.matriculaAutocar = matriculaAutocar;
	}

	public String getTipoJornada() {
		return tipoJornada;
	}

	public void setTipoJornada(String tipoJornada) {
		if(tipoJornada.equals("Parcial") || tipoJornada.equals("Completa")) {
			this.tipoJornada=tipoJornada;
		}else {
			this.tipoJornada="Completa";
		}
	}

}
