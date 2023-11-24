package com.ecommerce.API.Ecommerce.dto;

import com.ecommerce.API.Ecommerce.model.Contato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO implements Serializable {

    private Long id;
    private Long telefone;
    private String email;

    public ContatoDTO(Contato contato) {
        this.telefone = contato.getTelefone();
        this.email = contato.getEmail();
    }

}
