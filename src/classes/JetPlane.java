package src.classes;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower w;
    protected JetPlane(String Name, Coordinates obj) {super(Name, obj);}
    @Override
    public void updateConditions() {}
    @Override
    public void registerTower(WeatherTower obj) {w = obj;}
}
