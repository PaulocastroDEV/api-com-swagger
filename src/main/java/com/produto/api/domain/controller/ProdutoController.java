package com.produto.api.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.api.domain.dto.ProdutoDTO;
import com.produto.api.domain.dto.ProdutoDTOAssembler;
import com.produto.api.domain.dto.ProdutoDTODissambler;
import com.produto.api.domain.dto.ProdutoInputDTO;
import com.produto.api.domain.model.Produto;
import com.produto.api.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoDTOAssembler produtoDTOAssembler;
	
	@Autowired
	private ProdutoDTODissambler produtoDTODissambler;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<ProdutoDTO> findAll(){
		return produtoDTOAssembler.toCollectionMode( produtoService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody @Valid ProdutoInputDTO produtoInputDTO){
		Produto produto = produtoDTODissambler.toObjectDomain(produtoInputDTO);
		produtoService.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	@GetMapping("/{id}")
	public ProdutoDTO findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		return produtoDTOAssembler.toModel(produto);
		
	}
	//PAREI AQUI
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@RequestBody @Valid ProdutoInputDTO produtoInputDTO, @PathVariable Long id) {
		Produto produto= produtoDTODissambler.toObjectDomain(produtoInputDTO);
		produtoService.update(produto, id);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.remove(id);
		return ResponseEntity.noContent().build();
		
	}
}
