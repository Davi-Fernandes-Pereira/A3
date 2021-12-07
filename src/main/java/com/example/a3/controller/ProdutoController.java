package com.example.a3.controller;

import com.example.a3.domain.Produto;
import com.example.a3.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public List<Produto> getAllProdutos() {
        return produtoService.buscaTodos();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id) {
        return produtoService.buscaPorId(id);
    }

    @PostMapping("")
    public Produto saveProduto(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Integer id) {
        produtoService.deletaPorId(id);
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        return produtoService.altera(id, produto);
    }


}
