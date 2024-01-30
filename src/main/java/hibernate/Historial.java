package hibernate;
// Generated 30 ene 2024 16:53:44 by Hibernate Tools 5.4.33.Final

import java.util.Date;

/**
 * Historial generated by hbm2java
 */
public class Historial implements java.io.Serializable {

	private Integer id;
	private Usuario usuario;
	private Date fechaConexion;

	public Historial() {
	}

	public Historial(Usuario usuario, Date fechaConexion) {
		this.usuario = usuario;
		this.fechaConexion = fechaConexion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaConexion() {
		return this.fechaConexion;
	}

	public void setFechaConexion(Date fechaConexion) {
		this.fechaConexion = fechaConexion;
	}

}
