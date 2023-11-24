package com.ecommerce.API.Ecommerce.controller;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;
import com.ecommerce.API.Ecommerce.service.FornecedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/fornecedor")
public class FornecedorController {

    private final FornecedorServiceImpl fornecedorService;

    public FornecedorController(FornecedorServiceImpl fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<FornecedorDTO> buscar(@PathVariable(value = "id") Long id) {
        var fornecedor = fornecedorService.buscar(id);
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Void> salvar(@RequestBody FornecedorDTO fornecedorDTO) {
        fornecedorService.salvar(fornecedorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
        fornecedorService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable(value = "id") Long id, @RequestBody FornecedorDTO novoFornecedorDTO) {
        fornecedorService.atualizar(id, novoFornecedorDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
