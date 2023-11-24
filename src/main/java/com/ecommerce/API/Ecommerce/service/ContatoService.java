package com.ecommerce.API.Ecommerce.service;

import com.ecommerce.API.Ecommerce.dto.ContatoDTO;

public interface ContatoService {

    ContatoDTO buscar(Long id);

    void salvar(ContatoDTO contatoDTO);

    void excluir(Long id);

    void atualizar(Long id, ContatoDTO novoContatoDTO);

}
