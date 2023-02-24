package com.produto.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produto.api.domain.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
