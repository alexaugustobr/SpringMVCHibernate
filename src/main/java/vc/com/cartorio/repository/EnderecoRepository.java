package vc.com.cartorio.repository;

import java.util.List;

import vc.com.cartorio.domain.Endereco;

public interface EnderecoRepository {

	public void adicionarEndereco(Endereco e);
	public void atualizarEndereco(Endereco e);
	public List<Endereco> listarEnderecos();
	public Endereco getEnderecoPorId(int id);
	public void removerEndereco(int id);
}
