package Commands;

import Core.CollectionManager;

public class Info extends AbstractCommand{
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(){
        System.out.println("Collection's type: Stack ");
        System.out.println("Initialization date: " + collectionManager.getCreationDate());
        System.out.println("Number of elements " + collectionManager.size());

        return true;
    }
}
