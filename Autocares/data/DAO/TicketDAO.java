package Autocares.data.DAO;

import java.util.List;

import Autocares.data.Entities.Ticket;

public class TicketDAO implements DAO<Ticket,Long> {

	@Override
	public void insertar(Ticket a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean actualizar(Ticket a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ticket> obtenerTodos(Ticket a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket obtenerUno(Long b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(Ticket a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarPorID(Long b) {
		// TODO Auto-generated method stub
		return false;
	}

}
