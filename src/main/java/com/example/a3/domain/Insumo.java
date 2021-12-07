package com.example.a3.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private MateriaPrima materiaPrima;

    @Column
    private Integer quantidadeNecessaria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Integer getQuantidadeNecessaria() {
        return quantidadeNecessaria;
    }

    public void setQuantidadeNecessaria(Integer quantidadeNecessaria) {
        this.quantidadeNecessaria = quantidadeNecessaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insumo)) return false;
        Insumo insumo = (Insumo) o;
        return Objects.equals(getId(), insumo.getId()) && Objects.equals(getProduto(), insumo.getProduto()) && Objects.equals(getMateriaPrima(), insumo.getMateriaPrima()) && Objects.equals(getQuantidadeNecessaria(), insumo.getQuantidadeNecessaria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduto(), getMateriaPrima(), getQuantidadeNecessaria());
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "id=" + id +
                ", produto=" + produto +
                ", materiaPrima=" + materiaPrima +
                ", quantidadeNecessaria=" + quantidadeNecessaria +
                '}';
    }
}
