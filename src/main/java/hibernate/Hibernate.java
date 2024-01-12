/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alumno
 */
public class Hibernate {
    SessionFactory sessionFactory = Model();
    public SessionFactory Model() {
    	 try {
             return new Configuration().configure().buildSessionFactory(
                     new StandardServiceRegistryBuilder().configure().build());
         } catch (Throwable ex) {
             System.err.println(ex);
             throw new ExceptionInInitializerError(ex);
         }
    }

    public void closeSessionFactory() {
        // Cerrar la fábrica de sesiones al cerrar la aplicación
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
    
}
