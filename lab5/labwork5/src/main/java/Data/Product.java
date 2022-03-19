package Data;

import java.time.LocalDate;


public class Product {
    private Long id; // Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double price; //Поле может быть null, Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    private Organization manufacturer; //Поле не может быть null


    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String toString(){
        String detail = ("Name: " + name + '\n');
        detail += ("ID: "+ id + '\n');
        detail += ("Price: " + price + '\n');
        detail += ("Coordinates: " + '\n');
        detail += ("x: "+ coordinates.getX()+ '\n');
        detail += ("y: "+ coordinates.getY()+ '\n');
        detail += ("Creation date: "+ creationDate.toString() + '\n');
        detail += ("Unit of measure: "+ unitOfMeasure + '\n');
        detail += ("Manufacturer: "+ manufacturer.toString() + '\n');
        return detail;
    }

    public double compareTo(Object o) {
        Product product = (Product) o;
        return (getPrice() - product.getPrice());
    }
}