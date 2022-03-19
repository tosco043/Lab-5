package Data;

public class Address {
    private String zipCode; //Длина строки не должна быть больше 30, Поле может быть null
    private Location town; //Поле может быть null

    /**public Address(String zipCode, Location town) {
        this.zipCode = zipCode;
        this.town = town;
    }**/

    public Address() {

    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    public Location getTown() {

        return town;
    }

    public String toString(){
        String addDetail = ("               zip code: "+ zipCode + '\n');
               addDetail +=("               Location"+ '\n' + town.toString() + '\n');
               return addDetail;
    }

}
