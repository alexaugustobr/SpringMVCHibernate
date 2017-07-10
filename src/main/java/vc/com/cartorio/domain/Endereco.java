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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Endereco")
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
	@JsonBackReference
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
