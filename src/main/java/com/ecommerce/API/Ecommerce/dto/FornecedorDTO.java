package com.ecommerce.API.Ecommerce.dto;

import com.ecommerce.API.Ecommerce.model.Contato;
import com.ecommerce.API.Ecommerce.model.Endereco;
import com.ecommerce.API.Ecommerce.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO implements Serializable {

    private Long id;
    private String nome;
    private String cnpj;
    private Contato contato;
    private Endereco endereco;

    public FornecedorDTO(Fornecedor forncedor) {
        this.nome = forncedor.getNome();
        this.cnpj = forncedor.getCnpj();
        this.contato = forncedor.getContato();
        this.endereco = forncedor.getEndereco();
    }
}
