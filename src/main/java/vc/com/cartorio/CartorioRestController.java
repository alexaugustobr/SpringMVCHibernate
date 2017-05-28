package vc.com.cartorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vc.com.cartorio.model.Cartorio;
import vc.com.cartorio.service.CartorioService;

@RestController
public class CartorioRestController {

	private CartorioService cartorioService;

	@Autowired(required = true)
	@Qualifier(value = "cartorioService")
	public void setCartorioService(CartorioService ps) {
		this.cartorioService = ps;
	}

	@GetMapping("/cartorios")
	public List<Cartorio> todos() {
		return this.cartorioService.listarCartorios();
	}

}
