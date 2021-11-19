package Autocares.data.DAO;

import java.util.List;

public interface DAO<T,K>{
	public void insert(T a);
	public boolean update(T a);
	public List<T> getAll(T a);
	public T getOne(K b);
	public boolean deleteByObject(T a);
	public boolean deleteByID(K b);
}
