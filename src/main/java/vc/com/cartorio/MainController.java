package vc.com.cartorio;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.service.CartorioService;

@Controller
public class MainController {
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

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String novoCartorio(Model model) {
		model.addAttribute("cartorio", new Cartorio());
		return "cadastro";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String salvarCartorio( @Valid Cartorio cartorio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<ObjectError> erros= result.getAllErrors();
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
	public String editCartorio(@PathVariable("id") int id, Model model) {
		model.addAttribute("cartorio", this.cartorioService.getCartorioPorId(id));
		return "cadastro";
	}
	
	

}
