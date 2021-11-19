package Autocares.data.Entities;

import java.sql.Date;

public class Ticket {
	
	private Date fechaSalida;
	private Date fechaLlegada;
	private int id;
	private Usuario usuarioPropietario;
	
	public Ticket(int id,Date salida,Date llegada,Usuario propietario) {
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
