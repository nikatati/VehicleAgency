package Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;
//-------------Documentation-------------
//This is a Java class named Land_vehicle which extends the abstract class Vehicle.
// It represents land-based vehicles and contains attributes such as
// the number of wheels, road type, ability to move, model, total distance, maximum passengers, and maximum speed.
public abstract class Land_vehicle extends Vehicle implements ILand_vehicle
{
    int num_of_wheels;
    String road_type; //סלולה או עפר

    public Land_vehicle() {
        super();
        this.num_of_wheels=0;
        this.road_type="paved";
    }

    public Land_vehicle(int Ability_to_move, String Model, int Total_distance, int Max_passengers, int Max_speed  , int num_of_wheels, String road_type,Image img)
    {
        super(Ability_to_move, Model, Total_distance, Max_passengers, Max_speed,img);
        this.num_of_wheels=num_of_wheels;
        this.road_type=road_type;
    }

    @Override
    public String toString() {
        return "land_vehicle{" +
                "num_of_wheels=" + num_of_wheels + '\'' +
                "road_type="+ road_type+'\''+
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Land_vehicle that = (Land_vehicle) o;
        return num_of_wheels == that.num_of_wheels && Objects.equals(road_type, that.road_type);
    }

    public String move(){return "Move on Land";}


}
