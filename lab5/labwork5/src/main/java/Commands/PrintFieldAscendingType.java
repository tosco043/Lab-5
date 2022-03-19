package Commands;

import Core.CollectionManager;
import Data.Organization;
import java.util.ArrayList;


public class PrintFieldAscendingType extends AbstractCommand {
    private final CollectionManager collectionManager;

    public  PrintFieldAscendingType (CollectionManager c){
        this.collectionManager = c;
    }
    public boolean execute() {
        ArrayList<Organization> orgArray = collectionManager.getOrgArray();
        orgArray.forEach(System.out::println);
        return true;
    }
}
