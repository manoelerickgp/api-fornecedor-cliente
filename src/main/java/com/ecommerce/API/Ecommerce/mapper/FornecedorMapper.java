/*
package com.ecommerce.API.Ecommerce.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.ecommerce.API.Ecommerce.dto.FornecedorDTO;
import com.ecommerce.API.Ecommerce.model.Fornecedor;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class FornecedorMapper extends Fornecedor implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	public FornecedorMapper() {

		super(Fornecedor.class);
	}

	@Mappings({
		@Mapping(target = "rua", source = "endereco.rua"),
		@Mapping(target = "numero", source = "endereco.numero"),
		@Mapping(target = "cidade", source = "endereco.cidade"),
		@Mapping(target = "estado", source = "endereco.estado.descricao"),
		@Mapping(target = "pais", source = "endereco.pais"),
		@Mapping(target = "telefone", source = "contato.telefone"),
		@Mapping(target = "email", source = "contato.email"),
	})
	public abstract FornecedorDTO toDTO(Fornecedor fornecedor);

}
*/
