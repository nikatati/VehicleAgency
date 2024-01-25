package GUI;

import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TestDrive extends JDialog implements Runnable
{

    JPanel north;
    Random rand = new Random();
    VehiclePanel vehiclePanel;
    int distance=0;
    boolean isSleeping;
    SplashScreenWindow splashScreen;

    public TestDrive(VehiclePanel panel, Vehicle vehicle)
    {
        north = new JPanel();
        this.vehiclePanel=panel;
        this.setTitle("Test Drive");

        JLabel DistanceL =new JLabel("Distance ");
        DistanceL.setBounds(10,20,80,25);
        north.add(DistanceL);

        JTextField DistanceT=new JTextField(20);
        DistanceT.setBounds(10,20,165,25);
        north.add(DistanceT);

        JButton takeToTest=new JButton("Take to test");
        takeToTest.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<panel.getDealership().size();i++) {
                    if (panel.getDealership().get(i).equals(vehicle)) {
                        synchronized (panel.getDealership().get(i))
                        {
                            panel.getDealership().get(i).setAbility_to_move(Integer.parseInt(DistanceT.getText()));


                        distance = panel.getDealership().get(i).getAbility_to_move() * 100;


                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    isSleeping = true;
                                    System.out.println("The thread is sleep:" + isSleeping);
                                    setComponentsEnabled(false);
                                    Thread.sleep(distance);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }

                                synchronized (vehicle) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        public void run() {
                                            JOptionPane.showMessageDialog(null, "Updated distance of vehicle: " + vehicle.getAbility_to_move());
                                            setComponentsEnabled(true);
                                            isSleeping = false;
                                            System.out.println("The tread is sleep:" + isSleeping);
                                        }
                                    });
                                }
                            }
                        }).start();
                    }
                }
                    }
                }



        });
        north.add(takeToTest);
        this.add(north);
        //this.setPreferredSize(new Dimension(300,300));
        this.setBounds(10,10,250,150);
    }

    public void run()
    {
        this.setVisible(true);

    }

    private void setComponentsEnabled(boolean enabled)
    {
        for (Component component : north.getComponents()) {
            component.setEnabled(enabled);
        }
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


}
