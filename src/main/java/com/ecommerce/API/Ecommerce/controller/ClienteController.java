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

import com.ecommerce.API.Ecommerce.model.Cliente;
import com.ecommerce.API.Ecommerce.service.ClienteServiceImpl;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscar(@PathVariable(value = "id") Long id) {

		return clienteService.buscar(id);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Cliente cliente) {

		clienteService.salvar(cliente);

	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable(value = "id") Long id) {

		Cliente cliente = clienteService.buscar(id);

		clienteService.excluir(cliente);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(value = "id") Long id, @RequestBody Cliente novoCliente) {
		
		clienteService.atualizar(id, novoCliente);

	}

}
