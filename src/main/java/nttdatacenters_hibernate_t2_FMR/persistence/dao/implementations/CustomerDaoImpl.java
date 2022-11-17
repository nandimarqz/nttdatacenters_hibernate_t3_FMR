package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.persistence.Customer;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.CustomerDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;



public class CustomerDaoImpl extends DaoImpl<Customer> implements CustomerDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	/** Logger para la clase */
	private static final Logger CUSTOMERDAOLOG = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	public CustomerDaoImpl() {
		super();
		this.setClazz(Customer.class);
	}

	@Override
	public Customer getCustomerByDNI(String dni) {

		CUSTOMERDAOLOG.debug("Obteniendo cliente con el DNI: {}", dni );
		
		// Crea la consulta con lenguaje HQL
		String qlString = "FROM Customer WHERE DNI = " + "'" + dni + "'";

		// Crea la consulta y la guarda en una variable
		Query query = entityManager.createQuery(qlString);

		// Crea el objeto cliente a null
		Customer customer = null;

		// si la lista que devuelve la query esta vacia no entra en la condicion y se
		// retornaria null.
		// Si no esta vacia se obtiene el primer elemento ya que el DNI es unico y solo
		// va a devolver 1 elemento en la lista.
		if (!query.getResultList().isEmpty()) {

			customer = (Customer) query.getResultList().get(0);

		}

		//Devuelve el cliente
		return customer;
	}

}
