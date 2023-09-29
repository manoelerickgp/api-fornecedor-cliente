package com.ecommerce.API.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API.Ecommerce.model.Cliente;
import com.ecommerce.API.Ecommerce.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente buscar(Long id) {
		
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
		
	}

	@Override
	public void atualizar(Long id, Cliente novoCliente) {
		
		if (id != null) {
			
			try {
				
				Cliente cliente = this.buscar(id);
				
				cliente.setNome(novoCliente.getNome());
				cliente.setCpf(novoCliente.getCpf());
				cliente.setDataNascimento(novoCliente.getDataNascimento());
				cliente.setRg(novoCliente.getRg());
				cliente.setContato(novoCliente.getContato());
				cliente.setEndereco(novoCliente.getEndereco());
				
				clienteRepository.save(cliente);
				
			} catch (Exception e) {
				throw e;
			}
		}
		
	}

}
