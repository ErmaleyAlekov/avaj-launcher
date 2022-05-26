package src.app;
import src.classes.*;
import src.exceptions.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.IOException;
public class Program 
{
    public static void main(String[] args) throws InputOutputException
    {
        if (args.length != 1)
            throw new WrongNumberOfArguments();
        else
        {
            try 
            {
                Path path = Paths.get(args[0]);
                List<String> lst = Files.readAllLines(path);
                parsList(lst);
            } 
            catch (IOException e) 
            {
                throw new InputOutputException();
            }
        }
    }

    public static void parsList(List<String> lst)
    {
        if (lst.size() == 0)
            throw new ErrorFileFormatException();
        try {
            int count = Integer.parseInt(lst.get(0));
            for (int i =0;i<count;i++)
            {
                WeatherTower weatherTower = new WeatherTower();
                writeToFile("----------------------------------------------------------");
                ArrayList<Flyable> flyables = new ArrayList<Flyable>();
                for (int j= 1;j<lst.size();j++)
                {
                    ArrayList<String> lst2 = parsStr(lst.get(j));
                    if (!lst2.get(0).equals("Baloon") && lst2.get(0).equals("Helicopter") && lst2.get(0).equals("JetPlane"))
                        throw new ErrorFileFormatException();
                    if (Integer.parseInt(lst2.get(2)) <= 0 || Integer.parseInt(lst2.get(3)) <= 0 || Integer.parseInt(lst2.get(4)) <= 0)
                        throw new ErrorFileFormatException();
                    if (lst2.size() == 5)
                    {
                        flyables.add(AircraftFactory.newAircraft(lst2.get(0), lst2.get(1), 
                            Integer.parseInt(lst2.get(2)), Integer.parseInt(lst2.get(3)),
                            Integer.parseInt(lst2.get(4))));
                    }
                    else
                        throw new ErrorFileFormatException();
                }
                for (Flyable f : flyables)
                    f.registerTower(weatherTower);
                weatherTower.changeWeather();
                writeToFile("----------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<String> parsStr(String str)
    {
        char buff[] = str.toCharArray();
        StringBuilder res = new StringBuilder();
        ArrayList<String> lst = new ArrayList<String>();
        for (int i = 0;i<str.length();i++)
        {
            if (buff[i] != ' ')
                res.append(buff[i]);
            else
            {
                lst.add(res.toString());
                res = new StringBuilder();
            }
            if (i == str.length() -1)
                lst.add(res.toString());
        }
        return lst;
    }

    public static void writeToFile(String str) throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(str);
        Path file = Paths.get(System.getProperty("user.dir")+"/simulation.txt");
        Files.write(file,lines,StandardCharsets.UTF_8,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}