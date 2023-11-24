package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.EnderecoDTO;

public interface EnderecoService {

    EnderecoDTO buscar(Long id);

    void salvar(EnderecoDTO enderecoDTO);

    void excluir(Long id);

    void atualizar(Long id, EnderecoDTO novoEnderecoDTO);
}
