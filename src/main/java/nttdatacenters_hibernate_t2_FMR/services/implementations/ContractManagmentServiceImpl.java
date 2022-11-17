package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.Iterator;
import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContract;
import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.ContractDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.ContractManagmentServiceI;

public class ContractManagmentServiceImpl implements ContractManagmentServiceI {

	private ContractDaoI contractDao;
	
	public ContractManagmentServiceImpl() {
		
		contractDao = new ContractDaoImpl();
		
	}

	@Override
	public void insertNewContract(Contract contract) throws ExistingContract {

		boolean exist = Boolean.FALSE;

		if (contract != null && contract.getId() == null) {
			
			if(contractDao.getContractsByCustomer(contract.getCustomer()) != null) {
				
				Iterator<Contract> it = contractDao.getContractsByCustomer(contract.getCustomer()).iterator();
				
				while (it.hasNext() && !exist) {

					Contract c = it.next();

					if (c.getContractType().getId().equals(contract.getContractType().getId())) {

						exist = Boolean.TRUE;

					}

				}
				
			}

		

			if (!exist) {

				contractDao.insert(contract);

			} else {

				throw new ExistingContract("El contrato que se intenta insertar ya existe");

			}

		}

	}

	@Override
	public void updateContract(Contract contract) throws ContractNotFound {
		
		if(contract != null && contract.getId() != null) {
			
			if(contractDao.searchById(contract.getId()) != null) {
				
				contractDao.update(contract);
				
			}else {
				
				throw new ContractNotFound("El contrato que se intenta actualizar no existe");
				
			}
			
		}

	}

	@Override
	public void deleteContract(Contract contract) {

		if(contract != null && contract.getId() != null) {
			
			contractDao.delete(contract);
			
		}
		
	}

	@Override
	public void deleteContractByd(Long id) {
		
		if(id != null) {
			
			contractDao.deleteById(id);
			
		}

	}

	@Override
	public Contract getContractById(Long id) {
		
		Contract contract = null;
		
		if(id != null) {
			
			contract = contractDao.searchById(id);
			
		}
		
		return contract;
	}

	@Override
	public List<Contract> getAllContracts() {
		
		List<Contract> contracts = null;
		
		contracts = contractDao.searchAll();
		
		return contracts;
	}

}
