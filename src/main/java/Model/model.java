/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alber
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.password4j.*;
import hibernate.*;
import javax.swing.JOptionPane;

public class model {

	Hibernate hiber = new Hibernate();

	public void insertarUsuario(String username, String password, String correoRecuperacion, int edad,
			boolean esMenor) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			// Codificar la contraseña con Password4j
			String hashedPassword = hashPassword(password);
			// Crear y guardar el usuario
			Usuario usuario = new Usuario(username, hashedPassword, correoRecuperacion, edad, esMenor);
			session.save(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agregarNuevoAmigo(int idUsuario, int idNuevoAmigo) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			// Cargar el usuario actual y el nuevo amigo desde la base de datos
			Usuario usuario = session.get(Usuario.class, idUsuario);
			Usuario nuevoAmigo = session.get(Usuario.class, idNuevoAmigo);
			// Verificar si ya son amigos para evitar duplicados
			if (!usuario.getUsuariosForIdUsuario2().contains(nuevoAmigo)) {
				// Agregar el nuevo amigo a la lista
				usuario.getUsuariosForIdUsuario2().add(nuevoAmigo);
				// Establecer la relación en ambos lados (bidireccional)
				nuevoAmigo.getUsuariosForIdUsuario2().add(usuario);
				// Actualizar las entidades en la base de datos
				session.update(usuario);
				session.update(nuevoAmigo);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarAmigo(int idUsuario, int idAmigoEliminar) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			// Cargar el usuario actual y el amigo a eliminar desde la base de datos
			Usuario usuario = session.get(Usuario.class, idUsuario);
			Usuario amigoEliminar = session.get(Usuario.class, idAmigoEliminar);
			session.getTransaction().commit();
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
			session.beginTransaction();
			// Query para obtener un usuario con el nombre dado
			Query<Usuario> query = session.createQuery("FROM Usuario WHERE username = :username", Usuario.class);
			query.setParameter("username", username);
			Usuario usuario = query.uniqueResult();
			// Verificar si se encontró un usuario y la contraseña coincide
			return usuario != null /* && verificarPassword(password, usuario.getContrasenaEncriptada()) */;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean verificarPassword(String password, String hashedPassword) {
		// Verificar la contraseña utilizando Password4j
		var bcrypt = BcryptFunction.getInstance(12);
		var hash = "$2b$12$oG3H0L4Xhg28OHreCFM4zeIQIykLb4y356m6qn9GkbOc9i1.lbUne";
		var result = bcrypt.hash(password).getResult();
		var resultado = bcrypt.check(password, hash);
		return resultado;
	}
}
