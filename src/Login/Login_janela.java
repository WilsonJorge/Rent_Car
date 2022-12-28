/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
package Login;

//import Conexao_BD.Pedidos_BD;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Login_janela extends javax.swing.JFrame {

  //  private Pedidos_BD conect;
  // Janela_Pricinpal j;
   
    public Login_janela() {
        //conect= new Pedidos_BD();
       //j= new Janela_Pricinpal();
       // initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sair_btn = new javax.swing.JButton();
        entrar_btn = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();
        userLBL = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        passTXT = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lblnotificacao = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel4.setText("jLabel4");

        jButton1.setText("jButton1");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(400, 410));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        sair_btn.setBackground(new java.awt.Color(217, 81, 51));
        sair_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sair_btn.setForeground(new java.awt.Color(255, 255, 255));
        sair_btn.setText("Sair");
        sair_btn.setToolTipText("Sair da janela login");
        sair_btn.setBorderPainted(false);
        sair_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair_btn.setFocusPainted(false);
        sair_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair_btnActionPerformed(evt);
            }
        });

        entrar_btn.setBackground(new java.awt.Color(58, 65, 84));
        entrar_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        entrar_btn.setForeground(new java.awt.Color(255, 255, 255));
        entrar_btn.setText("Entrar");
        entrar_btn.setBorderPainted(false);
        entrar_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar_btn.setFocusPainted(false);
        entrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrar_btnActionPerformed(evt);
            }
        });

        userTxt.setBackground(new java.awt.Color(102, 102, 102));
        userTxt.setForeground(new java.awt.Color(255, 255, 255));
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });

        userLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userLBL.setText("UserName");

        passLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passLbl.setText("Password");

        passTXT.setBackground(new java.awt.Color(102, 102, 102));
        passTXT.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user-interface.png"))); // NOI18N

        lblnotificacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblnotificacao.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(sair_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(userTxt)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passLbl)
                            .addComponent(userLBL))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblnotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(entrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLBL)
                .addGap(11, 11, 11)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sair_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrar_btnActionPerformed
        String nome=userTxt.getText().toString();
        int pass=Integer.parseInt(passTXT.getText().toString());
        
        boolean val=conect.login(nome, pass);
        if(val==true)
        {
            j.setNome(nome);
            j.setVisible(true);
        }
        else
        {
           passTXT.setBackground(new java.awt.Color(255, 59, 40,100));
           lblnotificacao.setText("Verifica se o username ou  password esta correcto");
        }
            
       
       
        
    }//GEN-LAST:event_entrar_btnActionPerformed

    private void sair_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sair_btnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sair_btnActionPerformed

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblnotificacao;
    private javax.swing.JLabel passLbl;
    private javax.swing.JPasswordField passTXT;
    private javax.swing.JButton sair_btn;
    private javax.swing.JLabel userLBL;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}*/
