package GUI;
import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChangeFlag extends JDialog implements Runnable
{
    JPanel south,north;
    JComboBox cb;
    String[] Country={"Israel","USA","Germany","Italy","Greece","Somalia","Pirate"};
    Random rand = new Random();
    SplashScreenWindow splashScreen;


    public ChangeFlag(VehiclePanel panel)
    {
        north = new JPanel();
        this.setTitle("Change Flag");
        //this.setVisible(true);

        cb=new JComboBox(Country);
        cb.setBounds(10, 30,90,20);

        JButton chooseFlagB = new JButton("Choose");
        chooseFlagB.setBounds(10,50,80,25);
        chooseFlagB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for (int i=0;i<panel.getDealership().size();i++)
                {
                    if (panel.getDealership().get(i) instanceof Amphibious)
                    {
                        System.out.println(cb.getSelectedItem().toString());
                        waitingWindow();
                        ((Amphibious) panel.getDealership().get(i)).setFlag_country(cb.getSelectedItem().toString());
                    }
                    if (panel.getDealership().get(i) instanceof Croz_ship)
                    {
                        System.out.println(cb.getSelectedItem().toString());
                        waitingWindow();
                        ((Croz_ship) panel.getDealership().get(i)).setFlagCountry(cb.getSelectedItem().toString());
                    }
                    if (panel.getDealership().get(i) instanceof Frigate)
                    {
                        System.out.println(cb.getSelectedItem().toString());
                        waitingWindow();
                        ((Frigate) panel.getDealership().get(i)).setFlagCountry(cb.getSelectedItem().toString());
                    }
                }

            }
        });

        north.add(cb);
        north.add(chooseFlagB);
        this.add(north);
        this.setPreferredSize(new Dimension(300, 150));


        pack();
    }

    public void waitingWindow()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    splashScreen = new SplashScreenWindow();
                    splashScreen.setVisible(true);
                    Thread.sleep(rand.nextInt(8000-3000)+3000);
                }
                catch (InterruptedException ex1)
                {
                    ex1.printStackTrace();

                }
                finally {
                    if (splashScreen != null) {
                        splashScreen.dispose();
                        JOptionPane.showMessageDialog(null,"Flag changed successfully !");
                    }
                }
            }
        }).start();
    }

    public void run()
    {
        this.setVisible(true);
    }
}
