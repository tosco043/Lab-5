package Commands;

import Core.CollectionManager;
import Core.InputChecker;

public class MinOfficialAddress extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;

    public MinOfficialAddress(CollectionManager c, InputChecker i){
        this.collectionManager = c;
        this.inputChecker = i;
    }
    public boolean execute(String argument){
        if(inputChecker.manufacturerValidCheck()){
            String nameString = String.valueOf(argument);
            if(collectionManager.countByManufacturer(nameString))
                return true;
        }
        return true;
    }
}
