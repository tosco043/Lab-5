package Commands;

import Core.CollectionManager;

public class Show extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(){
        collectionManager.PrintCollection();
        return true;
    }
}
