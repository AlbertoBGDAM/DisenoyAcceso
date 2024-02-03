package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.password4j.*;
import com.password4j.types.Bcrypt;
import hibernate.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class model {
   
	Usuario user;
	Hibernate hiber = new Hibernate();

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
				usuario.setCorreo(correoRecuperacion);
				usuario.setEdad(edad);
				usuario.setEsMenor(esMenor);
				session.save(usuario);
				transaction.commit();
				return usuario; // Devolver la instancia gestionada después de guardarla
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

	public void agregarTarjetaCredito(Usuario user1, String numeroTarjeta, int codigoSeguridad) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			// Obtener la instancia gestionada del usuario
			Usuario usuario = session.get(Usuario.class, user1.getId()); // Asume que hay un método getId() en Usuario

			if (usuario != null) {
				// Actualizar la información de la tarjeta de crédito
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

	private String hashPassword(String password) {
		// Usar Password4j para almacenar contraseñas de manera segura
		var bcrypt = BcryptFunction.getInstance(12);
                System.out.println("Contraseña -> " + password);
		var hashedPassword = bcrypt.hash(password).getResult();
                System.out.println(hashedPassword);
		return hashedPassword;
	}

	public boolean verificarCredenciales(String username, String password) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			//String hashedPassword = hashPassword(password);
			Query query = session
					.createQuery("FROM Usuario WHERE correo = :username")
					.setParameter("username", username);
			Usuario usuario = (Usuario) query.uniqueResult();
			session.getTransaction().commit();
                        
			if(BcryptFunction
                                .getInstance(12).check(password, usuario.getContrasenaEncriptada())){
                            return true;
                        } else {
                            return false;
                        }
		} catch (Exception e) {
			e.printStackTrace();
                        return false;
		}
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
		return null;
	}

	public List<Juegos> obtenerJuegosComprados(int i) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("FROM Compras WHERE id_usuario = :usuarioId");
			query.setParameter("usuarioId", user.getId());
			if (i != 0) {
				query.setMaxResults(3);
			}
			List<Compras> compras = query.list();
			return compras.stream().map(Compras::getJuegos).toList();
		}
	}

        public List<Juegos> obtenerPrimerosTresJuegos() {
            SessionFactory sessionFactory = hiber.Model();
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
            // Utiliza HQL para obtener los tres primeros juegos de la tabla
            Query query = session.createQuery("FROM Juego");
            query.setMaxResults(3);  // Limitar a tres resultados
            List<Juegos> juegos = query.list();
            session.getTransaction().commit();
            return juegos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	public void setUser(String text, String valueOf) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			// Cargar un usuario por ID
			Long userId = 1L; // Cambia el valor según el ID del usuario que deseas cargar
			user = session.load(Usuario.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Musica> obtenerMusicasCompradas(int i) {
		SessionFactory sessionFactory = hiber.Model();
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("FROM Compras WHERE id_usuario = :usuarioId");
			query.setParameter("usuarioId", user.getId());
			if (i != 0) {
				query.setMaxResults(3);
			}
			List<Compras> compras = query.list();
			return compras.stream().map(Compras::getMusica).toList();
		}
	}

	public JPanel crearMusicaPanel(Musica musica) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel nombreLabel = new JLabel(musica.getNombre());
		JLabel descripcionLabel = new JLabel(musica.getDescripcion());
		JLabel creadorLabel = new JLabel("Creador: " + musica.getCreador());
		panel.add(nombreLabel, BorderLayout.NORTH);
		panel.add(descripcionLabel, BorderLayout.CENTER);
		panel.add(creadorLabel, BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(320, 280));
		return panel;
	}
    public Usuario getUser() {
        return user;
    }

    public void cambiarDatos(Usuario user, String nuevoAlias, String nuevaContrasena, String nuevoCorreo, String nuevaTarjeta) {
    SessionFactory sessionFactory = hiber.Model();
    try (Session session = sessionFactory.openSession()) {
        session.beginTransaction();

        // Buscar el usuario por ID
        Usuario usuario = session.get(Usuario.class, user.getId());

        if (usuario != null) {
            // Actualizar los datos del usuario
            usuario.setUsername(nuevoAlias);
            usuario.setCorreo(nuevoCorreo);

            // Solo actualizar la contraseña si se proporciona una nueva contraseña
            if (!nuevaContrasena.isEmpty()) {
                // Codificar la nueva contraseña con BCrypt (asumiendo que tienes el método hashPassword)
                String hashedPassword = hashPassword(nuevaContrasena);
                usuario.setContrasenaEncriptada(hashedPassword);
            }

            usuario.setNumeroTarjeta(nuevaTarjeta);

            // Confirmar la transacción
            session.getTransaction().commit();

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
        } else {
            // Mostrar un mensaje de error si el usuario no se encuentra
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

        hiber.closeSessionFactory();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public JList<String> listar(){
        DefaultListModel<String> juegosListModel = new DefaultListModel<>();
        JList<String> juegosJList = new JList<>(juegosListModel);
        SessionFactory sessionFactory = hiber.Model();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Buscar el usuario por ID con sus juegos asociados
            Usuario usuario = session.get(Usuario.class, user.getId());

            if (usuario != null) {
                // Obtener la lista de juegos del usuario
                Set juegos = usuario.getJuegoses();

                // Agregar nombres y descripciones al DefaultListModel
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

public void devolverJuegoSeleccionado(Usuario usuario, String juegoSeleccionado, String descripcionJuego) {
        SessionFactory sessionFactory = hiber.Model();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            // Obtener el juego a partir de su nombre y descripción
            Juegos juego = obtenerJuegoPorNombreYDescripcion(session, juegoSeleccionado, descripcionJuego);
            if (juego != null) {
                // Eliminar la compra del usuario para ese juego
                session.createQuery("DELETE FROM Compras WHERE id_usuario = :idUsuario AND id_juego = :idJuego")
                        .setParameter("idUsuario", usuario.getId())
                        .setParameter("idJuego", juego.getId())
                        .executeUpdate();
                transaction.commit();
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(null, "Juego devuelto exitosamente");
            } else {
                // Mostrar un mensaje de error si el juego no se encuentra
                JOptionPane.showMessageDialog(null, "Juego no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para obtener un juego por nombre y descripción
    private Juegos obtenerJuegoPorNombreYDescripcion(Session session, String nombre, String descripcion) {
        return (Juegos) session.createQuery("FROM Juego WHERE nombre = :nombre AND descripcion = :descripcion")
                .setParameter("nombre", nombre)
                .setParameter("descripcion", descripcion)
                .uniqueResult();
    }
}
