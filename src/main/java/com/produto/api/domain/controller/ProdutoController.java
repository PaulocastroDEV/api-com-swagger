package com.produto.api.domain.controller;

import java.util.List;

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

import com.produto.api.domain.model.Produto;
import com.produto.api.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> findAll(){
		return produtoService.findAll();
	}
	
	@PostMapping
	public Produto create(@RequestBody Produto produto){
		return produtoService.save(produto);
	}
	@GetMapping("/{id}")
	public Produto findById(@PathVariable Long id) {
		return produtoService.findById(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Long id) {
		Produto newProduto=produtoService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.update(produto, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.remove(id);
		return ResponseEntity.noContent().build();
		
	}
}
