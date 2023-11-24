package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.ClienteDTO;
import com.ecommerce.API.Ecommerce.exceptions.NotFoundException;
import com.ecommerce.API.Ecommerce.model.Cliente;
import com.ecommerce.API.Ecommerce.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ModelMapper mapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ModelMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public ClienteDTO buscar(Long id) {
        var cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente Não Encontrado"));
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public void salvar(ClienteDTO clienteDTO) {
        var cliente = mapper.map(clienteDTO, Cliente.class);
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar salvar.", e);
        }
    }

    @Override
    public void excluir(Long id) {
        var cliente = mapper.map(buscar(id), Cliente.class);
        clienteRepository.delete(cliente);
    }

    @Override
    public void atualizar(Long id, ClienteDTO novoClienteDTO) {
        var clienteSalvo = mapper.map(this.buscar(id), Cliente.class);
        atualizarCliente(clienteSalvo, novoClienteDTO);
        clienteRepository.save(clienteSalvo);
    }

    private void atualizarCliente(Cliente clienteSalvo, ClienteDTO novoCliente) {
        clienteSalvo.setNome(novoCliente.getNome());
        clienteSalvo.setCpf(novoCliente.getCpf());
        clienteSalvo.setDataNascimento(novoCliente.getDataNascimento());
        clienteSalvo.setRg(novoCliente.getRg());
        clienteSalvo.setContato(novoCliente.getContato());
        clienteSalvo.setEndereco(novoCliente.getEndereco());
    }

}

