package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.CType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;

/**
 * Interfaz para el DAO de los tipo de contratos
 * 
 * @author nandi
 *
 */
public interface ContractTypeDaoI extends DaoI<ContractType> {

	/**
	 * Devuelve el tipo de contrato del tipo pasado por parametro.
	 * Devuelve un tipo de contrato unicamente ya que el tipo es unico
	 * 
	 * @param type
	 * @return ContractType
	 */
	public ContractType getContractTypeByType(CType type);
}
