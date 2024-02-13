/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.model;
import hibernate.Juegos;
import hibernate.Usuario;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author alber
 */
public class JuegosUsuarios extends javax.swing.JPanel {
	model mod;
        Usuario user;
	/**
	 * Creates new form JuegosUsuarios
	 */
	public JuegosUsuarios(model model, Usuario user1) {
		this.mod = model;
                this.user=user1;
                mod.setUser(user);
		initComponents();
		paneljuego.setLayout(new GridLayout(0, 3, 10, 10)); // GridLayout con 3 columnas

		// Aquí debes obtener el iterador de la lista de juegos de tu base de datos
		Iterator<Juegos> juegosIterator = mod.obtenerJuegosComprados(1);

		// Por cada juego, crear un panel juegosdisplay y agregarlo al panelJuegos
		while (juegosIterator.hasNext()) {
			Juegos juego = juegosIterator.next();
			juegosdisplay juegoDisplay = new juegosdisplay(juego.getNombre(), juego.getDescripcion(),
					juego.getCreador(), juego.getCategoria());
			paneljuego.add(juegoDisplay);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		Spaneljuego = new javax.swing.JScrollPane();
		paneljuego = new javax.swing.JPanel();

		setBackground(new java.awt.Color(44, 47, 72));
		setForeground(new java.awt.Color(44, 47, 72));
		setMaximumSize(new java.awt.Dimension(1132, 774));
		setMinimumSize(new java.awt.Dimension(1132, 774));
		setPreferredSize(new java.awt.Dimension(1132, 774));
		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		Spaneljuego.setBackground(new java.awt.Color(44, 47, 72));
		Spaneljuego.setForeground(new java.awt.Color(44, 47, 72));
		Spaneljuego.setMaximumSize(new java.awt.Dimension(1132, 774));
		Spaneljuego.setMinimumSize(new java.awt.Dimension(1132, 774));
		Spaneljuego.setPreferredSize(new java.awt.Dimension(1132, 774));

		paneljuego.setBackground(new java.awt.Color(44, 47, 72));
		paneljuego.setMaximumSize(new java.awt.Dimension(1132, 774));
		paneljuego.setMinimumSize(new java.awt.Dimension(1132, 774));

		javax.swing.GroupLayout paneljuegoLayout = new javax.swing.GroupLayout(paneljuego);
		paneljuego.setLayout(paneljuegoLayout);
		paneljuegoLayout.setHorizontalGroup(paneljuegoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1132, Short.MAX_VALUE));
		paneljuegoLayout.setVerticalGroup(paneljuegoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 774, Short.MAX_VALUE));

		Spaneljuego.setViewportView(paneljuego);

		add(Spaneljuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane Spaneljuego;
	private javax.swing.JPanel paneljuego;
	// End of variables declaration//GEN-END:variables
}
