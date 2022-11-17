package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.CType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractTypeDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

public class ContractTypeDaoImpl extends DaoImpl<ContractType> implements ContractTypeDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	public ContractTypeDaoImpl() {
		super();
		this.setClazz(ContractType.class);
	}
	
	@Override
	public ContractType getContractTypeByType(CType type) {
		
		String qlString = "FROM ContractType WHERE TYPE = " + "'"+type.toString()+"'";
		
		Query query = entityManager.createQuery(qlString);
		
		ContractType ct = null;
		
		if(!query.getResultList().isEmpty()) {
			
			ct = (ContractType)query.getResultList().get(0);
			
		}
		return ct;
	}
	
}
