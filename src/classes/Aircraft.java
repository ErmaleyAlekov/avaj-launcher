package src.classes;

public abstract class Aircraft
{
    private long id;
    private Coordinates coordinates;
    private String name;
    private long idCounter;
    protected Aircraft(String Name, Coordinates obj) {name = Name;coordinates = obj;id = nextId();}
    public long nextId() {return idCounter++;}
    public Coordinates getCoordinates() {return coordinates;}
    public String getName() {return name;}
    public long getId() {return id;}
    public void setCoordinates(Coordinates obj) {coordinates = obj;}
}
