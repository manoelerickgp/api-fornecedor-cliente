package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.model.Endereco;

public interface EnderecoService {

	public Endereco buscar(Long id);

	public void salvar(Endereco endereco);

	public void excluir(Endereco endereco);

	public void atualizar(Long id, Endereco novoEndereco);
}
