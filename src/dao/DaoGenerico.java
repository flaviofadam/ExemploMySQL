package dao;

import java.util.List;

public interface DaoGenerico {
	
	public boolean insert(Object object);
	public Object getById(int id);
	public List<Object> getAll();
	public boolean update(Object object);
	public boolean delete(Object object);

}
