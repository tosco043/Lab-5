package Commands;

import Core.CollectionManager;

public class Save extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Save(CollectionManager C){
        this.collectionManager = C;
    }
    @Override
    public boolean execute(String filename) {
        collectionManager.save(filename);
        return true;
    }
}