/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiage.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 Design Pattern Singleton.
 */
public class JpaUtil {
    private static EntityManagerFactory emf;
    
    //Cria um construtir e diz para deixar o objeto em memoria
    static{
        emf = Persistence.createEntityManagerFactory("Config");
    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public static void FecharConexao(){
        emf.close();
    }
    
}
