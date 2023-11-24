package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;
import com.ecommerce.API.Ecommerce.exceptions.NotFoundException;
import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.model.Endereco;
import com.ecommerce.API.Ecommerce.model.Fornecedor;
import com.ecommerce.API.Ecommerce.repository.ContatoRepository;
import com.ecommerce.API.Ecommerce.repository.EnderecoRepository;
import com.ecommerce.API.Ecommerce.repository.FornecedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FornecedorServiceImpl implements FornecedorService{ 

	private final FornecedorRepository fornecedorRepository;
	private final EnderecoRepository enderecoRepository;
	private final ContatoRepository contatoRepository;
	private final ModelMapper mapper;

	public FornecedorServiceImpl(FornecedorRepository fornecedorRepository, EnderecoRepository enderecoRepository,
								 ContatoRepository contatoRepository, ModelMapper mapper) {
		this.fornecedorRepository = fornecedorRepository;
		this.enderecoRepository = enderecoRepository;
		this.contatoRepository = contatoRepository;
		this.mapper = mapper;
	}

	@Override
	public FornecedorDTO buscar(Long id) {
		var fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id Fornecedor Não Encontrado"));
		return mapper.map(fornecedor, FornecedorDTO.class);
	}

	@Override
	public void salvar(FornecedorDTO fornecedorDTO) {
		var fornecedor = mapper.map(fornecedorDTO, Fornecedor.class);

		if (this.fornecedorRepository.existsByCnpj(fornecedor.getCnpj()))
			throw new RuntimeException("Ocorreu um erro ao tentar salvar o fornecedor. Cnpj ja esta cadastrado.");

		if (fornecedor.getEndereco().getId() != null) {
			Endereco endereco = this.enderecoRepository.findById(fornecedor.getEndereco().getId())
					.orElseThrow(() -> new NotFoundException("Id Endereco Não Foi Encontrado"));
			fornecedor.setEndereco(endereco);
		}

		if (fornecedor.getContato().getId() != null) {
			Contato contato = this.contatoRepository.findById(fornecedor.getContato().getId())
					.orElseThrow(() -> new NotFoundException("Id Contato Não Foi Encontrado"));
			fornecedor.setContato(contato);
		}

		try {
			fornecedorRepository.save(fornecedor);

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar salvar o fornecedor.", e);
		}
	}

	@Override
	public void excluir(Long id) {
		var fornecedor = mapper.map(this.buscar(id), Fornecedor.class);
		this.fornecedorRepository.delete(fornecedor);
	}

	@Override
	public void atualizar(Long id, FornecedorDTO novoFornecedorDTO) {
		var fornecedorSalvo = mapper.map(this.buscar(id), Fornecedor.class);

		if (fornecedorSalvo.getEndereco().getId() != null) {
			Endereco endereco = this.enderecoRepository.findById(fornecedorSalvo.getEndereco().getId())
					.orElseThrow(() -> new NotFoundException("Id Endereco Não Foi Encontrado"));
			fornecedorSalvo.setEndereco(endereco);
		}

		if (fornecedorSalvo.getContato().getId() != null) {
			Contato contato = this.contatoRepository.findById(fornecedorSalvo.getContato().getId())
					.orElseThrow(() -> new NotFoundException("Id Contato Não Foi Encontrado"));
			fornecedorSalvo.setContato(contato);
		}
		updateFornecedor(fornecedorSalvo, novoFornecedorDTO);
		try {
			this.fornecedorRepository.save(fornecedorSalvo);

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar atualizar o fornecedor.", e);
		}
	}

	private void updateFornecedor(Fornecedor fornecedorSalvo, FornecedorDTO novoFornecedor) {
		fornecedorSalvo.setNome(novoFornecedor.getNome());
	}

}
