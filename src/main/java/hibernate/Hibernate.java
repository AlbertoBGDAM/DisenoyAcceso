/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alumno
 */
public class Hibernate {

    public SessionFactory Model() {
        // Configurar la fábrica de sesiones de Hibernate
        Configuration configuration = new Configuration().configure("hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public void closeSessionFactory() {
        // Cerrar la fábrica de sesiones al cerrar la aplicación
        SessionFactory sessionFactory = Model();
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
    
}
