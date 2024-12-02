import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




class Demo{
    public static void main(String[] args) {
        MainController NewMaindefance = new MainController();

        NewMaindefance.addObserverRoom(new Tank());
        NewMaindefance.addObserverRoom(new Submarin());
        NewMaindefance.addObserverRoom(new Helicopter());
    }
}