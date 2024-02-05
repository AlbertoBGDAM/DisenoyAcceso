/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.model;
import hibernate.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class PanelInicio extends javax.swing.JPanel {
	private JPanel panelCambia;
	private JPanel panelInformacion;

	model model = new model();

	/**
	 * Creates new form PanelInicio
	 */
	public PanelInicio() {
		initComponents();
		panelCambia = new JPanel(new GridLayout(0, 3, 50, 50));
		panelCambia.setBorder(BorderFactory.createEmptyBorder(133, 36, 214, 33));
		List<Juegos> juegos = model.obtenerJuegosComprados(3);
		if (juegos == null || juegos.isEmpty()) {
			juegos = model.obtenerPrimerosTresJuegos();
		}
		// Crear paneles de juegos y agregarlos al panel de juegos
		for (Juegos juego : juegos) {
			juegosdisplay juegoss = new juegosdisplay(juego.getNombre(), juego.getDescripcion(), juego.getCreador(), juego.getTipo());
			panelCambia.add(juegoss);
		}
		/*
		 * // Configurar el panel de música panelInformacion = new JPanel();s
		 * panelInformacion.setPreferredSize(new Dimension(1069, 135));
		 * panelInformacion.setBorder(BorderFactory.createEmptyBorder(65, 192, 53,
		 * 600)); List<Musica> musicas = model.obtenerMusicasCompradas(0); for (Musica
		 * musica : musicas) { JPanel musicaPanel = model.crearMusicaPanel(musica);
		 * panelCambia.add(musicaPanel); }
		 */
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

		panelmenu = new javax.swing.JPanel();

		panelmenu.setBackground(new java.awt.Color(44, 47, 72));
		panelmenu.setMinimumSize(new java.awt.Dimension(1132, 774));
		panelmenu.setPreferredSize(new java.awt.Dimension(1132, 774));

		javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
		panelmenu.setLayout(panelmenuLayout);
		panelmenuLayout.setHorizontalGroup(panelmenuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1132, Short.MAX_VALUE));
		panelmenuLayout.setVerticalGroup(panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 774, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelmenu,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelmenu,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents

	private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel panelmenu;
	// End of variables declaration//GEN-END:variables
}
