package vc.com.cartorio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Endereco")
@JsonInclude(value = Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
//@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
//@JsonTypeName("endereco")
//@JsonRootName("endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@XmlRootElement
//@JsonRootName(value = "Endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Numero nao pode estar vazio")
	private String numero;

	@NotEmpty(message = "Rua nao pode estar vazio")
	private String rua;

	@JoinColumn(name = "CARTORIO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_CARTORIO_ID"))
	@OneToOne(optional = false, fetch = FetchType.LAZY)
//	@JsonManagedReference
//	@JsonBackReference
	@JsonTypeInfo(include=As.EXISTING_PROPERTY, use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
	//se precisar com @type
	//@JsonTypeInfo(include=As.PROPERTY, use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME)
	private Cartorio cartorio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
