package Core;

import Data.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class CommandAsker {
    private final InputChecker inputChecker;

    public CommandAsker(InputChecker inputChecker){
        this.inputChecker = inputChecker;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public Product createProduct() {
        Product newProduct = new Product();
        System.out.println("Creating a new product into collection");

        newProduct.setId(idAsker());
        newProduct.setName(nameAsker());
        newProduct.setCoordinates(coordinatesAsker());
        newProduct.setPrice(priceAsker());
        newProduct.setCreationDate(creationDateAsker());
        newProduct.setUnitOfMeasure(unitOfMeasureAsker());
        newProduct.setManufacturer(manufacturerAsker());
        return newProduct;
    }



    public Long idAsker(){
        System.out.println("ID is automatically generated");
        long newID = new Random().nextInt();
        if(CollectionManager.IDChecker.contains(newID) || newID <= 0){
            System.out.println("repeated ID");
            return idAsker();
        }
        else{
            CollectionManager.IDChecker.add(newID);
            System.out.println("ID = " + newID + " has been successfully generated!");
            return  newID;
        }
    }

    public String nameAsker(){
        System.out.println("Insert name: ");
        return (scanner.nextLine());
    }

    public Coordinates coordinatesAsker(){
        System.out.println("Insert coordinates: ");
        while(true){
            System.out.println("Insert the x and y respectively");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 2){
                System.out.println("please insert numbers (x and y respectively)");
            }
            else{
                if(!inputChecker.longValidCheck(inputNumber[0], (long) -712, Long.MAX_VALUE)) continue;
                if(!inputChecker.longValidCheck(inputNumber[1], Long.MIN_VALUE, (long) 858)) continue;
                long x = Long.parseLong(inputNumber[0]);
                Long y = Long.parseLong(inputNumber[1]);
                return new Coordinates(x, y);
            }
        }
    }
    public Double priceAsker() {
        System.out.println("Insert price in rubles: ");
        String pri = scanner.nextLine();
        Double price = Double.parseDouble(pri);
            if (!inputChecker.doubleValidCheck(pri, 1.00, Double.MAX_VALUE)) {
                System.out.println("Insert price in form ##.##: ");
                return priceAsker();
            }
            else{return price;}
    }

    public LocalDate creationDateAsker(){
        System.out.println("Creation date is automatically generated");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        return date;
    }

    public UnitOfMeasure unitOfMeasureAsker() {
        while(true) {
            System.out.println("Insert the unit of measurement: ");
            String[] unit = scanner.nextLine().trim().split(" ");
            if(unit.length == 0){
                unit = null;
            }
            assert unit != null;
            if (unit.length > 1){
                System.out.println("Please insert the correct unit of measurement");
                continue;
            }
            try{
                return UnitOfMeasure.valueOf(unit[0]);
            } catch(IllegalArgumentException e){
                System.out.println("Invalid unit!");
                System.out.println("Please insert one of the following");
                for(UnitOfMeasure unitOfMeasure : UnitOfMeasure.values()){
                    System.out.println(unitOfMeasure);
                }
            }
        }
    }


    public Organization manufacturerAsker(){
        System.out.println("DETAILS ABOUT THE MANUFACTURER: ");

        Organization newOrganization = new Organization();

        newOrganization.setId(orgIdAsker());
        newOrganization.setName(orgNameAsker());
        newOrganization.setAnnualTurnover(annualTurnoverAsker());
        newOrganization.setType(typeAsker());
        newOrganization.setPostalAddress(postalAddressAsker());

        return newOrganization;
    }

    public long orgIdAsker() {
        System.out.println("Organization ID is automatically generated");
        long newID = new Random().nextInt();
        if (CollectionManager.IDChecker.contains(newID) || newID <= 0) {
            System.out.println("Input is invalid");
        }
        return newID;
    }

    public String orgNameAsker(){
        System.out.println("NOTE: PUT A '_' BETWEEN EACH WORD IF THE NAME IS MORE THAN A WORD");
        System.out.println("Insert name: ");
        return (scanner.nextLine());
    }

    public double annualTurnoverAsker() {
        System.out.println("Insert annual turnover: ");

        String pri = scanner.nextLine();
        double annualTurnover = Double.parseDouble(pri);
        inputChecker.doubleValidCheck(pri, 1.00, Double.MAX_VALUE);
        return annualTurnover;
    }

    public OrganizationType typeAsker(){
        while(true) {
            System.out.println("Insert the organization type: ");
            String[] type = scanner.nextLine().trim().split(" ");
            if (type.length != 1){
                System.out.println("Please insert the correct organization type");
                continue;
            }
            try{
                return OrganizationType.valueOf(type[0]);
            } catch(IllegalArgumentException e){
                System.out.println("Invalid type!");
                System.out.println("Please insert one of the following");
                for(OrganizationType organizationType : OrganizationType.values()){
                    System.out.println(organizationType);
                }
            }
        }
    }

    public Address postalAddressAsker(){
        System.out.println("Put in the address details");

        Address newAddress = new Address();

        newAddress.setZipCode(zipCodeAsker());
        newAddress.setTown(locationAsker());

        return newAddress;
    }

    public String zipCodeAsker(){
        System.out.println("Insert to zip code");
        String str = scanner.nextLine();
        if(str.contains(" ")){
            System.out.println("please zip code must not contain space");
            return zipCodeAsker();
        }
        else if (!inputChecker.zipCodeValidCheck(str))
            {return str;}
        return str;
    }

    public Location locationAsker(){
        System.out.println("Put in the location details");

        Location newLocation = new Location();

        newLocation.setX(LocationXAsker());
        newLocation.setY(LocationYAsker());
        newLocation.setTownName(LocationNameAsker());

        return newLocation;
    }

    public Double LocationXAsker(){
        System.out.println("Insert x: ");
        double LocationX;
        LocationX = doubleAsker(Float.MIN_VALUE, Float.MAX_VALUE);
        return LocationX;
    }

    public double LocationYAsker(){
        System.out.println("Insert y: ");
        double LocationY;
        LocationY = doubleAsker(Double.MIN_VALUE, Double.MAX_VALUE);
        return LocationY;
    }

    public String LocationNameAsker() {
        System.out.println("Insert name: ");
        String str = scanner.nextLine();
        if(str.length() >713){
            System.out.println("No such place exists");
            return LocationNameAsker();
        }
        return  str;
    }



    public double doubleAsker(double min, double max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one double number: ");
            }
            else{
                double x;
                try {
                    x = Double.parseDouble(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an double number");
                }
            }
        }
    }
}

