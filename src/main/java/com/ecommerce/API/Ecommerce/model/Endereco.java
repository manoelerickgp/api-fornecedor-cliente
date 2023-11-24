package com.ecommerce.API.Ecommerce.model;

import com.ecommerce.API.Ecommerce.enums.Estado;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@DynamicUpdate
@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 985098201651404172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String rua;

	@Column(nullable = false)
	private Long numero;

	@Column(length = 50, nullable = false)
	private String cidade;

	@Enumerated(EnumType.STRING)
	private Estado estado;

	@Column(length = 30, nullable = false)
	private String pais;

}
