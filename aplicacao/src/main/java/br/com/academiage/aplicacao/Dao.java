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

    public Dao() {
        
    }
    
    public void salvar(T entidade){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        em.persist(entidade);
        
        tx.commit();
        
        em.close();
    }
    
    
}
