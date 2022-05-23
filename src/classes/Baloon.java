package src.classes;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower o;
    protected Baloon (String Name, Coordinates obj) {super(Name, obj);}
    @Override
    public void updateConditions() {}
    @Override
    public void registerTower(WeatherTower obj) {o = obj;}
}
