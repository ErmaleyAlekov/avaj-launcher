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

    public static void parsList(List<String> list) throws IOException
    {
        if (list.size() == 0)
            throw new ErrorFileFormatException();
        int count = 0; List<String> lst = list;
        try {
            count = Integer.parseInt(lst.get(0));
        } catch (Exception e) {
            lst = decrypt(list);
        }
        if (lst.size() == 1)
            throw new ErrorFileFormatException();
        count = Integer.parseInt(lst.get(0));
        try {
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
            throw new ErrorFileFormatException();
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
    public static List<String> decrypt(List<String> list) throws IOException
    {
        Path path = Paths.get(System.getProperty("user.dir")+"/src/classes/Base.java");
        List<String> lst = Files.readAllLines(path);
        List<String> res = new ArrayList<String>();
        if (list.size() <= lst.size())
        {
            for (int i=0;i<list.size();i++)
            {
                int check = 0;
                for (int j=0;j<lst.size();j++)
                {
                    if (lst.get(j).indexOf(list.get(i)) != -1)
                    {
                        ArrayList<String> buff = parsStr(lst.get(j));
                        String buff2 = "";
                        for (int k=0;k<buff.size();k++)
                        {
                            if (k != 0 && k != buff.size() -1)
                            {
                                if (k == buff.size() -2)
                                    buff2 += buff.get(k);
                                else
                                    buff2 += buff.get(k) + " ";
                            }  
                        }
                        res.add(buff2);
                        check = 1;
                    }
                }
                if (check == 0)
                    throw new ErrorFileFormatException();
            }
            return res;
        }
        else
            throw new ErrorFileFormatException();
    }
}