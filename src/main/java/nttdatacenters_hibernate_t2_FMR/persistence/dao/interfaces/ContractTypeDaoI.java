package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.CType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;

public interface ContractTypeDaoI extends DaoI<ContractType> {

	public ContractType getContractTypeByType(CType type);
}
