package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Spy_glider extends Air_vehicle implements not_motorized
{

    public String power_source;
    public String energy_score;

    public Spy_glider(int Ability_to_move, String power_source, String energy_score, Image img)
    {
        super(Ability_to_move,"privileged",0,1,50,"Army",img);
        this.energy_score=energy_score;
        this.power_source=power_source;
    }
    public String power_source()
    {
        return power_source;
    }
    public String energy_score()
    {
        energy_score="C";
        return  energy_score;
    }

    @Override
    public String toString() {
        return "~~Spy gilder~~ "+super.toString()+"use of vehicle:"+use_of_air_vehicle;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
