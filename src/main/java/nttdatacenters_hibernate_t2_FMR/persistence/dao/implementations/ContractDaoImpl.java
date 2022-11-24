package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

/**
 * Implementación de la interfaz del Dao de clientes
 * 
 * @author nandi
 *
 */
public class ContractDaoImpl extends DaoImpl<Contract> implements ContractDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	/**
	 * Constructor sin parametros 
	 * setea la clase con la que trabaja el DAO genérico
	 */
	public ContractDaoImpl() {
		super();
		this.setClazz(Contract.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> getContractsByCustomer(Customer c) {

		// Crea un String con la consulta HQL
		String qlString = "FROM Contract WHERE ID_CUSTOMER = " + c.getId();

		// Crea la consulta y la guarda en una variable
		Query query = entityManager.createQuery(qlString);

		// Crea la lista de contratos a null;
		List<Contract> contracts = null;

		// Si el el resultado que da la query no esta vacio entra en la condicion
		// e iguala la lista de contratos al resultado, si estuviera vacia la lista,
		// retornaria la lista en null
		if (!query.getResultList().isEmpty()) {

			contracts = query.getResultList();

		}

		//Devuelve la lista de contratos
		return contracts;
	}

}
