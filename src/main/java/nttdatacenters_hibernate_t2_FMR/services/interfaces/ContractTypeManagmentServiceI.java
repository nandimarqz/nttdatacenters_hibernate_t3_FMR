package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractTypeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;

/**
 * Interfaz del servicio de gestion de los tipos de contrato
 * 
 * @author nandi
 *
 */
public interface ContractTypeManagmentServiceI {

	/**
	 * Inserta un nuevo tipo de contrato, si el tipo de contrato existe lanza una excepcion
	 * 
	 * @param contractType
	 * @throws ExistingContractType
	 */
	public void insertNewContractType(ContractType contractType) throws ExistingContractType;
	
	/**
	 * Actualiza un tipo de contrato existente, si no existe el tipo de contrato que se va
	 * a actualizar lanza una excepcion 
	 * 
	 * @param contractType
	 * @throws ContractTypeNotFound
	 */
	public void updateContractType(ContractType contractType) throws ContractTypeNotFound;
	
	/**
	 * Borra un tipo de contrato existente
	 * 
	 * @param contractType
	 */
	public void deleteContractType(ContractType contractType);
	
	/**
	 * Borra el tipo de contrato con el id pasado por parametro
	 * 
	 * @param id
	 */
	public void deleteContractTypeByd(Long id);
	
	/**
	 * Devuelve el cliente con el id pasado por parametro
	 * 
	 * @param id
	 * @return ContractType
	 */
	public ContractType getContractTypeById(Long id);
	
	/**
	 * Devuelve una lista con todos los tipos de contratos existente
	 * 
	 * @return lista de tipos de contratos
	 */
	public List<ContractType> getAllContractTypes();
}
