package src.classes;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower w;
    protected Helicopter(String Name, Coordinates obj) {super(Name, obj);}
    @Override
    public void updateConditions() {}
    @Override
    public void registerTower(WeatherTower obj) {w = obj;}
}
