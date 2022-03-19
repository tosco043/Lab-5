package Commands;

import Core.CollectionManager;
import Core.CommandAsker;

public class Add extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final CommandAsker commandAsker;

    public Add(CollectionManager cm, CommandAsker ca){
        this.collectionManager = cm;
        this.commandAsker = ca;
    }

    @Override
    public boolean execute() {
        collectionManager.add(commandAsker.createProduct());
        return true;
    }
}
