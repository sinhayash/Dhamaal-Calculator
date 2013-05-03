/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Calculator.java
 *
 * Created on Sep 8, 2010, 9:41:04 PM
 */
package calculator;

//imports
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.*;
import sun.audio.*;

/**
 *
 * @author YASH SINHA
 * (c) YASH SINHA
 */
public class Calculator extends javax.swing.JFrame {

    /** Creates new form Calculator */
    public Calculator() {
        initComponents();
        setLocation(300, getHeight() / 2);
        Dev.setLocation(getWidth() / 2, getHeight() / 2);
        Power.setLocation(getWidth() / 2, getHeight() / 2);
        Angle.setLocation(getWidth() / 2, getHeight() / 2);
        Alert.setLocation(getWidth() / 2, getHeight() / 2);
        help.setLocation(getWidth() / 2, getHeight() / 2);
        Mthconst.setLocation(getWidth() / 2, getHeight() / 2);
        skin.setLocation(getWidth() / 2, 0);
        close.setLocation(getWidth() / 2, getHeight() / 2);
    }
    static String sk = "Nimbus";
    int u, a, k, f, c = 1;
    static int l = 1;
    double x, y;
    static Methods txt = new Methods();

//*********************************************************************************************************//
    private static void ansSound() {
        try {
            InputStream so = new FileInputStream("C:\\WINDOWS\\Media\\tada.wav");
            AudioStream as = new AudioStream(so);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, e);
        }
    }
// ********************************************************************************************************//

    private static void errorSound() {
        try {
            InputStream so = new FileInputStream("C:\\WINDOWS\\Media\\chord.wav");
            AudioStream as = new AudioStream(so);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, e);
        }
    }
// ********************************************************************************************************//

    private static void clickSound() {
        try {
            InputStream so = new FileInputStream("C:\\WINDOWS\\Media\\Windows XP Default.wav");
            AudioStream as = new AudioStream(so);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    // ********************************************************************************************************//
    private static void updatelook() {
         
            try {
            Window[]  w = (java.awt.Window[])Calculator.getWindows();
           SwingUtilities.updateComponentTreeUI(w[1]);
                w[1].pack();   
                SwingUtilities.updateComponentTreeUI(w[2]);
                w[2].pack();
//                System.out.println(""+w.getClass());
//                int i =12;
//                while(i>=0) {
//                    System.out.println(w[i-1]);
//                    i--;
//                }
           
        } catch (Exception e) { System.out.println(""+e);
        }
                
        /*     //Jframe
            SwingUtilities.updateComponentTreeUI(Calculator.btnpanel);
            SwingUtilities.updateComponentTreeUI(Calculator.funcpanel);
            SwingUtilities.updateComponentTreeUI(Calculator.numpanel);
            SwingUtilities.updateComponentTreeUI(Calculator.MenuBar);*/
            
            SwingUtilities.updateComponentTreeUI(Calculator.Dev);
            Dev.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.Power);
            Power.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.Angle);
            Angle.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.Alert);
            Alert.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.help);
            help.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.Mthconst);
            Mthconst.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.skin);
            skin.pack();
            SwingUtilities.updateComponentTreeUI(Calculator.close);
            close.pack();
    }
    // ********************************************************************************************************//
//SYSTEM TRAY ICON

    public static void sysIcon() {
        TrayIcon trayIcon = null;
        if (SystemTray.isSupported()) {
            // get the SystemTray instance
            SystemTray tray = SystemTray.getSystemTray();
            // load an image
            Image Image = Toolkit.getDefaultToolkit().getImage("icon.png");
            // create a action listener to listen for default action executed on the tray icon
            ActionListener listener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    Dev.setVisible(true);
                    // execute default action of the application
                    // ...
                }
            };
            ActionListener listener2 = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    langen.doClick();
                }
            };
            ActionListener listener3 = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    langhi.doClick();
                }
            };
            ActionListener listener4 = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    skin.setVisible(true);
                }
            };
            ActionListener listener5 = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            ActionListener listener6 = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    langsa.doClick();
                }
            };
            // create a popup menu
            PopupMenu popup = new PopupMenu();

            PopupMenu popup2 = new PopupMenu();
            popup2.setLabel("Options");
            // create menu item for the default action
            MenuItem devItem = new MenuItem();
            devItem.setLabel("Developer");
            devItem.addActionListener(listener);

            MenuItem popup_2 = new MenuItem();
            popup_2.setLabel("Exit");
            popup_2.addActionListener(listener5);

//popup2
            MenuItem popup2_1 = new MenuItem();
            popup2_1.setLabel("English");
            popup2_1.addActionListener(listener2);

            MenuItem popup2_2 = new MenuItem();
            popup2_2.setLabel("Hindi");
            popup2_2.addActionListener(listener3);

            MenuItem popup2_3 = new MenuItem();
            popup2_3.setLabel("Skin Chooser");
            popup2_3.addActionListener(listener4);

            MenuItem popup2_4 = new MenuItem();
            popup2_4.setLabel("Sanskrit");
            popup2_4.addActionListener(listener6);
            // create menu item2 for the default action
            //set Items in popupmenu
            popup.add(devItem);
            popup.add(popup2);
            popup.add(popup_2);

            //add Items to popup2
            popup2.add(popup2_1);
            popup2.add(popup2_2);
            popup2.add(popup2_4);
            popup2.add(popup2_3);


            /// ... add other items
            // construct a TrayIcon
            trayIcon = new TrayIcon(Image, "Tray Demo", popup);
            trayIcon.setToolTip("You are using Dhamaal Calculator of YASH SINHA!!!");
            trayIcon.setImageAutoSize(true);// set the TrayIcon properties
            trayIcon.addActionListener(listener);
            // ...
            // add the tray image
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
            // ...
        } else {
            // disable tray option in your application or
            // perform other actions
            //...
        }
        // ...
        // some time later
        // the application state has changed - update the image
        if (trayIcon != null) {
            trayIcon.setImage(new ImageIcon("icon.png").getImage());
        }
    }
// ********************************************************************************************************//

    private static void decimalexceptioncheck() {
        //invoked both as KeyTyped & DecimalTyped
        String t1 = text.getText();
        int n1 = t1.length(), j = 0;
        for (int yy = 0; yy < n1 - 1; yy++) {
            if (("" + t1.charAt(yy)).equals(".")) {
                j++;
            }
        }
        if (j > 1) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }
// ********************************************************************************************************//

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dev = new javax.swing.JDialog();
        Devpanel = new javax.swing.JPanel();
        devhead = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        OKMsg = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Power = new javax.swing.JDialog();
        Powerpanel = new javax.swing.JPanel();
        Nval = new javax.swing.JTextField();
        Nvalbl = new javax.swing.JLabel();
        OKPower = new javax.swing.JButton();
        powr = new javax.swing.JRadioButton();
        rt = new javax.swing.JRadioButton();
        lg = new javax.swing.JRadioButton();
        Angle = new javax.swing.JDialog();
        Anglepanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        r2d = new javax.swing.JRadioButton();
        d2r = new javax.swing.JRadioButton();
        r2df = new javax.swing.JTextField();
        d2rf = new javax.swing.JTextField();
        OKAngle = new javax.swing.JButton();
        anbtngr = new javax.swing.ButtonGroup();
        Alert = new javax.swing.JDialog();
        Alertpanel = new javax.swing.JPanel();
        Alertxt = new javax.swing.JLabel();
        OKAlert = new javax.swing.JButton();
        help = new javax.swing.JDialog();
        helppanel = new javax.swing.JPanel();
        helptab = new javax.swing.JTabbedPane();
        Formulas = new javax.swing.JPanel();
        sinh = new javax.swing.JLabel();
        cosh = new javax.swing.JLabel();
        tanh = new javax.swing.JLabel();
        asinh = new javax.swing.JLabel();
        acosh = new javax.swing.JLabel();
        atanh = new javax.swing.JLabel();
        powh = new javax.swing.JLabel();
        angh = new javax.swing.JLabel();
        logeh = new javax.swing.JLabel();
        logh = new javax.swing.JLabel();
        xfach = new javax.swing.JLabel();
        sint = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        tant = new javax.swing.JLabel();
        asint = new javax.swing.JLabel();
        acost = new javax.swing.JLabel();
        atant = new javax.swing.JLabel();
        powt = new javax.swing.JLabel();
        angt = new javax.swing.JLabel();
        logt = new javax.swing.JLabel();
        loget = new javax.swing.JLabel();
        xfact = new javax.swing.JLabel();
        Exceptions = new javax.swing.JPanel();
        OKHelp = new javax.swing.JButton();
        powbtngrp = new javax.swing.ButtonGroup();
        lang = new javax.swing.ButtonGroup();
        Mthconst = new javax.swing.JDialog();
        Mthconstpanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pi = new javax.swing.JButton();
        e = new javax.swing.JButton();
        dec = new javax.swing.JButton();
        skin = new javax.swing.JDialog();
        skinpanel = new javax.swing.JPanel();
        skinchooser = new javax.swing.JColorChooser();
        skinlbl = new javax.swing.JLabel();
        OKskin = new javax.swing.JButton();
        metal = new javax.swing.JRadioButton();
        nimbus = new javax.swing.JRadioButton();
        linux = new javax.swing.JRadioButton();
        windows = new javax.swing.JRadioButton();
        wondowsc = new javax.swing.JRadioButton();
        lay = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        skinbtngrp = new javax.swing.ButtonGroup();
        close = new javax.swing.JDialog();
        closepanel = new javax.swing.JPanel();
        no = new javax.swing.JButton();
        yes = new javax.swing.JButton();
        closealertxt = new javax.swing.JLabel();
        btnpanel = new javax.swing.JPanel();
        funcpanel = new javax.swing.JPanel();
        sin = new javax.swing.JButton();
        asin = new javax.swing.JButton();
        pow = new javax.swing.JButton();
        ce = new javax.swing.JButton();
        cos = new javax.swing.JButton();
        acos = new javax.swing.JButton();
        ang = new javax.swing.JButton();
        xfac = new javax.swing.JButton();
        tan = new javax.swing.JButton();
        atan = new javax.swing.JButton();
        log = new javax.swing.JButton();
        loge = new javax.swing.JButton();
        ans = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        del = new javax.swing.JButton();
        numpanel = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        xinv = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        pnt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        div = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        sub = new javax.swing.JButton();
        mul = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        Preferences = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        langen = new javax.swing.JRadioButtonMenuItem();
        langhi = new javax.swing.JRadioButtonMenuItem();
        langsa = new javax.swing.JRadioButtonMenuItem();
        langsep = new javax.swing.JPopupMenu.Separator();
        skinmenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        constmenu = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        Developer = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenuItem();

        Dev.setTitle("About Calculator");
        Dev.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        Dev.setMinimumSize(new java.awt.Dimension(548, 255));

        Devpanel.setBackground(new java.awt.Color(255, 255, 255));

        devhead.setFont(new java.awt.Font("Monotype Corsiva", 0, 36));
        devhead.setText("<html>DHAMAAL CALCULATOR <sup>®</sup> ");

        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 24));
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Hindi Suported");

        jLabel3.setFont(new java.awt.Font("Bradley Hand ITC", 3, 18));
        jLabel3.setText("Version : 2.0");

        OKMsg.setText("OK");
        OKMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKMsgActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/icon.PNG"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jLabel6.setText("©YASH SINHA");

        javax.swing.GroupLayout DevpanelLayout = new javax.swing.GroupLayout(Devpanel);
        Devpanel.setLayout(DevpanelLayout);
        DevpanelLayout.setHorizontalGroup(
            DevpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DevpanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(DevpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DevpanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(DevpanelLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(OKMsg)
                .addContainerGap(324, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DevpanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(devhead, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DevpanelLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        DevpanelLayout.setVerticalGroup(
            DevpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DevpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DevpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devhead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DevpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(OKMsg))
        );

        javax.swing.GroupLayout DevLayout = new javax.swing.GroupLayout(Dev.getContentPane());
        Dev.getContentPane().setLayout(DevLayout);
        DevLayout.setHorizontalGroup(
            DevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
            .addGroup(DevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DevLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Devpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        DevLayout.setVerticalGroup(
            DevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
            .addGroup(DevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DevLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Devpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Power.setTitle("Give Value of N");
        Power.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        Power.setMinimumSize(new java.awt.Dimension(226, 150));
        Power.setResizable(false);

        Powerpanel.setBackground(new java.awt.Color(255, 255, 255));
        Powerpanel.setMinimumSize(new java.awt.Dimension(226, 160));

        Nval.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NvalFocusGained(evt);
            }
        });

        Nvalbl.setFont(new java.awt.Font("Tahoma", 1, 14));
        Nvalbl.setLabelFor(Nval);
        Nvalbl.setText("Value of N:");

        OKPower.setText("OK");
        OKPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKPowerActionPerformed(evt);
            }
        });

        powr.setBackground(new java.awt.Color(255, 255, 255));
        powbtngrp.add(powr);
        powr.setText("<HTML>X<SUP>N</SUP>:  [X<SUP>N</SUP>=?]</HTML> ");

        rt.setBackground(new java.awt.Color(255, 255, 255));
        powbtngrp.add(rt);
        rt.setText("<html>N<sup>th</sup>√ X:   [?<sup>N</sup>=X]");

        lg.setBackground(new java.awt.Color(255, 255, 255));
        powbtngrp.add(lg);
        lg.setText("<html>log<sub>X</sub>N:   [X<sup>?</sup>=N]");

        javax.swing.GroupLayout PowerpanelLayout = new javax.swing.GroupLayout(Powerpanel);
        Powerpanel.setLayout(PowerpanelLayout);
        PowerpanelLayout.setHorizontalGroup(
            PowerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PowerpanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(Nvalbl, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGap(56, 56, 56))
            .addGroup(PowerpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(OKPower)
                .addGap(20, 20, 20))
            .addGroup(PowerpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PowerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(powr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(PowerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PowerpanelLayout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(Nval, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PowerpanelLayout.setVerticalGroup(
            PowerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PowerpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nvalbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PowerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lg)
                    .addComponent(OKPower))
                .addGap(33, 33, 33))
            .addGroup(PowerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PowerpanelLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(Nval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PowerLayout = new javax.swing.GroupLayout(Power.getContentPane());
        Power.getContentPane().setLayout(PowerLayout);
        PowerLayout.setHorizontalGroup(
            PowerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Powerpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PowerLayout.setVerticalGroup(
            PowerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Powerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Angle.setTitle("Convert Angles");
        Angle.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        Angle.setMinimumSize(new java.awt.Dimension(207, 207));

        Anglepanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setText("CONVERSION OF ANGLES");

        r2d.setBackground(new java.awt.Color(255, 255, 255));
        anbtngr.add(r2d);
        r2d.setText("Radian to Degrees");

        d2r.setBackground(new java.awt.Color(255, 255, 255));
        anbtngr.add(d2r);
        d2r.setText("Degrees to Radian");

        r2df.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                r2dfFocusGained(evt);
            }
        });

        d2rf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                d2rfFocusGained(evt);
            }
        });

        OKAngle.setText("OK");
        OKAngle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKAngleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AnglepanelLayout = new javax.swing.GroupLayout(Anglepanel);
        Anglepanel.setLayout(AnglepanelLayout);
        AnglepanelLayout.setHorizontalGroup(
            AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
            .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AnglepanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnglepanelLayout.createSequentialGroup()
                            .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(d2r)
                                .addComponent(r2d)
                                .addComponent(OKAngle))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(r2df, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                .addComponent(d2rf, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
                        .addComponent(jLabel4))
                    .addContainerGap()))
        );
        AnglepanelLayout.setVerticalGroup(
            AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
            .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AnglepanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(r2d)
                        .addComponent(r2df, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(AnglepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(d2r)
                        .addComponent(d2rf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(OKAngle)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel4.getAccessibleContext().setAccessibleParent(Anglepanel);
        r2d.getAccessibleContext().setAccessibleParent(Anglepanel);
        d2r.getAccessibleContext().setAccessibleParent(Anglepanel);
        r2df.getAccessibleContext().setAccessibleParent(Anglepanel);
        d2rf.getAccessibleContext().setAccessibleParent(Anglepanel);
        OKAngle.getAccessibleContext().setAccessibleParent(Anglepanel);

        javax.swing.GroupLayout AngleLayout = new javax.swing.GroupLayout(Angle.getContentPane());
        Angle.getContentPane().setLayout(AngleLayout);
        AngleLayout.setHorizontalGroup(
            AngleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Anglepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AngleLayout.setVerticalGroup(
            AngleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Anglepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Alert.setTitle("Alert");
        Alert.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        Alert.setMinimumSize(new java.awt.Dimension(345, 130));
        Alert.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                AlertWindowActivated(evt);
            }
        });

        Alertpanel.setBackground(new java.awt.Color(255, 255, 255));
        Alertpanel.setMinimumSize(new java.awt.Dimension(269, 100));

        Alertxt.setFont(new java.awt.Font("Tahoma", 0, 14));
        Alertxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Alertxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        OKAlert.setText("OK");
        OKAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKAlertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AlertpanelLayout = new javax.swing.GroupLayout(Alertpanel);
        Alertpanel.setLayout(AlertpanelLayout);
        AlertpanelLayout.setHorizontalGroup(
            AlertpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AlertpanelLayout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(OKAlert)
                .addGap(164, 164, 164))
            .addGroup(AlertpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlertpanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Alertxt, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        AlertpanelLayout.setVerticalGroup(
            AlertpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AlertpanelLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(OKAlert)
                .addContainerGap())
            .addGroup(AlertpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AlertpanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Alertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout AlertLayout = new javax.swing.GroupLayout(Alert.getContentPane());
        Alert.getContentPane().setLayout(AlertLayout);
        AlertLayout.setHorizontalGroup(
            AlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Alertpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AlertLayout.setVerticalGroup(
            AlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Alertpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        help.setTitle("Help Topics");
        help.setMinimumSize(new java.awt.Dimension(420, 395));

        helppanel.setBackground(new java.awt.Color(255, 255, 255));

        Formulas.setBackground(new java.awt.Color(255, 255, 255));

        sinh.setText("SIN");

        cosh.setText("COS");

        tanh.setText("TAN");

        asinh.setText("<HTML>SIN<SUP>-1");

        acosh.setText("<HTML>COS<SUP>-1");

        atanh.setText("<HTML>TAN<SUP>-1");

        powh.setText("<HTML>X<SUP>N");

        angh.setFont(new java.awt.Font("Times New Roman", 0, 12));
        angh.setText("θ~π");

        logeh.setText("<HTML>log<SUB>10");

        logh.setText("ln");

        xfach.setText("X!");

        sint.setText("Returns the trigonometric sine of the angle (in degrees). ");

        cost.setText("Returns the trigonometric cosine of the angle (in degrees).");

        tant.setText("Returns the trigonometric tangent of the angle (in degrees).");

        asint.setText("Returns the arc sine of the value.");

        acost.setText("Returns the arc cosine of the value.");

        atant.setText("Returns the arc tangent of the value.");

        powt.setText("Returns the value - X raised to the power N.");

        angt.setText("Converts angles betwen Degrees and Radians.");

        logt.setText("Returns the base 10 logarithm of the arguement.");

        loget.setText("Returns the natural (base e) logarithm of the arguement.");

        xfact.setText("Returns the factorial value.");

        javax.swing.GroupLayout FormulasLayout = new javax.swing.GroupLayout(Formulas);
        Formulas.setLayout(FormulasLayout);
        FormulasLayout.setHorizontalGroup(
            FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormulasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sinh)
                    .addComponent(cosh)
                    .addComponent(tanh)
                    .addComponent(asinh)
                    .addComponent(acosh)
                    .addComponent(atanh)
                    .addComponent(powh)
                    .addComponent(angh)
                    .addComponent(logeh)
                    .addComponent(logh)
                    .addComponent(xfach))
                .addGap(18, 18, 18)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xfact, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(loget, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(logt, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(angt, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(powt, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(atant, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(acost, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(asint, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(tant, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(cost, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(sint, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addContainerGap())
        );
        FormulasLayout.setVerticalGroup(
            FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormulasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sinh)
                    .addComponent(sint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cosh)
                    .addComponent(cost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanh)
                    .addComponent(tant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asinh)
                    .addComponent(asint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acosh)
                    .addComponent(acost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atanh)
                    .addComponent(atant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(powh)
                    .addComponent(powt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(angh)
                    .addComponent(angt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logeh)
                    .addComponent(logt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logh)
                    .addComponent(loget))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FormulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xfach)
                    .addComponent(xfact))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        helptab.addTab("Formulas", Formulas);

        Exceptions.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ExceptionsLayout = new javax.swing.GroupLayout(Exceptions);
        Exceptions.setLayout(ExceptionsLayout);
        ExceptionsLayout.setHorizontalGroup(
            ExceptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        ExceptionsLayout.setVerticalGroup(
            ExceptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        helptab.addTab("Exceptions", Exceptions);

        OKHelp.setText("OK");
        OKHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout helppanelLayout = new javax.swing.GroupLayout(helppanel);
        helppanel.setLayout(helppanelLayout);
        helppanelLayout.setHorizontalGroup(
            helppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helppanelLayout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(OKHelp)
                .addGap(196, 196, 196))
            .addGroup(helppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(helptab, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );
        helppanelLayout.setVerticalGroup(
            helppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helppanelLayout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(OKHelp)
                .addContainerGap())
            .addGroup(helppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(helppanelLayout.createSequentialGroup()
                    .addComponent(helptab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout helpLayout = new javax.swing.GroupLayout(help.getContentPane());
        help.getContentPane().setLayout(helpLayout);
        helpLayout.setHorizontalGroup(
            helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        helpLayout.setVerticalGroup(
            helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helppanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Mthconst.setTitle("Constants");
        Mthconst.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        Mthconst.setMinimumSize(new java.awt.Dimension(160, 100));

        Mthconstpanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 11));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Maths Constants");

        pi.setFont(new java.awt.Font("Times New Roman", 0, 14));
        pi.setText("π");
        pi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piActionPerformed(evt);
            }
        });

        e.setText("<html>e<sup>x");
        e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eActionPerformed(evt);
            }
        });

        dec.setFont(new java.awt.Font("Times New Roman", 3, 18));
        dec.setText("∙");
        dec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MthconstpanelLayout = new javax.swing.GroupLayout(Mthconstpanel);
        Mthconstpanel.setLayout(MthconstpanelLayout);
        MthconstpanelLayout.setHorizontalGroup(
            MthconstpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MthconstpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MthconstpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MthconstpanelLayout.createSequentialGroup()
                        .addComponent(e)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dec))
                    .addComponent(jLabel8))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        MthconstpanelLayout.setVerticalGroup(
            MthconstpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MthconstpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(MthconstpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e)
                    .addComponent(pi)
                    .addComponent(dec, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout MthconstLayout = new javax.swing.GroupLayout(Mthconst.getContentPane());
        Mthconst.getContentPane().setLayout(MthconstLayout);
        MthconstLayout.setHorizontalGroup(
            MthconstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mthconstpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MthconstLayout.setVerticalGroup(
            MthconstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Mthconstpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        skin.setTitle("Skin Chooser");
        skin.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        skin.setMinimumSize(new java.awt.Dimension(550, 590));

        skinpanel.setBackground(new java.awt.Color(255, 255, 255));

        skinchooser.setBackground(new java.awt.Color(255, 255, 255));

        skinlbl.setFont(new java.awt.Font("Tahoma", 3, 18));
        skinlbl.setText("SKIN CHOOSER");

        OKskin.setText("OK");
        OKskin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKskinActionPerformed(evt);
            }
        });

        metal.setBackground(new java.awt.Color(255, 255, 255));
        skinbtngrp.add(metal);
        metal.setText("Metal ");
        metal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metalActionPerformed(evt);
            }
        });

        nimbus.setBackground(new java.awt.Color(255, 255, 255));
        skinbtngrp.add(nimbus);
        nimbus.setSelected(true);
        nimbus.setText("Nimbus (Default)");
        nimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimbusActionPerformed(evt);
            }
        });

        linux.setBackground(new java.awt.Color(255, 255, 255));
        skinbtngrp.add(linux);
        linux.setText("Motif (Only in Linux)");
        linux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linuxActionPerformed(evt);
            }
        });

        windows.setBackground(new java.awt.Color(255, 255, 255));
        skinbtngrp.add(windows);
        windows.setText("Windows (Only in Windows)");
        windows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowsActionPerformed(evt);
            }
        });

        wondowsc.setBackground(new java.awt.Color(255, 255, 255));
        skinbtngrp.add(wondowsc);
        wondowsc.setText("Windows Classic(Only in Windows)");
        wondowsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wondowscActionPerformed(evt);
            }
        });

        lay.setFont(new java.awt.Font("Tahoma", 3, 14));
        lay.setText("LAYOUTS");

        back.setFont(new java.awt.Font("Tahoma", 3, 14));
        back.setText("BACKGROUND");

        javax.swing.GroupLayout skinpanelLayout = new javax.swing.GroupLayout(skinpanel);
        skinpanel.setLayout(skinpanelLayout);
        skinpanelLayout.setHorizontalGroup(
            skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, skinpanelLayout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(skinlbl)
                .addGap(210, 210, 210))
            .addGroup(skinpanelLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(OKskin)
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(skinpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lay)
                .addGap(45, 45, 45)
                .addGroup(skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(windows)
                    .addComponent(nimbus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, skinpanelLayout.createSequentialGroup()
                        .addComponent(metal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(linux))
                    .addComponent(wondowsc, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(skinpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addContainerGap(455, Short.MAX_VALUE))
            .addGroup(skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(skinpanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(skinchooser, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        skinpanelLayout.setVerticalGroup(
            skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(skinpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(skinlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linux)
                    .addComponent(nimbus)
                    .addComponent(metal)
                    .addComponent(lay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windows)
                    .addComponent(wondowsc))
                .addGap(11, 11, 11)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 432, Short.MAX_VALUE)
                .addComponent(OKskin)
                .addContainerGap())
            .addGroup(skinpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(skinpanelLayout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(skinchooser, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout skinLayout = new javax.swing.GroupLayout(skin.getContentPane());
        skin.getContentPane().setLayout(skinLayout);
        skinLayout.setHorizontalGroup(
            skinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(skinpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        skinLayout.setVerticalGroup(
            skinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(skinpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        close.setTitle("Alert!");
        close.setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        close.setMinimumSize(new java.awt.Dimension(270, 140));

        closepanel.setBackground(new java.awt.Color(255, 255, 255));

        no.setText("No");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        yes.setText("Yes");
        yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesActionPerformed(evt);
            }
        });

        closealertxt.setText("Do you want to close Dhamaal Calculator?");

        javax.swing.GroupLayout closepanelLayout = new javax.swing.GroupLayout(closepanel);
        closepanel.setLayout(closepanelLayout);
        closepanelLayout.setHorizontalGroup(
            closepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closepanelLayout.createSequentialGroup()
                .addGroup(closepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(closepanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closealertxt))
                    .addGroup(closepanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(yes)
                        .addGap(44, 44, 44)
                        .addComponent(no)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        closepanelLayout.setVerticalGroup(
            closepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closealertxt)
                .addGap(18, 18, 18)
                .addGroup(closepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yes)
                    .addComponent(no))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout closeLayout = new javax.swing.GroupLayout(close.getContentPane());
        close.getContentPane().setLayout(closeLayout);
        closeLayout.setHorizontalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        closeLayout.setVerticalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Dhamaal Calculator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon("C:\\Program Files\\Dhamaal Calculator\\icon.png").getImage());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnpanel.setBackground(new java.awt.Color(255, 255, 255));
        btnpanel.setPreferredSize(new java.awt.Dimension(53, 23));

        funcpanel.setBackground(new java.awt.Color(255, 255, 255));
        funcpanel.setLayout(new java.awt.GridLayout(3, 4, 5, 3));

        sin.setFont(new java.awt.Font("Arial Narrow", 0, 10));
        sin.setText("SIN");
        sin.setMaximumSize(new java.awt.Dimension(53, 23));
        sin.setMinimumSize(new java.awt.Dimension(53, 23));
        sin.setPreferredSize(new java.awt.Dimension(53, 23));
        sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinActionPerformed(evt);
            }
        });
        funcpanel.add(sin);

        asin.setFont(new java.awt.Font("Tahoma", 0, 8));
        asin.setText("<HTML>SIN<SUP>-1</SUP></HTML>");
        asin.setMargin(new java.awt.Insets(1, 13, 1, 13));
        asin.setMaximumSize(new java.awt.Dimension(53, 23));
        asin.setMinimumSize(new java.awt.Dimension(53, 23));
        asin.setPreferredSize(new java.awt.Dimension(53, 23));
        asin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asinActionPerformed(evt);
            }
        });
        funcpanel.add(asin);

        pow.setFont(new java.awt.Font("Tahoma", 0, 8));
        pow.setLabel("<html>x<sup>n</sup></html>");
        pow.setMargin(new java.awt.Insets(1, 13, 1, 13));
        pow.setMaximumSize(new java.awt.Dimension(53, 23));
        pow.setMinimumSize(new java.awt.Dimension(53, 23));
        pow.setPreferredSize(new java.awt.Dimension(53, 23));
        pow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powActionPerformed(evt);
            }
        });
        funcpanel.add(pow);

        ce.setFont(new java.awt.Font("Tahoma", 0, 10));
        ce.setText("CE");
        ce.setMaximumSize(new java.awt.Dimension(53, 23));
        ce.setMinimumSize(new java.awt.Dimension(53, 23));
        ce.setPreferredSize(new java.awt.Dimension(53, 23));
        ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceActionPerformed(evt);
            }
        });
        funcpanel.add(ce);

        cos.setFont(new java.awt.Font("Arial Narrow", 0, 10));
        cos.setText("COS");
        cos.setMaximumSize(new java.awt.Dimension(53, 23));
        cos.setMinimumSize(new java.awt.Dimension(53, 23));
        cos.setPreferredSize(new java.awt.Dimension(53, 23));
        cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cosActionPerformed(evt);
            }
        });
        funcpanel.add(cos);

        acos.setFont(new java.awt.Font("Tahoma", 0, 8));
        acos.setText("<HTML>COS<SUP>-1</SUP></HTML>");
        acos.setMargin(new java.awt.Insets(1, 13, 1, 13));
        acos.setMaximumSize(new java.awt.Dimension(53, 23));
        acos.setMinimumSize(new java.awt.Dimension(53, 23));
        acos.setPreferredSize(new java.awt.Dimension(53, 23));
        acos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acosActionPerformed(evt);
            }
        });
        funcpanel.add(acos);

        ang.setFont(new java.awt.Font("Times New Roman", 0, 10));
        ang.setText("θ~π");
        ang.setMargin(new java.awt.Insets(1, 13, 1, 13));
        ang.setMaximumSize(new java.awt.Dimension(53, 23));
        ang.setMinimumSize(new java.awt.Dimension(53, 23));
        ang.setPreferredSize(new java.awt.Dimension(53, 23));
        ang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angActionPerformed(evt);
            }
        });
        funcpanel.add(ang);

        xfac.setFont(new java.awt.Font("Tahoma", 0, 10));
        xfac.setText("X!");
        xfac.setMaximumSize(new java.awt.Dimension(53, 23));
        xfac.setMinimumSize(new java.awt.Dimension(53, 23));
        xfac.setPreferredSize(new java.awt.Dimension(53, 23));
        xfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xfacActionPerformed(evt);
            }
        });
        funcpanel.add(xfac);

        tan.setFont(new java.awt.Font("Arial Narrow", 0, 10));
        tan.setText("TAN");
        tan.setMaximumSize(new java.awt.Dimension(53, 23));
        tan.setMinimumSize(new java.awt.Dimension(53, 23));
        tan.setPreferredSize(new java.awt.Dimension(53, 23));
        tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanActionPerformed(evt);
            }
        });
        funcpanel.add(tan);

        atan.setFont(new java.awt.Font("Tahoma", 0, 8));
        atan.setText("<HTML>TAN<SUP>-1</SUP></HTML>");
        atan.setMargin(new java.awt.Insets(1, 13, 1, 13));
        atan.setMaximumSize(new java.awt.Dimension(53, 23));
        atan.setMinimumSize(new java.awt.Dimension(53, 23));
        atan.setPreferredSize(new java.awt.Dimension(53, 23));
        atan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atanActionPerformed(evt);
            }
        });
        funcpanel.add(atan);

        log.setFont(new java.awt.Font("Tahoma", 0, 9));
        log.setText("<html>log<sub>10");
        log.setMargin(new java.awt.Insets(1, 13, 1, 13));
        log.setMaximumSize(new java.awt.Dimension(53, 23));
        log.setMinimumSize(new java.awt.Dimension(53, 23));
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        funcpanel.add(log);

        loge.setText("ln");
        loge.setMaximumSize(new java.awt.Dimension(53, 23));
        loge.setMinimumSize(new java.awt.Dimension(53, 23));
        loge.setPreferredSize(new java.awt.Dimension(53, 23));
        loge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logeActionPerformed(evt);
            }
        });
        funcpanel.add(loge);

        ans.setText("ANS");
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(10, 10));

        text.setColumns(24);
        text.setFont(text.getFont().deriveFont(text.getFont().getStyle() | java.awt.Font.BOLD, 15));
        text.setRows(2);
        text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFocusGained(evt);
            }
        });
        text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(text);

        del.setFont(new java.awt.Font("Tahoma", 0, 10));
        del.setText("DEL");
        del.setPreferredSize(new java.awt.Dimension(53, 23));
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        numpanel.setBackground(new java.awt.Color(255, 255, 255));
        numpanel.setLayout(new java.awt.GridLayout(4, 4, 2, 3));

        jButton7.setText("7");
        jButton7.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        numpanel.add(jButton7);

        jButton8.setText("8");
        jButton8.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        numpanel.add(jButton8);

        jButton9.setText("9");
        jButton9.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        numpanel.add(jButton9);

        xinv.setFont(new java.awt.Font("Times New Roman", 0, 9));
        xinv.setText("<html>x<sup>-1</sup></html>");
        xinv.setAlignmentY(0.0F);
        xinv.setMargin(new java.awt.Insets(1, 13, 1, 13));
        xinv.setMaximumSize(new java.awt.Dimension(39, 23));
        xinv.setPreferredSize(new java.awt.Dimension(41, 23));
        xinv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xinvActionPerformed(evt);
            }
        });
        numpanel.add(xinv);

        jButton4.setText("4");
        jButton4.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        numpanel.add(jButton4);

        jButton5.setText("5");
        jButton5.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        numpanel.add(jButton5);

        jButton6.setText("6");
        jButton6.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        numpanel.add(jButton6);

        pnt.setFont(new java.awt.Font("Tahoma", 0, 8));
        pnt.setText("%");
        pnt.setPreferredSize(new java.awt.Dimension(41, 23));
        pnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pntActionPerformed(evt);
            }
        });
        numpanel.add(pnt);

        jButton1.setText("1");
        jButton1.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        numpanel.add(jButton1);

        jButton2.setText("2");
        jButton2.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        numpanel.add(jButton2);

        jButton3.setText("3");
        jButton3.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        numpanel.add(jButton3);

        div.setText("÷");
        div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divActionPerformed(evt);
            }
        });
        numpanel.add(div);

        jButton0.setText("0");
        jButton0.setPreferredSize(new java.awt.Dimension(41, 23));
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });
        numpanel.add(jButton0);

        add.setText("+");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        numpanel.add(add);

        sub.setText("-");
        sub.setPreferredSize(new java.awt.Dimension(41, 23));
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActionPerformed(evt);
            }
        });
        numpanel.add(sub);

        mul.setText("*");
        mul.setPreferredSize(new java.awt.Dimension(41, 23));
        mul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulActionPerformed(evt);
            }
        });
        numpanel.add(mul);

        javax.swing.GroupLayout btnpanelLayout = new javax.swing.GroupLayout(btnpanel);
        btnpanel.setLayout(btnpanelLayout);
        btnpanelLayout.setHorizontalGroup(
            btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addGroup(btnpanelLayout.createSequentialGroup()
                        .addComponent(numpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(funcpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        btnpanelLayout.setVerticalGroup(
            btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(funcpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(btnpanelLayout.createSequentialGroup()
                        .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(numpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));

        File.setText("File");

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        MenuBar.add(File);

        Preferences.setText("Preferences");
        Preferences.add(jSeparator2);

        langen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        lang.add(langen);
        langen.setSelected(true);
        langen.setText("<html><U>E</U>nglish");
        langen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langenActionPerformed(evt);
            }
        });
        Preferences.add(langen);

        langhi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        lang.add(langhi);
        langhi.setText("<html><U>H</U>indi");
        langhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langhiActionPerformed(evt);
            }
        });
        Preferences.add(langhi);

        langsa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK));
        lang.add(langsa);
        langsa.setText("<html>Sans<U>k</U>rit");
        langsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langsaActionPerformed(evt);
            }
        });
        Preferences.add(langsa);
        Preferences.add(langsep);

        skinmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        skinmenu.setText("Choose Skin...");
        skinmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skinmenuActionPerformed(evt);
            }
        });
        Preferences.add(skinmenu);
        Preferences.add(jSeparator3);

        constmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        constmenu.setText("Maths Constants");
        constmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constmenuActionPerformed(evt);
            }
        });
        Preferences.add(constmenu);

        MenuBar.add(Preferences);

        About.setText("About");

        Developer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        Developer.setText("Developer");
        Developer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeveloperActionPerformed(evt);
            }
        });
        About.add(Developer);

        Help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        Help.setText("Help Topics");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });
        About.add(Help);

        MenuBar.add(About);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Calculator");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        text.append("0");
        clickSound();
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        text.append("1");
        clickSound();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        text.append("2");
        clickSound();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        text.append("3");
        clickSound();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        text.append("4");
        clickSound();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        text.append("5");
        clickSound();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        text.append("6");
        clickSound();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        text.append("7");
        clickSound();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        text.append("9");
        clickSound();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        text.append("8");
        clickSound();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            } else {
                x = (Double.parseDouble(text.getText()));
                u = 1;
                text.setText("");
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_addActionPerformed

    private void subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            } else {
                x = (Double.parseDouble(text.getText()));

                u = 2;
                text.setText("");
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_subActionPerformed

    private void mulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            } else {
                x = (Double.parseDouble(text.getText()));
                u = 3;
                text.setText("");
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_mulActionPerformed

    private void divActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            } else {
                x = (Double.parseDouble(text.getText()));
                u = 4;
                text.setText("");
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_divActionPerformed

    private void pntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pntActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            } else {
                x = (Double.parseDouble(text.getText()));
                u = 5;
                text.setText("");
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_pntActionPerformed

    private void xinvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xinvActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            } else {
                x = (Double.parseDouble(text.getText()));
                u = 6;
                text.setText("");
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_xinvActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        if (((text.getText()).isEmpty()) == true) {
            if (u == 6) {
                text.setText(String.valueOf((1 / x)));
            } else {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
            }
        } else {
            try {
                y = (Double.parseDouble(text.getText()));
                switch (u) {
                    case 1:
                        text.setText(String.valueOf((x + y)));
                        break;
                    case 2:
                        text.setText(String.valueOf((x - y)));
                        break;
                    case 3:
                        text.setText(String.valueOf((x * y)));
                        break;
                    case 4:
                        text.setText(String.valueOf((x / y)));
                        break;
                    case 5:
                        text.setText(String.valueOf((x / y * 100)));
                        break;
                }
                ansSound();
            } catch (NumberFormatException zz) {
                if (u == 6) {
                    text.setText(String.valueOf((1 / x)));
                    ansSound();
                } else {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
                }
            }
        }
    }//GEN-LAST:event_ansActionPerformed

    private void tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                text.setText(String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(text.getText())))));
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }

    }//GEN-LAST:event_tanActionPerformed

    private void ceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceActionPerformed
        text.setText("");
        Nval.setText("");
        Alertxt.setText("");
        r2df.setText("");
        d2rf.setText("");
        u = 0;
        a = 0;
        x = 0;
        y = 0;
        k = 0;
        f = 1;
        c = 1;
//        Del statement
     /*   int pass = 0;
        String pass2=null;
        long n=0;
        BufferedReader in = null;
        BufferedReader in2 = null;
        //Writing
        PrintWriter out = null;
        try {
        out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Program Files\\Dhamaal Calculator\\Del.txt")));
        } catch (IOException ex) {
        Logger.gLoggeretLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.write(text.getText());
        out.close();
        //Reading
        try {
        in = new BufferedReader(new FileReader("C:\\Program Files\\Dhamaal Calculator\\Del.txt"));
        } catch (FileNotFoundException ex) {
        Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (n=0;pass!=-1;n++)
        {
        try {
        if (n==0)
        {in.mark(ALLBITS);}
        in.skip(n);
        pass=in.read();
        if (pass==-1)
        {
        in.reset();
        in.skip(n);
        pass2=in.readLine();
        out.close();
        in.close();
        }
        } catch (IOException ex) {
        Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        try {
        in2 = new BufferedReader(new FileReader("C:\\Program Files\\Dhamaal Calculator\\Del.txt"));
        //            pass2 = in2.readLine();
        in2.close();
        } catch (IOException ex) {
        Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(pass2);
         */
    }//GEN-LAST:event_ceActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        close.setVisible(true);
    }//GEN-LAST:event_ExitActionPerformed

    private void DeveloperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeveloperActionPerformed
        Dev.setVisible(true);
    }//GEN-LAST:event_DeveloperActionPerformed

    private void sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                text.setText(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(text.getText())))));
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_sinActionPerformed

    private void cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                text.setText(String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(text.getText())))));
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_cosActionPerformed

    private void asinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asinActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                if ((Double.parseDouble(text.getText())) <= 1 && (Double.parseDouble(text.getText())) >= (-1)) {
                    text.setText(String.valueOf(Math.toDegrees(Math.asin(Double.parseDouble(text.getText())))));
                } else {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("Please enter value in range:(-1)≤SIN≤1", "Ñi;k lkbu &ƒ ls ƒ ds chp izos’k djas!", "Ñi;k lkbu &ƒ bR;kRk~ ƒ i;ZUre~ izos’ke~ dq# !", l));
                }
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_asinActionPerformed

    private void acosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acosActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                if ((Double.parseDouble(text.getText())) <= 1 && (Double.parseDouble(text.getText())) >= (-1)) {
                    text.setText(String.valueOf(Math.toDegrees(Math.acos(Double.parseDouble(text.getText())))));
                } else {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("Please enter value in range:(-1)≤COS≤1", "Ñi;k d‚l &ƒ ls ƒ ds chp izos’k djas!", "Ñi;k d‚l &ƒ bR;kRk~ ƒ i;ZUre~ izos’ke~ dq# !", l));
                }
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_acosActionPerformed

    private void atanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atanActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                text.setText(String.valueOf(Math.toDegrees(Math.atan(Double.parseDouble(text.getText())))));
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_atanActionPerformed

    private void OKMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKMsgActionPerformed
        Dev.dispose();
    }//GEN-LAST:event_OKMsgActionPerformed

    private void OKPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKPowerActionPerformed
        Power.dispose();
        if (rt.isSelected() == true) {
            k = 2;
        } else if (powr.isSelected() == true) {
            k = 1;
        } else if (lg.isSelected() == true) {
            k = 3;
        } else {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("You have not selected any radio button", "vkius dksbZ Hkh jsfM;ks CkVu ugha nCkk;k gS !", "HkOkkUk~ dks∙fi jsfM;ks&CkVue~ u vfpuksr~ !", l));
        }
        switch (k) {
            case 1:
                if ((((Nval.getText()).isEmpty()) == true) || (((text.getText()).isEmpty()) == true)) {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

                } else {
                    try {
                        text.setText(String.valueOf(Math.pow((Double.parseDouble(text.getText())), (Double.parseDouble(Nval.getText())))));
                    } catch (NumberFormatException zz) {
                        Alert.setVisible(true);
                        Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
                    }
                }
                break;
            case 2:
                if ((((Nval.getText()).isEmpty()) == true) || (((text.getText()).isEmpty()) == true)) {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

                } else {
                    try {
                        double i = Double.parseDouble(text.getText());
                        double j = Double.parseDouble(Nval.getText());
                        double sol = Math.exp((Math.log(i)) / j);
                        text.setText("" + sol);
                        System.out.println("" + sol);
                    } catch (Exception zz) {
                        Alert.setVisible(true);
                        Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
                    }
                    break;
                }
            case 3:
                if ((((Nval.getText()).isEmpty()) == true) || (((text.getText()).isEmpty()) == true)) {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

                } else {
                    text.setText("" + ((Math.log10(Double.parseDouble(Nval.getText()))) / (Math.log10(Double.parseDouble(text.getText())))));
                }
        }
    }//GEN-LAST:event_OKPowerActionPerformed

    private void powActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powActionPerformed
        Power.setVisible(true);
    }//GEN-LAST:event_powActionPerformed

    private void angActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angActionPerformed
        Angle.setVisible(true);
    }//GEN-LAST:event_angActionPerformed

    private void OKAngleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKAngleActionPerformed
        Angle.dispose();
        if ((((r2df.getText()).isEmpty()) == false) || (((d2rf.getText()).isEmpty()) == false)) {
            try {
                if ((r2d.isSelected()) == true) {
                    text.setText(String.valueOf(Math.toDegrees(Double.parseDouble(r2df.getText()))));
                } else if ((d2r.isSelected()) == true) {
                    text.setText(String.valueOf(Math.toRadians(Double.parseDouble(d2rf.getText()))));

                } else {
                    Alert.setVisible(true);
                    Alertxt.setText(txt.Font("You have not selected any radio button", "vkius dksbZ Hkh jsfM;ks CkVu ugha nCkk;k gS !", "HkOkkUk~ dks∙fi jsfM;ks&CkVue~ u vfpuksr~ !", l));
                }
            } catch (NumberFormatException zz) {
            }
        } else {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));
        }

    }//GEN-LAST:event_OKAngleActionPerformed

    private void xfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xfacActionPerformed
        //Timer
        new StopWatch().setVisible(false);
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                if ((text.getText()).equals("Infinity")) {
                    text.setText("∞! = ∞");
                } else {
                    double n = (Double.parseDouble(text.getText()));
                    double z, q = 1;
                    for (z = 1; z <= n; z++) {
                        q = q * z;
                    }
                    text.setText("" + q);
                }
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }

    }//GEN-LAST:event_xfacActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                text.setText("" + Math.log10(Double.parseDouble(text.getText())));
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_logActionPerformed

    private void logeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logeActionPerformed
        try {
            if (((text.getText()).isEmpty()) == true) {
                Alert.setVisible(true);
                Alertxt.setText(txt.Font("You have not entered any number!", "vkius dksbZ Hkh vad izos’k ugha fd;k gS !!!", "HkOkkUk~ dks∙fi vade~ izos’ke~ u vdjksr~ !", l));

            } else {
                text.setText("" + Math.log(Double.parseDouble(text.getText())));
            }
        } catch (NumberFormatException zz) {
            Alert.setVisible(true);
            Alertxt.setText(txt.Font("Invalid Entry!", "vekU; izos’k!", "vekU;e~  izos’ke~", l));
        }
    }//GEN-LAST:event_logeActionPerformed

    private void OKAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKAlertActionPerformed
        Alert.dispose();
    }//GEN-LAST:event_OKAlertActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        help.setVisible(true);
    }//GEN-LAST:event_HelpActionPerformed

    private void OKHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKHelpActionPerformed
        help.dispose();
    }//GEN-LAST:event_OKHelpActionPerformed

    private void langhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langhiActionPerformed
        if (langhi.isSelected() == true) {
            l = 2;
            Alertxt.setFont(new java.awt.Font("Kruti Dev 010", 0, 20));
        }
    }//GEN-LAST:event_langhiActionPerformed

    private void langenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langenActionPerformed
        if (langen.isSelected() == true) {
            l = 1;
            Alertxt.setFont(new java.awt.Font("Times New Roman", 0, 20));
        }
    }//GEN-LAST:event_langenActionPerformed

    private void constmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constmenuActionPerformed
        Mthconst.setVisible(true);
    }//GEN-LAST:event_constmenuActionPerformed

    private void eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eActionPerformed
        switch (f) {
            case 'a':
                r2df.setText("" + Math.E);
                break;
            case 'b':
                d2rf.setText("" + Math.E);
                break;
            case 'n':
                Nval.setText("" + Math.E);
                break;
            default:
                text.setText("" + Math.E);
        }
    }//GEN-LAST:event_eActionPerformed

    private void piActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piActionPerformed
        switch (f) {
            case 'a':
                r2df.setText("" + Math.PI);
                break;
            case 'b':
                d2rf.setText("" + Math.PI);
                break;
            case 'n':
                Nval.setText("" + Math.PI);
                break;
            default:
                text.setText("" + Math.PI);
        }
    }//GEN-LAST:event_piActionPerformed

    private void decActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decActionPerformed
        switch (f) {
            case 'a':
                r2df.setText(text.getText() + ".");
                break;
            case 'b':
                d2rf.setText(text.getText() + ".");
                break;
            case 'n':
                Nval.setText(text.getText() + ".");
                break;
            default:
                text.setText(text.getText() + ".");
        }
        decimalexceptioncheck();
    }//GEN-LAST:event_decActionPerformed

    private void NvalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NvalFocusGained
        f = 'n';
    }//GEN-LAST:event_NvalFocusGained

    private void r2dfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_r2dfFocusGained
        f = 'a';
    }//GEN-LAST:event_r2dfFocusGained

    private void d2rfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d2rfFocusGained
        f = 'b';
    }//GEN-LAST:event_d2rfFocusGained

    private void OKskinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKskinActionPerformed
        skin.dispose();
        btnpanel.setBackground(skinchooser.getColor());
        numpanel.setBackground(skinchooser.getColor());
        funcpanel.setBackground(skinchooser.getColor());
        Devpanel.setBackground(skinchooser.getColor());
        Powerpanel.setBackground(skinchooser.getColor());
        Anglepanel.setBackground(skinchooser.getColor());
        Alertpanel.setBackground(skinchooser.getColor());
        helppanel.setBackground(skinchooser.getColor());
        Formulas.setBackground(skinchooser.getColor());
        Exceptions.setBackground(skinchooser.getColor());
        Mthconstpanel.setBackground(skinchooser.getColor());
        skinpanel.setBackground(skinchooser.getColor());
        closepanel.setBackground(skinchooser.getColor());

    }//GEN-LAST:event_OKskinActionPerformed

    private void skinmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skinmenuActionPerformed
        skin.setVisible(true);
    }//GEN-LAST:event_skinmenuActionPerformed

    private void metalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metalActionPerformed
        try {
            sk = "javax.swing.plaf.metal.MetalLookAndFeel";
            UIManager.setLookAndFeel(sk);
            updatelook();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_metalActionPerformed

    private void nimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimbusActionPerformed
        try {
            sk = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
            UIManager.setLookAndFeel(sk);
            updatelook();
//            setMinimumSize(new java.awt.Dimension(280, 320));
//            setSize(new java.awt.Dimension(280, 320));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nimbusActionPerformed

    private void windowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowsActionPerformed
        try {
            sk = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            UIManager.setLookAndFeel(sk);
            updatelook();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_windowsActionPerformed

    private void wondowscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wondowscActionPerformed
        try {
            sk = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
            UIManager.setLookAndFeel(sk);
            updatelook();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_wondowscActionPerformed

    private void linuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linuxActionPerformed
        try {
            sk = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            UIManager.setLookAndFeel(sk);
            updatelook();
//            setMinimumSize(new java.awt.Dimension(285, 421));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linuxActionPerformed

    private void langsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langsaActionPerformed
        if (langsa.isSelected() == true) {
            l = 3;
            Alertxt.setFont(new java.awt.Font("Kruti Dev 010", 0, 20));
        }
    }//GEN-LAST:event_langsaActionPerformed

    private void yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesActionPerformed
        System.exit(0);
    }//GEN-LAST:event_yesActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        close.dispose();
    }//GEN-LAST:event_noActionPerformed

    private void textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusGained
        f = 't';
}//GEN-LAST:event_textFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        close.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        String t1 = text.getText();
        int n1 = t1.length(), j = 0;
        text.setText("");
        for (int yy = 0; yy < n1 - 1; yy++) {
            text.append("" + t1.charAt(yy));
            if (("" + t1.charAt(yy)).equals(".")) {
                j++;
            }
        }
    }//GEN-LAST:event_delActionPerformed

    private void AlertWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_AlertWindowActivated
        errorSound();
    }//GEN-LAST:event_AlertWindowActivated

    private void textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textKeyTyped
        decimalexceptioncheck();
}//GEN-LAST:event_textKeyTyped

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        clickSound();
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                        else if ("Windows".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                }
                /* try {
                Class.forName("Calculator", false, this.getClass().getClassLoader());
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, "abc", ex);
                }*/

                new Front().setVisible(true);
                sysIcon();


            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private static javax.swing.JDialog Alert;
    private javax.swing.JPanel Alertpanel;
    private static javax.swing.JLabel Alertxt;
    private static javax.swing.JDialog Angle;
    private javax.swing.JPanel Anglepanel;
    private static javax.swing.JDialog Dev;
    private javax.swing.JMenuItem Developer;
    private javax.swing.JPanel Devpanel;
    private javax.swing.JPanel Exceptions;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JPanel Formulas;
    private javax.swing.JMenuItem Help;
    private static javax.swing.JMenuBar MenuBar;
    private static javax.swing.JDialog Mthconst;
    private javax.swing.JPanel Mthconstpanel;
    private javax.swing.JTextField Nval;
    private javax.swing.JLabel Nvalbl;
    private javax.swing.JButton OKAlert;
    private javax.swing.JButton OKAngle;
    private javax.swing.JButton OKHelp;
    private javax.swing.JButton OKMsg;
    private javax.swing.JButton OKPower;
    private javax.swing.JButton OKskin;
    private static javax.swing.JDialog Power;
    private javax.swing.JPanel Powerpanel;
    private javax.swing.JMenu Preferences;
    private javax.swing.JButton acos;
    private javax.swing.JLabel acosh;
    private javax.swing.JLabel acost;
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup anbtngr;
    private javax.swing.JButton ang;
    private javax.swing.JLabel angh;
    private javax.swing.JLabel angt;
    private javax.swing.JButton ans;
    private javax.swing.JButton asin;
    private javax.swing.JLabel asinh;
    private javax.swing.JLabel asint;
    private javax.swing.JButton atan;
    private javax.swing.JLabel atanh;
    private javax.swing.JLabel atant;
    private javax.swing.JLabel back;
    private static javax.swing.JPanel btnpanel;
    private javax.swing.JButton ce;
    private static javax.swing.JDialog close;
    private javax.swing.JLabel closealertxt;
    private javax.swing.JPanel closepanel;
    private javax.swing.JMenuItem constmenu;
    private javax.swing.JButton cos;
    private javax.swing.JLabel cosh;
    private javax.swing.JLabel cost;
    private javax.swing.JRadioButton d2r;
    private javax.swing.JTextField d2rf;
    private javax.swing.JButton dec;
    private javax.swing.JButton del;
    private javax.swing.JLabel devhead;
    private javax.swing.JButton div;
    private javax.swing.JButton e;
    private static javax.swing.JPanel funcpanel;
    private static javax.swing.JDialog help;
    private javax.swing.JPanel helppanel;
    private javax.swing.JTabbedPane helptab;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.ButtonGroup lang;
    private static javax.swing.JRadioButtonMenuItem langen;
    private static javax.swing.JRadioButtonMenuItem langhi;
    private static javax.swing.JRadioButtonMenuItem langsa;
    private javax.swing.JPopupMenu.Separator langsep;
    private javax.swing.JLabel lay;
    private javax.swing.JRadioButton lg;
    private javax.swing.JRadioButton linux;
    private javax.swing.JButton log;
    private javax.swing.JButton loge;
    private javax.swing.JLabel logeh;
    private javax.swing.JLabel loget;
    private javax.swing.JLabel logh;
    private javax.swing.JLabel logt;
    private javax.swing.JRadioButton metal;
    private javax.swing.JButton mul;
    private javax.swing.JRadioButton nimbus;
    private javax.swing.JButton no;
    private static javax.swing.JPanel numpanel;
    private javax.swing.JButton pi;
    private javax.swing.JButton pnt;
    private javax.swing.JButton pow;
    private javax.swing.ButtonGroup powbtngrp;
    private javax.swing.JLabel powh;
    private javax.swing.JRadioButton powr;
    private javax.swing.JLabel powt;
    private javax.swing.JRadioButton r2d;
    private javax.swing.JTextField r2df;
    private javax.swing.JRadioButton rt;
    private javax.swing.JButton sin;
    private javax.swing.JLabel sinh;
    private javax.swing.JLabel sint;
    private static javax.swing.JDialog skin;
    private javax.swing.ButtonGroup skinbtngrp;
    private javax.swing.JColorChooser skinchooser;
    private javax.swing.JLabel skinlbl;
    private javax.swing.JMenuItem skinmenu;
    private javax.swing.JPanel skinpanel;
    private javax.swing.JButton sub;
    private javax.swing.JButton tan;
    private javax.swing.JLabel tanh;
    private javax.swing.JLabel tant;
    private static javax.swing.JTextArea text;
    private javax.swing.JRadioButton windows;
    private javax.swing.JRadioButton wondowsc;
    private javax.swing.JButton xfac;
    private javax.swing.JLabel xfach;
    private javax.swing.JLabel xfact;
    private javax.swing.JButton xinv;
    private javax.swing.JButton yes;
    // End of variables declaration//GEN-END:variables
}

class Methods {

    String Font(String en, String hi, String sa, int l) {
        String k = "Error!";
        if (l == 1) {
            k = en;
        }
        if (l == 2) {
            k = hi;
        }
        if (l == 3) {
            k = sa;
        }
        return k;
    }
}
