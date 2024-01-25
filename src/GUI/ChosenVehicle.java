package GUI;

import Vehicle.Vehicle;
import GUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChosenVehicle extends JDialog implements Runnable
{
    JPanel north;
    Thread ThreadTest;
    Random rand = new Random();
    boolean isSleeping;
    SplashScreenWindow splashScreen;

    //---------------------------------------------

    public ChosenVehicle(VehiclePanel panel, Vehicle vehicle)
    {
        this.setTitle("Chosen Vehicle");
        north = new JPanel();


        JButton testDriveB = new JButton("Test Drive");
        testDriveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestDrive testDrive = new TestDrive(panel, vehicle);
                ThreadTest = new Thread(testDrive);
                ThreadTest.start();
                System.out.println(ThreadTest.isAlive());


            }
        });


        JButton buyB = new JButton("Buy");
        buyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < panel.getDealership().size(); i++) {
                    if (panel.getDealership().get(i).equals(vehicle))
                    {
                        int numAtARR=i;
                        new Thread(new Runnable()
                        {
                            public void run() {
                                try {
                                    isSleeping=true;
                                    System.out.println("The tread is sleep:"+isSleeping);
                                    System.out.println("The random number: "+rand.nextInt(6000) + 5000);
                                    Thread.sleep(rand.nextInt(10000-5000) + 5000);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }

                                synchronized (vehicle)
                                {
                                    SwingUtilities.invokeLater(new Runnable()
                                    {
                                        public void run() {
                                            int choice = JOptionPane.showOptionDialog(null,
                                                    "Are you sure?",
                                                    "Confirmation",
                                                    JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,
                                                    new String[]{"Yes", "No"},
                                                    "No");
                                            if (choice == JOptionPane.YES_OPTION)
                                            {
                                                    waitingWindow();
                                                    System.out.println("User clicked Yes");
                                                    panel.getDealership().remove(numAtARR);

                                            }
                                            else
                                                {
                                                    System.out.println("User clicked No");
                                                }
                                            isSleeping=false;
                                            System.out.println("The tread is sleep:"+isSleeping);
                                        }
                                    });
                                }
                            }
                        }).start();


                    }
                }
            }
        });

        north.add(testDriveB);
        north.add(buyB);
        //this.setPreferredSize(new Dimension(400,400));
        this.setBounds(20, 20, 300, 200);
        this.add(north);

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
                    }
                }
            }
        }).start();
    }
}
