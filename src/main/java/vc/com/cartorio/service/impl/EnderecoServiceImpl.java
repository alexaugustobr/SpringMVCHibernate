package vc.com.cartorio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.com.cartorio.domain.Endereco;
import vc.com.cartorio.repository.EnderecoRepository;
import vc.com.cartorio.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	@Autowired
	private EnderecoRepository EnderecoRepository;

	public void setEnderecoDAO(EnderecoRepository EnderecoRepository) {
		this.EnderecoRepository = EnderecoRepository;
	}

	@Override
	@Transactional
	public void adicionarEndereco(Endereco p) {
		this.EnderecoRepository.adicionarEndereco(p);
	}

	@Override
	@Transactional
	public void atualizarEndereco(Endereco p) {
		this.EnderecoRepository.atualizarEndereco(p);
	}

	@Override
	@Transactional
	public List<Endereco> listarEnderecos() {
		return this.EnderecoRepository.listarEnderecos();
	}

	@Override
	@Transactional
	public Endereco getEnderecoPorId(int id) {
		return this.EnderecoRepository.getEnderecoPorId(id);
	}

	@Override
	@Transactional
	public void removerEndereco(int id) {
		this.EnderecoRepository.removerEndereco(id);
	}

}
