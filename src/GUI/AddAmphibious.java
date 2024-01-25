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

public class AddAmphibious extends JDialog implements Runnable {

    JPanel south,north;
    Image img=null;
    Random rand = new Random();
    SplashScreenWindow splashScreen;

    public AddAmphibious(VehiclePanel panel)
    {
        north = new JPanel();
        this.setTitle("Add Amphibious");
        this.setPreferredSize(new Dimension(500, 300));
        north.setLayout(new FlowLayout());
        this.setVisible(true);

        JLabel abilityL =new JLabel("Ability");
        abilityL.setBounds(10,20,80,25);
        north.add(abilityL);

        JTextField abilityT=new JTextField(20);
        abilityT.setBounds(10,20,165,25);
        north.add(abilityT);

        JLabel modelL =new JLabel("Model");
        abilityL.setBounds(10,40,80,25);
        north.add(modelL);

        JTextField modelT=new JTextField(20);
        modelT.setBounds(10,40,165,25);
        north.add(modelT);

        JLabel maxPassengersL =new JLabel("Max Passengers");
        maxPassengersL.setBounds(10,60,80,25);
        north.add(maxPassengersL);

        JTextField maxPassengersT=new JTextField(20);
        maxPassengersT.setBounds(10,60,165,25);
        north.add(maxPassengersT);


        JLabel Max_speedL =new JLabel("max Speed");
        Max_speedL.setBounds(10,80,80,25);
        north.add(Max_speedL);

        JTextField Max_speedT=new JTextField(20);
        Max_speedT.setBounds(10,80,165,25);
        north.add(Max_speedT);

        JLabel road_typeL =new JLabel("Road type");
        road_typeL.setBounds(10,100,80,25);
        north.add(road_typeL);

        JTextField road_typeT=new JTextField(20);
        road_typeT.setBounds(10,100,165,25);
        north.add(road_typeT);

        JLabel avr_fuelL =new JLabel("Average fuel");
        avr_fuelL.setBounds(10,120,80,25);
        north.add(avr_fuelL);

        JTextField avr_fuelT=new JTextField(20);
        avr_fuelT.setBounds(10,120,165,25);
        north.add(avr_fuelT);

        JLabel avr_life_engineL =new JLabel("Average life engine");
        avr_life_engineL.setBounds(10,140,80,25);
        north.add(avr_life_engineL);

        JTextField avr_life_engineT=new JTextField(20);
        avr_life_engineT.setBounds(10,140,165,25);
        north.add(avr_life_engineT);

        JLabel num_of_wheelsL =new JLabel("Number of wheels");
        num_of_wheelsL.setBounds(10,160,80,25);
        north.add(num_of_wheelsL);

        JTextField num_of_wheelsT=new JTextField(20);
        num_of_wheelsT.setBounds(10,160,165,25);
        north.add(num_of_wheelsT);

        JCheckBox with_windC = new JCheckBox("with wind");
        with_windC.setBounds(10,180,165,25);
        north.add(with_windC);

        JLabel flag_countryL =new JLabel("Flag country");
        flag_countryL.setBounds(10,220,80,25);
        north.add(flag_countryL);

        JTextField flag_countryT=new JTextField(20);
        flag_countryT.setBounds(10,220,165,25);
        north.add(flag_countryT);

        JLabel choosePictureL =new JLabel("Choose picture");
        choosePictureL.setBounds(10,260,80,25);
        north.add(choosePictureL);

        JButton choosePictureB =new JButton("Choose");
        choosePictureB.setBounds(10,260,80,25);
        choosePictureB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                int responseFile=fileChooser.showSaveDialog(null);

                if (responseFile==JFileChooser.APPROVE_OPTION)
                {
                    File filePic =new File(fileChooser.getSelectedFile().getAbsolutePath());
                    try{
                        img= ImageIO.read(filePic);
                    }
                    catch (IOException ex)
                    {
                        System.out.println("Cannot load img");
                        return;
                    }
                    System.out.println(filePic);
                }
            }
        });
        north.add(choosePictureB);

        JButton addB =new JButton("Add");
        addB.setBounds(10,280,80,25);
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Amphibious amphibious=new Amphibious(  Integer.parseInt(abilityT.getText()),modelT.getText(),0,Integer.parseInt(maxPassengersT.getText()),
                        Integer.parseInt(Max_speedT.getText()),Integer.parseInt(num_of_wheelsT.getText()),road_typeT.getText(),
                        with_windC.isSelected(),flag_countryT.getText(),
                        Integer.parseInt(avr_fuelT.getText()),Integer.parseInt(avr_life_engineT.getText()),img);


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
                                JOptionPane.showMessageDialog(null,"Amphibious added  !");
                            }
                        }
                    }
                }).start();
                panel.getDealership().add(amphibious);
                System.out.println(amphibious.getImg());
                System.out.println(amphibious.toString());


            }
        });
        north.add(addB);




        this.setPreferredSize(new Dimension(260,580));
        this.setResizable(false);


        this.add(north);
        this.pack();

    }

    public void run()
    {
        this.setVisible(true);
    }
}
