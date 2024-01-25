package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Frigate extends Water_vehicle implements motorized
{
    public int avr_fuel;
    public int avr_life_engine;

    public Frigate(int Ability_to_move, String Model, int Max_passengers, int Max_speed  , boolean with_wind, Image img)
    {
        super(Ability_to_move,Model,0,Max_passengers,Max_speed, with_wind, "Israel",img);
        this.avr_fuel=500;
        this.avr_life_engine=4;
    }

    @Override
    public String toString() {
        String str;
        if (with_wind==true)
        {
            str="with the wind.";
        }
        else {str="without the wind.";}

        return super.toString()+"under flag" + flag_country+str+
                "Engine"+Average_fuel_consumption()+", lifetime "+Average_life_of_the_engine();

    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


    public int Average_fuel_consumption()
    {
        avr_fuel=500;
        return avr_fuel;

    }
    public int Average_life_of_the_engine()
    {
        avr_life_engine=4;
        return avr_life_engine;
    }


}
