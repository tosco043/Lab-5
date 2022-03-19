package Core;

import Data.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Stack;


public class FileParser {

    public static Stack<Product> parse(String InputFileName){
        Stack<Product> collectionInput= new Stack<>();
        JSONParser jsonParser;
        jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(InputFileName)){
            Object obj = jsonParser.parse(reader);
            JSONArray productList = (JSONArray) obj;
            collectionInput = saveIntoCollection(productList);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return collectionInput;
    }
    /**
     * This method is used to convert JSONArray to STACK then save into Collection
     */
    @SuppressWarnings("unchecked")
    private static Stack<Product> saveIntoCollection(JSONArray jsArr){
        Stack<Product> AQ = new Stack<>();
        jsArr.forEach(p -> {
            try {
                AQ.push(convertJsonObjIntoProduct((JSONObject) p));
                //AQ.addLast(convertJsonObjIntoProduct((JSONObject) p));
            } catch (java.text.ParseException e){
                e.printStackTrace();
            }
        });
        return AQ;
    }
    /**
     * This method convert JsonObj to Person
     * @return Product which is converted from JsonObject
     * @throws java.text.ParseException throw if occurs error
     */

    private static Product convertJsonObjIntoProduct(JSONObject jsonObject) throws java.text.ParseException {
        Product p = new Product();

        //set ID (generates new ID)
        Long newID = (Long) jsonObject.get("id");
       if(CollectionManager.IDChecker.contains(newID)){
            System.out.println("ID is duplicate, please insert valid input!");
        }
        else{
            CollectionManager.IDChecker.add(newID);
            p.setId(newID);
        }
        //set Name
        p.setName((String)jsonObject.get("name"));

        //set coordinates
        JSONObject coordinatesObj = (JSONObject) jsonObject.get("coordinates");
        p.setCoordinates(new Coordinates((long) coordinatesObj.get("x"), (Long)coordinatesObj.get("y")));

         /*
           parse String to Date
        */

        //date in String
        String stringDate = (String)jsonObject.get("creationDate");

        //build formatter and set date
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate date = LocalDate.parse(stringDate, formatter);
        p.setCreationDate(date);

        //set price
        p.setPrice((Double) jsonObject.get("price"));

        //set unit of measurement
        String unitOfMeasure = (String)jsonObject.get("unitOfMeasure");
        UnitOfMeasure unitOfMeasureEnum = UnitOfMeasure.valueOf(unitOfMeasure);
        p.setUnitOfMeasure(unitOfMeasureEnum);

        /*
         * set Organization details
         */
        Organization o = new Organization();

        JSONObject orgObj = (JSONObject) jsonObject.get("Organization");

        //set organization ID (generates new ID)
        Long newOrgID = (Long) orgObj.get("orgId");
        if(CollectionManager.IDChecker.contains(newOrgID)){
            System.out.println("ID is duplicate, please insert valid input!");
        }
        else{
            CollectionManager.IDChecker.add(newOrgID);
            o.setId(Math.toIntExact(newOrgID));
        }

        //set organization Name
        o.setName((String) orgObj.get("orgName"));

        // set annual turnover
        o.setAnnualTurnover((double) orgObj.get("annualTurnover"));

        //set Organization type
        String orgTypeString = (String)orgObj.get("type");
        OrganizationType typeEnum = OrganizationType.valueOf(orgTypeString);
        o.setType(typeEnum);

        //SET ADDRESS DETAILS
        Address a = new Address();

        JSONObject addressObj = (JSONObject) orgObj.get("Address");
        //set zipcode
        a.setZipCode((String) addressObj.get("zipCode"));

        // set location
        Location l = new Location();
        JSONObject locationObj = (JSONObject)addressObj.get("Location");
        l.setTownName((String) locationObj.get("town"));
        l.setX((Double) locationObj.get("locX"));
        l.setY((Double) locationObj.get("locY"));
        a.setTown(l);

        //set address
        o.setPostalAddress(a);

        p.setManufacturer(o);

        return p;
    }
}