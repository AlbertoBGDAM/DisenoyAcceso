package hibernate;
// Generated 6 ene 2024, 13:03:03 by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tarjetacredito generated by hbm2java
 */
public class Tarjetacredito implements java.io.Serializable {

	private int idUsuario;
	private Usuario usuario;
	private String numeroTarjeta;
	private int codigoSeguridad;
	private Set comprases = new HashSet(0);

	public Tarjetacredito() {
	}

	public Tarjetacredito(Usuario usuario, String numeroTarjeta, int codigoSeguridad) {
		this.usuario = usuario;
		this.numeroTarjeta = numeroTarjeta;
		this.codigoSeguridad = codigoSeguridad;
	}

	public Tarjetacredito(Usuario usuario, String numeroTarjeta, int codigoSeguridad,
			Set comprases) {
		this.usuario = usuario;
		this.numeroTarjeta = numeroTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.comprases = comprases;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public int getCodigoSeguridad() {
		return this.codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public Set getComprases() {
		return this.comprases;
	}

	public void setComprases(Set comprases) {
		this.comprases = comprases;
	}

}
