package src.classes;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
public class MD5 
{
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get(args[0]);
        List<String> lst = Files.readAllLines(path);
        String str = "";
        String hex = null;
        for (int j =0;j<lst.size();j++)
        {
            try 
            {
                MessageDigest md = MessageDigest.getInstance("MD5");
                str = lst.get(j);
                md.update(str.getBytes());
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hex = sb.toString();
            } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            }
            if (j == 0)
                deleteFile();
            writeToFile(str + " " + hex);
            writeToFile2(hex);
        }
        
    }
    public static void writeToFile(String str) throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("// "+str);
        Path file = Paths.get(System.getProperty("user.dir")+"/src/classes/Base.java");
        List<String> lst = Files.readAllLines(file); int check = 0;
        for (int i =0;i<lst.size();i++)
        {
            if (lst.get(i).indexOf(lines.get(0)) != -1)
                check = 1;
        }
        if (check == 0)
            Files.write(file,lines,StandardCharsets.UTF_8,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    public static void writeToFile2(String str) throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(str);
        Path file = Paths.get(System.getProperty("user.dir")+"/scenario.md5.txt");
        Files.write(file,lines,StandardCharsets.UTF_8,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    public static void deleteFile() throws IOException
    {
        Path file = Paths.get(System.getProperty("user.dir")+"/scenario.md5.txt");
        Files.deleteIfExists(file);
    }
}
