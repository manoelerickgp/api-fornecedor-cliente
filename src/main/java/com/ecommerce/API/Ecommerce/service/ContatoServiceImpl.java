package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.ContatoDTO;
import com.ecommerce.API.Ecommerce.exceptions.NotFoundException;
import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.repository.ContatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;
    private final ModelMapper mapper;

    public ContatoServiceImpl(ContatoRepository contatoRepository, ModelMapper mapper) {
        this.contatoRepository = contatoRepository;
        this.mapper = mapper;
    }

    @Override
    public ContatoDTO buscar(Long id) {
        var contato = contatoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contato Não Encontrado"));
        return mapper.map(contato, ContatoDTO.class);
    }

    @Override
    public void salvar(ContatoDTO contatoDTO) {
        var contato = mapper.map(contatoDTO, Contato.class);
        try {
            contatoRepository.save(contato);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar salvar.", e);
        }
    }

    @Override
    public void excluir(Long id) {
        var contato = mapper.map(buscar(id), Contato.class);
        contatoRepository.delete(contato);
    }

    @Override
    public void atualizar(Long id, ContatoDTO novoContato) {
        var contatoSalvo = mapper.map(buscar(id), Contato.class);
        atualizarContato(contatoSalvo, novoContato);
        contatoRepository.save(contatoSalvo);
    }

    private void atualizarContato(Contato contatoSalvo, ContatoDTO novoContato) {
        contatoSalvo.setTelefone(novoContato.getTelefone());
        contatoSalvo.setEmail(novoContato.getEmail());
    }

}
