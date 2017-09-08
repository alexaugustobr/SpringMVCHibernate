package vc.com.cartorio.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.domain.Endereco;
import vc.com.cartorio.repository.EnderecoRepository;
import vc.com.cartorio.service.CartorioService;

@RestController
public class CartorioRestController {

	@Autowired
	private CartorioService cartorioService;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@RequestMapping(value = "/cartorios", method = RequestMethod.GET, produces = { "application/json" })
	public List<Cartorio> todos() {
//		List<Cartorio> cartorios = new ArrayList<Cartorio>();

		// for (Cartorio cartorio : this.cartorioService.listarCartorios()) {
		// Cartorio cartorioDTO = new Cartorio();
		// cartorioDTO.setId(cartorio.getId());
		// cartorio.getEndereco().setCartorio(null);
		// cartorioDTO.setEndereco(cartorio.getEndereco());
		// cartorios.add(cartorioDTO);
		// }

		return cartorioService.listarCartorios();
	}

	@RequestMapping(value = "/enderecos", method = RequestMethod.GET, produces = { "application/json" })
	public List<Endereco> todosE() {
		// List<Endereco> enderecos = new ArrayList<Endereco>();
		//
		// for (Cartorio cartorio : this.cartorioService.listarCartorios()) {
		// Endereco enderecoDTO = new Endereco();
		// Cartorio cartorioDTO = new Cartorio();
		// cartorioDTO.setId(cartorio.getId());
		// enderecoDTO.setId(cartorio.getEndereco().getId());
		// enderecoDTO.setRua(cartorio.getEndereco().getRua());
		// enderecoDTO.setCartorio(cartorioDTO);
		// enderecos.add(enderecoDTO);
		// }
		return enderecoRepository.listarEnderecos();
	}

	@RequestMapping(value = "/cartorios-string", method = RequestMethod.GET, produces = { "application/json" })
	public String todosS() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		//String rootName = Cartorio.class.getAnnotation(JsonRootName.class).value();
		
		String json = mapper.writer().withRootName("cartorios").writeValueAsString(cartorioService.listarCartorios());
		

		return json;
	}

}
