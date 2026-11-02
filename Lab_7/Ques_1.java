import java.io.*;

public class Ques_1 {

    public static void writeStudentText(String filename, String data){
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
            System.out.println("Student record written successfully.");
        } catch(IOException e){
            System.err.println("Error writing text file: " + e.getMessage());
        }
    }

    public static void readStudentText(String filename){
        try(FileReader reader = new FileReader(filename)){
            int ch;
            System.out.println("--- Student Details ---");
            while((ch = reader.read()) != -1){
                System.out.print((char) ch);
            }
            System.out.println("\n-----------------------");
        } catch(IOException e){
            System.err.println("Error reading text file: " + e.getMessage());
        }
    }

    public static void copyBinaryFile(String source, String destination){
        try(FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)){

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1){
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Binary file copied successfully from " + source + " to " + destination);
        } catch(IOException e){
            System.err.println("Error copying binary file: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        String textFile = "students.txt";
        String sampleData = "ID: 101, Name: Alice, Grade: A\nID: 102, Name: Bob, Grade: B";

        writeStudentText(textFile, sampleData);
        readStudentText(textFile);

        copyBinaryFile("students.txt", "students_backup.dat");
    }
}