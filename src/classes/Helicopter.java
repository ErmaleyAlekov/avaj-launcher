package src.classes;

import src.app.Program;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower w;
    protected Helicopter(String Name, Coordinates obj) {super(Name, obj);}
    @Override
    public void updateConditions() 
    {
        WeatherProvider provider = WeatherProvider.getProvider();
        String currentWeather = provider.getCurrentWeather(getCoordinates());
		int longitude = getCoordinates().getLongitude();
		int latitude = getCoordinates().getLatitude();
		int height = getCoordinates().getHeight();
        if (height > 0)
        {
            if (currentWeather.equals("SUN"))
            {
                try {
                    longitude += 10;
                    height += 2;
                    Program.writeToFile("Helicopter#" + getName() + "(" + getId() + "): "
                            + "LANDING!");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                
            }
            if (currentWeather.equals("RAIN"))
            {
                try {
                    longitude += 5;
                    Program.writeToFile("Helicopter#" + getName() + "(" + getId() + "): "
                            + "YES! FREE SHOWER!");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            if (currentWeather.equals("SNOW"))
            {
                try {
                    height -= 12;
                    Program.writeToFile("Helicopter#" + getName() + "(" + getId() + "): "
                            + "SHOULD DRESS WARMER!");
                    if (height <= 0)
                    {
                        Program.writeToFile("Helicopter#" + getName() + "(" + getId() + "): "
                            + "LANDING!");w.unregister(this);w=null;return;
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                
            }
            if (currentWeather.equals("FOG"))
            {
                try {
                    longitude += 1;
                    Program.writeToFile("Helicopter#" + getName() + "(" + getId() + "): "
                            + "I CAN NOT SEE ANYTHING!");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            if (height > 100)
				height = 100;
        }
        else
        {
            try {
                Program.writeToFile("Helicopter#" + getName() + "(" + getId() + "): "
            + "LANDING!");w.unregister(this);w=null;return;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        setCoordinates(new Coordinates(longitude, latitude, height));
    }
    @Override
    public void registerTower(WeatherTower obj) {w = obj;w.register(this);}
}
