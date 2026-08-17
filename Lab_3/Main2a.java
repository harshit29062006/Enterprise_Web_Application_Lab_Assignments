class InvalidException extends Exception{
    public InvalidException(String message){
        super(message);
    }
}

public class Main2a {
    static void register(int age) throws InvalidException{
        if(age < 18){
            throw new InvalidException("Registration failed: Age should be 18 or above");
        }
        System.out.println("Registration Successful!!!");
    }

    public static void main(String[] args){
        try{
            register(10);
        } catch(InvalidException a){
            System.out.println("Custom Exception: " + a.getMessage());
        }
        System.out.println("Program Continues!!!");
    }
}
