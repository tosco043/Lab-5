package Data;

public class Organization {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String fullName; //Поле не может быть null, Строка не может быть пустой
    private double annualTurnover; //Значение поля должно быть больше 0
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private OrganizationType type; //Поле не может быть null
    private Address postalAddress; //Поле не может быть null

    /**public Organization(int id, String name, float annualTurnover, OrganizationType type, Address postalAddress) {
        this.id = id;
        this.name = name;
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = postalAddress;
    }**/

    public Organization() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public double getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(double annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }




    public String toString(){
         String orgDetail =(" ID: "+ id + '\n' );
               orgDetail +=("             name: "+ fullName + '\n' );
               orgDetail +=("             Ann. turnover: "+ annualTurnover + '\n' );
               orgDetail +=("             type: "+ type + '\n' );
               orgDetail +=("          Address: "+'\n' + postalAddress.toString() + '\n' );
               return orgDetail;
    }
}
