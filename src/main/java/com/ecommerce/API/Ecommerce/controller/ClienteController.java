package com.ecommerce.API.Ecommerce.controller;

import com.ecommerce.API.Ecommerce.dto.ClienteDTO;
import com.ecommerce.API.Ecommerce.service.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(clienteService.buscar(id), HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO) {
        clienteService.salvar(clienteDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable(value = "id") Long id) {
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable(value = "id") Long id, @RequestBody ClienteDTO novoCliente) {
        clienteService.atualizar(id, novoCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
