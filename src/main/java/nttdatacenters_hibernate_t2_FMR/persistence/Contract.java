package nttdatacenters_hibernate_t2_FMR.persistence;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_CONTRACT_SEC", allocationSize = 1 )
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	@Column(name = "EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Column(name = "EXPIRATION_DATE")
	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "MONTHLY_PRICE")
	public double getMonthlyPrice() {
		return monthlyPrice;
	}

	public void setMonthlyPrice(double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CUSTOMER" )
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	@ManyToOne
	@JoinColumn(name="ID_CONTRACT_TYPE")
	public ContractType getContractType() {
		return contractType;
	}

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
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + ", customer=" + customer + "]";
	}

}
