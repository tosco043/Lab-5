package Commands;

import Core.CollectionManager;

public class Clear extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Clear(CollectionManager C){
        this.collectionManager = C;
    }
    @Override
    public boolean execute(){
        collectionManager.clear();
        return true;
    }
}
