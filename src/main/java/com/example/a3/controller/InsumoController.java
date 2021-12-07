package com.example.a3.controller;


import com.example.a3.domain.Insumo;
import com.example.a3.domain.Produto;
import com.example.a3.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("insumo")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @GetMapping()
    public List<Insumo> getAllProdutos() {
        return insumoService.buscaTodos();
    }

    @GetMapping("/{id}")
    public Insumo getProdutoById(@PathVariable Integer id) {
        return insumoService.buscaPorId(id);
    }

    @PostMapping("")
    public Insumo saveInsumo(@RequestBody Insumo insumo) throws Exception {
        return insumoService.salvar(insumo);
    }

    @DeleteMapping("/{id}")
    public void deleteInsumo(@PathVariable Integer id) {
        insumoService.deletaPorId(id);
    }

    @PutMapping("/{id}")
    public Insumo alterarInsumo(@PathVariable Integer id, @RequestBody Insumo insumo) throws Exception {
        return insumoService.altera(id, insumo);
    }
    @GetMapping("/rel")
    public String relatorio(){
        return insumoService.relatorio();
    }

}
