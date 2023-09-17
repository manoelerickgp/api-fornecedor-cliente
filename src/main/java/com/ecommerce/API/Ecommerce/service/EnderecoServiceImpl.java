package com.ecommerce.API.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API.Ecommerce.model.Endereco;
import com.ecommerce.API.Ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco buscar(Long id) {
		
		return enderecoRepository.findById(id).orElse(null);
	}

	@Override
	public void salvar(Endereco endereco) {

		if (endereco != null) {

			try {

				enderecoRepository.save(endereco);

			} catch (Exception e) {
				throw e;
			}
		}
	}

	@Override
	public void excluir(Endereco endereco) {

		if (endereco != null)
			enderecoRepository.delete(endereco);

	}

	@Override
	public void atualizar(Long id, Endereco novoEndereco) {
		
		Endereco endereco = this.buscar(id);
		
		if (endereco != null) {
			
			try {
				
				endereco.setRua(novoEndereco.getRua());
				endereco.setNumero(novoEndereco.getNumero());
				endereco.setCidade(novoEndereco.getCidade());
				endereco.setEstado(novoEndereco.getEstado());
				endereco.setPais(novoEndereco.getPais());
				
				enderecoRepository.save(endereco);
				
			} catch (Exception e) {
				throw e;
			}
			
		}
	}

}
