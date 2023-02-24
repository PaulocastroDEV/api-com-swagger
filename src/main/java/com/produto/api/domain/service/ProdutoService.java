package com.produto.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.produto.api.domain.exception.ResourceNotFoundException;
import com.produto.api.domain.exception.ValidationException;
import com.produto.api.domain.model.Produto;
import com.produto.api.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Transactional
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	@Transactional
	public Produto findById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		
		return produtoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado com o id : " + id));
	}
	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	@Transactional
	public Produto update(Produto produto,Long id) {
		try {
			findById(id);
			produto.setId(id);
			return produtoRepository.save(produto);	
		} catch (RuntimeException e) {
			throw new ValidationException(e.getMessage());
		}
		
	}
	@Transactional
	public void remove(Long id) {
		
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Produto não encontrado com o id : " + id);
		}
		
	}
}
