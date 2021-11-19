package Autocares.data.DAO;

import java.util.List;

import Autocares.data.Entities.Autocar;

public class AutocarDAO implements DAO<Autocar,String>{

	@Override
	public void insertar(Autocar a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean actualizar(Autocar a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Autocar> obtenerTodos(Autocar a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autocar obtenerUno(String b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(Autocar a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarPorID(String b) {
		// TODO Auto-generated method stub
		return false;
	}


}
