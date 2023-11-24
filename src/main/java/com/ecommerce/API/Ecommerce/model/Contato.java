package com.ecommerce.API.Ecommerce.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@DynamicUpdate
@Data
@Entity
@Table(name = "tb_contato")
public class Contato implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	@Column(length = 15, nullable = false)
	private Long telefone;

	@Column(length = 30, nullable = false)
	private String email;

}
