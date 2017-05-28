package vc.com.cartorio.dao;

import java.util.List;

import vc.com.cartorio.model.Cartorio;

public interface CartorioDAO {

	public void adicionarCartorio(Cartorio c);
	public void atualizarCartorio(Cartorio c);
	public List<Cartorio> listarCartorios();
	public Cartorio getCartorioPorId(int id);
	public void removerCartorio(int id);
}
