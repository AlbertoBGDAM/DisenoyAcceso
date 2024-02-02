/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.model;
import hibernate.Usuario;

/**
 *
 * @author alber
 */
public class Usermenu extends javax.swing.JPanel {
    model model=new model();
    Usuario usuario;
    /**
     * Creates new form Usermenu
     */
    public Usermenu(Usuario user) {
        initComponents();
        Usuario usuario=user;
        Juegos=model.listar();
        if(Juegos==null){
            remove(Juegos);
            /*add()*/
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

        modify = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        alias = new javax.swing.JLabel();
        Alias = new javax.swing.JTextArea();
        correo = new javax.swing.JLabel();
        Correo = new javax.swing.JTextArea();
        Contra = new javax.swing.JTextArea();
        contra = new javax.swing.JLabel();
        Tarjeta = new javax.swing.JTextArea();
        tarjeta = new javax.swing.JLabel();
        Cambiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Juegos = new javax.swing.JList<>();
        Devolver = new javax.swing.JButton();

        setBackground(new java.awt.Color(44, 47, 72));
        setMaximumSize(new java.awt.Dimension(1132, 774));
        setMinimumSize(new java.awt.Dimension(1132, 774));
        setPreferredSize(new java.awt.Dimension(1132, 774));

        modify.setBackground(new java.awt.Color(65, 74, 92));
        modify.setMaximumSize(new java.awt.Dimension(1071, 165));
        modify.setMinimumSize(new java.awt.Dimension(1071, 165));
        modify.setPreferredSize(new java.awt.Dimension(1071, 165));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N

        alias.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        alias.setForeground(new java.awt.Color(255, 255, 255));
        alias.setText("Alias:");
        alias.setToolTipText("");

        Alias.setBackground(new java.awt.Color(65, 74, 92));
        Alias.setColumns(20);
        Alias.setRows(1);
        Alias.setTabSize(1);

        correo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.setText("Correo:");
        correo.setToolTipText("");

        Correo.setBackground(new java.awt.Color(65, 74, 92));
        Correo.setColumns(20);
        Correo.setRows(1);
        Correo.setTabSize(1);

        Contra.setBackground(new java.awt.Color(65, 74, 92));
        Contra.setColumns(20);
        Contra.setRows(1);
        Contra.setTabSize(1);

        contra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        contra.setForeground(new java.awt.Color(255, 255, 255));
        contra.setText("Contraseña:");
        contra.setToolTipText("");

        Tarjeta.setBackground(new java.awt.Color(65, 74, 92));
        Tarjeta.setColumns(20);
        Tarjeta.setRows(1);
        Tarjeta.setTabSize(1);

        tarjeta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tarjeta.setForeground(new java.awt.Color(255, 255, 255));
        tarjeta.setText("Tarjeta:");
        tarjeta.setToolTipText("");

        Cambiar.setBackground(new java.awt.Color(29, 32, 62));
        Cambiar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Cambiar.setForeground(new java.awt.Color(255, 255, 255));
        Cambiar.setText("Cambiar datos");
        Cambiar.setPreferredSize(new java.awt.Dimension(232, 55));
        Cambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CambiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout modifyLayout = new javax.swing.GroupLayout(modify);
        modify.setLayout(modifyLayout);
        modifyLayout.setHorizontalGroup(
            modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(tarjeta)
                .addGap(18, 18, 18)
                .addComponent(Tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(modifyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(user)
                .addGroup(modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifyLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(correo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(modifyLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(alias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Alias, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(contra)
                        .addGap(18, 18, 18)
                        .addComponent(Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(318, Short.MAX_VALUE))))
        );
        modifyLayout.setVerticalGroup(
            modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifyLayout.createSequentialGroup()
                        .addGroup(modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alias)
                            .addComponent(Alias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contra)
                            .addComponent(Contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modifyLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(Cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(correo)
                                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))))
                    .addGroup(modifyLayout.createSequentialGroup()
                        .addComponent(user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                .addGroup(modifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tarjeta)
                    .addComponent(Tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        Juegos.setBackground(new java.awt.Color(65, 74, 92));
        Juegos.setBorder(null);
        Juegos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Juegos);

        Devolver.setBackground(new java.awt.Color(44, 47, 72));
        Devolver.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        Devolver.setForeground(new java.awt.Color(255, 255, 255));
        Devolver.setText("Devolver selecuionado");
        Devolver.setMaximumSize(new java.awt.Dimension(650, 75));
        Devolver.setMinimumSize(new java.awt.Dimension(650, 75));
        Devolver.setPreferredSize(new java.awt.Dimension(650, 75));
        Devolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DevolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(Devolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(Devolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CambiarMouseClicked
        model.cambiarDatos(usuario,Alias.getText(),Contra.getText(),Correo.getText(),Tarjeta.getText());
    }//GEN-LAST:event_CambiarMouseClicked

    private void DevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DevolverMouseClicked
        if (Juegos.getSelectedValue() != null) {
                String juegoSeleccionado = Juegos.getSelectedValue();
                String[] partes = juegoSeleccionado.split(" - ");
                String nombreJuego = partes[0];
                String descripcionJuego = partes[1];
                model.devolverJuegoSeleccionado(usuario,nombreJuego,descripcionJuego);
                Juegos=model.listar();
        }
    }//GEN-LAST:event_DevolverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alias;
    private javax.swing.JButton Cambiar;
    private javax.swing.JTextArea Contra;
    private javax.swing.JTextArea Correo;
    private javax.swing.JButton Devolver;
    private javax.swing.JList<String> Juegos;
    private javax.swing.JTextArea Tarjeta;
    private javax.swing.JLabel alias;
    private javax.swing.JLabel contra;
    private javax.swing.JLabel correo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel modify;
    private javax.swing.JLabel tarjeta;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
