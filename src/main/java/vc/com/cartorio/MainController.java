package vc.com.cartorio;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vc.com.cartorio.dao.CartorioDAO;
import vc.com.cartorio.dao.CartorioDAOImpl;
import vc.com.cartorio.model.Cartorio;
import vc.com.cartorio.service.CartorioService;
import vc.com.cartorio.service.CartorioServiceImpl;

@Controller
public class MainController {

	private CartorioService cartorioService;

	@Autowired(required = true)
	@Qualifier(value = "cartorioService")
	public void setCartorioService(CartorioService cs) {
		this.cartorioService = cs;
	}

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
	public String salvarCartorio(Model model, @ModelAttribute("cartorio") Cartorio c) {
		if (c.getNome().equals("") || c.getNome().equals(null)) {
			model.addAttribute("mensagemerro", "Nome não pode estar em branco!");
			return "cadastro";
		} else {
			if (c.getId() == 0) {
				System.out.println("novo");
				this.cartorioService.adicionarCartorio(c);
			} else {
				System.out.println("salvando");
				this.cartorioService.atualizarCartorio(c);
			}
			model.addAttribute("cartorio", new Cartorio());
			model.addAttribute("mensagem", "Cartório Salvo com sucesso!");
			return "cadastro";
		}
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
