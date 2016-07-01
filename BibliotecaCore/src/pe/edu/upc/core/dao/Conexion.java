/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User-Pc
 */
public class Conexion {
    
    private static final EntityManagerFactory EMF = 
            Persistence.createEntityManagerFactory("BibliotecaCorePU");
    public static EntityManager getEntityManager() throws Exception{
        return EMF.createEntityManager();
    }
    
}
