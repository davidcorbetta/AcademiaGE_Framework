/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiage.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Jefferson
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "nome_pro", length = 500)
    private String nome;
    
    @Column(name = "valor_pro", precision = 10, scale = 2, nullable = false)
    private Double valor;

    public Produto() {
    }

    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }  

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValot(Double valor) {
        this.valor = valor;
    }
    
    
    
}
