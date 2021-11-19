package Autocares.data.DAO;

import java.util.List;

import Autocares.data.Entities.Usuario;

public class UsuarioDAO implements DAO<Usuario,Long>{

	@Override
	public void insertar(Usuario a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean actualizar(Usuario a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> obtenerTodos(Usuario a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUno(Long b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(Usuario a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarPorID(Long b) {
		// TODO Auto-generated method stub
		return false;
	}

}
