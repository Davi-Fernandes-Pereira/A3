package com.example.a3.services;


import com.example.a3.domain.Insumo;
import com.example.a3.domain.MateriaPrima;
import com.example.a3.domain.Produto;
import com.example.a3.model.RelatorioModel;
import com.example.a3.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    public Insumo salvar(Insumo insumo) throws Exception {

        Produto produto = produtoService.buscaPorId(insumo.getProduto().getId());

        MateriaPrima materiaPrima = materiaPrimaService.buscaPorId(insumo.getMateriaPrima().getId());

        if (produto == null) {

            throw new Exception("Produto não cadastrado");

        } else if (materiaPrima == null) {

            throw new Exception("Matéria Prima não cadastrada");

        } else {

            insumo.setProduto(produto);
            insumo.setMateriaPrima(materiaPrima);
            return this.insumoRepository.save(insumo);
        }
    }

    public List<Insumo> buscaTodos() {

        return this.insumoRepository.findAll();
    }

    public Insumo buscaPorId(Integer id) {

        return this.insumoRepository.findById(id).get();
    }

    public void deletaPorId(Integer id) {

        this.insumoRepository.deleteById(id);
    }

    public Insumo altera(Integer id, Insumo insumo) throws Exception {
        Insumo insumo1 = buscaPorId(id);

        insumo1.setProduto(insumo.getProduto());
        insumo1.setMateriaPrima(insumo.getMateriaPrima());
        insumo1.setQuantidadeNecessaria(insumo.getQuantidadeNecessaria());

        return this.salvar(insumo1);
    }

    public List<RelatorioModel> relatorio() {
        List<RelatorioModel> relatorio = new ArrayList<>();
        for (Produto produto : produtoService.buscaTodos()) {
            Integer qtdProduzivelInsumo = 1000000000;

            for (Insumo insumo : produto.getInsumos()) {
                if (qtdProduzivelInsumo > insumo.getMateriaPrima().getQuantidade() / insumo.getQuantidadeNecessaria()) {
                    qtdProduzivelInsumo = insumo.getMateriaPrima().getQuantidade() / insumo.getQuantidadeNecessaria();
                }
            }

            atualizarMateriaPrima(produto, qtdProduzivelInsumo);
            relatorio.add(new RelatorioModel(produto.getNome(), qtdProduzivelInsumo));
        }
        return relatorio;
    }

    public void atualizarMateriaPrima(Produto produto, Integer qtdProduzida) {
        for (Insumo insumo : produto.getInsumos()) {
            Integer materiaSobra = insumo.getMateriaPrima().getQuantidade() - (qtdProduzida * insumo.getQuantidadeNecessaria());
            MateriaPrima materiaPrima = insumo.getMateriaPrima();
            materiaPrima.setQuantidade(materiaSobra);
            materiaPrimaService.altera(materiaPrima.getId(), materiaPrima);
        }
    }
}
