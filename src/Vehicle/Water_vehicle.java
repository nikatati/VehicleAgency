package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;
//-------------Documentation-------------
//This is a Java abstract class named "Water_vehicle" which extends the "Vehicle" abstract class.
// It includes three instance variables: "with_wind" of type boolean, and "flag_country" of type String
// which represents the flag country of the water vehicle.
public abstract class Water_vehicle extends Vehicle implements IWater_vehicle{

    protected boolean with_wind;
    protected String flag_country;

    public Water_vehicle()
    {
        with_wind=false;
        flag_country=null;
    }

    Water_vehicle(int Ability_to_move, String Model, int Total_distance, int Max_passengers, int Max_speed, boolean with_wind, String flag_country, Image img)
    {
        super(Ability_to_move,Model,Total_distance,Max_passengers,Max_speed,img);
        this.with_wind=with_wind;
        this.flag_country=flag_country;
    }

    public void setFlag_country(String flag_country) {
        this.flag_country = flag_country;
    }

    public String getFlag_country(){return this.flag_country;}

    @Override
    public String toString() {
        return "water_vehicle{" +
                "with_wind=" + with_wind +
                ", flag_country='" + flag_country + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Water_vehicle that = (Water_vehicle) o;
        return with_wind == that.with_wind && Objects.equals(flag_country, that.flag_country);
    }

    public void setFlagCountry(String flag_country){this.flag_country=flag_country;}

    public String move(){return "move on water";}


}

