package Commands;

import Core.CollectionManager;
import Core.InputChecker;

public class CountLessThanOfficialAddress extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;

    public CountLessThanOfficialAddress(CollectionManager c, InputChecker i){
        this.collectionManager = c;
        this.inputChecker = i;
    }
    public  boolean execute(String argument){
        if (inputChecker.nameValidCheck()){
            String nameString = String.valueOf(argument);
            if(collectionManager.filterContainsName(nameString))
                return true;
        }
        return true;
    }
}
