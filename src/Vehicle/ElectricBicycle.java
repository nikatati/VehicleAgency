package Vehicle;

import java.awt.*;

public class ElectricBicycle extends Bicycle implements motorized,electric
{

    public int avr_fuel;
    public int avr_life_engine;

    public ElectricBicycle(int Ability_to_move, String Model, int Max_passengers, int Max_speed, String road_type,int avr_life_engine, Image img)
    {
        super(Ability_to_move, Model, Max_passengers,  Max_speed, road_type, img);
        this.avr_fuel=20;
        this.avr_life_engine=avr_life_engine;
    }
    public int Average_fuel_consumption(){return avr_fuel;}
    public int Average_life_of_the_engine(){return avr_life_engine;}
    public boolean isElectric(){return  true;}

    @Override
    public String toString() {
        return super.toString()+" Electric| "+ " avr_life_engine->"+avr_life_engine+ " avr_fuel->" +avr_fuel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
