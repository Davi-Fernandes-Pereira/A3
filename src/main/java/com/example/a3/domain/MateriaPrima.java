package com.example.a3.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column
    Integer quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MateriaPrima)) return false;
        MateriaPrima that = (MateriaPrima) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getQuantidade(), that.getQuantidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getQuantidade());
    }

    @Override
    public String toString() {
        return "MateriaPrima{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
