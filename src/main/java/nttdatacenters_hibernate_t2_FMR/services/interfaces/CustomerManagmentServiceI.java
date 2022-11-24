package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.CustomerNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingCustomer;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;

/**
 * Interfaz del servicio de gestion de los clientes
 * 
 * @author nandi
 *
 */
public interface CustomerManagmentServiceI {

	/**
	 * Inserta un nuevo cliente, si el cliente que inserta existe lanza una
	 * excepcion
	 * 
	 * @param customer
	 * @throws ExistingCustomer
	 */
	public void insertNewCustomer(Customer customer) throws ExistingCustomer;

	/**
	 * Actualiza un cliente existente, si no existe el cliente que se va a
	 * actualizar lanza una excepcion
	 * 
	 * @param customer
	 * @throws CustomerNotFound
	 */
	public void updateCustomer(Customer customer) throws CustomerNotFound;

	/**
	 * Borra un cliente existente
	 * 
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);

	/**
	 * Borra un cliente existente con el dni pasado por parametro
	 * 
	 * @param customerId
	 */
	public void deleteCustomerById(Long customerId);

	/**
	 * Devulve un cliente existente con el id pasado por parametro
	 * 
	 * @param customerId
	 * @return Customer
	 */
	public Customer getCustomerById(Long customerId);

	/**
	 * Devuelve un cliente existente con el dni pasado por parametro, Si no
	 * encuentra ningun cliente lanza una excepcion
	 * 
	 * @param dni
	 * @return Customer
	 * @throws CustomerNotFound
	 */
	public Customer getCustomerByDNI(String dni) throws CustomerNotFound;

	/**
	 * Devuelve una lista con todos los clientes existentes
	 * 
	 * @return lista de clientes
	 */
	public List<Customer> getAllCustomers();

}
