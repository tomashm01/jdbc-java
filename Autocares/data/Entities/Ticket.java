package Autocares.data.Entities;

import java.sql.Date;

public class Ticket {
	
	private Date fechaSalida;
	private Date fechaLlegada;
	private Long id;
	private Usuario usuarioPropietario;
	
	public Ticket(Long id,Date salida,Date llegada,Usuario propietario) {
		setId(id);
		setFechaSalida(salida);
		setFechaLlegada(llegada);
		setUsuarioPropietario(propietario);
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioPropietario() {
		return usuarioPropietario;
	}

	public void setUsuarioPropietario(Usuario usuarioPropietario) {
		if(usuarioPropietario.getEdad()>17) {
			this.usuarioPropietario = usuarioPropietario;
		}else {
			this.usuarioPropietario=null;
		}
	}
}
