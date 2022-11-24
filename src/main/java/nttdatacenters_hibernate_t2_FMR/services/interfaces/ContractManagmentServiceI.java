package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContract;
import nttdatacenters_hibernate_t2_FMR.persistence.Contract;

/**
 * Interfaz del servicio de gestion de los contratos
 * 
 * @author nandi
 *
 */
public interface ContractManagmentServiceI {

	/**
	 * Inserta un nuevo contrato, si el contrato que inserta existe lanza una
	 * excepcion
	 * 
	 * @param contract
	 * @throws ExistingContract
	 */
	public void insertNewContract(Contract contract) throws ExistingContract;

	/**
	 * Actualiza un contrato existente, si no existe el contrato que se va a
	 * actualizar lanza una excepcion
	 * 
	 * @param contract
	 * @throws ContractNotFound
	 */
	public void updateContract(Contract contract) throws ContractNotFound;

	/**
	 * Borra un contrato existente
	 * 
	 * @param contract
	 */
	public void deleteContract(Contract contract);

	/**
	 * Borra el contrato con el id pasado por parametro 
	 * 
	 * @param id
	 */
	public void deleteContractByd(Long id);

	/**
	 * Devuelve el contrato con el id pasado por parametro
	 * 
	 * @param id
	 * @return Contract
	 */
	public Contract getContractById(Long id);

	/**
	 * Devuelve una lista con todos los contratos existentes
	 * 
	 * @return lista de contratos
	 */
	public List<Contract> getAllContracts();

}
