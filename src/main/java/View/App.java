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
import java.awt.Color;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
public class App extends javax.swing.JFrame {
	model model;
	Usuario user;

	/**
	 * Creates new form main
	 */
	public App(model mod, Usuario user) {
		initComponents();
		this.model = mod;
                this.user=user;
                model.setUser(user);
		Personal.setText(user.getUsername());
		colores(Principal);
		cambiarPanel(new PanelInicio(model, user));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        Explorar = new javax.swing.JLabel();
        Principal = new javax.swing.JPanel();
        principal = new javax.swing.JLabel();
        Comprar = new javax.swing.JPanel();
        comprar = new javax.swing.JLabel();
        Jugar = new javax.swing.JPanel();
        jugar = new javax.swing.JLabel();
        Musica = new javax.swing.JPanel();
        musica = new javax.swing.JLabel();
        Amigos = new javax.swing.JPanel();
        amigos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Personal = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        panelExplorar = new javax.swing.JPanel();
        explorar = new javax.swing.JPanel();
        explore = new javax.swing.JLabel();
        Cambiante = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(44, 47, 72));
        panelMenu.setPreferredSize(new java.awt.Dimension(320, 806));

        Menu.setBackground(new java.awt.Color(44, 47, 72));

        Explorar.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        Explorar.setForeground(new java.awt.Color(255, 255, 255));
        Explorar.setText("Explore, Find, Play");
        Explorar.setMaximumSize(new java.awt.Dimension(244, 44));
        Explorar.setMinimumSize(new java.awt.Dimension(244, 44));
        Explorar.setPreferredSize(new java.awt.Dimension(244, 44));

        Principal.setBackground(new java.awt.Color(44, 47, 72));
        Principal.setPreferredSize(new java.awt.Dimension(212, 40));
        Principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrincipalMouseEntered(evt);
            }
        });

        principal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        principal.setForeground(new java.awt.Color(255, 255, 255));
        principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Explore.png"))); // NOI18N
        principal.setText("Home");

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Comprar.setBackground(new java.awt.Color(44, 47, 72));
        Comprar.setPreferredSize(new java.awt.Dimension(212, 40));

        comprar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        comprar.setForeground(new java.awt.Color(255, 255, 255));
        comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tech.png"))); // NOI18N
        comprar.setText("Comprar");
        comprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comprarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout ComprarLayout = new javax.swing.GroupLayout(Comprar);
        Comprar.setLayout(ComprarLayout);
        ComprarLayout.setHorizontalGroup(
            ComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        ComprarLayout.setVerticalGroup(
            ComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comprar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Jugar.setBackground(new java.awt.Color(44, 47, 72));
        Jugar.setPreferredSize(new java.awt.Dimension(212, 40));

        jugar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jugar.setForeground(new java.awt.Color(255, 255, 255));
        jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Education.png"))); // NOI18N
        jugar.setText("Jugar");
        jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jugarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout JugarLayout = new javax.swing.GroupLayout(Jugar);
        Jugar.setLayout(JugarLayout);
        JugarLayout.setHorizontalGroup(
            JugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JugarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        JugarLayout.setVerticalGroup(
            JugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JugarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Musica.setBackground(new java.awt.Color(44, 47, 72));
        Musica.setPreferredSize(new java.awt.Dimension(212, 40));

        musica.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        musica.setForeground(new java.awt.Color(255, 255, 255));
        musica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Music.png"))); // NOI18N
        musica.setText("Musica");
        musica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                musicaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout MusicaLayout = new javax.swing.GroupLayout(Musica);
        Musica.setLayout(MusicaLayout);
        MusicaLayout.setHorizontalGroup(
            MusicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MusicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(musica, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        MusicaLayout.setVerticalGroup(
            MusicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MusicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(musica, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Amigos.setBackground(new java.awt.Color(44, 47, 72));
        Amigos.setPreferredSize(new java.awt.Dimension(212, 40));

        amigos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        amigos.setForeground(new java.awt.Color(255, 255, 255));
        amigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Symbol.png"))); // NOI18N
        amigos.setText("Amigos");
        amigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                amigosMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout AmigosLayout = new javax.swing.GroupLayout(Amigos);
        Amigos.setLayout(AmigosLayout);
        AmigosLayout.setHorizontalGroup(
            AmigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AmigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amigos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        AmigosLayout.setVerticalGroup(
            AmigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(amigos, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Amigos, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Musica, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Explorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(Explorar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Musica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Amigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        Personal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Personal.setForeground(new java.awt.Color(255, 255, 255));
        Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        Personal.setText("User");
        Personal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Personal.setIconTextGap(22);
        Personal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonalMouseClicked(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(65, 74, 92));
        Salir.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.setPreferredSize(new java.awt.Dimension(162, 28));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(Personal)
                .addGap(18, 18, 18)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 818));

        panelExplorar.setBackground(new java.awt.Color(44, 47, 72));
        panelExplorar.setPreferredSize(new java.awt.Dimension(1132, 44));

        explorar.setBackground(new java.awt.Color(46, 51, 90));
        explorar.setForeground(new java.awt.Color(255, 255, 255));
        explorar.setPreferredSize(new java.awt.Dimension(442, 24));

        explore.setForeground(new java.awt.Color(255, 255, 255));
        explore.setText("Explore");

        javax.swing.GroupLayout explorarLayout = new javax.swing.GroupLayout(explorar);
        explorar.setLayout(explorarLayout);
        explorarLayout.setHorizontalGroup(
            explorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, explorarLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(explore)
                .addGap(185, 185, 185))
        );
        explorarLayout.setVerticalGroup(
            explorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(explorarLayout.createSequentialGroup()
                .addComponent(explore)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelExplorarLayout = new javax.swing.GroupLayout(panelExplorar);
        panelExplorar.setLayout(panelExplorarLayout);
        panelExplorarLayout.setHorizontalGroup(
            panelExplorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExplorarLayout.createSequentialGroup()
                .addContainerGap(363, Short.MAX_VALUE)
                .addComponent(explorar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        panelExplorarLayout.setVerticalGroup(
            panelExplorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExplorarLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(explorar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        getContentPane().add(panelExplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 0, 1150, -1));

        Cambiante.setBackground(new java.awt.Color(29, 32, 62));
        Cambiante.setMaximumSize(new java.awt.Dimension(1132, 774));
        Cambiante.setMinimumSize(new java.awt.Dimension(1132, 774));
        Cambiante.setPreferredSize(new java.awt.Dimension(1132, 774));

        javax.swing.GroupLayout CambianteLayout = new javax.swing.GroupLayout(Cambiante);
        Cambiante.setLayout(CambianteLayout);
        CambianteLayout.setHorizontalGroup(
            CambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        CambianteLayout.setVerticalGroup(
            CambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );

        getContentPane().add(Cambiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 44, 1140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonalMouseClicked
        cambiarPanel(new Usermenu(user));
    }//GEN-LAST:event_PersonalMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SalirActionPerformed
		dispose();
	}// GEN-LAST:event_SalirActionPerformed

	private void PrincipalMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PrincipalMouseEntered
		colores(Principal);
		cambiarPanel(new PanelInicio(model,user));
	}

	private void comprarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_comprarMouseEntered
		colores(Comprar);
		cambiarPanel(new Compras(model,user));
	}

	private void jugarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jugarMouseEntered
		colores(Jugar);
		cambiarPanel(new JuegosUsuarios(model,user));
	}

	private void musicaMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_musicaMouseEntered
		colores(Musica);
		cambiarPanel(new PanelInicio(model,user));
	}

	private void amigosMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_amigosMouseEntered
		colores(Amigos);
		controller.Amigos();
	}

private void cambiarPanel(javax.swing.JPanel nuevoPanel) {
    System.out.println("Cambiando panel...");
    System.out.println("Nuevo panel: " + nuevoPanel.getClass().getName());
    System.out.println("Tamaño del panel Cambiante: " + Cambiante.getSize());

    nuevoPanel.setSize(Cambiante.getWidth(), Cambiante.getHeight());
    nuevoPanel.setLocation(0, 0);

    System.out.println("Tamaño del nuevo panel: " + nuevoPanel.getSize());
    System.out.println("Posición del nuevo panel: " + nuevoPanel.getLocation());

    Cambiante.removeAll();
    Cambiante.add(nuevoPanel);
    Cambiante.revalidate();
    Cambiante.repaint();

    System.out.println("Panel cambiado exitosamente.");
}


	private void colores(javax.swing.JPanel Panelpuesto) {
		Amigos.setBackground(Color.decode("#2C2F48"));
		Comprar.setBackground(Color.decode("#2C2F48"));
		Jugar.setBackground(Color.decode("#2C2F48"));
		Explorar.setBackground(Color.decode("#2C2F48"));
		Musica.setBackground(Color.decode("#2C2F48"));
		Principal.setBackground(Color.decode("#2C2F48"));
		Panelpuesto.setBackground(Color.black);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Amigos;
    private javax.swing.JPanel Cambiante;
    private javax.swing.JPanel Comprar;
    private javax.swing.JLabel Explorar;
    private javax.swing.JPanel Jugar;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Musica;
    private javax.swing.JLabel Personal;
    private javax.swing.JPanel Principal;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel amigos;
    private javax.swing.JLabel comprar;
    private javax.swing.JPanel explorar;
    private javax.swing.JLabel explore;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jugar;
    private javax.swing.JLabel musica;
    private javax.swing.JPanel panelExplorar;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel principal;
    // End of variables declaration//GEN-END:variables

}
