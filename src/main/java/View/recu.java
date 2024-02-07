/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.*;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
class Recu extends javax.swing.JPanel {
	model mod;
	String defN = "ejemplo@ejemplo.com", defC = "holabuenosdias";

	/**
	 * Creates new form Loging
	 */
	public Recu(model mod1) {
            this.mod=mod1;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		nombre = new javax.swing.JLabel();
		Nombre = new javax.swing.JTextField();
		correo = new javax.swing.JButton();

		setBackground(new java.awt.Color(31, 37, 51));
		setMinimumSize(new java.awt.Dimension(432, 636));
		setPreferredSize(new java.awt.Dimension(432, 636));

		nombre.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
		nombre.setForeground(new java.awt.Color(255, 255, 255));
		nombre.setText("Correo:");

		Nombre.setBackground(new java.awt.Color(31, 37, 51));
		Nombre.setForeground(new java.awt.Color(204, 204, 204));
		Nombre.setText("ejemplo@ejemplo.com");
		Nombre.setToolTipText("");
		Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				NombreMouseClicked(evt);
			}
		});
		Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				NombreKeyPressed(evt);
			}
		});

		correo.setBackground(new java.awt.Color(25, 30, 42));
		correo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
		correo.setForeground(new java.awt.Color(255, 255, 255));
		correo.setText("Enviar nueva contraseña");
		correo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		correo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				correoActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(nombre)
								.addGap(156, 156, 156).addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(77, 77, 77).addComponent(correo)))
				.addContainerGap(12, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(209, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nombre).addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(166, 166, 166).addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(156, 156, 156)));
	}// </editor-fold>//GEN-END:initComponents

	private void NombreMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_NombreMouseClicked
		if (Nombre.getText().equals(defN)) {
			Nombre.setText("");
			Nombre.setForeground(Color.black);
		}
	}// GEN-LAST:event_NombreMouseClicked

	private void NombreKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_NombreKeyPressed
		if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			correo.requestFocus();
		}
	}// GEN-LAST:event_NombreKeyPressed

	private void correoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_correoActionPerformed
		String nuevacontraseña = "contraseñaprovisional";
		mod.cambiarContrasena(Nombre.getText(), nuevacontraseña);
		EmailUtil emailUtil = new EmailUtil();
		emailUtil.sendEmail(Nombre.getText(), nuevacontraseña);
	}// GEN-LAST:event_correoActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField Nombre;
	private javax.swing.JButton correo;
	private javax.swing.JLabel nombre;
	// End of variables declaration//GEN-END:variables
}
