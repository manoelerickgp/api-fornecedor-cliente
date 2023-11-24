package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;

public interface FornecedorService {

	FornecedorDTO buscar(Long id);
	void salvar(FornecedorDTO fornecedorDTO);
	void excluir(Long id);
	void atualizar(Long id, FornecedorDTO novoFornecedorDTO);
}
