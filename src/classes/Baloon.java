package src.classes;

import java.io.IOException;

import src.app.Program;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower w;
    protected Baloon (String Name, Coordinates obj) {super(Name, obj);}
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
                longitude += 2;
				height += 4;
                try {
                    Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
						+ "УРА СЕГОДНЯ СОЛНЕЧНО!");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
                
            }
            if (currentWeather.equals("RAIN"))
            {
                try {
                    height -= 5;
                    Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
                            + "УРА БЕЗПЛАТНЫЙ ДУШ!");
                    if (height <= 0)
                    {
                        Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
                            + "ИДУ НА ПОСАДКУ!");w.unregister(this);w=null;return;
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                
            }
            if (currentWeather.equals("SNOW"))
            {
                try {
                    height -= 15;
                    Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
                            + "НАДО ОДЕТЬСЯ ТЕПЛЕЕ!");
                    if (height <= 0)
                    {
                        Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
                            + "ИДУ НА ПОСАДКУ!");w.unregister(this);w=null;return;
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                
            }
            if (currentWeather.equals("FOG"))
            {
                try {
                    height -= 3;
                    Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
                            + "НИЧЕГО НЕ ВИДНО!");
                    if (height <= 0)
                    {
                        Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
                            + "ИДУ НА ПОСАДКУ!");w.unregister(this);w=null;return;
                    }
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
                Program.writeToFile("Baloon#" + getName() + "(" + getId() + "): "
            + "ИДУ НА ПОСАДКУ!");w.unregister(this);w= null;return;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        setCoordinates(new Coordinates(longitude, latitude, height));
    }
    @Override
    public void registerTower(WeatherTower obj) {w = obj;w.register(this);}
}
