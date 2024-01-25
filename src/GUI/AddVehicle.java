package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehicle extends JDialog implements Runnable
{
    JButton chooseBtn;
    JPanel addVehiclePanel2;
    JPanel addVehiclePanel1;
    JComboBox cb;
    String[] Vehicles={"Jeep","Bicycle","Croz ship","Frigate","Game gilder","Spy gilder","Amphibious","Hybride Plane","Electric Bicycle"};


    public AddVehicle(VehiclePanel panel)
    {
        this.setTitle("Add Vehicle");
        this.addVehiclePanel1=new JPanel();
        this.addVehiclePanel2=new JPanel();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setBounds(170,140,400,200);

        cb=new JComboBox(Vehicles);
        cb.setBounds(50, 50,90,20);

        chooseBtn=new JButton("Choose");
        chooseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedItem()=="Jeep")
                {
                    AddJeep addJeep=new AddJeep(panel);
                }
                if(cb.getSelectedItem()=="Bicycle")
                {
                    AddBicycle addBicycle=new AddBicycle(panel);
                }
                if(cb.getSelectedItem()=="Croz ship")
                {
                    AddCrozShip addCrozShip=new AddCrozShip(panel);
                }
                if(cb.getSelectedItem()=="Frigate")
                {
                    AddFrigate addFrigate=new AddFrigate(panel);
                }
                if(cb.getSelectedItem()=="Game gilder")
                {
                    AddGameGilder addGameGilder=new AddGameGilder(panel);
                }
                if(cb.getSelectedItem()=="Spy gilder")
                {
                    AddSpyGilder addSpyGilder=new AddSpyGilder(panel);
                }
                if(cb.getSelectedItem()=="Amphibious")
                {
                    AddAmphibious addAmphibious=new AddAmphibious(panel);
                }
                if (cb.getSelectedItem()=="Hybride Plane")
                {
                    AddHybridePlane addHybridePlane=new AddHybridePlane(panel);
                }
                if (cb.getSelectedItem()=="Electric Bicycle")
                {
                    AddElectricBicycle addElectricBicycle=new AddElectricBicycle(panel);
                }

            }
        });
        addVehiclePanel1.add(cb);
        addVehiclePanel2.add(chooseBtn);
        this.add(addVehiclePanel2, BorderLayout.SOUTH);
        this.add(addVehiclePanel1, BorderLayout.NORTH);

    }

    @Override
    public void run()
    {
        this.setVisible(true);
    }

}
