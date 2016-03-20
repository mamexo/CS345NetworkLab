package chatapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
/**
 *
 * @author khyati
 */
public class TEstJFRAme extends javax.swing.JFrame {

    Image image;
    private Point initialClick;
    /**
     * Creates new form TEstJFRAme
     */
    public TEstJFRAme() {
        this.setUndecorated(true);
        initComponents();
        this.setBackground(new Color(0,0,1,0));
        this.setLocationRelativeTo(null);
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // get location of Window
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });

    
    messageArea.setToolTipText("Enter Message Here");
        allMessageArea.setEditable(false);
        messageArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e)
            {
              if (e.getKeyCode() == KeyEvent.VK_ENTER)
              {
                  broadCastMessage();
              }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        connectedTo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allMessageArea = new javax.swing.JTextPane();
        sendMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groupchat/images/close.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        connectedTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        connectedTo.setForeground(new java.awt.Color(0, 0, 255));
        connectedTo.setText("?");
        getContentPane().add(connectedTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 20, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Connected To Group ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, -1, -1));

        allMessageArea.setEditable(false);
        allMessageArea.setBackground(new java.awt.Color(255, 255, 153));
        allMessageArea.setBorder(null);
        allMessageArea.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(allMessageArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 780, 540));

        sendMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groupchat/images/send.png"))); // NOI18N
        sendMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMessageMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sendMessageMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sendMessageMouseReleased(evt);
            }
        });
        getContentPane().add(sendMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 680, 150, 140));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groupchat/images/close.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        messageArea.setBackground(new java.awt.Color(102, 255, 255));
        messageArea.setColumns(20);
        messageArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        messageArea.setLineWrap(true);
        messageArea.setRows(5);
        jScrollPane2.setViewportView(messageArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, 620, 260));

        jLabel2.setBackground(new java.awt.Color(204, 0, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groupchat/images/computer3.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -120, 1030, 1250));

        jLabel3.setText("Connected To Group No");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMessageMouseClicked
        broadCastMessage();
       
        // TODO add your handling code here:
    }//GEN-LAST:event_sendMessageMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void sendMessageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMessageMousePressed
        // TODO add your handling code here:
        sendMessage.setSize(new Dimension(150,150));
    }//GEN-LAST:event_sendMessageMousePressed

    private void sendMessageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMessageMouseReleased
        sendMessage.setSize(new Dimension(152,152));
        // TODO add your handling code here:
    }//GEN-LAST:event_sendMessageMouseReleased

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
            java.util.logging.Logger.getLogger(TEstJFRAme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TEstJFRAme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TEstJFRAme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TEstJFRAme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TEstJFRAme().setVisible(true);
            }
        });
    }
    
    void printMessage(String from, String message) throws BadLocationException{
        System.out.println("Client called me");
        String msg = from+" : "+ message+"\n";
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        allMessageArea.setBackground(new Color(230,230,230));
   
        if(from.equals(clientName)){
            StyleConstants.setForeground(keyWord, new Color(219,0,17));
               
            StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_RIGHT);
        }
        else{
            StyleConstants.setForeground(keyWord, new Color(9,9,26));
           
            StyleConstants.setAlignment(keyWord, StyleConstants.ALIGN_LEFT); 
        }
        
        allMessageArea.getStyledDocument().insertString(allMessageArea.getStyledDocument().getLength(),msg,keyWord); 
    }
    
    void sendMessage(String ipAddress,int friendPort,String message) throws BadLocationException{
        if(message.equals(""))
        {
            System.out.println("Empty text not allowed");
            JOptionPane.showMessageDialog(null, "Empty Message not allowed");     
            return ;
        }
        try {
            Socket s = new Socket(ipAddress, friendPort);
            System.out.println("Socket created on port no " + friendPort);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            // add message from the text area
            
            String msg = clientName+":"+ friendName + ":"+ message;
            System.out.println(msg);       
            dout.writeUTF(msg);
            System.out.println("Message successfully received");
            s.close();
            messageArea.setText("");
        } catch (IOException ex) {
            Logger.getLogger(ChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    void broadCastMessage(){
        String message = messageArea.getText().toString();
//        try {
//            printMessage(clientName,messageArea.getText().toString());
//        } catch (BadLocationException ex) {
//            Logger.getLogger(ChatBox.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.err.println("Size of ip array list is " + members.size());
        String ip = members.get(0);
            System.err.println("Sending message to " + ip + " --> " + message);
            String ipAddress = ip.split(":")[0];
            int port = Integer.parseInt(ip.split(":")[1]);
            
            try {
                System.err.println("Message in message text area "+messageArea.getText().toString());
                sendMessage(ipAddress, port,message);
            } catch (BadLocationException ex) {
                System.out.println("Message not sent successfuly for " + ip);
                Logger.getLogger(ChatBox.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    
//    void setIPAddress(String str){
//        ipAddress = str;
//        
//    }
    
    void setFriendName(String str){
        friendName = str;
        connectedTo.setText(str);
    }
    
    void setClientName(String str){
        clientName = str;
    }
    
//    void setFriendPort(int port){
//        friendPort = port;
//    }
//    
    void setMembers(String str){
        System.out.println("Setting members of chatbox MEMBERS** :-: " + str);
        String mems[] = str.split("\\$");
        members.clear();
        for(String s: mems){
            System.out.println("Adding : " + s);
            members.add(s);
        }
        System.out.println("Members setup successful");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane allMessageArea;
    private javax.swing.JLabel connectedTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JLabel sendMessage;
    // End of variables declaration//GEN-END:variables
    String friendName = "";
    String clientName  ="";
//    int friendPort = 0 ;
    // array list will only contain a single address i.e. of master only
    ArrayList<String> members = new ArrayList<>();
}