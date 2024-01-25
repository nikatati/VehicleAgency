package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bicycle extends Land_vehicle implements not_motorized
{


    public Bicycle(int Ability_to_move, String Model, int Max_passengers, int Max_speed, String road_type, Image img)
    {
        super(Ability_to_move, Model, 0, Max_passengers, Max_speed, 2, road_type,img);
    }

    @Override
    public String toString() {
        return super.toString()+"num of wheels:"+ num_of_wheels+"road: " +road_type;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public String power_source() {return "A";}
    public String energy_score() {return "Manual";}
}
