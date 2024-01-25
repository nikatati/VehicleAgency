package GUI;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;

public class CurrentInventoryReport  extends JDialog implements Runnable
{
    JPanel north;
    VehiclePanel vehiclePanel;
    Thread ThreadChoose;



    public CurrentInventoryReport(VehiclePanel panel) {
        north = new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("Current Inventory Report");
        //this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.vehiclePanel=panel;


        for (int i = 0; i < panel.getDealership().size(); i++) {
            Vehicle vehicle = panel.getDealership().get(i);
            //buttonChoose = new JButton();
            ImageIcon icon = new ImageIcon(vehicle.getImg());
            JLabel pic=new JLabel(icon);
            pic.setToolTipText(vehicle.toString());
            pic.setPreferredSize(new Dimension(100,100));
            north.add(pic);
        }
        this.add(north);
        pack();
        //this.setVisible(true);
    }

    public void updateVehiclePanel(VehiclePanel panel) {
        north.removeAll();

        for (Vehicle vehicle : vehiclePanel.getDealership())
        {
            ImageIcon icon = new ImageIcon(vehicle.getImg());
            JLabel pic=new JLabel(icon);
            pic.setToolTipText(vehicle.toString());
            pic.setPreferredSize(new Dimension(100,100));

            north.add(pic);
        }

        north.revalidate();
        north.repaint();
    }

    public void run()
    {
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
