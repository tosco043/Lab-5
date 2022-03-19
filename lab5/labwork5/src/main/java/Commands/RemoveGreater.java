package Commands;

import Core.CollectionManager;
import Core.CommandAsker;

public class RemoveGreater extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final CommandAsker commandAsker;
    public RemoveGreater(CollectionManager c, CommandAsker a){
        this.collectionManager = c;
        this.commandAsker = a;
    }

    @Override
    public boolean execute(){
        collectionManager.removeGreater(commandAsker.createProduct());
        return true;
    }
}
