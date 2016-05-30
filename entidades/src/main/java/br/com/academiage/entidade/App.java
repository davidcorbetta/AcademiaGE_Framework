package br.com.academiage.entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )            
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Config");
        EntityManager manager = emf.createEntityManager();
        
        Query q = manager.createQuery("SELECT COUNT(1) FROM Cliente c");
        
        Long n = (Long) q.getSingleResult();
        
        System.out.println("Quantidade Clientes: "+ n.toString());
        
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        n++;
        
        Cliente c = new Cliente("Cliente "+ n.toString());
        
        manager.persist(c);
        tx.commit();
        manager.close();
        emf.close();
    }
}
