/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.password4j.*;
import hibernate.*;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Transaction;

public class model {

	Hibernate hiber = new Hibernate();

public void insertarUsuario(String username, String password, String correoRecuperacion, int edad, boolean esMenor) {
    try (Session session = hiber.Model().openSession()) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // Codificar la contraseña con Password4j
            String hashedPassword = hashPassword(password);
            // Crear y guardar el usuario
            Usuario usuario = new Usuario(username, hashedPassword, correoRecuperacion, edad, esMenor);
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	public void cambiarContrasena(String correo, String nuevaContrasena) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			// Buscar el usuario por correo
			Usuario usuario = (Usuario) session.createQuery("FROM Usuario WHERE correo = :correo")
					.setParameter("correo", correo).uniqueResult();
			if (usuario != null) {
				// Codificar la nueva contraseña con BCrypt
				String hashedPassword = hashPassword(nuevaContrasena);
				// Establecer la nueva contraseña
				usuario.setContrasenaEncriptada(hashedPassword);
				session.getTransaction().commit();
				// Mostrar un mensaje de éxito
				JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente");
			} else {
				// Mostrar un mensaje de error si el usuario no se encuentra
				JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
			hiber.closeSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agregarTarjetaCredito(String correoUsuario, String numeroTarjeta, int codigoSeguridad) {
            SessionFactory sessionFactory = hiber.Model();
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
		// Buscar el usuario por correo
		Usuario usuario = (Usuario) session.createQuery("FROM Usuario WHERE correo = :correo")
				.setParameter("correo", correoUsuario).uniqueResult();
		if (usuario != null) {
                    // Crear la nueva tarjeta de crédito
                    Tarjetacredito tarjetaCredito = new Tarjetacredito(usuario, numeroTarjeta, codigoSeguridad);
                    // Asociar la tarjeta de crédito con el usuario
                    usuario.setTarjetacredito(tarjetaCredito);
                    // Guardar la tarjeta de crédito en la base de datos
                    session.save(tarjetaCredito);
                    session.getTransaction().commit();
		} else {
                    System.out.println("Usuario no encontrado.");
		}
		} catch (Exception e) {
                    e.printStackTrace();
		}
	}

	private String hashPassword(String password) {
		// Usar Password4j para almacenar contraseñas de manera segura
		var bcrypt = BcryptFunction.getInstance(12);
		var hashedPassword = bcrypt.hash(password).getResult();
		return hashedPassword;
	}

	public boolean verificarCredenciales(String username, String password) {
            SessionFactory sessionFactory = hiber.Model();
             try (Session session = sessionFactory.openSession()) {
                // Cargar un usuario por ID
                Long userId = 1L; // Cambia el valor según el ID del usuario que deseas cargar
                Usuario usuario = session.load(Usuario.class, userId);
                // Verificar si el usuario fue cargado
                if (usuario != null) {
                    return true;
                }
        } catch (Exception e) {
                e.printStackTrace();
            }
                 return false;
	}

	private boolean verificarPassword(String password, String hashedPassword) {
		// Verificar la contraseña utilizando Password4j
		var bcrypt = BcryptFunction.getInstance(12);
		var hash = "$2b$12$oG3H0L4Xhg28OHreCFM4zeIQIykLb4y356m6qn9GkbOc9i1.lbUne";
		var result = bcrypt.hash(password).getResult();
		var resultado = bcrypt.check(password, hash);
		return resultado;
	}
        public List<Usuario> obtenerNoAmigos(int usuarioId) {
             SessionFactory sessionFactory = hiber.Model();
             try (Session session = sessionFactory.openSession()) {
                Query query = session.createQuery("FROM Usuario u WHERE u.id NOT IN "
                        + "(SELECT amigo.id FROM Usuario usuario JOIN usuario.amigos amigo WHERE usuario.id = :usuarioId)");
                query.setParameter("usuarioId", usuarioId);
                return query.list();
            } catch (Exception e) {
            e.printStackTrace();
            }
            return Collections.emptyList(); // En caso de error, devolver una lista vacía o manejar la excepción adecuadamente
        }
}
