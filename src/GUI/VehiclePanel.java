package GUI;

import Vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VehiclePanel extends JPanel implements ActionListener
{

    private Image VehicleImage;
    JButton addVehicleBtn, currentVehiclesBtn, ClearBtn, ChangeFlagBtn,ReportBtn, ExitBtn;
    JComboBox comboBox;
    JLabel chooseLabel;
    ArrayList<Vehicle> dealership = new ArrayList<Vehicle>();
    Thread ThreadAdd,ThreadChangeFlag,ThreadCurrentVehicle,ThreadCurrentInventoryReportDialog,
    ThreadClear;

    public VehiclePanel()
    {
        this.setPreferredSize(new Dimension(930, 500));
        this.setBackground(Color.ORANGE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        try {
            VehicleImage = ImageIO.read((new File("C:\\Users\\nikat\\IdeaProjects\\Car_Agency_Project\\src\\GUI\\VehiclesEnter.jpg")));
        } catch (IOException ex) {
            System.out.println("Cannot load image");
        }
        panel.add(new JLabel(new ImageIcon(VehicleImage.getScaledInstance(790, 480, Image.SCALE_SMOOTH))));


        addVehicleBtn =new JButton("Add Vehicle");
        addVehicleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAddVehicleDialog();

            }
        });

        currentVehiclesBtn =new JButton("Current Vehicles");
        currentVehiclesBtn.setPreferredSize(new Dimension(150,30));
        currentVehiclesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentVehicleDialog();
            }
        });

        ClearBtn =new JButton("Clear");
        ClearBtn.setPreferredSize(new Dimension(150,30));
        ClearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealership.clear();
                if(dealership.size()==0)
                    JOptionPane.showMessageDialog(null,"All the vehicles are cleared");
            }
        });

        ChangeFlagBtn =new JButton("Change Flag");
        ChangeFlagBtn.setPreferredSize(new Dimension(150,30));
        ChangeFlagBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFlagDialog();
            }
        });

        ReportBtn=new JButton("Current inventory report");
        ReportBtn.setPreferredSize(new Dimension(180,30));
        ReportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentInventoryReportDialog();
            }
        });


        ExitBtn =new JButton("Exit");
        ExitBtn.setPreferredSize(new Dimension(150,30));
        ExitBtn.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });


        JPanel south = new JPanel();
        south.add(addVehicleBtn);
        south.add(currentVehiclesBtn);
        south.add(ClearBtn);
        south.add(ChangeFlagBtn);
        south.add(ReportBtn);
        south.add(ExitBtn);
        this.setLayout(new BorderLayout());
        this.add(south,BorderLayout.SOUTH);
        this.add(panel);


        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==comboBox)
        {
            System.out.println(comboBox.getSelectedItem());
        }
    }
    private void createAddVehicleDialog(){
        AddVehicle addVehicle=new AddVehicle(this);
        ThreadAdd = new Thread(addVehicle);
        ThreadAdd.start();
        System.out.println(ThreadAdd.isAlive());

    }

    private void changeFlagDialog(){
        ChangeFlag changeFlag=new ChangeFlag(this);
        ThreadChangeFlag =new Thread(changeFlag);
        ThreadChangeFlag.start();
        System.out.println(ThreadChangeFlag.isAlive());

    }

    private void currentVehicleDialog(){
        CurrentVehicles currentVehicles=new CurrentVehicles(this);
        ThreadCurrentVehicle=new Thread(currentVehicles);
        ThreadCurrentVehicle.start();
        System.out.println(ThreadCurrentVehicle.isAlive());

    }

    private void CurrentInventoryReportDialog(){
        CurrentInventoryReport currentInventoryReport=new CurrentInventoryReport(this);
        ThreadCurrentInventoryReportDialog=new Thread(currentInventoryReport);
        ThreadCurrentInventoryReportDialog.start();
        System.out.println(ThreadCurrentInventoryReportDialog.isAlive());

    }

    public ArrayList<Vehicle> getDealership()
    {
        return this.dealership;
    }


}
