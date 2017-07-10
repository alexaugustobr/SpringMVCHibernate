package vc.com.cartorio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.com.cartorio.domain.Cartorio;
import vc.com.cartorio.repository.CartorioRepository;
import vc.com.cartorio.service.CartorioService;

@Service
public class CartorioServiceImpl implements CartorioService {
	@Autowired
	private CartorioRepository CartorioRepository;
	
	public void setCartorioDAO(CartorioRepository CartorioRepository) {
		this.CartorioRepository = CartorioRepository;
	}

	@Override
	@Transactional
	public Cartorio adicionarCartorio(Cartorio c) {
		return CartorioRepository.adicionarCartorio(c);
	}

	@Override
	@Transactional
	public void atualizarCartorio(Cartorio c) {
		this.CartorioRepository.atualizarCartorio(c);
	}

	@Override
	@Transactional
	public List<Cartorio> listarCartorios() {
		return this.CartorioRepository.listarCartorios();
	}

	@Override
	@Transactional
	public Cartorio getCartorioPorId(int id) {
		return this.CartorioRepository.getCartorioPorId(id);
	}

	@Override
	@Transactional
	public void removerCartorio(int id) {
		this.CartorioRepository.removerCartorio(id);
	}

}
