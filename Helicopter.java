import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class Helicopter extends  JFrame implements ObserverRoom {
    private JLabel lblHeli, JCheckBox;
    private JButton Shoot, Missile, Inbox,HelicopterbtnSend, clickPosition,clickMissie;
    private JCheckBox chkPosition;
    private JTextField Helicoptertxttyp,MainControllerTxtTyp;
    private JTextArea Helicoptertextarea ,MainControllerTextArea;

    Helicopter() {
        setTitle("Helicopter");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        lblHeli = new JLabel("Area Not Cleared");
        lblHeli.setBounds(20, 10, 120, 25);
        add(lblHeli);
//---------------------------------------------------------------position button---------------------------------
        chkPosition = new JCheckBox("Position");
        chkPosition.setBounds(320, 90, 100, 25);
        chkPosition.setBackground(Color.red);
        chkPosition.setForeground(Color.white);

        chkPosition.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (chkPosition.isSelected()) {
                    add(Shoot);
                    add(Missile);
                    revalidate();
                } else {
                    remove(Shoot);
                    remove(Missile);
                }
                revalidate();
                repaint();
            }
        });
        add(chkPosition);
        //======================================================= Click Position========================================

        clickPosition = new JButton("Click Position");
        clickPosition.setBounds(20, 40, 120, 30);
        add(clickPosition);

        clickMissie = new JButton("Click Position ON Missile");
        clickMissie.setBounds(150, 40, 150, 30);
        add(clickMissie);

        //==========================================================Shoting OFF=========================================
        Shoot = new JButton("Shoting OFF");
        Shoot.setBounds(20, 40, 120, 30);
        Shoot.setForeground(Color.red);

        Missile = new JButton("Missile Operation OFF");
        Missile.setBounds(150, 40, 150, 30);
        Missile.setForeground(Color.red);
//----------------------------------------------------------------------------------------------------------------------
        Inbox = new JButton("Inbox");
        Inbox.setBounds(20, 80, 120, 30);
        add(Inbox);
//===============================================HELICOPTORE INBOX CREATE ============================================
        //---------------------text Arrya------------------------------------------------------------
        Helicoptertextarea = new JTextArea();
        Helicoptertextarea.setBounds(20,130, 350,100);
        add(Helicoptertextarea);

        Helicoptertxttyp = new JTextField();
        Helicoptertxttyp.setBounds(20, 240, 350, 30);
        add(Helicoptertxttyp);
        //------------------------------Helicopter Send Button ------------------------------------------
        HelicopterbtnSend = new JButton("Send");
        HelicopterbtnSend.setBounds(380, 240, 80, 30);
        add(HelicopterbtnSend);
        HelicopterbtnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == HelicopterbtnSend){
                    Helicoptertextarea.setText("Helicopter "+Helicoptertxttyp.getText());
                    MainControllerTextArea.setText(" MainController "+MainControllerTxtTyp.getText());

                }
            }
        });
        setVisible(true);
    }
    //-------------------------------------------------------------------------------------------
    public void update(int MainController) {
        Shoot.setText(MainController >= 10 ? "Shoting ON" : "Shotin Off");
        Missile.setText(MainController >= 50 ? "Missile ON" : "Missile Off");
    }
    public void update(String MainController){
        Helicoptertextarea.setText(" MainController :- "+MainController);
    }
}