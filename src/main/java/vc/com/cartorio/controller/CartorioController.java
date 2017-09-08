package vc.com.cartorio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.dto.ListaCartoriosDTO;
import vc.com.cartorio.service.CartorioService;

@Controller
public class CartorioController {
	@Autowired
	private CartorioService cartorioService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listarCartorios(Model model) {
		model.addAttribute("listCartorios", this.cartorioService.listarCartorios());
		if (this.cartorioService.listarCartorios().isEmpty()) {
			model.addAttribute("mensagemerro", "Não a cartórios cadastrados! Favor cadastrar um cartório!");
		}
		return "consulta";
	}
	
	@RequestMapping(value = "/consulta-jquery", method = RequestMethod.GET)
	public String listarCartoriosJquery(Model model) {
		return "consultaJquery";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String novoCartorio(Model model) {
		model.addAttribute("cartorio", new Cartorio());
		return "cadastro";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String salvarCartorio(@Valid Cartorio cartorio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<ObjectError> erros = result.getAllErrors();
			List<String> mensagemerros = new ArrayList<String>();
			for (ObjectError objectError : erros) {
				mensagemerros.add(objectError.getDefaultMessage());
			}
			model.addAttribute("mensagemerros", mensagemerros);
			return "cadastro";
		}
		if (cartorio.getId() == 0) {
			cartorio.getEndereco().setCartorio(cartorio);
			cartorio = cartorioService.adicionarCartorio(cartorio);
		} else {
			this.cartorioService.atualizarCartorio(cartorio);
		}
		model.addAttribute("cartorio", new Cartorio());
		model.addAttribute("mensagem", "Cartório Salvo com sucesso!");
		return "cadastro";
	}

	@RequestMapping("/remover/{id}")
	public String removerCartorio(@PathVariable("id") int id, Model model) {
		try {
			this.cartorioService.removerCartorio(id);
			model.addAttribute("mensagem", "Cartório Removido com sucesso!");

		} catch (Exception e) {
			model.addAttribute("mensagemerro", "Não foi possivel remover o Cartorio!");
		}

		model.addAttribute("listCartorios", this.cartorioService.listarCartorios());
		return "consulta";
	}

	@RequestMapping("/editar/{id}")
	public String editarCartorio(@PathVariable("id") int id, Model model) {
		model.addAttribute("cartorio", this.cartorioService.getCartorioPorId(id));
		return "cadastro";
	}

	@RequestMapping(value = "/editar/todos", method = RequestMethod.GET)
	public String editartodos(Model model) {
		model.addAttribute("cartorios", this.cartorioService.listarCartorios());
		if (this.cartorioService.listarCartorios().isEmpty()) {
			model.addAttribute("mensagemerro", "Não a cartórios cadastrados! Favor cadastrar um cartório!");
		}
		return "editarTodos";
	}

	@RequestMapping(value = "/editar/todos", method = RequestMethod.POST)
	public String salvarTodos(@Valid ListaCartoriosDTO listaCartoriosDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<ObjectError> erros = result.getAllErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			List<String> mensagemerros = new ArrayList<String>();
			List<String> campoerros = new ArrayList<String>();
//			for (ObjectError objectError : erros) {
//				mensagemerros.add(objectError.getDefaultMessage());
//			}
			for (FieldError fieldError : fieldErrors) {
				System.out.println(fieldError.getDefaultMessage());
				System.out.println(fieldError.getField());
				mensagemerros.add(fieldError.getField());
				campoerros.add(fieldError.getDefaultMessage());
			}
			model.addAttribute("cartorios", listaCartoriosDTO.getCartorios());
			model.addAttribute("mensagemerros", mensagemerros);
			model.addAttribute("campoerros", campoerros);
			return "editarTodos";
		}
		for (Cartorio c : listaCartoriosDTO.getCartorios()) {
			System.out.println(c.getNome());
			cartorioService.atualizarCartorio(c);
		}
		model.addAttribute("mensagem", "Cartório Salvo com sucesso!");
		return this.editartodos(model);
	}
}
