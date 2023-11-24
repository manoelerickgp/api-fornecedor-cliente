package com.ecommerce.API.Ecommerce.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Calendar;

@DynamicUpdate
@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	@Serial
	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Calendar dataNascimento;

	private String cpf;

	private String rg;

	@OneToOne(cascade = CascadeType.ALL)
	private Contato contato;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

}
