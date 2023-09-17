package com.ecommerce.API.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API.Ecommerce.model.Fornecedor;
import com.ecommerce.API.Ecommerce.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService{ 
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	public Fornecedor buscar(Long id) {
		
		return fornecedorRepository.findById(id).orElse(null);
	}

	@Override
	public void salvar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void excluir(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
		
	}

	@Override
	public void atualizar(Long id, Fornecedor novoFornecedor) {
		
		if (id != null) {
			
			try {
				
				Fornecedor fornecedor = this.buscar(id);
				
				fornecedor.setCnpj(novoFornecedor.getCnpj());
				fornecedor.setNome(novoFornecedor.getNome());
				fornecedor.setContato(novoFornecedor.getContato());
				fornecedor.setEndereco(novoFornecedor.getEndereco());
				
				fornecedorRepository.save(fornecedor);
				
			} catch (Exception e) {
				throw e;
			}
		}
		
	}
	
	

}
