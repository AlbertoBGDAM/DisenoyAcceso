package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.password4j.*;
import hibernate.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.List;

public class model {
    Usuario user;
    Hibernate hiber = new Hibernate();

    public Usuario insertarUsuario(String username, String password, String correoRecuperacion, int edad, boolean esMenor) {
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

    public void agregarTarjetaCredito(Usuario user1, String numeroTarjeta, int codigoSeguridad) {
    SessionFactory sessionFactory = hiber.Model();
    try (Session session = sessionFactory.openSession()) {
        session.beginTransaction();
        // Buscar el usuario por correo
        Usuario usuario = user1;
        if (usuario != null) {
            // Actualizar la información de la tarjeta de crédito
            usuario.setNumeroTarjeta(numeroTarjeta);
            usuario.setCodigoSeguridad(codigoSeguridad);
            session.update(usuario); // Utilizar el método update para realizar el update
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
        Query query = session.createQuery("FROM Usuario WHERE correo = :username AND contrasena = :password")
                .setParameter("username", username)
                .setParameter("password", password);
        Usuario usuario = (Usuario) query.uniqueResult();
        session.getTransaction().commit();
        return usuario != null;
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

    public JPanel crearJuegoPanel(Juegos juego) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel nombreLabel = new JLabel(juego.getNombre());
        JLabel descripcionLabel = new JLabel(juego.getDescripcion());
        JLabel creadorLabel = new JLabel("Creador: " + juego.getCreador());
        panel.add(nombreLabel, BorderLayout.NORTH);
        panel.add(descripcionLabel, BorderLayout.CENTER);
        panel.add(creadorLabel, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(320, 280));
        return panel;
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
}
