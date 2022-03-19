package Commands;

public abstract class AbstractCommand implements ICommands{
    @Override
    public boolean execute(String argument){
        return false;
    }
    @Override
    public boolean execute() {
        return false;
    }
}

//The class the sets the execution to false all things been equal
