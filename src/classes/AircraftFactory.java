package src.classes;

public abstract class AircraftFactory 
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (type.equals("Baloon"))
			return new Baloon(name, new Coordinates(longitude, latitude,
					height));
		if (type.equals("JetPlane"))
			return new JetPlane(name, new Coordinates(longitude, latitude,
					height));
		return new Helicopter(name, new Coordinates(longitude, latitude,
				height));
    }
}
