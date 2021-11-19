package Autocares.data.DAO;

import java.util.List;

public interface DAO<T,K>{
	public void insertar(T a);
	public boolean actualizar(T a);
	public List<T> obtenerTodos(T a);
	public T obtenerUno(K b);
	public boolean borrar(T a);
	public boolean borrarPorID(K b);
}
