package com.produto.api.domain.exception;

import lombok.Getter;

@Getter
public enum ProblemType {
	INVALID_DATA("/dados-invalidos","dados-invalidos"),
	RESOURCE_NOT_FOUND("/recurso-nao-encontrado","recurso-nao-encontrado");
	
	private String title;
	private String uri;
	
	
	
	ProblemType(String path,String title){
		this.uri="https://api.produtos.com.br"+path;
		this.title=title;
	}
}