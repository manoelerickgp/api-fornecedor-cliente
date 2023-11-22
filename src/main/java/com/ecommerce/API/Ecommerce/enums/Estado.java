package com.ecommerce.API.Ecommerce.enums;

public enum Estado {

	AC(0L, "Acre"),
	AL(1L, "Alagoas"),
	AP(2L, "Amapá"),
	AM(3L, "Amazonas"),
	BA(4L, "Bahia"),
	CE(5L, "Ceará"),
	DF(6L, "Distrito Federal"),
	ES(7L, "Espírito Santo"),
	GO(8L, "Goiás"),
	MA(9L, "Maranhão"),
	MT(10L, "Mato Grosso"),
	MS(11L, "Mato Grosso do Sul"),
	MG(12L, "Minas Gerais"),
	PA(13L, "Pará"),
	PB(14L, "Paraíba"),
	PR(15L, "Paraná"),
	PE(16L, "Pernambuco"),
	PI(17L, "Piauí"),
	RJ(18L, "Rio de Janeiro"),
	RN(19L, "Rio Grande do Norte"),
	RS(20L, "Rio Grande do Sul"),
	RO(21L, "Rondônia"),
	RR(22L, "Roraima"),
	SC(23L, "Santa Catarina"),
	SP(24L, "São Paulo"),
	SE(25L, "Sergipe"),
	TO(26L, "Tocantins");

	private Long id;

	private String descricao;

	private Estado(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
