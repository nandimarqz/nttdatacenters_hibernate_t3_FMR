package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.List;

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
	
	
	@Column(name="ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_CONTRACT_TYPE_SEC", allocationSize = 1 )
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="TYPE", unique=true)
	public CType getType() {
		return type;
	}

	public void setType(CType type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contractType")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	@Transient
	public Long getId() {
	
		return typeId;
	}

	@Override
	@Transient
	public void setId(Long id) {
	
		this.typeId = id;
		
	}

}
