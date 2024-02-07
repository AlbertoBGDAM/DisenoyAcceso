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
	model model = new model();
	Usuario user;
        public void setUser(Usuario user){
            this.user=user;
        }
	/**
	 * Creates new form main
	 */
	public App() {
		initComponents();
		User.setText(user.getUsername());
		Personal.setText(user.getUsername());
		User.setIcon(new FlatSVGIcon("image/user.svg"));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
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
        User = new javax.swing.JLabel();
        Personal = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        panelExplorar = new javax.swing.JPanel();
        nuevosamigos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Cambiante = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Explorar, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
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

        User.setForeground(new java.awt.Color(255, 255, 255));
        User.setPreferredSize(new java.awt.Dimension(183, 101));
        User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserMouseEntered(evt);
            }
        });

        Personal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Personal.setForeground(new java.awt.Color(255, 255, 255));
        Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        Personal.setText("User");
        Personal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Personal.setIconTextGap(22);

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
                        .addComponent(Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Personal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        panelExplorar.setBackground(new java.awt.Color(44, 47, 72));
        panelExplorar.setPreferredSize(new java.awt.Dimension(1132, 44));

        nuevosamigos.setBackground(new java.awt.Color(46, 51, 90));
        nuevosamigos.setForeground(new java.awt.Color(255, 255, 255));
        nuevosamigos.setPreferredSize(new java.awt.Dimension(442, 24));
        nuevosamigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevosamigosMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Explore");

        javax.swing.GroupLayout nuevosamigosLayout = new javax.swing.GroupLayout(nuevosamigos);
        nuevosamigos.setLayout(nuevosamigosLayout);
        nuevosamigosLayout.setHorizontalGroup(
            nuevosamigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nuevosamigosLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(185, 185, 185))
        );
        nuevosamigosLayout.setVerticalGroup(
            nuevosamigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevosamigosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelExplorarLayout = new javax.swing.GroupLayout(panelExplorar);
        panelExplorar.setLayout(panelExplorarLayout);
        panelExplorarLayout.setHorizontalGroup(
            panelExplorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExplorarLayout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(nuevosamigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        panelExplorarLayout.setVerticalGroup(
            panelExplorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExplorarLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(nuevosamigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        Cambiante.setBackground(new java.awt.Color(29, 32, 62));
        Cambiante.setPreferredSize(new java.awt.Dimension(1132, 774));

        javax.swing.GroupLayout CambianteLayout = new javax.swing.GroupLayout(Cambiante);
        Cambiante.setLayout(CambianteLayout);
        CambianteLayout.setHorizontalGroup(
            CambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
        );
        CambianteLayout.setVerticalGroup(
            CambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Cambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevosamigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevosamigosMouseClicked
        AmigosNuevos an= new AmigosNuevos();
        an.setmod(model);
        an.setUsuario(user);
        an.main();
    }//GEN-LAST:event_nuevosamigosMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        controller.salir();
    }//GEN-LAST:event_SalirActionPerformed

    private void PrincipalMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PrincipalMouseEntered
	colores(Principal);
	cambiarPanel(new PanelInicio());
    }

    private void UserMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_UserMouseEntered
	cambiarPanel(new Usermenu(user));
    }

    private void comprarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_comprarMouseEntered
	colores(Comprar);
	cambiarPanel(new PanelInicio());
    }

    private void jugarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jugarMouseEntered
	colores(Jugar);
	cambiarPanel(new PanelInicio());
    }

    private void musicaMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_musicaMouseEntered
    	colores(Musica);
	cambiarPanel(new PanelInicio());
    }

    private void amigosMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_amigosMouseEntered
    	colores(Amigos);
    	cambiarPanel(new PanelInicio());
    }

    private void cambiarPanel(javax.swing.JPanel nuevoPanel) {
	nuevoPanel.setSize(Cambiante.getWidth(), Cambiante.getHeight());
	nuevoPanel.setLocation(0, 0);
	Cambiante.removeAll();
	Cambiante.add(nuevoPanel);
	Cambiante.revalidate();
	Cambiante.repaint();
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

	public static void main() {
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
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		FlatGradiantoMidnightBlueIJTheme.setup();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new App().setVisible(true);
			}
		});
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
    private javax.swing.JLabel User;
    private javax.swing.JLabel amigos;
    private javax.swing.JLabel comprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jugar;
    private javax.swing.JLabel musica;
    private javax.swing.JPanel nuevosamigos;
    private javax.swing.JPanel panelExplorar;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel principal;
    // End of variables declaration//GEN-END:variables

}
