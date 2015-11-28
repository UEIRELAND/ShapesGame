package shapes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author x13114352
 */
public class LeaderBrdGUI extends javax.swing.JFrame {

    CustButton myButton = new CustButton();
    CustButton myButton1 = new CustButton();

    int score = 0;
    Player obj = new Player();

    Connection conn;
    Player currPlayer;
    DBManager manager;

    String dbServer = "jdbc:mysql://mysql1.gear.host/";
    String dbName = "shapersdb";
    String dbUser = "shapers";
    String dbPass = "shapers!";
    String driver = "com.mysql.jdbc.Driver";
    private Object stmt;

    /**
     * Creates new form gameGUI
     */
    public LeaderBrdGUI() {
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

//    public void setPlayer(Player p) {
//        this.obj = p;
//}

//    public void updateScore(Player s) {
//        String query = "UPDATE Player SET gamerscore = " + s.getGamercore() + ""
//                + " where pid=" + s.getPid() + ";";
//        boolean upd = manager.UPDATE_QUERY(query);
//    }

//    public boolean setLeaderBoard(Player a) {
//        String query = "SELECT * FROM Player ORDER BY Gamerscore DESC " + a.getGamertag() + a.getGamercore() + ""
//                + " where pid=" + a.getPid() + ";";
//        ResultSet rs = manager.SELECT_QUERY(query);
//
//        try {
//            if (rs.next()) {
//
//                currPlayer.getGamertag();
//                currPlayer.getPid();
//                currPlayer.getGamercore();
//
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//            return false;
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        HomeBtn = new javax.swing.JButton();
        LeaderTF = new javax.swing.JTextField();
        ScoreTF = new javax.swing.JTextField();
        ScoreBtn = new javax.swing.JButton();
        PlayerBTN = new javax.swing.JButton();
        TitleBtn = new javax.swing.JLabel();
        EndBTn = new javax.swing.JButton();
        displayLbl = new javax.swing.JLabel();
        bcGroundLbl = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(630, 630));
        jPanel1.setLayout(null);

        HomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home.png"))); // NOI18N
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(HomeBtn);
        HomeBtn.setBounds(0, 280, 80, 20);
        jPanel1.add(LeaderTF);
        LeaderTF.setBounds(240, 100, 110, 20);
        jPanel1.add(ScoreTF);
        ScoreTF.setBounds(240, 180, 110, 20);

        ScoreBtn.setText("Score");
        ScoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScoreBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ScoreBtn);
        ScoreBtn.setBounds(90, 180, 90, 23);

        PlayerBTN.setText("Player");
        PlayerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerBTNActionPerformed(evt);
            }
        });
        jPanel1.add(PlayerBTN);
        PlayerBTN.setBounds(90, 100, 90, 23);

        TitleBtn.setBackground(new java.awt.Color(255, 255, 255));
        TitleBtn.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        TitleBtn.setText("LeaderBoard");
        jPanel1.add(TitleBtn);
        TitleBtn.setBounds(160, 30, 200, 30);

        EndBTn.setBackground(new java.awt.Color(255, 255, 255));
        EndBTn.setText("End Game");
        EndBTn.setOpaque(false);
        EndBTn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndBTnActionPerformed(evt);
            }
        });
        jPanel1.add(EndBTn);
        EndBTn.setBounds(360, 280, 100, 23);

        displayLbl.setBackground(new java.awt.Color(102, 255, 255));
        displayLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        displayLbl.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(displayLbl);
        displayLbl.setBounds(1, 274, 460, 15);

        bcGroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bGround.jpg"))); // NOI18N
        jPanel1.add(bcGroundLbl);
        bcGroundLbl.setBounds(0, 0, 460, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EndBTnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndBTnActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_EndBTnActionPerformed

    private void PlayerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerBTNActionPerformed
        // TODO add your handling code here:
        //Display to leaderboard

        String query1 = "select gamertag from shapersdb.player where gamerscore =(select max(gamerscore) from shapersdb.player)";
        ResultSet rs = manager.SELECT_QUERY(query1);

        try {
            if (rs.next()) {
                LeaderTF.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }//GEN-LAST:event_PlayerBTNActionPerformed

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        HomeGUI a = new HomeGUI();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void ScoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScoreBtnActionPerformed
        // TODO add your handling code here:
          String query1 = "select gamerscore from shapersdb.player where gamerscore=(select max(gamerscore) from shapersdb.player)";
        ResultSet rs = manager.SELECT_QUERY(query1);

        try {
            if (rs.next()) {
                ScoreTF.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_ScoreBtnActionPerformed

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
            java.util.logging.Logger.getLogger(GameGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EndBTn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextField LeaderTF;
    private javax.swing.JButton PlayerBTN;
    private javax.swing.JButton ScoreBtn;
    private javax.swing.JTextField ScoreTF;
    private javax.swing.JLabel TitleBtn;
    private javax.swing.JLabel bcGroundLbl;
    private javax.swing.JLabel displayLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}