package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.EnderecoDTO;
import com.ecommerce.API.Ecommerce.exceptions.NotFoundException;
import com.ecommerce.API.Ecommerce.model.Endereco;
import com.ecommerce.API.Ecommerce.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ModelMapper mapper;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, ModelMapper mapper) {
        this.enderecoRepository = enderecoRepository;
        this.mapper = mapper;
    }

    @Override
    public EnderecoDTO buscar(Long id) {
        var endereco = this.enderecoRepository
                .findById(id).orElseThrow(() -> new NotFoundException("Id de Endereco Não foi encontrado"));
        return mapper.map(endereco, EnderecoDTO.class);
    }

    @Override
    public void salvar(EnderecoDTO enderecoDTO) {
        var endereco = mapper.map(enderecoDTO, Endereco.class);
        enderecoRepository.save(endereco);
    }

    @Override
    public void excluir(Long id) {
        var endereco = mapper.map(buscar(id), Endereco.class);
        enderecoRepository.delete(endereco);
    }

    @Override
    public void atualizar(Long id, EnderecoDTO novoEnderecoDTO) {
        var enderecoSalvo = mapper.map(buscar(id), Endereco.class);
        atualizarEndereco(enderecoSalvo, novoEnderecoDTO);
        enderecoRepository.save(enderecoSalvo);
    }

    private void atualizarEndereco(Endereco enderecoSalvo, EnderecoDTO novoEndereco) {
        enderecoSalvo.setRua(novoEndereco.getRua());
        enderecoSalvo.setNumero(novoEndereco.getNumero());
        enderecoSalvo.setCidade(novoEndereco.getCidade());
        enderecoSalvo.setEstado(novoEndereco.getEstado());
        enderecoSalvo.setPais(novoEndereco.getPais());
    }

}
