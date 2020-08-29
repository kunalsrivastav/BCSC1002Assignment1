/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : FrontDesk.java
 * */
package execution;

import definitions.Library;
import definitions.Student;

import java.util.Scanner;

public class FrontDesk {
    private static final int ISSUE_A_NEW_BOOK = 1;
    private static final int RETURN_A_PREVIOUSLY_ISSUED_BOOK = 2;
    private static final int SHOW_ALL_ISSUED_BOOKS = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentChoice;
        Student student = new Student();
        Library library = new Library();
        library.setBooksInLibrary();
        do {
            System.out.println("-=-=--=-=-\"Welcome To The Front Desk\"-=-=--=-=-");
            System.out.println("How may I help you today?");
            System.out.println("1. Issue a new book for me.");
            System.out.println("2. Return a previously issues book for me.");
            System.out.println("3. Show me all my issues books.");
            System.out.println("4. Exit.");
            System.out.println("Enter your choice (1..4): ");
            studentChoice = scanner.nextInt();
            switch (studentChoice) {
                case ISSUE_A_NEW_BOOK:
                    scanner.nextLine();
                    System.out.println("Enter your name: ");
                    student.setNameOfTheStudent(scanner.nextLine());
                    System.out.println("Enter your University roll number: ");
                    student.setUniversityRollNumberOfTheStudent(scanner.nextLong());
                    System.out.println("How much books you want to issue: ");
                    student.setNumberOfBooksIssuedByTheStudent(scanner.nextInt());
                    System.out.println("These are the available books: ");
                    library.showAvailableBooks();
                    break;
                case RETURN_A_PREVIOUSLY_ISSUED_BOOK:
                    break;
                case SHOW_ALL_ISSUED_BOOKS:
                    break;
                case EXIT:
                    break;
                default:
                    break;
            }
        } while (studentChoice != EXIT);
    }
}
