package vc.com.cartorio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.com.cartorio.dao.CartorioDAO;
import vc.com.cartorio.model.Cartorio;

@Service
public class CartorioServiceImpl implements CartorioService {
	
	private CartorioDAO CartorioDAO;

	public void setCartorioDAO(CartorioDAO CartorioDAO) {
		this.CartorioDAO = CartorioDAO;
	}

	@Override
	@Transactional
	public void adicionarCartorio(Cartorio p) {
		this.CartorioDAO.adicionarCartorio(p);
	}

	@Override
	@Transactional
	public void atualizarCartorio(Cartorio p) {
		this.CartorioDAO.atualizarCartorio(p);
	}

	@Override
	@Transactional
	public List<Cartorio> listarCartorios() {
		return this.CartorioDAO.listarCartorios();
	}

	@Override
	@Transactional
	public Cartorio getCartorioPorId(int id) {
		return this.CartorioDAO.getCartorioPorId(id);
	}

	@Override
	@Transactional
	public void removerCartorio(int id) {
		this.CartorioDAO.removerCartorio(id);
	}

}
