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

import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.service.ContatoServiceImpl;

@RestController
@RequestMapping(value = "/api/contato")
public class ContatoController {

	@Autowired
	private ContatoServiceImpl contatoService;

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Contato buscar(@PathVariable(value = "id") Long id) {

		return contatoService.buscar(id);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Contato contato) {

		contatoService.salvar(contato);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable(value = "id") Long id) {

		Contato contato = contatoService.buscar(id);

		contatoService.excluir(contato);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody Contato novoContato) {

		contatoService.atualizar(id, novoContato);

	}

}
