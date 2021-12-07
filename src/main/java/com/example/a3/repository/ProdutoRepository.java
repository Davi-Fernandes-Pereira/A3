package com.example.a3.repository;

import com.example.a3.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {
}
