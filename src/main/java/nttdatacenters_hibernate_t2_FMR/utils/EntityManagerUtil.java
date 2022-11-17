package nttdatacenters_hibernate_t2_FMR.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

/**
 * Clase sencilla de utilidad que nos ayude a establecer y manejar las
 * conexiones con la base de datos
 * 
 * @author nandi
 *
 */
public class EntityManagerUtil {

	/** Logger para la clase */
	private static final Logger EMULOG = LoggerFactory.getLogger(EntityManagerUtil.class);
	
	private EntityManagerUtil() {
		
		
	}
	
	/**
	 * Devuelve el entityManager de la unidad de persistencia que le indiquemos al
	 * Factory
	 * 
	 * @return
	 */
	public static EntityManager getEntityManager() {

		EMULOG.debug("Generando el EntityManager");
		
		// en la siguiente línea se pone lo que pusimos en <persistence-unit
		// name="HibernateT1"
		// en el fichero persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateT2");
		 

		return factory.createEntityManager();
	}

	/*
	 * en esta clase crearemos un único método estático, getEntityManager que no
	 * recibe nada, pero devuelve un objeto EntityManager, el de la librería de
	 * persistencia de Java. Crearemos un objeto factoría dentro de este método. A
	 * la hora de crear la factoría, es importante que le indiquemos el nombre
	 * correcto que le hayamos dado a la unidad de persistencia del fichero de
	 * configuración Persistence.xml, en nuestro caso, HibernateT1, sin acentos,
	 * claro. Y ahora que ya tenemos la factoría, le pedimos al gestor de entidades,
	 * el EntityManager que necesitamos devolver.
	 */
}
