package vc.com.cartorio.service;

import java.util.List;

import vc.com.cartorio.domain.Endereco;

public interface EnderecoService {

	public void adicionarEndereco(Endereco c);
	public void atualizarEndereco(Endereco c);
	public List<Endereco> listarEnderecos();
	public Endereco getEnderecoPorId(int id);
	public void removerEndereco(int id);
	
}
