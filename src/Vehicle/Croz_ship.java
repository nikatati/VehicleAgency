package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class Croz_ship extends Water_vehicle implements motorized,commercial_use
{
    public int avr_fuel;
    public int avr_life_engine;

    public Croz_ship(int Ability_to_move, String Model, int Max_passengers, int Max_speed  , int avr_fuel, int avr_life_engine, Image img)
    {
        super(Ability_to_move,Model,0,Max_passengers,Max_speed, true, "Israel",img);
        this.avr_fuel=avr_fuel;
        this.avr_life_engine=avr_life_engine;
    }


    @Override
    public String toString() {
        return "Croz_ship{" +
                "avr_fuel=" + avr_fuel +
                ", avr_life_engine=" + avr_life_engine +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Croz_ship croz_ship = (Croz_ship) o;
        return avr_fuel == croz_ship.avr_fuel && avr_life_engine == croz_ship.avr_life_engine;
    }


    public String license_type(){return "Unlimited";}
    public int Average_fuel_consumption(){return avr_fuel;}
    public int Average_life_of_the_engine(){return avr_life_engine;}
}
