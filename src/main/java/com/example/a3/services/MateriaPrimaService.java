package com.example.a3.services;


import com.example.a3.domain.MateriaPrima;
import com.example.a3.domain.Produto;
import com.example.a3.repository.MateriaPrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaPrimaService {


    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;


    public MateriaPrima salvar(MateriaPrima materiaPrima) {
        return this.materiaPrimaRepository.save(materiaPrima);
    }

    public List<MateriaPrima> buscaTodos() {

        return this.materiaPrimaRepository.findAll();
    }

    public MateriaPrima buscaPorId(Integer id) {

        return this.materiaPrimaRepository.findById(id).get();
    }

    public void deletaPorId(Integer id) {

        this.materiaPrimaRepository.deleteById(id);
    }

    public MateriaPrima altera(Integer id, MateriaPrima materiaPrima) {
        MateriaPrima materiaPrima1 = materiaPrimaRepository.findById(id).get();

        materiaPrima1.setNome(materiaPrima.getNome());
        materiaPrima1.setQuantidade(materiaPrima.getQuantidade());

        return this.salvar(materiaPrima1);
    }


}
