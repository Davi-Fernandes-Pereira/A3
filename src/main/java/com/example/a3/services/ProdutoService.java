package com.example.a3.services;

import com.example.a3.domain.Produto;
import com.example.a3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public List<Produto> buscaTodos() {
        return this.produtoRepository.findAll();
    }

    public Produto buscaPorId(Integer id) {
        return this.produtoRepository.findById(id).get();
    }

    public void deletaPorId(Integer id) {
        this.produtoRepository.deleteById(id);
    }

    public Produto altera(Integer id, Produto produto) {
        Produto produto1 = produtoRepository.findById(id).get();

        produto1.setNome(produto.getNome());
        produto1.setValor(produto.getValor());

        return this.salvar(produto1);
    }

}
