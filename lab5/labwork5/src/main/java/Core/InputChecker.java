package Core;


public class InputChecker {
    public InputChecker(){}

    private static final double eps = 1E-6;
    public boolean integerValidCheck(String s, int min, int max){
        try{
            int x = Integer.parseInt(s);
            if(x >= min && x <= max) return true;
            System.out.println("Input is invalid. Please enter the integer in the correct range");
            return false;
        } catch (NumberFormatException e){
            System.out.println("Input is invalid. Please enter an integer");
            return false;
        }
    }

    public boolean longValidCheck(String s, Long min, Long max){
        try{
            long x = Long.parseLong(s);
            if(x >= min && x <= max) return true;
            System.out.println("Input is invalid. Please enter the long number in correct range");
            return false;
        } catch(NumberFormatException e){
            System.out.println("Input is invalid. Please enter a long number");
            return false;
        }
    }

    public boolean doubleValidCheck(String s, Double min, Double max){
        try{
            Double x = Double.parseDouble(s);
            if( x - min > eps && max - x > eps){
                return true;
            }
            System.out.println("Input is invalid. Please enter the double number in correct range");
            return false;
        } catch (NumberFormatException e){
            System.out.println("Input is invalid. Please enter a double number");
            return false;
        }
    }

    /**public boolean floatValidCheck(String s, Float min, Float max){
        try{
            Float x = Float.parseFloat(s);
            if( x - min > eps && max - x > eps){
                return true;
            }
            System.out.println("Input is invalid. Please enter the float number in correct range");
            return false;
        } catch (NumberFormatException e){
            System.out.println("Input is invalid. Please enter a float number");
            return false;
        }
    }**/

    public boolean zipCodeValidCheck(String s){
            if (s.length() > 30){
                System.out.println("Input is invalid, zip code must not be greater than 30 characters");
            } return false;
    }

    public boolean manufacturerValidCheck() {
        return true;
    }
    public boolean nameValidCheck(){
        return true;
    }





}
