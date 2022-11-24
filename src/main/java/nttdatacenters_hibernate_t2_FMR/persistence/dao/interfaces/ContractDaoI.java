package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;

/**
 * Interfaz para el DAO de contratos
 * 
 * @author nandi
 *
 */
public interface ContractDaoI extends DaoI<Contract> {

	/**
	 * Devuelve la lista de contratos del cliente que se pasa por parametro
	 * 
	 * @param c
	 * @return Lista de contratos por el cliente pasado por parametro
	 */
	public List<Contract> getContractsByCustomer(Customer c);

}