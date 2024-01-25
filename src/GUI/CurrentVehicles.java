package GUI;
import Vehicle.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.text.Position;


public class CurrentVehicles  extends JDialog implements Runnable
{
    JPanel south,north;
    JButton buttonChoose;
    VehiclePanel vehiclePanel;
    Thread ThreadChoose;


    public CurrentVehicles(VehiclePanel panel)
    {
        north = new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        south = new JPanel();
        this.setTitle("Current Vehicles");
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(700,700));
        this.setLocationRelativeTo(null);
        this.vehiclePanel=panel;




        for(int i=0;i< panel.getDealership().size();i++)
        {
            Vehicle vehicle=panel.getDealership().get(i);
            buttonChoose = new JButton();
            ImageIcon icon = new ImageIcon(vehicle.getImg());
            buttonChoose.setIcon(icon);
            buttonChoose.setToolTipText(vehicle.toString());
            buttonChoose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ChosenVehicle chosenVehicle=new ChosenVehicle(panel,vehicle);
                    ThreadChoose=new Thread(chosenVehicle);
                    ThreadChoose.start();
                    System.out.println(ThreadChoose.isAlive());
                }
            });
            buttonChoose.setPreferredSize(new Dimension(150,150));
            north.add( buttonChoose);



        }
        updateVehiclePanel(panel);



        this.add(north,BorderLayout.NORTH);
        this.add(south,BorderLayout.SOUTH);
        pack();
        //this.setVisible(true);

    }


    public void updateVehiclePanel(VehiclePanel panel) {
        north.removeAll();

        for (Vehicle vehicle : vehiclePanel.getDealership()) {
            buttonChoose = new JButton(new ImageIcon(vehicle.getImg()));
            buttonChoose.setToolTipText(vehicle.toString());
            buttonChoose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ChosenVehicle chosenVehicle = new ChosenVehicle(panel, vehicle);
                    ThreadChoose=new Thread(chosenVehicle);
                    ThreadChoose.start();
                    System.out.println(ThreadChoose.isAlive());
                }
            });
            buttonChoose.setPreferredSize(new Dimension(150, 150));
            north.add(buttonChoose);
        }

        north.revalidate();
        north.repaint();
    }

    public void run() {
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                updateVehiclePanel(vehiclePanel);
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                // Do nothing
            }
        });

        this.setVisible(true);
    }

}
