package com.ecommerce.API.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;
import com.ecommerce.API.Ecommerce.model.Fornecedor;
import com.ecommerce.API.Ecommerce.service.FornecedorServiceImpl;

@RestController
@RequestMapping(value = "/api/fornecedor", produces = MediaType.APPLICATION_JSON_VALUE)
public class FornecedorController {

	@Autowired
	private FornecedorServiceImpl fornecedorService;

	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<FornecedorDTO> buscar(@PathVariable(value = "id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(this.fornecedorService.buscar(id));
	}

	@PostMapping(value = "/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Fornecedor fornecedor) {

		fornecedorService.salvar(fornecedor);

	}

	@DeleteMapping(value = "/excluir/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable(value = "id") Long id) {

		fornecedorService.excluir(id);
	}

	@RequestMapping(value = "/atualizar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody Fornecedor novoFornecedor) {
		
		fornecedorService.atualizar(id, novoFornecedor);

	}

}
