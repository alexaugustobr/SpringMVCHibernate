package vc.com.cartorio.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import vc.com.cartorio.domain.Cartorio;

public class ListaCartoriosDTO {
	@Valid
	@NotNull
	@NotEmpty
	List<Cartorio> cartorios;

	public List<Cartorio> getCartorios() {
		return cartorios;
	}

	public void setCartorios(List<Cartorio> cartorios) {
		this.cartorios = cartorios;
	}
	
	
}
