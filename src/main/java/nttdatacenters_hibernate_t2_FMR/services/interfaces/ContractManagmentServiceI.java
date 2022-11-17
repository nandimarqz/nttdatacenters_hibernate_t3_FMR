package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContract;
import nttdatacenters_hibernate_t2_FMR.persistence.Contract;

public interface ContractManagmentServiceI {
	
public void insertNewContract(Contract contract) throws ExistingContract;
	
	public void updateContract(Contract contract) throws ContractNotFound;
	
	public void deleteContract(Contract contract);
	
	public void deleteContractByd(Long id);
	
	public Contract getContractById(Long id);
	
	public List<Contract> getAllContracts();

}
