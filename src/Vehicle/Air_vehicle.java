package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;
import java.util.Objects;

//-------------Documentation-------------
//The code defines an abstract class Air_vehicle which extends the Vehicle class.
//It contains a protected string variable use_of_air_vehicle which indicates the purpose of the air vehicle.

public abstract class Air_vehicle extends Vehicle implements IAir_vehicle{
    protected String use_of_air_vehicle;

    public Air_vehicle()
    {
        super();
        use_of_air_vehicle="Army";
    }

    Air_vehicle(int Ability_to_move, String Model, int Total_distance, int Max_passengers, int Max_speed, String use_of_air_vehicle, Image img)
    {
        super(Ability_to_move,Model,Total_distance,Max_passengers,Max_speed,img);
        this.use_of_air_vehicle="Army ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Air_vehicle that = (Air_vehicle) o;
        return Objects.equals(use_of_air_vehicle, that.use_of_air_vehicle);
    }


    @Override
    public String toString() {
        return "  use_of_air_vehicle= '" + use_of_air_vehicle + super.toString();
    }

    public String move(){return "move in air";}

}
