package library.Main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.util.InputValidator;

public class Main {

    public static void main (String[] args) {
        Book book1 = new Book(101, "Advanced C++", "Scott Meyers");
        Book book2 = new Book(102, "Data Structures", "Thomas Cormen");
        Book book3 = new Book(103, "Operating Systems", "Galvin");

        DigitalResource digital1 = new DigitalResource(104, "Machine Learning", "Tom Mitchell");
        DigitalResource digital2 = new DigitalResource(105, "Artificial Intelligence", "Russell");
    
        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = book1;
        resources[1] = book2;
        resources[2] = book3;
        resources[3] = digital1;
        resources[4] = digital2;

        int[] overdueDays = {3, 0, 5, 4, 2};

        for(int i=0;i<5;i++){
            if(InputValidator.validateResourceId(resources[i].getResourceId()) == false){
                System.out.println("Invalid Resource ID");
                continue;
            }
            if(InputValidator.validateFineDays(overdueDays[i]) == false){
                System.out.println("Invalid Fine Days");
                continue;
            }

            if(resources[i] == book1){
                book1.printDetails();
            }
            else if(resources[i] == book2){
                book2.printDetails();
            }
            else if(resources[i] == book3){
                book3.printDetails();
            }
            else if(resources[i] == digital1){
                digital1.printDetails();
            }
            else if(resources[i] == digital2){
                digital2.printDetails();
            }

            double fine = resources[i].calculateFine(overdueDays[i]);

            System.out.println("Overdue Days: " + overdueDays[i]);
            System.out.println("Fine: Rs " + fine);
        }

        double totalFine = 0;

        for(int i=0;i<5;i++){
            if(InputValidator.validateFineDays(overdueDays[i])){
                totalFine = totalFine + resources[i].calculateFine(overdueDays[i]);
            }
        }

        System.out.println();
        System.out.println("********************");
        System.out.println("Total Fine: Rs " + totalFine);
        System.out.println("********************");

        LibraryResource.displayTotalResources();
    }
    
}
