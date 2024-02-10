/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.model;
import hibernate.Usuario;
import javax.swing.JList;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class AmigosNuevos extends javax.swing.JFrame {
	model mod;
	Usuario us;

	/**
	 * Creates new form AmigosNuevos
	 */
	public AmigosNuevos(Usuario use, model mode) {
		initComponents();
		this.us = use;
		this.mod = mode;
		listaamigos = mod.obtenerNoAmigos(us.getId());
	}

	void setUsuario(Usuario user) {

	}

	void setmod(model model) {

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelamigos = new javax.swing.JPanel();
		Listaamigos = new javax.swing.JScrollPane();
		listaamigos = new javax.swing.JList<>();
		agregar = new javax.swing.JButton();
		panellogo = new javax.swing.JPanel();
		Icon = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		panelamigos.setBackground(new java.awt.Color(31, 37, 51));

		listaamigos.setBackground(new java.awt.Color(45, 64, 87));
		listaamigos.setForeground(new java.awt.Color(255, 255, 255));
		listaamigos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		Listaamigos.setViewportView(listaamigos);

		agregar.setBackground(new java.awt.Color(25, 30, 42));
		agregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		agregar.setForeground(new java.awt.Color(255, 255, 255));
		agregar.setText("Agregar amigos");
		agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		agregar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				agregarMouseClicked(evt);
			}
		});
		agregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				agregarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelamigosLayout = new javax.swing.GroupLayout(panelamigos);
		panelamigos.setLayout(panelamigosLayout);
		panelamigosLayout.setHorizontalGroup(panelamigosLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelamigosLayout.createSequentialGroup().addGroup(panelamigosLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelamigosLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(agregar,
								javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(panelamigosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(Listaamigos,
								javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		panelamigosLayout
				.setVerticalGroup(panelamigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelamigosLayout.createSequentialGroup().addContainerGap(38, Short.MAX_VALUE)
								.addComponent(Listaamigos, javax.swing.GroupLayout.PREFERRED_SIZE, 246,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38)));

		getContentPane().add(panelamigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 420, 430));

		panellogo.setBackground(new java.awt.Color(44, 47, 72));
		panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		panellogo.add(Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

		getContentPane().add(panellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 390, 440));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void agregarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_agregarMouseClicked
		Usuario usuarioSeleccionado = listaamigos.getSelectedValue();
		if (usuarioSeleccionado != null) {
			mod.agregarAmigo(usuarioSeleccionado, us); // Aquí debes pasar el ID del usuario actual
		}
	}// GEN-LAST:event_agregarMouseClicked

	private void agregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_agregarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_agregarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel Icon;
	private javax.swing.JScrollPane Listaamigos;
	private javax.swing.JButton agregar;
	private javax.swing.JList<Usuario> listaamigos;
	private javax.swing.JPanel panelamigos;
	private javax.swing.JPanel panellogo;
	// End of variables declaration//GEN-END:variables
}
