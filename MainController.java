import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



class MainController extends JFrame{
    private JSlider contLevelSlider;
    private JLabel labelMainController;
    private JButton MainControllerBtnSend;
    private JButton Shoot, Missile, Inbox,HelicopterbtnSend, clickPosition,clickMissie;
    private JTextField MainControllerTxtTyp,Submarintxttyp;
    private JTextArea MainControllerTextArea;

    ArrayList<ObserverRoom>Armylist = new ArrayList<>();

    MainController(){
        setTitle("MainController");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        contLevelSlider = new JSlider(JSlider.VERTICAL,0,100,0);
        contLevelSlider.setMajorTickSpacing(15);
        contLevelSlider.setBounds(20, 50, 50, 300);
        contLevelSlider.setPaintTicks(true);
        contLevelSlider.setPaintLabels(true);

        contLevelSlider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                int sliderValue=contLevelSlider.getValue();
                for(ObserverRoom ob: Armylist){
                    ob.update(sliderValue);
                }
            }
        });

        labelMainController = new JLabel("");
        labelMainController.setFont(new Font("Arial", Font.BOLD, 20));
        labelMainController.setBounds(80, 20, 300, 30);
        add(labelMainController);
        add(contLevelSlider);
//-------------------------------------------MainController  txt--------------------------------------------------------

        MainControllerTextArea = new JTextArea(5,30);
        MainControllerTextArea.setBounds(80, 130, 250, 100);
        add(MainControllerTextArea);

        MainControllerTxtTyp = new JTextField();
        MainControllerTxtTyp.setBounds(80, 240, 250, 30);
        add(MainControllerTxtTyp);

//------------------------------MainController Send Button ------------------------------------------
        MainControllerBtnSend = new JButton("Send");
        MainControllerBtnSend.setBounds(80, 280, 80, 30);
        add(MainControllerBtnSend);

        MainControllerBtnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == MainControllerBtnSend){
                    MainControllerTextArea.setText("  MainController "+MainControllerTxtTyp.getText());

                    for (ObserverRoom ob : Armylist) {
                        ob.update(MainControllerTxtTyp.getText());
                    }

                }
            }
        });
        //==============================================================================================================
        setVisible(true);
    }
    public void addObserverRoom(ObserverRoom ob) {
        Armylist.add(ob);
    }
    public void update(String MainController){
        MainControllerTextArea.setText("Submarin "+Submarintxttyp.getText());
    }
}
