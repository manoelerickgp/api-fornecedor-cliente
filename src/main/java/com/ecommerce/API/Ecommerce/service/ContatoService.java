package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.model.Contato;

public interface ContatoService {

	public Contato buscar(Long id);

	public void salvar(Contato contato);

	public void excluir(Contato contato);

}
