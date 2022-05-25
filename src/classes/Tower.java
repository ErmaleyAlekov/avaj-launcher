package src.classes;
import java.util.ArrayList;
import src.app.Program;

public class Tower 
{
    private ArrayList<Flyable> lst = new ArrayList<Flyable>();

    public void register(Flyable obj) 
    {
        try {
            Aircraft aircraft = Aircraft.class.cast(obj);
            String str = "Tower says: ";
            lst.add(obj);
            if (obj instanceof Baloon)
                str +="Baloon";
            if (obj instanceof JetPlane)
                str +="JetPlane";
            if (obj instanceof Helicopter)
                str +="Helicopter";
            Program.writeToFile(str +"#"+aircraft.getName()+"("+ aircraft.getId()+") registered to weather tower.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void unregister(Flyable obj) 
    {
        try {
            Aircraft aircraft = Aircraft.class.cast(obj);
            lst.add(obj);
            String str = "Tower says: ";
            if (obj instanceof Baloon)
                str +="Baloon";
            if (obj instanceof JetPlane)
                str +="JetPlane";
            if (obj instanceof Helicopter)
                str +="Helicopter";
            Program.writeToFile(str +"#"+aircraft.getName()+"("+ aircraft.getId()+") unregistered from weather tower.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void conditionChanged() 
    {
        ArrayList<Flyable> lst2 = lst;
        for (int i = 0;i<lst2.size();i++)
            lst2.get(i).updateConditions();
    }
}
