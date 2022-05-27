package src.classes;

public abstract class Aircraft
{
    protected long id;
    protected Coordinates coordinates;
    protected String name;
    // private long idCounter;
    protected Aircraft(String Name, Coordinates obj) {name = Name;coordinates = obj;id = nextId();}
    public long nextId() {return ++id;}
    public Coordinates getCoordinates() {return coordinates;}
    public String getName() {return name;}
    public long getId() {return id;}
    public void setCoordinates(Coordinates obj) {coordinates = obj;}
}
