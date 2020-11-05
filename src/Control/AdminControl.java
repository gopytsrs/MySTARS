package Control;

import Entity.*;
import java.time.*;
import java.util.*;

public class AdminControl {
    private int adminID;
    public int choice;
    Scanner sc = new Scanner(System.in);

    public void AdminControl(){

    }

    public LocalDateTime editStudentAccessPeriod(LocalDateTime currentDateTime){
        choice = 0;

        System.out.println("The current access period is " + currentDateTime);
        System.out.println("Would you like to change the access period?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Please enter your choice: ");

        switch (choice){
            case 1:
                System.out.println("Date time to change access period to? (YYYY-MM-DDTHH:MM)");
                String changeDateTime = sc.nextLine();
                currentDateTime = LocalDateTime.parse(changeDateTime);
                System.out.println("The current access period is " + currentDateTime);
                System.out.println("Access Period Changed");
                break;

            case 2:
                System.out.println("The current access period is " + currentDateTime);
                break;

            default:
                System.out.println("Please enter a valid number. (1 or 2)");
                break;
        }

        return currentDateTime;
    }

    public void addStudent(Student student){
        String username;
        String password;
        Boolean confirmed = false;
        choice = 0;

        while (!confirmed) {
            System.out.println("Username: ");
            username = sc.nextLine();

            System.out.println("Password: ");
            password = sc.nextLine();

            System.out.println("Would you like to confirm that username is " + username + " and password is " + password + ".");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Please enter your choice: ");

            switch (choice) {
                case 1:
                    //create new username and password
                    System.out.println("Created Student Account");
                    confirmed = true;
                    break;

                case 2:
                    //let the loop run 1 more time
                    System.out.println("Please re-enter the username and password");
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        }
    }

    public void addCourse(Course course){

    }

    public void deleteCourse(Course course){

    }

    public void checkAvailableSlots(){

    }

    public void printStudentByCourse(){}

    public void printStudentByIndex(){}
}
