package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;

public interface ContractDaoI extends DaoI<Contract> {

	public List<Contract> getContractsByCustomer(Customer c);

}