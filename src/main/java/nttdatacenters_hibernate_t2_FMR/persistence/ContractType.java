package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Esta clase hace referencia a la tabla NTTDATA_T2_HIBERNATE_CONTRACT_TYPE en
 * la base de datos
 * 
 * @author nandi
 *
 */
@Entity
@Table(name = "NTTDATA_T2_HIBERNATE_CONTRACT_TYPE")
public class ContractType extends AbstracEntity {

	private static final long serialVersionUID = 1L;

	/** Id del contrato */
	private Long typeId;

	/** Tipo del contrato */
	private CType type;

	/** Contratos con el tipo */
	private List<Contract> contracts;

	/**
	 * Devuelve el id del tipo de contrato
	 * 
	 * @return Long
	 */
	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_CONTRACT_TYPE_SEC", allocationSize = 1)
	public Long getTypeId() {
		return typeId;
	}

	/**
	 * Establece el id del tipo de contrato
	 * 
	 * @param typeId
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	/**
	 * Devuelve el tipo del tipo de contrato
	 * 
	 * @return CType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", unique = true)
	public CType getType() {
		return type;
	}

	/**
	 * Establece el tipo del tipo de contrato
	 * 
	 * @param type
	 */
	public void setType(CType type) {
		this.type = type;
	}

	/**
	 * Devuelve la lista de contratos que tienen el tipo de contrato
	 * 
	 * @return Lista de contratos del tipo 
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contractType")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Contract> getContracts() {
		return contracts;
	}

	/**
	 * Establece la lista de contratos que tienen el tipo de contrato
	 * 
	 * @param contracts
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	@Transient
	public Long getId() {

		return this.getTypeId();
	}

	@Override
	@Transient
	public void setId(Long id) {

		this.typeId = id;

	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractType other = (ContractType) obj;
		return type == other.type;
	}

	@Override
	public String toString() {
		return "ContractType [typeId=" + typeId + ", type=" + type + "]";
	}

}
