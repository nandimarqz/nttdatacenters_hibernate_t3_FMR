package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractTypeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.ContractTypeDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractTypeDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.ContractTypeManagmentServiceI;

public class ContractTypeManagmentServiceImpl implements ContractTypeManagmentServiceI {

	private ContractTypeDaoI ctDao;
	
	public ContractTypeManagmentServiceImpl() {
		
		ctDao = new ContractTypeDaoImpl();
		
	}
	
	@Override
	public void insertNewContractType(ContractType contractType) throws ExistingContractType {
		
		if(contractType != null && contractType.getId() == null) {
			
			if(ctDao.getContractTypeByType(contractType.getType()) == null) {
				
				ctDao.insert(contractType);
				
			}else {
				
				throw new ExistingContractType("El tipo de contrato que intenta insertar ya existe");
				
			}
			
			
		}
		
	}

	@Override
	public void updateContractType(ContractType contractType) throws ContractTypeNotFound {
		
		if(contractType != null && contractType.getId() != null) {
			
			if(ctDao.searchById(contractType.getId()) != null) {
				
				ctDao.update(contractType);
				
			}else {
				
				throw new ContractTypeNotFound("El tipo de contrato que intenta actualizar no existe");
				
			}
			
		}
		
	}

	@Override
	public void deleteContractType(ContractType contractType) {
		
		if(contractType != null && contractType.getId() != null) {
			
			ctDao.delete(contractType);
			
		}
		
	}

	@Override
	public void deleteContractTypeByd(Long id) {
		
		if(id != null) {
			
			ctDao.deleteById(id);
			
		}
		
	}

	@Override
	public ContractType getContractTypeById(Long id) {
		
		ContractType ct = null;
		
		if(id != null) {
			
			ct = ctDao.searchById(id);
			
		}
		
		return ct;
	}

	@Override
	public List<ContractType> getAllContractTypes() {
		
		List<ContractType> cst = null;
		
		cst = ctDao.searchAll();
		
		return cst;
	}

}
