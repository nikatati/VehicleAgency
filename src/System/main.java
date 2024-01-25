package System;

import java.util.ArrayList;
import java.util.Scanner;
import Vehicle.*;
import GUI.*;

//-------------Documentation-------------
//This is a vehicle rental agency program that allows
// users to add different types of vehicles to the agency,
// buy and test drive them, and change the country flag in every vehicle.
// The program uses inheritance to create different types of vehicles such as
// Jeep, Spy Glider, Game Glider, and Frigate.

public class main {
    public static void main(String[] args)
    {
       /* ArrayList<Vehicle> dealership = new ArrayList<Vehicle>();
        int Ability_to_move=0,Total_distance=0,Max_passengers=0,Max_speed=0,avr_fuel=0,avr_life_engine=0,num_of_wheels;
        String Model, power_source, energy_score;
        boolean with_wind=false;
        String road_type=null,flag_country=null;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int counterVehicle, type_vehicle,type_vehicle_spe;


        System.out.println("Go ahead and build your vehicle rent agency !");
        System.out.println("How many vehicles do you want in your agency ?");
        counterVehicle=scanner.nextInt();

        for (int i = 0; i < counterVehicle; i++)
        {
            System.out.println("Choose your vehicle:");
            System.out.println("Type: 1-Land vehicle | 2-Air vehicle |3-Water vehicle");
            type_vehicle = scanner.nextInt();  // Read user input

            if (type_vehicle == 1)
            {
                System.out.println("Land vehicle");
                System.out.println("Choose: 1- Jeep | 2- Bicycle | 3- Amphibious");
                type_vehicle_spe=scanner.nextInt();
                if (type_vehicle_spe==1)
                {
                    System.out.println("Enter Model");
                    Model=scanner.next();
                    System.out.println("Enter Max passengers");
                    Max_passengers=scanner.nextInt();
                    System.out.println("Enter Max speed");
                    Max_speed=scanner.nextInt();
                    System.out.println("Enter road type (dirt/paved)");
                    road_type=scanner.next();
                    System.out.println("Enter average fuel");
                    avr_fuel=scanner.nextInt();
                    System.out.println("Enter average life engine");
                    avr_life_engine= scanner.nextInt();
                    Jeep jeep = new Jeep(Ability_to_move,Model,Max_passengers,Max_speed,road_type,avr_fuel,avr_life_engine);
                    dealership.add(jeep);
                }
                if (type_vehicle_spe==2)
                {
                    System.out.println("Enter Model");
                    Model=scanner.next();
                    System.out.println("Enter Max passengers");
                    Max_passengers=scanner.nextInt();
                    System.out.println("Enter Max speed");
                    Max_speed=scanner.nextInt();
                    System.out.println("Enter road type (dirt/paved)");
                    road_type=scanner.next();
                    System.out.println("Enter average fuel");
                    avr_fuel=scanner.nextInt();
                    System.out.println("Enter average life engine");
                    avr_life_engine= scanner.nextInt();
                    Bicycle bicycle = new Bicycle(Ability_to_move,Model,Max_passengers,Max_speed,road_type);
                    dealership.add(bicycle);
                }
                if (type_vehicle_spe==3)
                {
                    System.out.println("Enter Model");
                    Model=scanner.next();
                    System.out.println("Enter Max passengers");
                    Max_passengers=scanner.nextInt();
                    System.out.println("Enter Max speed");
                    Max_speed=scanner.nextInt();
                    System.out.println("Enter road type (dirt/paved)");
                    road_type=scanner.next();
                    System.out.println("Enter average fuel");
                    avr_fuel=scanner.nextInt();
                    System.out.println("Enter average life engine");
                    avr_life_engine= scanner.nextInt();
                    System.out.println("Enter num of wheels");
                    num_of_wheels=scanner.nextInt();
                    System.out.println("Enter flag country");
                    flag_country=scanner.next();

                    Amphibious amphibious = new  Amphibious( Ability_to_move,  Model,  Total_distance,  Max_passengers,  Max_speed,
                            num_of_wheels, road_type,  with_wind,flag_country,  avr_fuel,  avr_life_engine);
                    dealership.add(amphibious);
                }

            }

            else if (type_vehicle == 2)
            {
                System.out.println("Air vehicle");
                System.out.println("Choose: 1- Spy gilder | 2- Game gilder");
                type_vehicle_spe=scanner.nextInt();
                if (type_vehicle_spe==1)
                {
                    System.out.println("~Spy gilder~");
                    System.out.println("Enter power source");
                    power_source=scanner.next();
                    System.out.println("Enter energy score");
                    energy_score= scanner.next();
                    Spy_glider spy_glider=new Spy_glider(Ability_to_move,power_source,energy_score);
                    dealership.add(spy_glider);
                }
                if (type_vehicle_spe==2)
                {
                    System.out.println("~Game gilder~");
                    Game_glider game_glider=new Game_glider(Ability_to_move);
                    dealership.add(game_glider);
                }
            }

            else if (type_vehicle == 3)
            {
                System.out.println("Water vehicle");
                System.out.println("Choose: 1- Frigate | 2- Croz ship| 3- Amphibious");
                type_vehicle_spe=scanner.nextInt();

                if (type_vehicle_spe==1)
                {
                    System.out.println("~Frigate~");
                    System.out.println("Enter Max passengers");
                    Max_passengers=scanner.nextInt();
                    System.out.println("Enter Max speed");
                    Max_speed=scanner.nextInt();
                    System.out.println("Enter Model");
                    Model=scanner.next();
                    System.out.println("Enter 1-With wind |2-Without wind");
                    int temp2=scanner.nextInt();
                    if (temp2==1)
                    {
                        with_wind = true;

                    }
                    else
                            {
                                with_wind = false;
                            }
                        Frigate frigate = new Frigate(Ability_to_move, Model, Max_passengers, Max_speed, with_wind);
                        dealership.add(frigate);

                }



                if (type_vehicle_spe==2)
                {
                    System.out.println("~Croz ship~");
                    System.out.println("Enter Max passengers");
                    Max_passengers=scanner.nextInt();
                    System.out.println("Enter Max speed");
                    Max_speed=scanner.nextInt();
                    System.out.println("Enter Model");
                    Model=scanner.next();
                    Croz_ship croz_ship = new Croz_ship(Ability_to_move, Model, Max_passengers, Max_speed, avr_fuel, avr_life_engine);
                    dealership.add(croz_ship);
                }

                if (type_vehicle_spe==3)
                {
                    System.out.println("Enter Model");
                    Model=scanner.next();
                    System.out.println("Enter Max passengers");
                    Max_passengers=scanner.nextInt();
                    System.out.println("Enter Max speed");
                    Max_speed=scanner.nextInt();
                    System.out.println("Enter road type (dirt/paved)");
                    road_type=scanner.next();
                    System.out.println("Enter average fuel");
                    avr_fuel=scanner.nextInt();
                    System.out.println("Enter average life engine");
                    avr_life_engine= scanner.nextInt();
                    System.out.println("Enter num of wheels");
                    num_of_wheels=scanner.nextInt();
                    System.out.println("Enter flag country");
                    flag_country=scanner.next();

                    Amphibious amphibious = new  Amphibious( Ability_to_move,  Model,  Total_distance,  Max_passengers,  Max_speed,
                            num_of_wheels, road_type,  with_wind,flag_country,  avr_fuel,  avr_life_engine);
                    dealership.add(amphibious);

                }





            }
        }

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Buy a vehicle from the dealership");
            System.out.println("2. Take a vehicle to a test drive");
            System.out.println("3. Reset all cars the availability to move");
            System.out.println("4.Change the country flag in every vehicle");
            System.out.println("5. Exit the system");
            int option = scanner.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("Available vehicles:");
                    for (Vehicle vehicle : dealership)
                    {
                        System.out.println(vehicle.toString());
                    }

                    System.out.println("Enter the model of the vehicle you want to buy:");
                    String want_to_buy=scanner.next();
                    for (int i=0;i<counterVehicle;i++)
                    {
                        if (dealership.get(i).getModel().equals(want_to_buy))
                        {
                            System.out.println("Purchase made successfully");
                            dealership.remove(i);
                        }
                        else {
                        System.out.println("The vehicle does not exist");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter model of the car:");
                    String take_to_test=scanner.next();
                    System.out.println("Enter distance of the test drive:");
                    int testDrive=scanner.nextInt();
                    for (int i=0;i<counterVehicle;i++)
                    {
                        if (dealership.get(i).getModel().equals(take_to_test))
                        {
                            dealership.get(i).setAbility_to_move(testDrive);
                            System.out.println("The test drive was good. The distance has been updated");
                        }
                        else
                            {
                                System.out.println("Vehicle do not exist");
                            }
                    }
                    break;
                case 3:
                    for (int i=0;i<counterVehicle;i++)
                    {
                       dealership.get(i).setAbility_to_move(0);

                    }
                    break;
                case 4:
                    System.out.println("enter a new country flag");
                    String newCountryFlag=scanner.next();
                    for (int i=0;i<counterVehicle;i++)
                    {
                        if (dealership.get(i) instanceof Water_vehicle)
                        {
                            ((Water_vehicle) dealership.get(i)).setFlag_country(newCountryFlag);
                            System.out.println("Now all the water vehicles are from "+((Water_vehicle) dealership.get(i)).getFlag_country());
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }*/


        VehicleEntryWindow vehicleEntryWindow=new VehicleEntryWindow();
        

    }
}