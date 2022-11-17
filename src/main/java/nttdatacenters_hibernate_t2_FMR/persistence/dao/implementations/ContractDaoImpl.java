package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

public class ContractDaoImpl extends DaoImpl<Contract> implements ContractDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	public ContractDaoImpl() {
		super();
		this.setClazz(Contract.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> getContractsByCustomer(Customer c) {
		
		String qlString = "FROM Contract WHERE ID_CUSTOMER = " +c.getId() ;
		
		Query query = entityManager.createQuery(qlString);
		
		List<Contract> contracts = null;
		
		if(!query.getResultList().isEmpty()) {
			
			contracts = query.getResultList();
			
		}
		
		return contracts;
	}
	
	
	
}
