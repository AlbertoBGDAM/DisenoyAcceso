/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.model;
import hibernate.Juegos;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class Juego extends javax.swing.JPanel {

    /**
     * Creates new form Juegoss
     */
    private JPanel panelCambia;
    model model= new model();
    public Juego() {
        List<Juegos> juegos = model.obtenerJuegosComprados(0); // Obtener los primeros 3 juegos comprados
        panelCambia = new JPanel(new GridLayout(0, 3, 50, 50));
        panelCambia.setBorder(BorderFactory.createEmptyBorder(133, 36, 84, 0));
        for (Juegos juego : juegos) {
            JPanel juegoPanel = model.crearJuegoPanel(juego);
            panelCambia.add(juegoPanel);
        }
        Juegoss = new JScrollPane(panelCambia);
        Juegoss.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        Juegoss.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Juegoss = new javax.swing.JScrollPane();

        setMaximumSize(new java.awt.Dimension(1132, 774));
        setMinimumSize(new java.awt.Dimension(1132, 774));
        setPreferredSize(new java.awt.Dimension(1132, 774));

        Juegoss.setToolTipText("");
        Juegoss.setHorizontalScrollBar(null);
        Juegoss.setMaximumSize(new java.awt.Dimension(1132, 774));
        Juegoss.setMinimumSize(new java.awt.Dimension(1132, 774));
        Juegoss.setPreferredSize(new java.awt.Dimension(1132, 774));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Juegoss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Juegoss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Juegoss;
    // End of variables declaration//GEN-END:variables
}
