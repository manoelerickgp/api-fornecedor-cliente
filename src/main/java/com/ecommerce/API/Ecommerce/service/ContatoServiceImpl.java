package com.ecommerce.API.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public Contato buscar(Long id) {

		return contatoRepository.findById(id).orElse(null);
	}

	@Override
	public void salvar(Contato contato) {

		if (contato != null) {

			if (contato.getEmail() == null || contato.getEmail().isEmpty()) {
				throw new IllegalArgumentException("O campo 'email' não pode ser nulo");
			}

			try {

				contatoRepository.save(contato);

			} catch (Exception e) {
				throw e;
			}
		}
	}

	@Override
	public void excluir(Contato contato) {

		if (contato != null) {

			contatoRepository.delete(contato);

		}
	}

	@Override
	public void atualizar(Long id, Contato novoContato) {

		Contato contato = this.buscar(id);

		if (contato != null) {

			try {

				contato.setTelefone(novoContato.getTelefone());
				contato.setEmail(novoContato.getEmail());

				contatoRepository.save(contato);

			} catch (Exception e) {
				throw new IllegalArgumentException("ID não encontrado na base de dados.");
			}
		}

	}

}
