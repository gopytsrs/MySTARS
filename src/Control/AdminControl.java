package Control;

import Entity.*;

import java.io.*;
import java.sql.SQLOutput;
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
            String school = sc.nextInt();
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
        String userName;
        String password;
        boolean confirmed = false;
        int choice = 0;

        System.out.println("Username: ");
        userName = sc.next();
        System.out.println("Password: ");
        password = sc.next();

        while (!confirmed) {
            System.out.println("Would you like to confirm that username is " + userName + " and password is " + password + ".");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //create new username and password
                    System.out.println("Created Student Account");
                    File course = new File("student.txt");
                    try (FileWriter fw = new FileWriter("student.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    out.println(userName + " " + password);
                } catch (IOException e) {
                    System.out.println("An error has occurred.");
                }
                    confirmed = true;
                    break;

                case 2:
                    //let the loop run 1 more time
                    System.out.println("Please re-enter the username and password");
                    System.out.println("Username: ");
                    userName = sc.next();
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

    public void addCourse(Scanner sc) {
        int noOfStudent = 0;
        int totalNoOfStudent = 20;
        int choice = 0;

        do {
            System.out.println("Would you like to");
            System.out.println("1. Add a course");
            System.out.println("2. Exit");
            System.out.println("Enter your choice here: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Course Code (ALL CAPITALISED): ");
                    String courseCode = sc.next();

                    try {
                        File course = new File("courses.txt");
                        BufferedReader br = new BufferedReader(new FileReader(course));
                        String courseExist;
                        try {
                            while ((courseExist = br.readLine()) != null) { //Read until the end
                                if (courseExist.equals(courseCode)){    //Check whether the course exist
                                    System.out.println("Course Already Exist");
                                }

                                else{
                                    try {
                                        System.out.println("Course Created: " + course);
                                        try (FileWriter fw = new FileWriter("course.txt", true);
                                             BufferedWriter bw = new BufferedWriter(fw);
                                             PrintWriter out = new PrintWriter(bw)) {
                                            out.println(courseCode);
                                            out.println(noOfStudent + "/" + totalNoOfStudent);
                                        } catch (IOException e) {
                                            System.out.println("An error has occurred.");
                                        }
                                    } catch (IOError e){

                                    }
                                }
                            }
                        } catch (IOException e){
                            System.out.println("An error occurred");
                        }

                    } catch (FileNotFoundException f){
                        System.out.println("File is not found");
                    }
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        } while (choice != 2);
    }

    public void updateCourse(Course course, Scanner sc){
        int choice = 0;

        do {
            System.out.println("Would you like to");
            System.out.println("1. Update a course");
            System.out.println("2. Exit");
            System.out.println("Enter your choice here: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    try {
                        // input the (modified) file content to the StringBuffer "input"
                        BufferedReader file = new BufferedReader(new FileReader("courses.txt"));
                        StringBuffer inputBuffer = new StringBuffer();
                        String replacement;

                        while ((replacement = file.readLine()) != null) {
                            replacement = sc.next(); // line replacement done here
                            inputBuffer.append(replacement);
                        }
                        file.close();

                        // write the new string with the replaced line OVER the same file
                        FileOutputStream fileOut = new FileOutputStream("courses.txt");
                        fileOut.write(inputBuffer.toString().getBytes());
                        fileOut.close();

                    } catch (Exception e) {
                        System.out.println("Problem reading file.");
                    }
                    break;

                case 2:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        } while (choice != 2);
    }

    public void deleteCourse(Course course){

    }

    public void checkAvailableSlots(Course course){

    }

    public void printStudentByCourse(Student student, Course course){

    }

    public void printStudentByIndex(Student student, Course course){

    }
}
