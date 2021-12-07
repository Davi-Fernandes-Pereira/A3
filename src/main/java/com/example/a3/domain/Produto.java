package com.example.a3.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Integer id;

    @Column
    private String nome;

    @Column
    private Double  valor;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId()) && Objects.equals(getNome(), produto.getNome()) && Objects.equals(getValor(), produto.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getValor());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
