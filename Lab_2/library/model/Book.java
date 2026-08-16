package library.model;

import library.service.Printable;

public class Book extends LibraryResource implements Printable{
    public Book(int resourceId, String title, String author){
        super (resourceId, title, author);
    }
    @Override
    public double calculateFine(int overdueDays){
        return overdueDays * 5;
    }

    @Override
    public void printDetails(){
        System.out.println();
        System.out.println("********** BOOK DETAILS ********");

        displayBasicDetails();

        System.out.println("Resource Type: Book");
        System.out.println("Fine Rate: Rs 5 per day");
    }
}
