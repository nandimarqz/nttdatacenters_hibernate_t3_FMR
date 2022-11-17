package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractTypeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;

public interface ContractTypeManagmentServiceI {

	public void insertNewContractType(ContractType contractType) throws ExistingContractType;
	
	public void updateContractType(ContractType contractType) throws ContractTypeNotFound;
	
	public void deleteContractType(ContractType contractType);
	
	public void deleteContractTypeByd(Long id);
	
	public ContractType getContractTypeById(Long id);
	
	public List<ContractType> getAllContractTypes();
}
