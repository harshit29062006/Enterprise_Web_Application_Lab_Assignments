import java.io.*;

// The class must implement Serializable
class Employee implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee [ID=" + id + ", Name=" + name + 
               ", Department=" + department + ", Salary=$" + salary + "]";
    }
}

public class Ques_3{

    public static void serializeEmployees(String filename, Employee[] employees){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(employees);
            System.out.println("Employees successfully serialized to " + filename);
        } catch(IOException e){
            System.err.println("Serialization error: " + e.getMessage());
        }
    }

    public static void deserializeEmployees(String filename){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            Employee[] employees = (Employee[]) in.readObject();

            System.out.println("\n--- Retrieved Employees from File ---");
            for(Employee emp : employees){
                System.out.println(emp);
            }
        } catch(IOException e){
            System.err.println("Deserialization I/O error: " + e.getMessage());
        } catch(ClassNotFoundException e){
            System.err.println("Employee class not found: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        String filename = "employees.ser";

        Employee[] staff = {
            new Employee(101, "Sarah Connor", "Security", 85000),
            new Employee(102, "John Doe", "IT", 72000),
            new Employee(103, "Emma Watson", "HR", 68000)
        };

        serializeEmployees(filename, staff);

        deserializeEmployees(filename);
    }
} 