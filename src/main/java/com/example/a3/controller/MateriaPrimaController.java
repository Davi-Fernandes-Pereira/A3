package com.example.a3.controller;

import com.example.a3.domain.MateriaPrima;
import com.example.a3.services.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materiaPrima")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    @GetMapping()
    public List<MateriaPrima> getAllMateriaPrimas() {
        return materiaPrimaService.buscaTodos();
    }

    @GetMapping("/{id}")
    public MateriaPrima getMateriaPrimasById(@PathVariable Integer id) {
        return materiaPrimaService.buscaPorId(id);
    }

    @PostMapping("")
    public MateriaPrima saveMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
        return materiaPrimaService.salvar(materiaPrima);
    }

    @DeleteMapping("/{id}")
    public void deleteMateriaPrima(@PathVariable Integer id) {
        materiaPrimaService.deletaPorId(id);
    }

    @PutMapping("/{id}")
    public MateriaPrima alterarMateriaPrima(@PathVariable Integer id, @RequestBody MateriaPrima materiaPrima) {
        return materiaPrimaService.altera(id, materiaPrima);
    }


}
