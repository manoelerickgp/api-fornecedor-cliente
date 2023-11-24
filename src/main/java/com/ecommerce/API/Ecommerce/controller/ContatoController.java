package com.ecommerce.API.Ecommerce.controller;

import com.ecommerce.API.Ecommerce.dto.ContatoDTO;
import com.ecommerce.API.Ecommerce.service.ContatoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/contato")
public class ContatoController {

    private final ContatoServiceImpl contatoService;

    public ContatoController(ContatoServiceImpl contatoService, ModelMapper mapper) {
        this.contatoService = contatoService;
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<ContatoDTO> buscar(@PathVariable(value = "id") Long id) {
        var contatoDTO = contatoService.buscar(id);
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Void> salvar(@RequestBody ContatoDTO contatoDTO) {
        contatoService.salvar(contatoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(value = "id") Long id) {
        contatoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable(value = "id") Long id, @RequestBody ContatoDTO novoContatoDTO) {
        contatoService.atualizar(id, novoContatoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
