package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.CustomerDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;


/**
 * Implementacion de la interfaz del Dao de cliente
 * 
 * @author nandi
 *
 */
public class CustomerDaoImpl extends DaoImpl<Customer> implements CustomerDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	/** Logger para la clase */
	private static final Logger CUSTOMERDAOLOG = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	/**
	 * Constructor sin parametros 
	 * setea la clase con la que trabaja el DAO genérico
	 */
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

	@Override
	public List<Customer> getCustomerByContractMonthlyGt(Double monthlyPrice) {
		CUSTOMERDAOLOG.debug("Obteniendo clientes con la mensualidad del contrato mayor a : {}", monthlyPrice);
		
		//Consulta
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cquery = cb.createQuery(Customer.class);
		Root<Customer> rootP = cquery.from(Customer.class); 
		Join<Customer,Contract> pJoinT = rootP.join("contracts");
		
		//Where
		Predicate pr = cb.gt(pJoinT.<Double>get("monthlyPrice"), monthlyPrice);
		
		//Consulta
		cquery.select(rootP).where(cb.and(pr)).distinct(true);
		
		//Ejecucion de la consulta 
		return  entityManager.createQuery(cquery).getResultList();
	}
	
	

}
