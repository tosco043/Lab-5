package Commands;

import Core.CollectionManager;

public class Reorder extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Reorder(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(){
        collectionManager.PrintCollection();
        return true;
    }
}

