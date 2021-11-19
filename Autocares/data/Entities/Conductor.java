package Autocares.data.Entities;

public class Conductor extends Usuario {

	private Long matriculaAutocar;
	private String tipoJornada;
	
	public Conductor(String dni, String nombreCompleto,int edad,String tipoJornada) {
		super(dni, nombreCompleto,edad);
		setTipoJornada(tipoJornada);
	}

	public Long getMatriculaAutocar() {
		return matriculaAutocar;
	}

	public void setMatriculaAutocar(Long matriculaAutocar) {
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
