package shapes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author declan
 */
public class LoginGUI extends javax.swing.JFrame {

    Connection conn;
    Player currPlayer;
    DBManager manager;

    String dbServer = "jdbc:mysql://mysql1.gear.host/";
    String dbName = "shapersdb";
    String dbUser = "shapers";
    String dbPass = "shapers!";
    String driver = "com.mysql.jdbc.Driver";
    

    public LoginGUI() {
        super("Shapes Game");
        initComponents();

        currPlayer = new Player();
        manager = new DBManager();

        try {
            conn = DriverManager.getConnection(dbServer + dbName, dbUser, dbPass);
            manager.setConn(conn);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }

    private boolean login(String name) {
        String query = "SELECT * FROM Player WHERE gamertag = '" + name + "';";
        ResultSet rs = manager.SELECT_QUERY(query);

        try {
            if (rs.next()) {
                
                currPlayer.setGamertag(rs.getString(2));
                currPlayer.setPid(rs.getInt(1));
                currPlayer.setGamercore(rs.getInt(3));

                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public void Register(Player p) {
        String query = "INSERT INTO Player VALUES(null,'" + p.getGamertag()
                +"'," + p.getGamercore() + ");";
        
        boolean upd = manager.UPDATE_QUERY(query);
        if(upd == true){
        JOptionPane.showMessageDialog(null, "Registered Successfully");    
        }else{
        JOptionPane.showMessageDialog(null, "Register Failed! Please try again!");
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

        ShapePnl = new javax.swing.JPanel();
        registerBtn = new javax.swing.JButton();
        TitleLbl = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        NameLbl = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        LoginLbl = new javax.swing.JLabel();
        LoginBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ShapePnl.setLayout(null);

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        ShapePnl.add(registerBtn);
        registerBtn.setBounds(370, 220, 120, 30);

        TitleLbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        TitleLbl.setText("Learn with Shapes!");
        TitleLbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        ShapePnl.add(TitleLbl);
        TitleLbl.setBounds(140, 30, 390, 60);
        ShapePnl.add(NameTF);
        NameTF.setBounds(253, 170, 250, 31);

        NameLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameLbl.setText("NAME:");
        ShapePnl.add(NameLbl);
        NameLbl.setBounds(160, 170, 101, 22);

        LoginBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginBtn.setText("Log In");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        ShapePnl.add(LoginBtn);
        LoginBtn.setBounds(260, 220, 106, 31);

        LoginLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginLbl.setText("Please enter your name to Login/Register:");
        ShapePnl.add(LoginLbl);
        LoginLbl.setBounds(140, 110, 400, 22);

        LoginBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Login2.jpg"))); // NOI18N
        ShapePnl.add(LoginBG);
        LoginBG.setBounds(0, 0, 630, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ShapePnl, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ShapePnl, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        // TODO add your handling code here:
        if(login(NameTF.getText()) == true){
        JOptionPane.showMessageDialog(null, "Welcome " + currPlayer.getGamertag() + "\n" +"Your previous Score was:" + "\n" + currPlayer.getGamercore());
        GameGUI a = new GameGUI();
        a.setPlayer(currPlayer);
        a.setVisible(true);
        dispose();
        }else{
        JOptionPane.showMessageDialog(null, "Login Failed! Please try again.");
        }
      
        
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        Player obj = new Player();
        obj.setGamertag(NameTF.getText());
        obj.setGamercore(0);
        Register(obj);
    }//GEN-LAST:event_registerBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginBG;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LoginLbl;
    private javax.swing.JLabel NameLbl;
    private javax.swing.JTextField NameTF;
    private javax.swing.JPanel ShapePnl;
    private javax.swing.JLabel TitleLbl;
    private javax.swing.JButton registerBtn;
    // End of variables declaration//GEN-END:variables
}
