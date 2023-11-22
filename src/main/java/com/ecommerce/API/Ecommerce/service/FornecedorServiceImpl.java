package com.ecommerce.API.Ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;
import com.ecommerce.API.Ecommerce.mapper.FornecedorMapper;
import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.model.Endereco;
import com.ecommerce.API.Ecommerce.model.Fornecedor;
import com.ecommerce.API.Ecommerce.repository.ContatoRepository;
import com.ecommerce.API.Ecommerce.repository.EnderecoRepository;
import com.ecommerce.API.Ecommerce.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private FornecedorMapper fornecedorMapper;

	@Override
	public FornecedorDTO buscar(Long id) {

		Fornecedor fornecedor = null;

		if (id != null) {

			try {

				fornecedor = fornecedorRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("Fornecedor não foi encontrado no sistema.", e);
			}
		}

		FornecedorDTO dto = this.fornecedorMapper.toDTO(fornecedor);

		return dto;
	}

	@Override
	public void salvar(Fornecedor fornecedor) {

		if (this.fornecedorRepository.existsByCnpj(fornecedor.getCnpj()))
			throw new RuntimeException("Ocorreu um erro ao tentar salvar o fornecedor. Cnpj ja esta cadastrado.");

		if (fornecedor.getEndereco().getId() != null) {

			Endereco endereco = this.enderecoRepository.findById(fornecedor.getEndereco().getId()).orElse(null);

			fornecedor.setEndereco(endereco);
		}

		if (fornecedor.getContato().getId() != null) {

			Contato contato = this.contatoRepository.findById(fornecedor.getContato().getId()).orElse(null);

			fornecedor.setContato(contato);
		}

		try {

			fornecedorRepository.save(fornecedor);

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao tentar salvar o fornecedor.", e);
		}
	}

	@Override
	@Transactional
	public void excluir(Long id) {

		if (id != null) {

			Fornecedor fornecedor = null;

			try {

				fornecedor = this.fornecedorRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("Fornecedor não foi encontrado no sistema.", e);
			}

			this.fornecedorRepository.delete(fornecedor);
		}
	}

	@Override
	public void atualizar(Long id, Fornecedor novoFornecedor) {

		if (id != null) {

			Fornecedor fornecedor;

			try {

				fornecedor = this.fornecedorRepository.findById(id).orElse(null);

			} catch (Exception e) {
				throw new RuntimeException("Fornecedor não foi encontrado no sistema.", e);
			}

			/*
			 * Cnpj não pode ser alterado.
			 */
			fornecedor.setNome(novoFornecedor.getNome());

			if (fornecedor.getEndereco().getId() != null) {

				Endereco endereco = this.enderecoRepository.findById(fornecedor.getEndereco().getId()).orElse(null);

				fornecedor.setEndereco(endereco);
			}

			if (fornecedor.getContato().getId() != null) {

				Contato contato = this.contatoRepository.findById(fornecedor.getContato().getId()).orElse(null);

				fornecedor.setContato(contato);
			}

			fornecedorRepository.save(fornecedor);
		}
	}

}
