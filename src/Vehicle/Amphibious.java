package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Amphibious extends Vehicle implements IWater_vehicle,ILand_vehicle,motorized
{
    private Water_vehicle water_vehicle;
    private Land_vehicle land_vehicle;

    private int avr_fuel,Ability_to_move , Total_distance, Max_passengers, Max_speed  , num_of_wheels,avr_life_engine;
    private String Model,road_type,flag_country;
    private boolean with_wind;
    private Image img;

    public Amphibious(int Ability_to_move, String Model, int Total_distance, int Max_passengers, int Max_speed  , int num_of_wheels,
                      String road_type, boolean with_wind, String flag_country, int  avr_fuel, int  avr_life_engine, Image img)
    {
        super(Ability_to_move, Model,  Total_distance, Max_passengers,  Max_speed,img);
        this.Ability_to_move=Ability_to_move;
        this.Model=Model;
        this.Total_distance=0;
        this.Max_passengers=Max_passengers;
        this.Max_speed=Max_speed;
        this.num_of_wheels=num_of_wheels;
        this.road_type="paved";
        this.with_wind=with_wind;
        this.flag_country=flag_country;
        this.avr_life_engine=avr_life_engine;
        this.avr_fuel=avr_fuel;
        this.img=img;
        water_vehicle=new Frigate(Ability_to_move, Model, Max_passengers,  Max_speed  , with_wind,img);
        land_vehicle=new Jeep( Ability_to_move,  Model,  Max_passengers,  Max_speed,  road_type,  avr_fuel,  avr_life_engine,img);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Ability move"+Ability_to_move+
                "Model"+Model+
                "Total dis"+Total_distance+
                "Max passengers"+Max_passengers+
                "Max speed"+Max_speed+
                "road type"+road_type+
                "avr_life_engine" + avr_life_engine+
                "ave fuel"+avr_fuel;
    }

    public String move(){return  "move on land and water";}
    public int Average_fuel_consumption(){return avr_fuel; }

    public void setFlag_country(String flag_country) {
        this.flag_country = flag_country;
    }

    public int Average_life_of_the_engine(){return avr_life_engine;}
}
