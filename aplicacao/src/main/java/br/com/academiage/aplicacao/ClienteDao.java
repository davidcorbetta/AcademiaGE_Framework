/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiage.aplicacao;

import br.com.academiage.entidade.Cliente;
import br.com.academiage.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author david
 */
public class ClienteDao extends Dao{

    public ClienteDao() {
        super(Cliente.class);
    }

    public ClienteDao(Class classePersistente) {
        super(classePersistente);
    }
    
    public List<Cliente> buscaPorNome(String nome){
        EntityManager em = JpaUtil.getEntityManager();
        
        return em.createQuery("SELECT c FROM "+
                       Cliente.class.getName()+
                       " c WHERE c.nome = :p_nome").setParameter("p_nome", nome).getResultList();
    }
    
    
}
