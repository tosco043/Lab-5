package Commands;

public class Help extends AbstractCommand{
    public boolean execute(){
        System.out.println("help                                     - display help for available commands");
        System.out.println("info                                     - displays information about the collection (type, date of\n "+
                           "                                          initialization, number of elements, etc.) to standard output");
        System.out.println("show                                     - display all the elements of the collection");
        System.out.println("add {element}                            - add new element to the collection");
        System.out.println("update_id {element}                      - update the value of the collection item whose id is equal to the\n"+
                           "                                           given");
        System.out.println("remove_by_id {id}                        - remove element has corresponding id from the collection");
        System.out.println("clear                                    - clear collection");
        System.out.println("save                                     - save collection into file");
        System.out.println("execute_script file_name                 - read and execute script from corresponding file. The script\n" +
                           "                                           contains commands in the same form in which the user enters them\n"+
                           "                                           interactively");
        System.out.println("exit                                     - end the program without saving to file");
        System.out.println("remove_greater                           - remove from the collection all elements greater than the given");
        System.out.println("remove_lower                             - remove from the collection all elements greater than the given");
        System.out.println("reorder                                  - sort the collection in reverse order of the current one");
        System.out.println("history                                  - print last 7 command (without argument)");
        System.out.println("min_by_official_address name             - display any object from the collection whose officialAddress field\n "+
                           "                                          value is the minimum");
        System.out.println("count_less_than_official_address name    - display the number of elements whose officialAddress field value is less\n "+
                           "                                          than the given one");
        System.out.println("print_field_ascending_type               - print the values of the manufacturer field of all elements in descending\n"+
                           "                                           order");

        return true;
    }
}