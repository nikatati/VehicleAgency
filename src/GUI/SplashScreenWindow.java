package GUI;

import javax.swing.*;

public class SplashScreenWindow extends JDialog{
    public SplashScreenWindow() {
        setSize(300, 100);
        JLabel label = new JLabel("Updating database... Please wait :-)");
        add(label);
    }
}




