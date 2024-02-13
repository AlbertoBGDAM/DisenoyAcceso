package Model;

import Controller.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.password4j.*;
import hibernate.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class model {

	Hibernate hiber = new Hibernate();
	Usuario user = controller.getUser();

	/**
	 * Inserta un nuevo usuario en la base de datos.
	 * 
	 * @param username           El nombre de usuario.
	 * @param password           La contraseña del usuario.
	 * @param correoRecuperacion El correo de recuperación del usuario.
	 * @param edad               La edad del usuario.
	 * @param esMenor            Indica si el usuario es menor de edad.
	 * @return La instancia del usuario insertado.
	 */
	public Usuario insertarUsuario(String username, String password, String correoRecuperacion, int edad,
			boolean esMenor) {
		try (Session session = hiber.Model().openSession()) {
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				String hashedPassword = hashPassword(password);
				Usuario usuario = new Usuario();
				usuario.setUsername(username);
				usuario.setContrasenaEncriptada(hashedPassword);
				usuario.setCorreoRecuperacion(correoRecuperacion);
				usuario.setEdad(edad);
				usuario.setEsMenor(esMenor);
				session.save(usuario);
				transaction.commit();
				this.user = usuario;
				return usuario;
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Agrega la información de una tarjeta de crédito a un usuario existente.
	 * 
	 * @param user1           El usuario al que se le agregará la tarjeta de
	 *                        crédito.
	 * @param numeroTarjeta   El número de la tarjeta de crédito.
	 * @param codigoSeguridad El código de seguridad de la tarjeta de crédito.
	 */
	public void agregarTarjetaCredito(Usuario user1, String numeroTarjeta, int codigoSeguridad) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, user1.getId());
			if (usuario != null) {
				usuario.setNumeroTarjeta(numeroTarjeta);
				usuario.setCodigoSeguridad(codigoSeguridad);
				session.update(usuario);
				session.getTransaction().commit();
			} else {
				System.out.println("Usuario no encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cambia la contraseña de un usuario.
	 * 
	 * @param correo          El correo del usuario.
	 * @param nuevaContrasena La nueva contraseña del usuario.
	 */
	public void cambiarContrasena(String correo, String nuevaContrasena) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Usuario usuario = (Usuario) session.createQuery("FROM Usuario WHERE correoRecuperacion = :correo")
					.setParameter("correo", correo).uniqueResult();
			if (usuario != null) {
				String hashedPassword = hashPassword(nuevaContrasena);
				usuario.setContrasenaEncriptada(hashedPassword);
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cambia los datos del usuario en la base de datos.
	 * 
	 * @param user            El usuario cuyos datos se van a cambiar.
	 * @param nuevoAlias      El nuevo alias para el usuario.
	 * @param nuevaContrasena La nueva contraseña para el usuario.
	 * @param nuevoCorreo     El nuevo correo electrónico para el usuario.
	 * @param nuevaTarjeta    El nuevo número de tarjeta para el usuario.
	 */
	public void cambiarDatos(Usuario user, String nuevoAlias, String nuevaContrasena, String nuevoCorreo,
			String nuevaTarjeta) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Query query = session.createQuery("FROM Usuario WHERE correo_recuperacion = :username")
					.setParameter("username", user);
			Usuario usuario = (Usuario) query.uniqueResult();
			if (usuario != null) {
				// Actualizar los datos del usuario
				usuario.setUsername(nuevoAlias);
				usuario.setCorreoRecuperacion(nuevoCorreo);

				// Solo actualizar la contraseña si se proporciona una nueva contraseña
				if (!nuevaContrasena.isEmpty()) {
					// Codificar la nueva contraseña con BCrypt (asumiendo que tienes el método
					// hashPassword)
					String hashedPassword = hashPassword(nuevaContrasena);
					usuario.setContrasenaEncriptada(hashedPassword);
				}

				usuario.setNumeroTarjeta(nuevaTarjeta);

				// Confirmar la transacción
				session.getTransaction().commit();

				// Mostrar un mensaje de éxito
				JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
			} else { // Mostrar un mensaje de error si el usuario no se encuentra
				JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String hashPassword(String password) {
		var bcrypt = BcryptFunction.getInstance(12);
		System.out.println("Contraseña -> " + password);
		var hashedPassword = bcrypt.hash(password).getResult();
		System.out.println(hashedPassword);
		return hashedPassword;
	}

	/**
	 * Verifica las credenciales de inicio de sesión de un usuario.
	 * 
	 * @param username El nombre de usuario.
	 * @param password La contraseña del usuario.
	 * @return true si las credenciales son válidas, false de lo contrario.
	 */
	public boolean verificarCredenciales(String username, String password, controller con) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Query query = session.createQuery("FROM Usuario WHERE correo_recuperacion = :username")
					.setParameter("username", username);
			Usuario usuario = (Usuario) query.uniqueResult();
			session.getTransaction().commit();
			if (usuario != null && BcryptFunction.getInstance(12).check(password, usuario.getContrasenaEncriptada())) {
				con.setUser(usuario); // Guarda el usuario
				return true; // Devuelve true si las credenciales son válidas
			} else {
				return false; // Devuelve false si las credenciales no son válidas
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Establece el usuario actual basado en el nombre de usuario.
	 * 
	 * @param username El nombre de usuario.
	 */
	public void setUser(Usuario username) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query<Usuario> query = session.createQuery("FROM Usuario u WHERE u.username = :username", Usuario.class);
			query.setParameter("username", username.getUsername());
			Usuario user = query.uniqueResult();
			this.user = user;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Agrega un nuevo registro al historial para el usuario especificado.
	 * 
	 * @param usuario El usuario para el cual se registrará el historial.
	 */
	public void setHistory(Usuario usuario) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();

			// Obtener la fecha actual del sistema
			Calendar calendar = Calendar.getInstance();
			Date fechaActual = calendar.getTime();

			// Crear una instancia de Historial con el usuario y la fecha actual del sistema
			Historial historial = new Historial(usuario, fechaActual);

			// Guardar el historial en la base de datos
			session.save(historial);

			// Confirmar la transacción
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene el usuario actual.
	 * 
	 * @return El usuario actual.
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * Lista los juegos asociados al usuario.
	 * 
	 * @return Una lista de juegos asociados al usuario.
	 */
	public JList<String> listar() {
		DefaultListModel<String> juegosListModel = new DefaultListModel<>();
		JList<String> juegosJList = new JList<>(juegosListModel);
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			// Consulta para obtener las compras del usuario
			Query<Compras> query = session.createQuery("FROM Compras c WHERE c.usuario.id = :userId", Compras.class);
			query.setParameter("userId", user.getId());
			List<Compras> compras = query.list();
			// Recorrer las compras para obtener los juegos asociados
			for (Compras compra : compras) {
				Juegos juego = compra.getJuegos();
				String juegoInfo = juego.getNombre() + " - " + juego.getDescripcion();
				juegosListModel.addElement(juegoInfo);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return juegosJList;
	}

	/**
	 * Devuelve un juego seleccionado por el usuario.
	 * 
	 * @param usuario           El usuario que devuelve el juego.
	 * @param juegoSeleccionado El juego seleccionado por el usuario.
	 * @param descripcionJuego  La descripción del juego seleccionado.
	 */
	public void devolverJuegoSeleccionado(Usuario usuario, String juegoSeleccionado, String descripcionJuego) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Juegos juego = obtenerJuegoPorNombreYDescripcion(session, juegoSeleccionado, descripcionJuego);
			if (juego != null) {
				session.createQuery("DELETE FROM Compras WHERE usuario.id = :usuarioId AND juegos.id = :juegoId")
						.setParameter("usuarioId", usuario.getId()).setParameter("juegoId", juego.getId())
						.executeUpdate();
				transaction.commit();
				JOptionPane.showMessageDialog(null, "Juego devuelto exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "Juego no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método para obtener un juego por nombre y descripción
	private Juegos obtenerJuegoPorNombreYDescripcion(Session session, String nombre, String descripcion) {
		return (Juegos) session.createQuery("FROM Juegos WHERE nombre = :nombre AND descripcion = :descripcion")
				.setParameter("nombre", nombre).setParameter("descripcion", descripcion).uniqueResult();
	}

	/**
	 * Agrega un amigo al usuario.
	 * 
	 * @param amigo El amigo que se agregará.
	 * @param user  El usuario al que se le agregará el amigo.
	 */
	public void agregarAmigo(Usuario amigo, Usuario user) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			user.getUsuariosForIdUsuario1().add(amigo);
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene un iterador sobre la lista de usuarios que no son amigos del usuario
	 * dado.
	 * 
	 * @param usuarioId El ID del usuario.
	 * @return Un iterador sobre la lista de usuarios que no son amigos del usuario
	 *         dado.
	 */
	public List<Usuario> obtenerNoAmigos(int usuarioId) {
		try (Session session = hiber.Model().openSession()) {
			session.beginTransaction();

			// Obtener todos los usuarios
			Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
			List<Usuario> todosLosUsuarios = query.list();

			// Obtener el usuario actual
			Usuario usuarioActual = session.get(Usuario.class, usuarioId);

			// Remover el usuario actual de la lista
			todosLosUsuarios.remove(usuarioActual);

			// Obtener la lista de amigos del usuario actual
			List<Usuario> amigos = new ArrayList<>(usuarioActual.getUsuariosForIdUsuario1());

			// Remover a los amigos de la lista de todos los usuarios
			todosLosUsuarios.removeAll(amigos);

			session.getTransaction().commit();

			return todosLosUsuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene un iterador sobre todos los juegos disponibles en la base de datos.
	 * 
	 * @return Un iterador sobre todos los juegos disponibles, o un iterador vacío
	 *         si no se encuentran juegos.
	 */
	public Iterator<Juegos> obtenerTodosLosJuegos() {
		try (Session session = hiber.Model().openSession()) {
			session.beginTransaction();
			Query<Juegos> query = session.createQuery("FROM Juegos", Juegos.class);
			List<Juegos> juegos = query.list();
			session.getTransaction().commit();
			return juegos.iterator();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene una lista de juegos comprados por el usuario.
	 * 
	 * @param i numero de juegos que recibe del usuario.
	 * @return Una lista de juegos comprados por el usuario.
	 */
	public Iterator<Juegos> obtenerJuegosComprados(int i) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query<Juegos> query = session.createQuery("SELECT c.juegos FROM Compras c WHERE c.usuario.id = :usuarioId",
					Juegos.class);
			query.setParameter("usuarioId", user.getId());
			if (i != 0) {
				query.setMaxResults(i);
			}
			List<Juegos> juegosList = query.list();
			return juegosList.iterator();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Realiza la compra de un juego por parte de un usuario.
	 * 
	 * @param usuario     El usuario que realiza la compra.
	 * @param nombreJuego El nombre del juego que se compra.
	 */
	public void realizarCompra(Usuario usuario, String nombreJuego) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			// Obtener el juego seleccionado por su nombre
			Query<Juegos> query = session.createQuery("FROM Juegos j WHERE j.nombre = :nombre", Juegos.class);
			query.setParameter("nombre", nombreJuego);
			Juegos juego = query.uniqueResult();
			if (juego != null) {
				Calendar calendar = Calendar.getInstance();
				Date fechaActual = calendar.getTime();
				// Crear una instancia de Compras con el usuario y el juego seleccionado
				Compras compra = new Compras(juego, usuario, fechaActual);
				// Guardar la compra en la base de datos
				session.save(compra);
				// Confirmar la transacción
				transaction.commit();
			} else {
				JOptionPane.showMessageDialog(null, nombreJuego, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("El juego seleccionado no existe.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
