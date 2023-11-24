package com.ecommerce.API.Ecommerce.dto;

import com.ecommerce.API.Ecommerce.model.Cliente;
import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private Calendar dataNascimento;
    private String cpf;
    private String rg;
    private Contato contato;
    private Endereco endereco;

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.rg = cliente.getRg();
        this.contato = cliente.getContato();
        this.endereco = cliente.getEndereco();
    }

}
