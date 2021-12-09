package com.example.a3.model;


public class RelatorioModel {

    private String nomeProduto;
    private Integer qtdProduzida;

    public RelatorioModel(String nomeProduto, Integer qtdProduzida) {
        this.nomeProduto = nomeProduto;
        this.qtdProduzida = qtdProduzida;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQtdProduzida() {
        return qtdProduzida;
    }

    public void setQtdProduzida(Integer qtdProduzida) {
        this.qtdProduzida = qtdProduzida;
    }
}