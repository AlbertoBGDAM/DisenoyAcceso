/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.controller;
import Model.model;
import hibernate.Usuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class Loging extends javax.swing.JPanel {
	model model;
	inicio in;
	String defN = "ejemplo@ejemplo.com", defC = "holabuenosdias";

	/**
	 * Creates new form Loging
	 */
	public Loging(model mod, inicio ini) {
		this.model = mod;
		this.in = ini;
		initComponents();
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

		nombre = new javax.swing.JLabel();
		contraseña = new javax.swing.JLabel();
		Nombre = new javax.swing.JTextField();
		contra = new javax.swing.JPasswordField();
		conectarse = new javax.swing.JButton();

		setBackground(new java.awt.Color(31, 37, 51));
		setMinimumSize(new java.awt.Dimension(432, 636));
		setPreferredSize(new java.awt.Dimension(432, 636));

		nombre.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
		nombre.setForeground(new java.awt.Color(255, 255, 255));
		nombre.setText("Correo:");

		contraseña.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
		contraseña.setForeground(new java.awt.Color(255, 255, 255));
		contraseña.setText("Contraseña:");

		Nombre.setBackground(new java.awt.Color(31, 37, 51));
		Nombre.setForeground(new java.awt.Color(255, 255, 255));
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

		contra.setBackground(new java.awt.Color(31, 37, 51));
		contra.setForeground(new java.awt.Color(255, 255, 255));
		contra.setText("jPasswordField1");
		contra.setMinimumSize(new java.awt.Dimension(139, 22));
		contra.setPreferredSize(new java.awt.Dimension(139, 22));
		contra.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				contraMouseClicked(evt);
			}
		});
		contra.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				contraKeyPressed(evt);
			}
		});

		conectarse.setBackground(new java.awt.Color(25, 30, 42));
		conectarse.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
		conectarse.setForeground(new java.awt.Color(255, 255, 255));
		conectarse.setText("Conectarse");
		conectarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		conectarse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				conectarseActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(188, 188, 188)
						.addComponent(conectarse, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(42, 42, 42)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(nombre).addComponent(contraseña))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addComponent(Nombre).addGap(25, 25, 25))
								.addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, 330,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(52, 52, 52)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(232, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nombre).addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(59, 59, 59)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(contraseña).addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE,
										35, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(83, 83, 83).addComponent(conectarse, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(122, 122, 122)));
	}// </editor-fold>//GEN-END:initComponents

	private void NombreMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_NombreMouseClicked
		if (Nombre.getText().equals(defN)) {
			Nombre.setText("");
			Nombre.setForeground(Color.white);
		}
		if (String.valueOf(contra.getPassword()).equals("")) {
			contra.setText(defC);
			contra.setForeground(Color.LIGHT_GRAY);
		}
	}// GEN-LAST:event_NombreMouseClicked

	private void NombreKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_NombreKeyPressed
		if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			contra.requestFocus();
		}
	}// GEN-LAST:event_NombreKeyPressed

	private void conectarseActionPerformed(java.awt.event.ActionEvent evt) {
		boolean ver = model.verificarCredenciales(Nombre.getText(), String.valueOf(contra.getPassword()));
		if (ver) {
			JOptionPane.showMessageDialog(null, "¡Bienvenido!", "Mensaje de Bienvenida",
					JOptionPane.INFORMATION_MESSAGE);
			model.setUser(Nombre.getText());
			controller.mainApp(model);
			in.cerrar();

			// Obtener la referencia al JFrame actual
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

			// Cerrar el JFrame actual
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtalo de nuevo.", "Mensaje de Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void contraKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_contraKeyPressed
		if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			conectarse.requestFocus();
		}
	}// GEN-LAST:event_contraKeyPressed

	private void contraMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_contraMouseClicked
		if (Nombre.getText().equals("")) {
			Nombre.setText(defN);
			Nombre.setForeground(Color.LIGHT_GRAY);
		}
		if (String.valueOf(contra.getPassword()).equals(defC)) {
			contra.setText("");
			contra.setForeground(Color.black);
		}
	}// GEN-LAST:event_contraMouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField Nombre;
	private javax.swing.JButton conectarse;
	private javax.swing.JPasswordField contra;
	private javax.swing.JLabel contraseña;
	private javax.swing.JLabel nombre;
	// End of variables declaration//GEN-END:variables
}
