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

		if (id != null) {

			try {

				return contatoRepository.findById(id).map(c -> {
					c.getId();
					return c;
				}).orElse(null);

			} catch (Exception e) {
				throw e;
			}
		}

		return null;
	}

	@Override
	public void salvar(Contato contato) {

		if (contato != null) {

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

			try {

				contatoRepository.delete(contato);

			} catch (Exception e) {
				throw e;
			}
		}
	}

}
