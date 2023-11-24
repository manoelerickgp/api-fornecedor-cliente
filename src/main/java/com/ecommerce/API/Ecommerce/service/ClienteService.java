package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO buscar(Long id);

    void salvar(ClienteDTO cliente);

    void excluir(Long id);

    void atualizar(Long id, ClienteDTO novoClienteDTO);

}
