package com.produto.api.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
}
