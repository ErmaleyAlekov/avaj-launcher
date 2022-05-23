package src.classes;

public abstract class Aircraft
{
    private long id;
    private Coordinates coordinates;
    private String name;
    private long idCounter;
    protected Aircraft(String Name, Coordinates obj) {name = Name;coordinates = obj;id = nextId();}
    public long nextId() {return idCounter++;}
}
