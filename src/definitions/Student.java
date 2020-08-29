/*  Created by IntelliJ IDEA.
 *  User: Divyansh Bhardwaj (dbc2201)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Student.java
 * */
package definitions;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private static final int MAXIMUM_BOOKS_STUDENT_CAN_ISSUE = 5;
    private String nameOfTheStudent;
    private long universityRollNumberOfTheStudent;
    private int numberOfBooksIssuedByTheStudent;
    private Book[] namesOfTheBooksIssuedByTheStudent;

    // Parameterized Constructor
    public Student(String nameOfTheStudent, long universityRollNumberOfTheStudent, int numberOfBooksIssuedByTheStudent, Book[] namesOfTheBooksIssuedByTheStudent) {
        this.nameOfTheStudent = nameOfTheStudent;
        this.universityRollNumberOfTheStudent = universityRollNumberOfTheStudent;
        this.numberOfBooksIssuedByTheStudent = numberOfBooksIssuedByTheStudent;
        this.namesOfTheBooksIssuedByTheStudent = namesOfTheBooksIssuedByTheStudent;
    }

    // Non-Parameterized Constructor
    public Student() {
        this.nameOfTheStudent = "";
        this.universityRollNumberOfTheStudent = 0L;
        this.numberOfBooksIssuedByTheStudent = 0;
        this.namesOfTheBooksIssuedByTheStudent = new Book[MAXIMUM_BOOKS_STUDENT_CAN_ISSUE];
        for (int initializingBook = 0; initializingBook < MAXIMUM_BOOKS_STUDENT_CAN_ISSUE; initializingBook++) {
            this.namesOfTheBooksIssuedByTheStudent[initializingBook] = new Book();
        }
    }

    public String getNameOfTheStudent() {
        return nameOfTheStudent;
    }

    public void setNameOfTheStudent(String nameOfTheStudent) {
        this.nameOfTheStudent = nameOfTheStudent;
    }

    public long getUniversityRollNumberOfTheStudent() {
        return universityRollNumberOfTheStudent;
    }

    public void setUniversityRollNumberOfTheStudent(long universityRollNumberOfTheStudent) {
        this.universityRollNumberOfTheStudent = universityRollNumberOfTheStudent;
    }

    public int getNumberOfBooksIssuedByTheStudent() {
        return numberOfBooksIssuedByTheStudent;
    }

    public void setNumberOfBooksIssuedByTheStudent(int numberOfBooksIssuedByTheStudent) {
        this.numberOfBooksIssuedByTheStudent = numberOfBooksIssuedByTheStudent;
    }

    public Book[] getNamesOfTheBooksIssuedByTheStudent() {
        return namesOfTheBooksIssuedByTheStudent;
    }

    public void setNamesOfTheBooksIssuedByTheStudent(Book[] namesOfTheBooksIssuedByTheStudent) {
        this.namesOfTheBooksIssuedByTheStudent = namesOfTheBooksIssuedByTheStudent;
    }

    @Override
    public String toString() {
        return "Name of Student: " + getNameOfTheStudent() + ", " +
                "University Roll Number: " + getUniversityRollNumberOfTheStudent() + ", " +
                "Number of Books Issued: " + getNumberOfBooksIssuedByTheStudent() + ", " +
                "Names of Books Issued: " + Arrays.toString(getNamesOfTheBooksIssuedByTheStudent()) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getUniversityRollNumberOfTheStudent() == student.getUniversityRollNumberOfTheStudent() &&
                getNumberOfBooksIssuedByTheStudent() == student.getNumberOfBooksIssuedByTheStudent() &&
                Objects.equals(getNameOfTheStudent(), student.getNameOfTheStudent()) &&
                Arrays.equals(getNamesOfTheBooksIssuedByTheStudent(), student.getNamesOfTheBooksIssuedByTheStudent());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNameOfTheStudent(), getUniversityRollNumberOfTheStudent(), getNumberOfBooksIssuedByTheStudent());
        result = 31 * result + Arrays.hashCode(getNamesOfTheBooksIssuedByTheStudent());
        return result;
    }

    /**
     * This method will issue the books to the Student
     *
     * @param bookIssuingIndex The index where the book is issueing.
     * @param bookName         The name of the book which is issuing.
     */
    public void issueBooksToStudents(int bookIssuingIndex, String bookName) {
        namesOfTheBooksIssuedByTheStudent[bookIssuingIndex].setNameOfTheBook(bookName);
    }

    /**
     * This method will return the Book which the student has issued.
     *
     * @param bookName The name of the book which is used to be returned.
     * @return It will return Boolean value, if return will be successful then it will return true else false.
     */
    public boolean returnBook(String bookName) {
        boolean returnSuccessful = false;
        int returnBookIndex = 0;
        for (int tempIndex = 0; tempIndex < MAXIMUM_BOOKS_STUDENT_CAN_ISSUE; tempIndex++) {
            if (bookName.equals(namesOfTheBooksIssuedByTheStudent[tempIndex].getNameOfTheBook())) {
                returnSuccessful = true;
                returnBookIndex = tempIndex;
                setNumberOfBooksIssuedByTheStudent(getNumberOfBooksIssuedByTheStudent() - 1);
                break;
            }
        }
        if (returnSuccessful) {
            namesOfTheBooksIssuedByTheStudent[returnBookIndex].setNameOfTheBook(null);
        } else {
            System.out.println("Please Enter the correct book name.");
        }
        return returnSuccessful;
    }

    /**
     * This method will show all the books which is issued by the Student.
     */
    public void showIssuedBooksByStudent() {
        if (getNumberOfBooksIssuedByTheStudent() == 0) {
            System.out.println("Sorry, you haven't issued any book yet.");
        } else {
            System.out.println("These are the books issued by you: ");
            for (int issuedBookIndex = 0; issuedBookIndex < MAXIMUM_BOOKS_STUDENT_CAN_ISSUE; issuedBookIndex++) {
                if (namesOfTheBooksIssuedByTheStudent[issuedBookIndex].getNameOfTheBook() != null) {
                    System.out.print(namesOfTheBooksIssuedByTheStudent[issuedBookIndex].getNameOfTheBook() + (issuedBookIndex < getNumberOfBooksIssuedByTheStudent() - 1 ? ", " : ".\n"));
                }
            }
        }
    }
}
