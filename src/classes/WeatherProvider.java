package src.classes;

import java.util.ArrayList;

public class WeatherProvider 
{
	private static WeatherProvider weatherProvider;
	private WeatherProvider() {}
	private static String[] weather = { "SNOW", "RAIN", "FOG", "SUN" };
	public static WeatherProvider getProvider() 
	{
		weatherProvider = weatherProvider == null ? new WeatherProvider() : weatherProvider;
		return weatherProvider;
	}
	public String getCurrentWeather(Coordinates obj)
	{
		int count = obj.getLatitude() + obj.getHeight()+obj.getLongitude();
		ArrayList<Integer> lst = new ArrayList<Integer>();int [] res = {0,0,0,0}; int index = 0;
		for (int i =0;i<count;i++)
			lst.add(0 + (int)(Math.random() * 4));
		for (int j = 0;j<lst.size();j++)
		{
			if (lst.get(j) == 0)
				res[0]++;
			if (lst.get(j) == 1)
				res[1]++;
			if (lst.get(j) == 2)
				res[2]++;
			if (lst.get(j) == 3)
				res[3]++;
		}
		int max = 0;
		for (int i = 0;i<res.length;i++)
		{
			for (int j = 0;j<res.length;j++)
			{
				if (res[i] > res[j] && i != j && res[i] > max)
					max = res[i];
				// else
				// 	max = res[j];
			}
			// break;
		}
		for (int i = 0;i<res.length;i++)
			if (res[i] == max)
				index = i;
		return weather[index];
	}
    
}
