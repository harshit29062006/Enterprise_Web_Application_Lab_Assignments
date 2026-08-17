import java.io.IOException;

public class Main1 {
    static void readFile() throws IOException{
        throw new IOException("File could not be read!!!!");
    }
    static void checkAge(int age){
        if(age < 21){
            throw new IllegalArgumentException("Age must be greater than 21");
        }
    }


    public static void main(String[] args){
        try{
            int ans = 20/0;
        } catch(ArithmeticException a){
            System.out.println("Arithematic Exception: " + a.getMessage());
        }

        try{
            int[] arr = {10,20,30};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Array Index Out Of Bounds Exception: " + a.getMessage());
        }

        try{
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException a){
            System.out.println("Null Pointer Exception: " + a.getMessage());
        }

        try{
            readFile();
        } catch(IOException a){
            System.out.println("IO Exception: " + a.getMessage());
        }

        try{
            checkAge(18);
        } catch(IllegalArgumentException a){
            System.out.println("Illegal Argumentation Error: " + a.getMessage());
        }

        finallyBlock();
        System.out.println("All programs are successfully executed!!!");
    }

    static void finallyBlock(){
        try{
            System.out.println("Inside try block!!!");
        } catch(Exception a){
            System.out.println("Exception handeled!!!");
        } finally{
            System.out.println("Finally Block executed!!!");
        }
    }
}
