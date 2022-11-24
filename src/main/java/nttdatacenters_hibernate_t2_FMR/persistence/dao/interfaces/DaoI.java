package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import java.util.List;

public interface DaoI<T> {

	/**
	 * Inserta en la BBDD el Objeto pasado por parametro
	 * 
	 * @param param
	 */
	public void insert(T param);

	/**
	 * Actualiza en la base de datos el Objeto pasado por parametro
	 * 
	 * @param param
	 */
	public void update(T param);

	/**
	 * Borra en la base de datos el Objeto pasado por parametro
	 * 
	 * @param param
	 */
	public void delete(T param);

	/**
	 * Borra en la base de datos el Objeto que tenga el id pasado por parametro
	 * 
	 * @param id
	 */
	public void deleteById(Long id);

	/**
	 * Devuelve un Objeto recogido de la base de datos que tenga el id pasado por
	 * parametro
	 * 
	 * @param id
	 * @return clase invocante
	 */
	public T searchById(Long id);

	/**
	 * Devuelve una lista de Objetos recogido de la base de datos
	 * 
	 * @return lista de elementos de la clase invocante
	 */
	public List<T> searchAll();

}
