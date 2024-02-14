/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.controller;
import Model.model;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import hibernate.Usuario;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class inicio extends javax.swing.JFrame {

	/**
	 * Creates new form NewJFrame
	 */
	model mod;
        controller con;
	public inicio(model model,controller cono) {
		setLocationRelativeTo(null);
		initComponents();
		this.mod = model;
                this.con=cono;
		cambiarPanel(new Loging(mod, this,con), false);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mobil = new javax.swing.JPanel();
        fijo = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        registrarse = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        contraseña = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mobil.setMinimumSize(new java.awt.Dimension(432, 636));
        mobil.setPreferredSize(new java.awt.Dimension(432, 636));

        javax.swing.GroupLayout mobilLayout = new javax.swing.GroupLayout(mobil);
        mobil.setLayout(mobilLayout);
        mobilLayout.setHorizontalGroup(
            mobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        mobilLayout.setVerticalGroup(
            mobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        fijo.setBackground(new java.awt.Color(28, 10, 67));
        fijo.setForeground(new java.awt.Color(28, 10, 67));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        registrarse.setBackground(new java.awt.Color(25, 30, 42));
        registrarse.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        registrarse.setForeground(new java.awt.Color(255, 255, 255));
        registrarse.setText("Registrarse");
        registrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseActionPerformed(evt);
            }
        });

        atras.setBackground(new java.awt.Color(25, 30, 42));
        atras.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setText("Atras");
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        contraseña.setBackground(new java.awt.Color(25, 30, 42));
        contraseña.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setText("Restablecer contraseña");
        contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fijoLayout = new javax.swing.GroupLayout(fijo);
        fijo.setLayout(fijoLayout);
        fijoLayout.setHorizontalGroup(
            fijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fijoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fijoLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(fijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fijoLayout.createSequentialGroup()
                        .addComponent(contraseña)
                        .addGap(32, 32, 32)
                        .addComponent(registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        fijoLayout.setVerticalGroup(
            fijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fijoLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(fijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fijo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_contraseñaActionPerformed
		cambiarPanel(new Recu(mod), true);
	}// GEN-LAST:event_contraseñaActionPerformed

	private void atrasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_atrasActionPerformed
		cambiarPanel(new Loging(mod, this,con), false);
	}// GEN-LAST:event_atrasActionPerformed

	private void registrarseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registrarseActionPerformed
		cambiarPanel(new nuevacuenta(mod), true);
	}// GEN-LAST:event_registrarseActionPerformed

	private void cambiarPanel(javax.swing.JPanel nuevoPanel, boolean atrass) {
		atras.setVisible(atrass);
		contraseña.setVisible(!atrass);
		registrarse.setVisible(!atrass);
		nuevoPanel.setSize(mobil.getWidth(), mobil.getHeight());
		nuevoPanel.setLocation(0, 0);
		mobil.removeAll();
		mobil.add(nuevoPanel);
		mobil.revalidate();
		mobil.repaint();
	}

	public void cerrar() {
		dispose();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton contraseña;
    private javax.swing.JPanel fijo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mobil;
    private javax.swing.JButton registrarse;
    // End of variables declaration//GEN-END:variables

	public Usuario getuser() {
		return mod.getUser();
	}
}
