package Data;

public class Coordinates {
    private final long x; //Значение поля должно быть больше -712
    private final long y; //Максимальное значение поля: 858, Поле не может быть null

    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

}
