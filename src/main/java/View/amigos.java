/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import com.formdev.flatlaf.extras.FlatSVGIcon;
/**
 *
 * @author Alumno
 */
public class amigos extends javax.swing.JFrame {

    /**
     * Creates new form amigos
     */
    public amigos() {
        initComponents();
        atras.setIcon(new FlatSVGIcon( "atras.svg" ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Atras = new javax.swing.JPanel();
        atras = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout AtrasLayout = new javax.swing.GroupLayout(Atras);
        Atras.setLayout(AtrasLayout);
        AtrasLayout.setHorizontalGroup(
            AtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AtrasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(atras, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
        );
        AtrasLayout.setVerticalGroup(
            AtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AtrasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(atras, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        getContentPane().add(Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 380, 246));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 330, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Atras;
    private javax.swing.JLabel Icon;
    private javax.swing.JLabel atras;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}