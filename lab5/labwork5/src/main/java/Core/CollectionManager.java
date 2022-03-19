package Core;

import Data.Organization;
import Data.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CollectionManager {
    private Stack<Product> listProduct = new Stack<>();
    public static HashSet<Long> IDChecker = new HashSet<>();
    private final LocalDate creationDate = LocalDate.now();
    public void readInputFromJSONFile(String InputFileName){
        System.out.println(InputFileName);
        listProduct =  FileParser.parse(InputFileName);
    }

    public LocalDate getCreationDate(){
        return this.creationDate;
    }
    public int size(){
        return listProduct.size();
    }

    public void PrintCollection(){
        listProduct.forEach(p -> System.out.println(p.toString()));
    }

    public void add(Product P){
        listProduct.push(P);
    }

    public void removeGreater(Product P){
        boolean judge = true;
        for (Product product : listProduct) {
            if (P.compareTo(product) < 0) {
                judge = false;
            }
        }
        if (judge) {
            listProduct.remove(P);
        }
    }
    public void removeLower(Product P){
        boolean judge = true;
        for (Product product : listProduct){
            if (P.compareTo(product) > 0){
                judge = false;
                break;
            }
        }
        if(judge){
            listProduct.remove(P);
        }
    }

    public boolean removeById(Long id){
        boolean flag = false;
        for(Iterator<Product> iterator = listProduct.iterator(); iterator.hasNext();){
            Product product = iterator.next();
            if(product.getId().equals(id)){
                flag = true;
                iterator.remove();
            }
        }
        return !flag;
    }

    public void clear(){
        listProduct.clear();
    }

    public boolean countByManufacturer(String nameString){
        int counter =0;
        for (Product product : listProduct){
            if (nameString.equals(product.getManufacturer().getName()))
                counter = counter+1;
        }
        System.out.println(counter);
        return true;
    }

    public boolean filterContainsName(String nameString){
        for (Product product : listProduct){
            if (product.getName().contains(nameString))
                System.out.println("listProduct.element()");
        }
        return true;
    }

    public ArrayList<Organization> getOrgArray(){
        ArrayList<Organization> result = new ArrayList<>();
        listProduct.forEach(product -> result.add(product.getManufacturer()));
        System.out.println(result);
        return result;
    }


    @SuppressWarnings("unchecked")
    public void save(String filename){

        JSONArray ProductList = new JSONArray();
        for(Product product : listProduct) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", product.getId());
            jsonObject.put("name", product.getName());

            //write coordinates to file
            JSONObject coordinatesObj = new JSONObject();
            coordinatesObj.put("x", product.getCoordinates().getX());
            coordinatesObj.put("y", product.getCoordinates().getY());
            jsonObject.put("coordinates", coordinatesObj);

            //write location to file
            JSONObject locationObj = new JSONObject();
            locationObj.put("locX", product.getManufacturer().getPostalAddress().getTown().getX());
            locationObj.put("locY", product.getManufacturer().getPostalAddress().getTown().getY());
            locationObj.put("town", product.getManufacturer().getPostalAddress().getTown().getTownName());

            //write address to file
            JSONObject addressObj = new JSONObject();
            addressObj.put("zipCode", product.getManufacturer().getPostalAddress().getZipCode());
            addressObj.put("Location", locationObj);

            //write manufacturer to file
            JSONObject orgObj = new JSONObject();
            orgObj.put("orgId", product.getManufacturer().getId());
            orgObj.put("orgName", product.getManufacturer().getName());
            orgObj.put("annualTurnover", product.getManufacturer().getAnnualTurnover());
            String s = product.getManufacturer().getType().toString();
            orgObj.put("type", s);
            orgObj.put("Address", addressObj);

            LocalDate date = product.getCreationDate();
            DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE;
            String stringDate = date.format(dateFormat);
            jsonObject.put("creationDate", stringDate);
            jsonObject.put("price", product.getPrice());
            String unitStr = product.getUnitOfMeasure().toString();
            jsonObject.put("unitOfMeasure", unitStr);
            jsonObject.put("Organization", orgObj);

            ProductList.add(jsonObject);

        }

            try{
                FileOutputStream outputStream = new FileOutputStream(filename);
                System.out.println("using file output stream");
                String s = ProductList.toJSONString();
                byte[] bytesArray = s.getBytes();
                outputStream.write(bytesArray);
                outputStream.flush();
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
