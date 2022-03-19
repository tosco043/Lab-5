package Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Commander {
    private final HashMap<String, Boolean> stack = new HashMap<>();
    private final CommandManager commandManager;
    private final String DataFile;
    private final Scanner userScanner;
    private final Deque<String> historyRecorder = new ArrayDeque<>(7);

    static final String FilePath = "src/main/java/Files/";
    public Commander(CommandManager commandManager, Scanner userScanner, String DataFile){

        this.commandManager = commandManager;
        this.DataFile = DataFile;
        this.userScanner = userScanner;
    }

    public void interactiveMode() {
        while(true){
            String[] userCommand = userScanner.nextLine().trim().split(" ");
            if(userCommand.length>2){
                System.out.println("Invalid command!");
                continue;
            }
            if(userCommand[0].equals("Exit")){
                System.exit(0);
            }
            if(categorizeCommand(userCommand)){
                System.out.println("Invalid command!");
                continue;
            }
            updateHistory(userCommand);
            System.out.println("--------------------------");
        }
    }

    public void updateHistory(String[] newCommand){
        String str;
        str = String.join(" ", newCommand);

        if(historyRecorder.size() == 7 ) historyRecorder.removeFirst();
        historyRecorder.addLast(str);
    }

    private boolean scriptMode(String filename){

        System.out.println("Executing script file " + filename);
        if(stack.get(filename) != null) {
            if (stack.get(filename)) {
                System.out.println("To avoid infinite recursion, file " + filename + "can't be executed");
                return false;
            }
        }
        stack.put(filename, true);
        File scriptFile = new File(filename);
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(scriptFile);
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println("Script file does not exist. Please check the file path");
            return false;
        }
        while (fileScanner.hasNextLine()){
            String[] userCommand = fileScanner.nextLine().trim().split(" ");
            if (userCommand.length > 2) {
                System.out.println("Can't execute! Invalid command! Valid command should contain 1 or 2 arguments.");
                continue;
            }
            if (categorizeCommand(userCommand)) {
                System.out.println("Command is invalid. Can't execute!");
                continue;
            }
            updateHistory(userCommand);
            System.out.println("------------");
        }
        stack.put(filename, false);
        return true;
    }

    /**
     *  to categorize user's command and try to launch it.
     * @param userCommand user command
     * @return true if the command is not executable. Otherwise, false if the command is executable
     */
    private boolean categorizeCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "help":
                if (userCommand.length == 1) {
                    return !commandManager.help();
                }
                return true;

            case "info":
                if (userCommand.length == 1) {
                    return !commandManager.info();
                }
                System.out.println("This command does not support argument");
                return true;

            case "show":
                if (userCommand.length == 1) {
                    return !commandManager.show();
                }
                System.out.println("This command doesn't support argument!");
                return true;

            case "add":
                if (userCommand.length == 1) {
                    return !commandManager.add();
                }
                System.out.println("To add new person, you should insert name of command 'add' only!");
                return true;

            case "remove_by_id":
                if (userCommand.length == 2) {
                    return !commandManager.removeById(userCommand[1]);
                }
                System.out.println("Please insert the Id and command on the same line");
                return true;

            case "update_id":
                if (userCommand.length == 2) {
                    return !commandManager.update(userCommand[1]);
                }
                System.out.println("Please insert the Id and command on the same line");
                return true;
            case "clear":
                if(userCommand.length == 1){
                    return !commandManager.clear();
                }
            case "save":
                if(userCommand.length == 1){
                    return !commandManager.save(DataFile);
                }
                System.out.println("This command doesn't support the argument");
                return true;
            case "exit":
                if(userCommand.length ==1){
                    return !commandManager.exit();
                }
                System.out.println("Does not support argument");
                return true;

            case "history":
                if(userCommand.length ==1){
                    for(String cm : historyRecorder){
                        System.out.println(cm);
                    }
                    return false;
                }
                System.out.println("This command doesn't support argument!");
                return true;

            case "execute_script":
                if(userCommand.length != 1) {
                    return !scriptMode(userCommand[1]);
                }
                System.out.println("Please insert scriptFile!");
                return true;

            case "reorder":
                if (userCommand.length == 1) {
                    return !commandManager.reorder();
                }
                System.out.println("This command doesn't support argument!");
                return true;

            case "remove_greater":
                if(userCommand.length == 1){
                    return !commandManager.RemoveGreater();
                }
                System.out.println("This command doesn't support argument!");
                return true;

            case "remove_lower":
                if(userCommand.length == 1){
                    return !commandManager.RemoveLower();
                }
                System.out.println("This command doesn't support argument!");
                return true;

            case "count_less_than_official_address":
                if(userCommand.length == 2){
                    return !commandManager.MinOfficialAddress(userCommand[1]);
                }
                System.out.println("Write the address name");
                return true;

            case "min_by_official_address":
                if(userCommand.length == 2){
                    return !commandManager.CountLessThanOfficialAddress(userCommand[1]);
                }
                System.out.println("Write key word");
                return true;

            case "print_field_ascending_type":
                if(userCommand.length == 1){
                    return !commandManager.PrintFieldAscendingType();
                }
                System.out.println("This command doesn't support argument!");
                return true;

                default:
                System.out.println("Your command is not supported. Please insert correct name!\n" +
                        "Use help command to show the guideline.");
                return true;
        }
    }
}
