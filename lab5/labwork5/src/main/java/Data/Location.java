package Data;

public class Location {
    private double x; //Поле не может быть null
    private double y;
    private String townName; //Длина строки не должна быть больше 713, Поле может быть null

    public Location(Float x, double y, String townName) {
        this.x = x;
        this.y = y;
        this.townName = townName;
    }

    public Location() {

    }

    public double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName){
        this.townName = townName;
    }

    public String toString(){
        String locDetail =("                   locX: "+ x + '\n');
             locDetail += ("                   locY: "+ y + '\n');
             locDetail += ("                   town: "+ townName);
             return locDetail;
    }
}
