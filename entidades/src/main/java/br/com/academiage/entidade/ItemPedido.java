/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiage.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jefferson
 */
@Entity
public class ItemPedido {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_pedido")
    private Pedido pedido;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_produto")
    private Produto produto;
    
    @Column(name = "valor_pro", precision = 10, scale = 2, nullable = false)
    private Double valorVenda;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto, Double valorVenda) {
        this.produto = produto;
        this.valorVenda = valorVenda;
    }

    public ItemPedido(Pedido pedido, Produto produto, Double valorVenda) {
        this.pedido = pedido;
        this.produto = produto;
        this.valorVenda = valorVenda;
    }
        
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }
    
}
