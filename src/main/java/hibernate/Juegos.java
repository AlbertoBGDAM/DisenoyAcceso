package hibernate;
// Generated 29 ene 2024 18:07:53 by Hibernate Tools 5.4.33.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Juegos generated by hbm2java
 */
public class Juegos implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String creador;
	private String descripcion;
	private Date fechaSalida;
	private Set comprases = new HashSet(0);
	private Set usuarios = new HashSet(0);

	public Juegos() {
	}

	public Juegos(String nombre, String creador) {
		this.nombre = nombre;
		this.creador = creador;
	}

	public Juegos(String nombre, String creador, String descripcion, Date fechaSalida, Set comprases, Set usuarios) {
		this.nombre = nombre;
		this.creador = creador;
		this.descripcion = descripcion;
		this.fechaSalida = fechaSalida;
		this.comprases = comprases;
		this.usuarios = usuarios;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreador() {
		return this.creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Set getComprases() {
		return this.comprases;
	}

	public void setComprases(Set comprases) {
		this.comprases = comprases;
	}

	public Set getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set usuarios) {
		this.usuarios = usuarios;
	}

}
