package GUI;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleEntryWindow extends JFrame
{

    public VehicleEntryWindow()
    {
        super("Agency");
        this.add(new VehiclePanel());
        this.setVisible(true);
        this.setResizable(false);
        this.pack();

    }


}
