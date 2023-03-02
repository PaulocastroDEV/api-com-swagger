package com.produto.api.domain.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.produto.api.domain.model.Produto;

@Component
public class ProdutoDTODissambler {
	@Autowired
	private ModelMapper modelMapper;
	
	public Produto toObjectDomain(ProdutoInputDTO produtoInputDTO) {
		return modelMapper.map(produtoInputDTO, Produto.class);
	}
}
