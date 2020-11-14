package Control;

import Entity.*;

import java.io.*;
import java.time.*;
import java.util.*;

public class AdminControl {
    private int adminID;

    public void AdminControl(){

    }

    // Method should have no parameters
    public LocalDateTime editStudentAccessPeriod(LocalDateTime currentDateTime, Scanner sc){
    // Check for school inside this method, then get currentaccessdatetime

    /*    System.out.println("Which school to change access period");
        school = sc.next();

        AccessPeriod accessPeriod = school.getAccessPeriod();
        currentDateTime = accessPeriod.getStartDate(); */

        int choice = 0;
        boolean changed = false;

        /*do {
            System.out.println("What school do you want to check?");
            String school = sc.nextLine();
            }
        while (school < 5);*/

        do{
            System.out.println("The current access period is " + currentDateTime);
            System.out.println("Would you like to change the access period?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Date time to change access period to? (YYYY-MM-DDTHH:MM)");
                    String changeDateTime = sc.next();
                    currentDateTime = LocalDateTime.parse(changeDateTime);
                    System.out.println("The current access period is " + currentDateTime);
                    System.out.println("Access Period Changed");
                    changed = true;
                    break;

                case 2:
                    System.out.println("The current access period is " + currentDateTime);
                    changed = true;
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        }while(!changed);

        return currentDateTime;
    }

    public void addStudent(Student student, Scanner sc){
        String username;
        String password;
        boolean confirmed = false;
        int choice = 0;

        System.out.println("Username: ");
        username = sc.next();
        System.out.println("Password: ");
        password = sc.next();

        while (!confirmed) {
            System.out.println("Would you like to confirm that username is " + username + " and password is " + password + ".");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //create new username and password
                    System.out.println("Created Student Account");
                    confirmed = true;
                    break;

                case 2:
                    //let the loop run 1 more time
                    System.out.println("Please re-enter the username and password");
                    System.out.println("Username: ");
                    username = sc.next();
                    System.out.println("Password: ");
                    password = sc.next();

                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    sc.next();
                    break;
            }
        }
    }

    public void addCourse(Scanner sc){
        int vacancies = 20;
        int totalNoOfStudent = 20;

        System.out.println("Course code (all capitalised): ");
        String code = sc.next();
        System.out.println("Name of the course: ");
        sc.nextLine();
        String courseName = sc.nextLine();

        try {
            File myObj = new File(code + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("Course created: " + myObj.getName());

                try (FileWriter fw = new FileWriter(code + ".txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)){
                    out.println("Course Name: " + courseName);
                    out.println("Vacancies: " + vacancies + "/" + totalNoOfStudent);
                } catch (IOException e) {
                    System.out.println("An error had occurred.");
                }
            } else {
                System.out.println("What would you like to update?");
                //update the course
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteCourse(Course course){

    }

    public void checkAvailableSlots(){

    }

    public void printStudentByCourse(){}

    public void printStudentByIndex(){}
}
