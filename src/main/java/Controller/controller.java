package Controller;

import Model.model;
import View.*;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import hibernate.Usuario;

public class controller {
	private inicio in;
	private App main;
	static Usuario us;
	static model mod = new model();
	static controller con = new controller();

	public static void main(String[] args) {
		FlatGradiantoMidnightBlueIJTheme.setup();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new inicio(mod, con).setVisible(true);
			}
		});
	}

	public static void mainApp(model model) {
		FlatGradiantoMidnightBlueIJTheme.setup();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new App(mod, us).setVisible(true);
			}
		});
	}

	public static void setUser(Usuario usuario) {
		us = usuario;
		mod.setHistory(us);
	}

	public static Usuario getUser() {
		return us;
	}

	public static void Amigos() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AmigosNuevos(us, mod).setVisible(true);
			}
		});
	}
}
