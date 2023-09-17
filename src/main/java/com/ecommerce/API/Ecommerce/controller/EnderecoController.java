package com.ecommerce.API.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.API.Ecommerce.model.Endereco;
import com.ecommerce.API.Ecommerce.service.EnderecoServiceImpl;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoServiceImpl enderecoService;

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Endereco buscar(@PathVariable(value = "id") Long id) {

		return enderecoService.buscar(id);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Endereco endereco) {

		enderecoService.salvar(endereco);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable(value = "id") Long id) {

		Endereco endereco = enderecoService.buscar(id);

		enderecoService.excluir(endereco);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody Endereco novoEndereco) {

		enderecoService.atualizar(id, novoEndereco);
	}

}
