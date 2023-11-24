package com.ecommerce.API.Ecommerce.controller;

import com.ecommerce.API.Ecommerce.dto.EnderecoDTO;
import com.ecommerce.API.Ecommerce.service.EnderecoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

    private final EnderecoServiceImpl enderecoService;

    public EnderecoController(EnderecoServiceImpl enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<EnderecoDTO> buscar(@PathVariable(value = "id") Long id) {
        var endereco = enderecoService.buscar(id);
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Void> salvar(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.salvar(enderecoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(value = "id") Long id) {
        enderecoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable(value = "id") Long id, @RequestBody EnderecoDTO novoEnderecoDTO) {
        enderecoService.atualizar(id, novoEnderecoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
