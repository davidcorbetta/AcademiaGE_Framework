/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiage.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson
 */
@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "nome_cli", length = 500)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    private Date dataCadastro = new Date();

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
    
}
