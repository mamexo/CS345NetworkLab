/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import com.sun.corba.se.spi.activation.Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayank
 */
public class AuthenticationServer extends javax.swing.JFrame {

    /**
     * Creates new form NewApplication
     */
    public AuthenticationServer() {
        try {
            initComponents();
            s = new ServerSocket(authServerPort);
            users = new HashMap<>();
            onlineusers = new HashMap<>();
            onlineusersPort = new HashMap<>();
            friendList = new HashMap<>();
            
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
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

        jDialog2 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        serverStat = new javax.swing.JToggleButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        addUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        serverLog = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        serverStat.setText("Start Server");
        serverStat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serverStatMouseClicked(evt);
            }
        });
        serverStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverStatActionPerformed(evt);
            }
        });

        addUser.setText("Add User");
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });

        serverLog.setColumns(20);
        serverLog.setRows(5);
        jScrollPane1.setViewportView(serverLog);

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serverStat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverStat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void serverStatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serverStatMouseClicked
      acceptConn();         
    }//GEN-LAST:event_serverStatMouseClicked

    
    void acceptConn(){
        if(serverStat.getText().toString().equals("Start Server")){
            initialiseList();
            addToLog("Server started on " + authServerPort);
            
            serverStat.setText("Stop Server");
            Runnable r = new Runnable() {
                @Override
                public void run(){
                    while(true){  
                        try{
                            System.out.println("trying Accepting");
                            sock = s.accept(); 
                            sock.setSoTimeout(5000);
                            System.out.print("Server conn accepted");
                            din = new DataInputStream(sock.getInputStream());
                            dout = new DataOutputStream(sock.getOutputStream());
                            String userData = din.readUTF();
                            System.out.println("user data is: "+userData);
                            
                            if(!userData.equals("")){
                                if(userData.split(":")[0].equals("Auth")){
                                    authUser(userData);
                                    System.out.println(""+onlineusersPort.values());
                                    System.err.println("user login");
                                }
                                else if(userData.split(":")[0].equals("AddFriend")){
                                    int num = addFriend(userData);
                                    dout.writeUTF("AddFriendRes:"+num);
                                }
                                else if(userData.split(":").equals("Server")){
                                    handleServer(userData);
                                }
                                else if(userData.split(":")[0].equals("OnlineTest")){
                                    System.out.println("Online Test");
                                    String user = null;
                                    if(userData.split(":")[1].contains("-"))
                                        user = userData.split(":")[1].split("-")[0];
                                    else
                                        user = userData.split(":")[1];
                                    boolean res = checkOnline(user);
                                    System.out.println("Online Test"+ res);
                                    if(res){
                                        dout.writeUTF("Available:"+onlineusers.get(userData.split(":")[1]));
                                    }
                                    else
                                        dout.writeUTF("Unavailable");
                                }
                                else if(userData.split(":")[0].equals("RefreshFriends")){
                                    System.err.println("Server checking friends");
                                    String sp[] = userData.split(":");
                                    System.out.println("friend list i s: " + friendList.values() );
                                    ArrayList<String> friends = friendList.get(sp[1]);

                                    String send = "";
                                    for(String name : friends){
                                        if(onlineusers.get(name) != null){
                                            send = send + name + "-A:";
                                            System.out.println(""+ name + "is avlaiable");
                                        }
                                        else
                                            send = send + name + ":";
                                        System.out.println(""+name);
                                    }

                                    System.out.println("SENT FRIEND LIST:"+send);
                                    send = send.substring(0,send.length()-1);
                                    System.out.println("SENT FRIEND LIST:"+send);
                                    dout.writeUTF(send);

                                }
                                else if(userData.split(":")[0].equals("RequestPort")){
                                    System.out.println("made a port request"+ userData);
                                    String portStr = onlineusersPort.get(userData.split(":")[1]);
                                     dout = new DataOutputStream(sock.getOutputStream());
                                    dout.writeUTF(portStr);
                                }
                                else if(userData.split(":")[0].equals("RequestIP")){
                                    System.out.println("made a port request"+ userData);
                                    String portStr = onlineusers.get(userData.split(":")[1]);
                                    dout = new DataOutputStream(sock.getOutputStream());
                                    dout.writeUTF(portStr);
                                }
                                else if(userData.split(":")[0].equals("LogOut")){
                                    onlineusers.remove((userData.split(":")[1]));
                                    onlineusersPort.remove(userData.split(":")[1]);
                                }
                                sock.close();
                            }
                        } 
                        catch (IOException ex) {
                            Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }     
            };
            t1 = new Thread(r);
            t1.start();
            System.out.println("Sercver started" + "" + (serverStat.getText().toString()));
        }
        
        else if(serverStat.getText().toString().equals("Stop Server")){
            try {
                serverStat.setText("Start Server");
                addToLog("Serer closed");
                t1.stop();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void serverStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverStatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverStatActionPerformed

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        // TODO add your handling code here
        addUser();
    }//GEN-LAST:event_addUserMouseClicked

    
    
    
    void refreshList(String name){
        try {
            Socket s = new Socket(onlineusers.get(name),friendlistServerPort);
            DataOutputStream doutFriend = new DataOutputStream(s.getOutputStream());
            String str = "";
           for(String arr : friendList.get("name")){
               str += arr+":";
           }
            System.err.println(""+str);
            str = str.substring(0,str.length()-1);
            System.err.println(""+str);
            doutFriend.writeUTF(str);
            
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
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
            java.util.logging.Logger.getLogger(AuthenticationServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthenticationServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthenticationServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthenticationServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthenticationServer().setVisible(true);
            }
        });
    }
    
    void handleServer(String userData) {
        
    }
    
    void addUser(){
        String use= username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(users.get(use) != null || use.equals("") || pass.equals(""))
            return;
        users.put(use,pass); 
        friendList.put(username.getText().toString(),new ArrayList<>());
        writeUserToFile(use,pass);
       addToLog("User"+username.getText().toString() + "Successfuly added");
        System.out.println(""+users.values());
    }
    
    
    boolean checkOnline(String name){
        return onlineusers.get(name) != null;
    }

    void authUser(String userdata){
        String data[] =  userdata.split(":");
        
        System.out.println("Trying validation");
        String passwd = users.get(data[1]);
        if(passwd != null){
            System.out.println("User Valid");
            
            try {
                if(passwd.equals(data[2])){
                     System.out.println("User Valid");
                    dout.writeUTF("Valid");
                     for(String s: data){
                         System.out.println("->> "+s);
                        }
                        onlineusers.put(data[1], data[3]);
                        System.out.println(data[1] + " " + data[4]);
                        onlineusersPort.put(data[1], data[4]);
                }
                else{
                     System.out.println("User InValid");
                    dout.writeUTF("InValid");
                }
            } catch (IOException ex) {
                Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        else{
            try {
                dout.writeUTF("InValid");
            } catch (IOException ex) {
                Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("InValid Username and passwd");
        }
        
    }
    
    
    
    
    void initialiseUserList(){
        String usersFilename = "userslist.txt";
        File file = new File(usersFilename);
        if(file == null)
            return;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                String user[] = line.split("#");
                System.out.println(line );
                users.put(user[0],user[1]);
                if(friendList.get(user[0]) == null){
                    friendList.put(user[0], new ArrayList<>());
                }
            }
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    
    void addToLog(String log){
        serverLog.append(log+"\n");
    }
    void initialiseFriendList(){
        
        try{
            
            String friendsListFilename = "friendslist.txt";
            File file = new File(friendsListFilename);
            if(file == null)
                return;
            if (!file.exists()) file.createNewFile();
            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                for(String line; (line = br.readLine()) != null; ) {
                    String user[] = line.split("#");
                    System.err.println("Line of friends from file is " + line);
                    friendList.get(user[0]).add(user[1]);            
                    
                }
            }
            
            catch(IOException ex){
                ex.printStackTrace();
            }
            
            System.out.println("***********All friend list at server is \n"+ friendList.entrySet());
        }
        
        catch(IOException ex){
            Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    void initialiseList(){
        friendList.clear();
        onlineusers.clear();
        users.clear();
        initialiseUserList();
        initialiseFriendList();
    }
    
    void writeUserToFile(String user,String pass)
    {
            String usersFilename = "userslist.txt";
                    try {		
                            String content = user+"#"+pass+"\n";
                            File file = new File(usersFilename);
                            if (!file.exists()) {
                                file.createNewFile();
                                System.out.println("Created new file" + file.getAbsolutePath());
                            }				
                            FileWriter fw = new FileWriter(file,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(content);
                            bw.close();
                            fw.close();
                            System.err.println("Successfult wriiten to file");
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }
    }
    
    void writeUserToFriendsFile(String user,String pass)
    {
            String friendsListFilename = "friendslist.txt";
                    try {		
                            String content = user+"#"+pass+"\n";
                            File file = new File(friendsListFilename);
                            if (!file.exists()) file.createNewFile();				
                            FileWriter fw = new FileWriter(file,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(content);
                            bw.close();
                            fw.close();
                            System.out.println("friend Successfuly written");
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }
    }
    
    int addFriend(String userdata){
        String data[] = userdata.split(":");
        System.out.println("Adding started Friend done" + friendList.get(data[1]).toString());
        boolean flag = true;
        if(users.get(data[2]) == null){
            System.out.println("No user named " + data[2]);
            return 4;
        }
        for(String usr : friendList.get(data[1])){
            if(usr.equals(data[2])){
                flag = false;
                return 2;        
            }
        }
        
        if(friendList.get(data[1]) != null && flag){
            friendList.get(data[1]).add(data[2]);
            friendList.get(data[2]).add(data[1]);
            
            writeUserToFriendsFile(data[1], data[2]);
            writeUserToFriendsFile(data[2],data[1]);
            
            System.out.println("Add Friend done");
            System.out.println(""+ friendList.values());
        }
        return 0;
    }
    
    
        void connectToChatServer(){
        try {
            Socket sock = new Socket("localhost",chatServerPort);
            DataInputStream dataIn = new DataInputStream(sock.getInputStream());
            String read = dataIn.readUTF();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addUser;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTextField password;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JTextArea serverLog;
    private javax.swing.JToggleButton serverStat;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
    private ServerSocket s;
    private int authServerPort = 6544;
    DataInputStream din;
    DataOutputStream dout;
    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
    HashMap<String,String> users;
    HashMap<String,String> onlineusers;
    HashMap<String,String> onlineusersPort;
    HashMap<String,ArrayList<String> > friendList;
   
    Socket sock;
    private int chatServerPort = 6524;
    private int friendlistServerPort = 6521;
    Thread t1 = null ;
}
