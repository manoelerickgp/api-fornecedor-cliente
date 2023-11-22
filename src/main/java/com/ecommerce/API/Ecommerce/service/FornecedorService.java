package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;
import com.ecommerce.API.Ecommerce.model.Fornecedor;

public interface FornecedorService {

	public FornecedorDTO buscar(Long id);

	public void salvar(Fornecedor fornecedor);

	public void excluir(Long id);

	public void atualizar(Long id, Fornecedor novoFornecedor);
}
