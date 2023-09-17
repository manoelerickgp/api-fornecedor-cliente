package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.model.Fornecedor;

public interface FornecedorService {

	public Fornecedor buscar(Long id);

	public void salvar(Fornecedor fornecedor);

	public void excluir(Fornecedor fornecedor);

	public void atualizar(Long id, Fornecedor novoFornecedor);
}
