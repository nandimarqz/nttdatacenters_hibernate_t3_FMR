package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.DaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;



public abstract class DaoImpl<T> implements DaoI<T> {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	/** Tipo de clase */
	private Class<T> clazz;
	
	/** Logger para la clase */
	private static final Logger DAOLOG = LoggerFactory.getLogger(DaoImpl.class);

	/**
	 * Establece la clase por la clase pasada por parametro
	 * 
	 */
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void insert(T param) {

		DAOLOG.debug("Insertando {}", param.getClass());
		// Crea la transaccion
		EntityTransaction tx = entityManager.getTransaction();

		try {
			// Inicia la transaccion
			tx.begin();

			// Inserta el objeto
			entityManager.persist(param);

			// Hace el commit
			tx.commit();

			// Si hubiera un tipo de error lo controlamos y hacemos el rollback
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

	}

	@Override
	public void update(T param) {

		DAOLOG.debug("Actualizando {}", param.getClass());
		// Crea la transaccion
		EntityTransaction tx = entityManager.getTransaction();

		try {
			// Inicia la transaccion
			tx.begin();

			// Actualiza el objeto en la base de datos
			entityManager.merge(param);

			// Hace el commit
			tx.commit();

			// Si hubiera un tipo de error lo controlamos y hacemos el rollback
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

	@Override
	public void delete(T param) {

		DAOLOG.debug("Eliminando {}", param.getClass());
		
		// Crea la transaccion
		EntityTransaction tx = entityManager.getTransaction();

		try {
			// Inicia la transaccion
			tx.begin();
			
			// Actualiza el objeto en la base de datos
			T entity = entityManager.merge(param);

			// Borra en la base de datos el objeto
			entityManager.remove(entity);

			// Hace el commit
			tx.commit();

			// Si hubiera un tipo de error lo controlamos y hacemos el rollback
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

	@Override
	public void deleteById(Long id) {

		DAOLOG.debug("Eliminando {} a traves del id", clazz.getName());
		// Crea la transaccion
		EntityTransaction tx = entityManager.getTransaction();

		try {
			// Inicia la transaccion
			tx.begin();
			
			// Crea el borrado con lenguaje HQL
			String qlString = "DELETE FROM " + clazz.getName() + " WHERE ID = " + id;

			// Crea el borrado y la guarda en una variable
			Query query = entityManager.createQuery(qlString);

			// Ejecuta el borrado
			query.executeUpdate();

			// Realiza el commit
			tx.commit();

			// Si hubiera un tipo de error lo controlamos y hacemos el rollback
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

	}

	@Override
	public T searchById(Long id) {

		DAOLOG.debug("Buscando {} a traves del id", clazz.getName());
		
		// Busca y devuelve el objeto del tipo que sea la clase por el id
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		DAOLOG.debug("Buscando todos l@s {}", clazz.getName());
		
		// Crea la consulta en lenguaje HQL
		String qlString = "FROM " + clazz.getName();
		
		// Crea la consulta con el entitymanager pasandole el String que contiene la
		// consutla
		Query query = entityManager.createQuery(qlString);
		
		// Devuelve la lista
		return query.getResultList();
	}

}
