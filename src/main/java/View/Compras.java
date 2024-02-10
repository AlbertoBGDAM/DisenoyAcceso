/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.model;
import hibernate.Juegos;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class Compras extends javax.swing.JPanel {

    private model modelo;
    public Compras(model mode) {
        this.modelo = mode;
        initComponents();

        DefaultListModel<String> juegosListModel = new DefaultListModel<>();
        listadecompra.setModel(juegosListModel);

        List<Juegos> todosLosJuegos = modelo.obtenerTodosLosJuegos();
        List<Juegos> juegosComprados = modelo.obtenerJuegosComprados();

        for (Juegos juego : todosLosJuegos) {
            if (!juegosComprados.contains(juego)) {
                juegosListModel.addElement(juego.getNombre());
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compras = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadecompra = new javax.swing.JList<>();

        compras.setBackground(new java.awt.Color(29, 32, 62));
        compras.setPreferredSize(new java.awt.Dimension(1132, 774));

        listadecompra.setBackground(new java.awt.Color(25, 30, 42));
        listadecompra.setForeground(new java.awt.Color(255, 255, 255));
        listadecompra.setMaximumSize(new java.awt.Dimension(965, 603));
        listadecompra.setMinimumSize(new java.awt.Dimension(965, 603));
        listadecompra.setPreferredSize(new java.awt.Dimension(965, 603));
        jScrollPane1.setViewportView(listadecompra);

        javax.swing.GroupLayout comprasLayout = new javax.swing.GroupLayout(compras);
        compras.setLayout(comprasLayout);
        comprasLayout.setHorizontalGroup(
            comprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comprasLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        comprasLayout.setVerticalGroup(
            comprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comprasLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1144, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(compras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(compras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel compras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listadecompra;
    // End of variables declaration//GEN-END:variables
}
