package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.model.Cliente;

public interface ClienteService {

	public Cliente buscar(Long id);

	public void salvar(Cliente cliente);

	public void excluir(Cliente cliente);

	public void atualizar(Long id, Cliente novoCliente);
}
