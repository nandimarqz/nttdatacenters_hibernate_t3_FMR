package nttdatacenters_hibernate_t2_FMR.persistence;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Esta clase hace referencia a la tabla NTTDATA_T2_HIBERNATE_CONTRACT en la
 * base de datos
 * 
 * @author nandi
 *
 */
@Entity
@Table(name = "NTTDATA_T2_HIBERNATE_CONTRACT")
public class Contract extends AbstracEntity {

	private static final long serialVersionUID = 1L;

	/** Identificador del contrato */
	private Long contractId;

	/** Fecha de vigencia */
	private Date effectiveDate;

	/** Fecha de caducidad */
	private Date expirationDate;

	/** Precio mensual */
	private double monthlyPrice;

	/** Cliente del contrato */
	private Customer customer;

	/** Tipo de contrato */
	private ContractType contractType;

	/**
	 * Devuelve el id del contrato
	 * 
	 * @return Long
	 */
	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_CONTRACT_SEC", allocationSize = 1)
	public Long getContractId() {
		return contractId;
	}

	/**
	 * Establece el id del contrato por el id pasado por parametro
	 * 
	 * @param contractId
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * Devuelve la fecha de vigencia del contrato
	 * 
	 * @return Date
	 */
	@Column(name = "EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Establece la fecha de vigencia del contrato por la fecha pasada por parametro
	 * 
	 * @param effectiveDate
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Devuelve la fecha de caducidad del contrato
	 * 
	 * @return Date
	 */
	@Column(name = "EXPIRATION_DATE")
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Establece la fecha de caducidad del contrato por la pasada por parametro
	 * 
	 * @param expirationDate
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Devuelve el precio mensual de contrato
	 * 
	 * @return double
	 */
	@Column(name = "MONTHLY_PRICE")
	public double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * Establece el precio mesual del contrato por el pasado por parametro
	 * 
	 * @param monthlyPrice
	 */
	public void setMonthlyPrice(double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * Devuelve el cliente del contrato
	 * 
	 * @return Customer
	 */
	@ManyToOne
	@JoinColumn(name = "ID_CUSTOMER")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Establece el cliente del contrato por el pasado por parametro
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Devuelve el tipo del contrato
	 * 
	 * @return ContractType
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTRACT_TYPE")
	public ContractType getContractType() {
		return contractType;
	}

	/**
	 * Establece el tipo del contrato por el contrato tipo de contrato pasado por
	 * parametro
	 * 
	 * @param contractType
	 */
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		return Objects.equals(contractId, other.contractId);
	}

	@Override
	@Transient
	public Long getId() {

		return this.contractId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.contractId = id;

	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + ", customer=" + customer.getDni() + "]";
	}

}
