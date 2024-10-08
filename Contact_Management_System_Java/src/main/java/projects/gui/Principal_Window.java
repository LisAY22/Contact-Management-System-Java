package projects.gui;

import projects.sql.ConnectionDB;

/**
 *
 * @author lisaj
 */
public class Principal_Window extends javax.swing.JFrame {
    
    private ConnectionDB con;
    
    /**
     * Creates new form Principal_Window
     */
    public Principal_Window() {
        this.con = new ConnectionDB();
        con.obtainConnection();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Add_jButton = new javax.swing.JButton();
        Edit_jButton = new javax.swing.JButton();
        View_jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 238, 158));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTACT INFORMATION");

        Add_jButton.setBackground(new java.awt.Color(62, 86, 65));
        Add_jButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        Add_jButton.setForeground(new java.awt.Color(255, 255, 255));
        Add_jButton.setText("ADD");
        Add_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_jButtonActionPerformed(evt);
            }
        });

        Edit_jButton.setBackground(new java.awt.Color(62, 86, 65));
        Edit_jButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        Edit_jButton.setForeground(new java.awt.Color(255, 255, 255));
        Edit_jButton.setText("EDIT/DELETE");
        Edit_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_jButtonActionPerformed(evt);
            }
        });

        View_jButton.setBackground(new java.awt.Color(62, 86, 65));
        View_jButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        View_jButton.setForeground(new java.awt.Color(255, 255, 255));
        View_jButton.setText("VIEW");
        View_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(View_jButton)
                .addGap(76, 76, 76)
                .addComponent(Add_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Edit_jButton)
                        .addGap(196, 196, 196))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(View_jButton)
                    .addComponent(Add_jButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Edit_jButton)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Add_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_jButtonActionPerformed
        // TODO add your handling code here:
        Add_Window add_screen = new Add_Window(con);
        add_screen.setVisible(true);
        add_screen.setLocationRelativeTo(null);
        
        dispose();
    }//GEN-LAST:event_Add_jButtonActionPerformed

    private void View_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_jButtonActionPerformed
        // TODO add your handling code here:
        View_Window view_screen = new View_Window(con);
        view_screen.setVisible(true);
        view_screen.setLocationRelativeTo(null);
        
        dispose(); 
    }//GEN-LAST:event_View_jButtonActionPerformed

    private void Edit_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_jButtonActionPerformed
        // TODO add your handling code here:
        Edit_Window edit_screen = new Edit_Window(con);
        edit_screen.setVisible(true);
        edit_screen.setLocationRelativeTo(null);

        dispose();
    }//GEN-LAST:event_Edit_jButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_jButton;
    private javax.swing.JButton Edit_jButton;
    private javax.swing.JButton View_jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
