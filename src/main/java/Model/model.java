package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.password4j.*;
import hibernate.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * @author ALBERTO BARCALA GUTIÉRREZ Clase que gestiona las operaciones
 *         relacionadas con la base de datos y los usuarios.
 */
public class model {

	Hibernate hiber = new Hibernate();
	Usuario user;

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

			// Buscar el usuario por ID
			Usuario usuario = session.get(Usuario.class, user.getId());

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
	public boolean verificarCredenciales(String username, String password) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Query query = session.createQuery("FROM Usuario WHERE correo_recuperacion = :username")
					.setParameter("username", username);
			Usuario usuario = (Usuario) query.uniqueResult();
			session.getTransaction().commit();
			if (BcryptFunction.getInstance(12).check(password, usuario.getContrasenaEncriptada())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene los primeros tres juegos de la tabla.
	 * 
	 * @return Una lista de los primeros tres juegos.
	 */
	public List<Juegos> obtenerPrimerosTresJuegos() {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Query query = session.createQuery("FROM Juegos");
			query.setMaxResults(3);
			List<Juegos> juegos = query.list();
			session.getTransaction().commit();
			return juegos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Establece el usuario actual basado en el nombre de usuario.
	 * 
	 * @param username El nombre de usuario.
	 */
	public void setUser(String username) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query<Usuario> query = session.createQuery("FROM Usuario u WHERE u.username = :username", Usuario.class);
			query.setParameter("username", username);
			Usuario user = query.uniqueResult();
			this.user = user;
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
			Usuario usuario = session.get(Usuario.class, user.getId());
			if (usuario != null) {
				Set juegos = usuario.getJuegoses();
				for (Iterator it = juegos.iterator(); it.hasNext();) {
					Juegos juego = (Juegos) it.next();
					String juegoInfo = juego.getNombre() + " - " + juego.getDescripcion();
					juegosListModel.addElement(juegoInfo);
				}
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
	 * Obtiene los juegos comprados por un usuario.
	 * 
	 * @return Una lista de juegos comprados por el usuario.
	 */
	public List<Juegos> obtenerJuegosComprados() {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("FROM Compras WHERE usuario.id = :usuarioId");
			query.setParameter("usuarioId", user.getId());
			List<Compras> compras = query.list();
			return compras.stream().map(Compras::getJuegos).toList();
		}
	}

	/**
	 * Obtiene una lista de usuarios que no son amigos del usuario dado.
	 * 
	 * @param usuarioId El ID del usuario.
	 * @return Una lista de usuarios que no son amigos del usuario dado.
	 */
	public JList<Usuario> obtenerNoAmigos(int usuarioId) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query<Usuario> query = session.createQuery("FROM Usuario u WHERE u.id NOT IN "
					+ "(SELECT amigo.id FROM Usuario usuario JOIN usuario.usuariosForIdUsuario1 amigo WHERE usuario.id = :usuarioId)",
					Usuario.class);
			query.setParameter("usuarioId", usuarioId);
			List<Usuario> resultList = query.list();
			Usuario[] usuariosArray = resultList.toArray(new Usuario[0]);
			return new JList<>(usuariosArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Obtiene una lista de juegos comprados por el usuario.
	 * 
	 * @param i numero de juegos que recibe del usuario.
	 * @return Una lista de juegos comprados por el usuario.
	 */
	public List<Juegos> obtenerJuegosComprados(int i) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("FROM Compras WHERE usuario.id = :usuarioId");
			query.setParameter("usuarioId", user.getId());
			if (i == 0) {
				query.setMaxResults(3);
			}
			List<Compras> compras = query.list();
			return compras.stream().map(Compras::getJuegos).toList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Juegos> obtenerTodosLosJuegos() {
		try (Session session = hiber.Model().openSession()) {
			session.beginTransaction();
			Query<Juegos> query = session.createQuery("FROM Juegos", Juegos.class);
			List<Juegos> juegos = query.list();
			session.getTransaction().commit();
			return juegos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
