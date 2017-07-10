package vc.com.cartorio.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.service.CartorioService;

@RestController
public class CartorioRestController {

	@Autowired
	private CartorioService cartorioService;

	@RequestMapping(value="/cartorios", method = RequestMethod.GET, produces={"application/json"})
	public List<Cartorio> todos() {
		return this.cartorioService.listarCartorios();
	}

}
