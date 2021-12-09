package com.example.a3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class MateriaPrima {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column
    Integer quantidade;

    @OneToMany(mappedBy = "materiaPrima")
    @JsonIgnore
    private Set<Insumo> insumo;


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

    public Set<Insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(Set<Insumo> insumo) {
        this.insumo = insumo;
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
