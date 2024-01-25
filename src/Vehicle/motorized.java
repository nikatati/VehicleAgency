package Vehicle;
//-------------Documentation-------------
//This code defines an interface called motorized,
// which includes two methods: Average_fuel_consumption() and Average_life_of_the_engine().
// Any class that implements this interface must provide an implementation of these methods.
// The purpose of this interface is to allow for polymorphism between different types of motorized vehicles,
// where the specific implementation of fuel consumption and engine life may vary between different types of vehicles.
public interface motorized
{
    public int Average_fuel_consumption();
    public int Average_life_of_the_engine();
}
