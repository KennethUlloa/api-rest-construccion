package grupo7.apirest.modelo.dao;

import java.util.List;

public interface GenericDAO<T,ID> {
	void create(T obj);
	void update(T obj);
	void deleteById(ID id);
	T getById(ID id);
	List<T> getAll();
}