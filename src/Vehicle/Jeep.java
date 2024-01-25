package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Jeep extends Land_vehicle implements motorized,commercial_use
{
    public int avr_fuel;
    public int avr_life_engine;

    public Jeep(int Ability_to_move, String Model, int Max_passengers,
                int Max_speed, String road_type, int avr_fuel, int avr_life_engine, Image img)
    {
        super(Ability_to_move, Model, 0, Max_passengers, Max_speed, 4, road_type,img);
        if (Max_passengers <= 5 && (road_type.equals("dirt") || road_type.equals("paved"))) {
            this.avr_fuel = avr_fuel;
            this.avr_life_engine = avr_life_engine;
        }
    }


    @Override
    public String toString() {
        return super.toString()+"num of wheels:"+ num_of_wheels+"road: " +road_type;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public int Average_fuel_consumption()
    {
        return avr_fuel;
    }
    public int Average_life_of_the_engine()
    {
        return avr_life_engine;
    }
    public String license_type()
    {
        return "MINI";
    }
}
