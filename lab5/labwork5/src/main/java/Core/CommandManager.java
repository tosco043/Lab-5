package Core;

import Commands.*;


public class CommandManager {
    private final ICommands Add;
    private final ICommands Clear;
    private final ICommands Exit;
    private final ICommands Help;
    private final ICommands Info;
    private final ICommands RemoveById;
    private final ICommands Show;
    private final ICommands Update;
    private final ICommands Save;
    private final ICommands RemoveGreater;
    private final ICommands RemoveLower;
    private final ICommands MinOfficialAddress;
    private final ICommands CountLessThanOfficialAddress;
    private final ICommands PrintFieldAscendingType;
    private final ICommands Reorder;

    public CommandManager( ICommands add, ICommands removeGreater, ICommands removeLower, ICommands clear, ICommands minOfficialAddress,
                           ICommands exit, ICommands countLessThanOfficialAddress, ICommands help, ICommands info, ICommands printFieldAscendingType,
                           ICommands removeById, ICommands save, ICommands show, ICommands update, ICommands reorder) {
        this.Help = help;
        this.Info = info;
        this.Show = show;
        this.Add = add;
        this.Update = update;
        this.RemoveById = removeById;
        this.Clear = clear;
        this.Save = save;
        this.Exit = exit;
        this.RemoveGreater = removeGreater;
        this.RemoveLower = removeLower;
        this.MinOfficialAddress = minOfficialAddress;
        this.CountLessThanOfficialAddress = countLessThanOfficialAddress;
        this.PrintFieldAscendingType = printFieldAscendingType;
        this.Reorder = reorder;

    }
    public boolean help(){
        return Help.execute();
    }
    public boolean info(){ return Info.execute(); }
    public boolean show(){
        return Show.execute();
    }
    public boolean add() {return Add.execute();}
    public boolean update(String argument){return Update.execute(argument);}
    public boolean removeById(String argument){return RemoveById.execute(argument);}
    public boolean clear(){return Clear.execute();}
    public boolean save(String filename){
        return Save.execute(filename);
    }
    public boolean exit(){return Exit.execute();}
    public boolean RemoveGreater(){return RemoveGreater.execute();}
    public boolean RemoveLower(){return  RemoveLower.execute();}
    public boolean MinOfficialAddress(String argument){ return MinOfficialAddress.execute(argument);}
    public boolean CountLessThanOfficialAddress(String argument){return CountLessThanOfficialAddress.execute(argument);}
    public boolean PrintFieldAscendingType(){return PrintFieldAscendingType.execute();}
    public boolean reorder(){return Reorder.execute();}


}
