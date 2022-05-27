package src.classes;
import java.util.ArrayList;
import src.app.Program;

public class Tower 
{
    private ArrayList<Flyable> lst = new ArrayList<Flyable>();
    private Aircraft aircraft;
    public void register(Flyable obj) 
    {
        try {
            aircraft = Aircraft.class.cast(obj);
            String str = "Tower says: ";
            lst.add(obj);
            for (int i =0;i<lst.size() - 1;i++)
                aircraft.id = aircraft.nextId();
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
            lst.remove(obj);
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
