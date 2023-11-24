package com.ecommerce.API.Ecommerce.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@DynamicUpdate
@Data
@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 14, nullable = false)
	private String cnpj;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	private Contato contato;

}
