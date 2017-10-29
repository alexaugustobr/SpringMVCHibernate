package vc.com.cartorio.controller.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.service.CartorioService;

@Component
@Path("/cartorios")
public class CartorioRestResource {

	@Autowired
	private CartorioService cartorioService;

	@Produces("application/json")
	@GET
	public List<Cartorio> todos() {
		return cartorioService.listarCartorios();
	}
	
	@Path("{id}")
	@Produces("application/json")
	@GET
	public Cartorio um(@PathParam("id")int id) {
		return cartorioService.getCartorioPorId(id);
	}

}
