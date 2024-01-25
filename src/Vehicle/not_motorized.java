package Vehicle;
//-------------Documentation-------------
//This code defines a Java interface called "not_motorized" which has two abstract methods:
// "power_source()" and "energy_score()".
// Any class that implements this interface must provide concrete implementations for these methods.
// The purpose of this interface is likely to define a contract for classes that represent non-motorized vehicles,
// such as bicycles or sailboats,
// to ensure that they provide certain functionality related to their power source and energy efficiency.

public interface not_motorized {
    public String power_source();
    public String energy_score();
}
