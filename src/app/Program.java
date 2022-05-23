package src.app;
import src.exceptions.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.io.IOException;
public class Program 
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
            throw new WrongNumberOfArguments();
        else
        {
            Path path = Paths.get(args[1]);
            List<String> lst = Files.readAllLines(path);
        }
    }
}