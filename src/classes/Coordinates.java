package src.classes;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    public Coordinates(int longi, int lati,int h)
    {
        longitude = longi;
        latitude = lati;
        height = h;
    }
    public int getLongitude() {return longitude;}
    public int getLatitude() {return latitude;}
    public int getHeight(){return height;}
}
