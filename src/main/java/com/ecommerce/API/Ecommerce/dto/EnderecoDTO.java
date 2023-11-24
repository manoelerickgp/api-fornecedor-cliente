package com.ecommerce.API.Ecommerce.dto;

import com.ecommerce.API.Ecommerce.enums.Estado;
import com.ecommerce.API.Ecommerce.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO implements Serializable {

    private Long id;
    private String rua;
    private Long numero;
    private String cidade;
    private Estado estado;
    private String pais;

    public EnderecoDTO(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getId();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.pais = endereco.getPais();
    }

}
