package vc.com.cartorio.service;

import java.util.List;

import vc.com.cartorio.domain.Cartorio;

public interface CartorioService {

	public Cartorio adicionarCartorio(Cartorio c);
	public void atualizarCartorio(Cartorio c);
	public List<Cartorio> listarCartorios();
	public Cartorio getCartorioPorId(int id);
	public void removerCartorio(int id);
	
}
