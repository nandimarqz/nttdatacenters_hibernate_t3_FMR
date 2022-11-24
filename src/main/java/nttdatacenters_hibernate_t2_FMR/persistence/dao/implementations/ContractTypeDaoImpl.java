package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.CType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractTypeDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

/**
 * Implementacion de la interfaz del Dao del tipo de contrato
 * 
 * @author nandi
 *
 */
public class ContractTypeDaoImpl extends DaoImpl<ContractType> implements ContractTypeDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	/**
	 * Constructor sin parametros setea la clase con la que trabaja el DAO genérico
	 */
	public ContractTypeDaoImpl() {
		super();
		this.setClazz(ContractType.class);
	}

	@Override
	public ContractType getContractTypeByType(CType type) {

		// Crea un String con una consulta HQL
		String qlString = "FROM ContractType WHERE TYPE = " + "'" + type.toString() + "'";

		// Crea la consulta y la guarada en un variable
		Query query = entityManager.createQuery(qlString);

		// Crea el objeto de tipo de contrato a null
		ContractType ct = null;

		// Si el resultado que da la query esta vacio no entra en la condicion y retorna
		// la variable a null
		// Si no esta vacio el resultado entra en la condicion y se obtiene el primer
		// elemento del resultado de la query ya que el tipo de contrato es unico.
		if (!query.getResultList().isEmpty()) {

			ct = (ContractType) query.getResultList().get(0);

		}
		
		//Devuelve el tipo de contrato
		return ct;
	}

}
