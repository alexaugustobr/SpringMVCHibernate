package vc.com.cartorio.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Cartorio")
//@JsonInclude(value = Include.NON_NULL)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
//@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
//@JsonTypeName("cartorio")
//@JsonRootName("cartorio")
//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@XmlRootElement
//@JsonRootName(value = "Cartorio")
public class Cartorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	private String nome;

//	@Valid
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cartorio")
//	@JsonManagedReference
//	@JsonBackReference
//	@JsonTypeInfo(include=As.EXISTING_PROPERTY, use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
	//se precisar com @type
	//@JsonTypeInfo(include=As.PROPERTY, use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
	private List<Endereco> enderecos;
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome;
	}
}
