package Commands;

public class Exit extends AbstractCommand{
    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }
}
