/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
import Model.model;
import View.*;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import hibernate.Usuario;

public class controller {
	private inicio in;
	private App main;
	Usuario us;
	static model mod = new model();

	public static void main() {
		FlatGradiantoMidnightBlueIJTheme.setup();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new inicio(mod).setVisible(true);
			}
		});
	}

	public static void mainApp(model model) {
		FlatGradiantoMidnightBlueIJTheme.setup();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new App(mod, mod.getUser()).setVisible(true);
			}
		});
	}

	public static void Amigos() {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AmigosNuevos.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AmigosNuevos.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AmigosNuevos.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AmigosNuevos.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AmigosNuevos(mod.getUser(), mod).setVisible(true);
			}
		});
	}
}
