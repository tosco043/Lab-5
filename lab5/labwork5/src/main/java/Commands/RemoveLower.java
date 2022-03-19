package Commands;

import Core.CollectionManager;
import Core.CommandAsker;

public class RemoveLower extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final CommandAsker commandAsker;
    public RemoveLower(CollectionManager c, CommandAsker a){
        this.collectionManager = c;
        this.commandAsker = a;
    }

    @Override
    public boolean execute(){
        collectionManager.removeLower(commandAsker.createProduct());
        return true;
    }
}
