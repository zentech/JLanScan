/*
 * Purpose: application to scan the network for live host
 * and scan host for open ports.
 * Author: Jorge L. Vazquez
 * Updated: 7/15/2012
 */
package jlanscan;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LanScanFrame extends javax.swing.JFrame {
    
    /*
     * attributes & methods
     */
    String ipV4;
    String ipV6;
    int cidr;
    String broadCast;
    String hostName;
    String ipAddress;
    String subnet;
    String router;
    String mac;
    IPrange netRange = new IPrange();
    ArrayList<String> r = netRange.getRange();  
    NetworkInterface networkInterface;

    /**
     * Creates new form LanScanFrame
     */
    public LanScanFrame() throws UnknownHostException {
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
        jLabel2 = new javax.swing.JLabel();
        portInputText = new javax.swing.JTextField();
        portScanButton = new javax.swing.JButton();
        portCleanButton = new javax.swing.JButton();
        ipPortText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        portOutputText = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ipTextFrom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ipTextTo = new javax.swing.JTextField();
        scanButton = new javax.swing.JButton();
        clearIpButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ipOutputText = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabelipConfig = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        ExitMenu = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JLanScan");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(java.awt.Color.darkGray);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Port Scanner"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("IP address:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ports eg:1-100");

        portScanButton.setText("Scan");
        portScanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portScanButtonActionPerformed(evt);
            }
        });

        portCleanButton.setText("Clear");
        portCleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portCleanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipPortText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portInputText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(portScanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(portCleanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portInputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portScanButton)
                    .addComponent(portCleanButton)
                    .addComponent(ipPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        portOutputText.setColumns(20);
        portOutputText.setRows(5);
        jScrollPane1.setViewportView(portOutputText);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("IP Scanner"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("IP Range     From:");

        ipTextFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTextFromActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("To:");

        scanButton.setText("Scan");
        scanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanButtonActionPerformed(evt);
            }
        });

        clearIpButton.setText("Clear");
        clearIpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearIpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipTextFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipTextTo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clearIpButton, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipTextFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipTextTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scanButton)
                    .addComponent(clearIpButton))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ipOutputText.setEditable(false);
        ipOutputText.setColumns(20);
        ipOutputText.setRows(5);
        jScrollPane2.setViewportView(ipOutputText);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("IP Configuration"));

        jLabelipConfig.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelipConfig.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelipConfig.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelipConfig, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelipConfig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        FileMenu.setText("File");
        FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileMenuActionPerformed(evt);
            }
        });

        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenu);

        jMenuBar1.add(FileMenu);

        HelpMenu.setText("Help");

        AboutMenu.setText("About");
        AboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenu);

        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.getAccessibleContext().setAccessibleName("");
        jPanel3.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private void portScanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portScanButtonActionPerformed
        try {        
            StartPortScan();
        } catch (InterruptedException ex) {
            Logger.getLogger(LanScanFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_portScanButtonActionPerformed

    private void portCleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portCleanButtonActionPerformed
        clearPortScan();
    }//GEN-LAST:event_portCleanButtonActionPerformed

    private void scanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanButtonActionPerformed
        try {
            StartIPscan();
        } catch (InterruptedException ex) {
            Logger.getLogger(LanScanFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(LanScanFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanButtonActionPerformed

    private void clearIpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIpButtonActionPerformed
        clearIPrange();
    }//GEN-LAST:event_clearIpButtonActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        //exit menu command
        System.exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileMenuActionPerformed
        //opening file
        
    }//GEN-LAST:event_FileMenuActionPerformed

    private void AboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuActionPerformed
        // About box information
        showAboutBox();
    }//GEN-LAST:event_AboutMenuActionPerformed

    private void ipTextFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTextFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTextFromActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
               
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LanScanFrame().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(LanScanFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
      
    
        
        
        
    
     
    //ipThreads is the number of threads to spawn for scanning
    int IPTHREADS;
    int range;
    Thread tIp[];
    IPscanner ipScan[];
    int startIp = 0;
    int endIp;
    int totalHost = 0;
    
    
    
    ArrayList<Integer> allPorts = new ArrayList();
    //portThreads is the number of threds for port scanning
    int PTHREADS;
    int prange;
    Thread portThread[];
    PortScanner portTask[];
    int startPort;
    int endPort;
    
    
    
    
    
    //performing ip scan
     public void StartIPscan() throws InterruptedException, SocketException {
        this.getInetConfig();
        String ipFrom = ipTextFrom.getText();
        String ipTo = ipTextTo.getText(); 
        netRange.setFromip(ipFrom);
        netRange.setToip(ipTo);
        netRange.StrToIP();
        netRange.calcNetwork();        
        IPTHREADS = r.size();        
        range = r.size() / IPTHREADS;
        tIp = new Thread[IPTHREADS];
        ipScan = new IPscanner[IPTHREADS];
        String subnet = netRange.getSubnet();
        endIp = startIp + range;
        
        System.out.println(IPTHREADS + ", " + range + ", " + startIp + ", " + endIp);
        
        System.out.println(Integer.toString(IPTHREADS));
        //Initializing threds
//        for(int i = 0; i < IPTHREADS-1; i++)
//        {
//            System.out.println("starting threads");
//            //creating ArrayList containing a sublist of r (adjusting range of ip)
//            System.out.println(i + " " + startIp + ", " + endIp);
//            ipScan[i] = new IPscanner(startIp, endIp, subnet, ipOutputText);
//            tIp[i] = new Thread(ipScan[i]);  
//            startIp = endIp;
//            endIp = startIp + range;
//            
//        }
        
        //output to interface ip scanning started
//        ipOutputText.append("Scanning network "+"\""+ subnet + startIp +"...\""+"\n");
//        
//        //starting threds
//        for(int i = 0; i < IPTHREADS-1; i++) 
//        {
//            tIp[i].start();
//        }
//        
//        //wait for a sec
//        Thread.sleep(1000);
//        
//        //collecting threads result
//        for(int i = 0; i < IPTHREADS-1; i++)
//        {
//            tIp[i].join();
//        } 
//        
//        //retrieving total number of host detected        
//        for(int i = 0; i < IPTHREADS-1; i++)
//        {
//            totalHost += ipScan[i].getLiveHosts();
//        }
//        
//        ipOutputText.append("\n======  Results  ======\n");
//        ipOutputText.append("Number of hosts detected: " + totalHost);            
    }
     
     //performing port scan
     public void StartPortScan() throws InterruptedException
     {
         
        calcPortRange();
        int numOpenPorts = 0; //num of open ports
        PTHREADS = (int) ((allPorts.size() * 10) / 100) ; //threads are 10% of all ports
        prange = (allPorts.size() / PTHREADS);
        portThread = new Thread[PTHREADS];
        portTask = new PortScanner[PTHREADS];
        int beginPort = startPort;
        int stopPort = beginPort + prange;
        String ipAddress = ipPortText.getText();
        
        //if ip address was not provided prompt user
        if(ipAddress.isEmpty()) {
            this.showIpMessage();
            return;
        }
        
//        System.out.println("Performing port scan!" + PTHREADS + " " + range);       
        
        portOutputText.append("Scanning for open ports on "+"\""+ipAddress+"\""+"..."+"\n");        
         
         //Initializing threds
        for(int i = 0; i < PTHREADS; i++)
        {
            System.out.println("Initialize Threads " + ipAddress + " " + beginPort + " " + stopPort);
            portTask[i] = new PortScanner(ipAddress, beginPort, stopPort, portOutputText);
            portThread[i] = new Thread(portTask[i]);    
            beginPort = stopPort + 1;
            stopPort = beginPort + prange;
            
        }       
        
        //starting threds
        for(int i = 0; i < PTHREADS; i++) 
        {
             System.out.println("Performing port scan!");
            portThread[i].start();
        }
        
        //wait for a sec
        Thread t = new Thread();
        t.sleep(1000);
        
        //collecting threads result
        for(int i = 0; i < PTHREADS; i++)
        {
            portThread[i].join();
        }   
        
        //retrieving total number of host detected        
        for(int i = 0; i < PTHREADS; i++)
        {
            numOpenPorts += portTask[i].getPortCounter();
        }
        
        portOutputText.append("\n======  Results  ======\n");
        portOutputText.append("Number of port open: " + numOpenPorts);
     }
     
     
      //clear ip range and ip output text area
    public void clearIPrange() {
        ipOutputText.setText("");
        ipTextFrom.setText("");
        ipTextTo.setText("");
        r.clear();

    }
     
     //clear port input and output area
     public void clearPortScan()
     {
         ipPortText.setText("");
         portInputText.setText("");
         portOutputText.setText("");
         allPorts.clear();        
     }  
     
     //calculating port range and adding to arraylist
     public void calcPortRange()
    {
        
        String portRange = portInputText.getText(); 
        //checking if port was provided by user
        if(portRange.isEmpty()) {
            this.showPortMessage();
            return;
        }
//        String portRange = "1-1024"; for testing only
        int startPort, endPort;
        String[] pRange;
        
        /*
         * input contains "-" we have a range
         * if not then we have only one port  
         */
        if(portRange.contains("-"))
        {
            pRange = portRange.split("-");
            startPort = Integer.parseInt(pRange[0]);
            endPort = Integer.parseInt(pRange[1]);
            
            for (int i = startPort; i <= endPort; i++) {
                allPorts.add(i);
            }
        }
        else if(portRange.contains(",")) 
        {
            pRange = portRange.split(",");
            for(int i = 0; i < pRange.length; i++)
            {
                allPorts.add(Integer.parseInt(pRange[i]));
            }
        }
        else
        {
            allPorts.add(Integer.parseInt(portRange));
        }        
    }
     
    /*
    * getting interface configuration ipv4 & ipv6
    */
    public void getInetConfig() throws SocketException {
        String output = "";
        Enumeration<NetworkInterface> networkInterfaces = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            try {
                for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {                      
                    if(!networkInterface.getDisplayName().contains("VirtualBox") && isValidIPv4(address.getAddress().getHostAddress())) {
                        System.out.println(networkInterface.getDisplayName().toString() + " " + address.toString());
                        ipV4 = address.getAddress().getHostAddress();                        
                        cidr = address.getNetworkPrefixLength();
                        NetworkInterface inFace = NetworkInterface.getByInetAddress(address.getAddress());
                        mac = macToString(inFace.getHardwareAddress());
                        broadCast = address.getBroadcast().toString().replaceAll("^/", "");
                        continue;
                    } 
                    if(address.getAddress().isLinkLocalAddress()) {
                        ipV6 = address.getAddress().getHostAddress();                    
                        continue;
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }     
        
        output = "<html>" + "IP v4: " + "<br>" + ipV4 + "/" + cidr + "<br>" +
                "MAC: " + mac.toString() + "<br>" +
                "Broadcast: " + "<br>" + broadCast + "</html>";        
        jLabelipConfig.setText(output);             
        
        
//        System.out.println(ipV4 + " " + cidr + " " + broadCast);
//        System.out.println(ipV6);
    }
    
    public String macToString(byte m[]) {
        String tempMac = "";
        for (int k = 0; k < m.length; k++) {
            tempMac.format("%02X%s", m[k], (k < m.length - 1) ? "-" : "");
        }
        return tempMac;
    }
    
    public boolean isValidIPv4(String ip) {        
        //checking for loopback address
        if(ip.substring(0, 3).equals("127")) {
            return false;
        }
        //ipv4 reg expression
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
//        System.out.println(ip + " " + ip.matches(PATTERN));
        return ip.matches(PATTERN);
    }
    
     //about box 
    private javax.swing.JFrame frame;
    public void showAboutBox(){
        JOptionPane.showMessageDialog(frame, "JLanScan v 1.2 \n by zentech");
    }
    
    //display message if user does not enter ip address
    public void showIpMessage(){
        JOptionPane.showMessageDialog(frame, "Enter IP address!");
    }
    
    //display message if user does not enter port range
    public void showPortMessage() 
    {
        JOptionPane.showMessageDialog(frame, "Enter ports eg:1-1024 \n eg: 22,80,443");
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenu;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JButton clearIpButton;
    private javax.swing.JTextArea ipOutputText;
    private javax.swing.JTextField ipPortText;
    private javax.swing.JTextField ipTextFrom;
    private javax.swing.JTextField ipTextTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelipConfig;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton portCleanButton;
    private javax.swing.JTextField portInputText;
    private javax.swing.JTextArea portOutputText;
    private javax.swing.JButton portScanButton;
    private javax.swing.JButton scanButton;
    // End of variables declaration//GEN-END:variables
}
