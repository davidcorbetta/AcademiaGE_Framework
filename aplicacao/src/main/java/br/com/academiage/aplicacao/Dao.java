/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiage.aplicacao;

import br.com.academiage.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author david
 */
public class Dao<T> {
    
    private Class<?> classePersistente;
    
    public Dao() {
        
    }
    
    public Dao(Class<?> classePersistente){
        this.classePersistente = classePersistente;
    }
    
    public void salvar(T entidade){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        em.persist(entidade);
        
        tx.commit();
        
        em.close();
    }
    
    public void remover(T entidade){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        if(!em.contains(entidade)){
            entidade = em.merge(entidade);
        }
        em.remove(entidade);
        
        tx.commit();
        
        em.close();
    }
    
    public T buscaPorID(Long id){
       EntityManager em = JpaUtil.getEntityManager();
       
       //Instancia e retorna um objeto.
       
       //Dessa forma faz um where em uma chave primaria
       return (T) em.find(this.classePersistente, id);
    }
    
    
    
}
