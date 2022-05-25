package src.classes;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates obj) {WeatherProvider weatherProvider = WeatherProvider.getProvider();
		return weatherProvider.getCurrentWeather(obj);}
    public void changeWeather() {conditionChanged();}
}
