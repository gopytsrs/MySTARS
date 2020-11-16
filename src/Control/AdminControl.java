package Control;

import Entity.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class AdminControl {
    private int adminID;

    public void AdminControl() {

    }

    // Method should have no parameters
    public void editStudentAccessPeriod(Scanner sc) {
        // Check for school inside this method, then get currentaccessdatetime
        String schoolname;
        System.out.println("Which school to change access period");
        schoolname = sc.next();
        School A = null;
        AccessPeriod schoolAccess = null;
        try {
            File schoolData = new File("school.txt");      //file will be in main page
            Scanner reader = new Scanner(schoolData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] token = line.split(",");       // splitting the string to get schoolname, accessperiod and other information
                System.out.println(token[0]);
                System.out.println(token[1]);
                System.out.println(token[2]);
                System.out.println(token[3]);
                System.out.println(token[4]);
                /*if(token.length!=5){throw new IllegalArgumentException();} //exception is thrown if the line contains anything more or less than a username and password
                if(token[0].equals(schoolname))
                {
                    LocalDateTime startdate = LocalDateTime.parse(token[1]);        //might need to read all variables temporarily
                    LocalDateTime enddate = LocalDateTime.parse(token[2]);
                    schoolAccess = new AccessPeriod(startdate,enddate);
                    A = new School(token[0],schoolAccess);
                }*/
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error in finding file");
            e.printStackTrace();
        }

        if (A == null && schoolAccess == null) {
            System.out.println("School does not exist.");
            return;
        }


        int choice = 0;
        boolean changed = false;
        //LocalDateTime currentDateTime = LocalDateTime.now();

        /*do {
            System.out.println("What school do you want to check?");
            String school = sc.nextInt();
            }
        while (school < 5);*/

        do {
            System.out.println("The current access period is " + schoolAccess.getStartDate() + " to " + schoolAccess.getEndDate());
            System.out.println("Would you like to change the access period?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Start Date time to change access period to? (YYYY-MM-DDTHH:MM)");
                    String changeDateTime = sc.next();
                    LocalDateTime startDate = LocalDateTime.parse(changeDateTime);
                    schoolAccess.setStartDate(startDate);
                    System.out.println("The current start access period is " + schoolAccess.getStartDate());
                    System.out.println("Start Date time to change access period to? (YYYY-MM-DDTHH:MM)");
                    String changeDateTime1 = sc.next();
                    LocalDateTime EndDate = LocalDateTime.parse(changeDateTime1);
                    schoolAccess.setStartDate(EndDate);
                    System.out.println("The current access period is " + schoolAccess.getEndDate());
                    System.out.println("Access Period Changed");
                    changed = true;
                    break;

                case 2:
                    System.out.println("The current access period is " + schoolAccess.getStartDate() + " to " + schoolAccess.getEndDate());
                    changed = true;
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        } while (!changed);

        return;         //haven't add changing to txt file
    }

    public void addStudent(Student student, Scanner sc) {
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
                        System.out.println("This is fine!");
                        File course = new File("courses.txt");
                        BufferedReader br = new BufferedReader(new FileReader(course));
                        String readCourse;
                        boolean courseExist = false;

                        try {
                            while ((readCourse = br.readLine()) != null) { //Read until the end
                                if (readCourse.equals(courseCode)) {    //Check whether the course exist
                                    System.out.println("Course Already Exist");
                                    System.out.println("This is fine!");
                                    courseExist = true;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("An error has occurred.");
                        }

                        if (courseExist == false)
                            try {
                                System.out.println("This is fine!");
                                System.out.println("Course Created: " + courseCode);
                                try (FileWriter fw = new FileWriter("courses.txt", true);
                                     BufferedWriter bw = new BufferedWriter(fw);
                                     PrintWriter out = new PrintWriter(bw)) {
                                    out.println("\n" + courseCode);
                                    out.println(noOfStudent + "/" + totalNoOfStudent);
                                    break;
                                } catch (IOException e) {
                                    System.out.println("An error has occurred.");
                                }
                            } catch (IOError e) {
                                System.out.println("An error has occurred.");
                            }
                    } catch (FileNotFoundException f) {
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

    public void updateCourse(Course course, Scanner sc) {
        int choice = 0;

        do {
            System.out.println("Would you like to");
            System.out.println("1. Update a course");
            System.out.println("2. Exit");
            System.out.println("Enter your choice here: ");
            choice = sc.nextInt();

            switch (choice) {
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

    public void deleteCourse(Course course) {

    }

    public void checkAvailableSlots(Course course) {

    }

    public void printStudentByCourse(Student student, Course course) {

    }

    public void printStudentByIndex(Course course) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index no:");
        int indexNo = Integer.valueOf(scanner.nextLine());

        //Load the index arraylist here to find the corresponding index
        ArrayList<Index> indexes = new ArrayList<Index>();

        Index indexToPrint = null;
        for (Index index : indexes) {
            if (index.getIndexNo() == indexNo) {
                indexToPrint = index;
            }
        }

        ArrayList<Student> registeredStudents = indexToPrint.getAssignedStudents();
        Deque<Student> waitListStudents = indexToPrint.getWaitList();

        System.out.println(
                "Name\t" +
                        "School\t" +
                        "Year of Study\t" +
                        "Gender\t" +
                        "Nationality\t" +
                        "Status\t");
        for (Student student : registeredStudents) {
            System.out.println(student + "Assigned");
        }
        for (Student student : waitListStudents) {
            System.out.println(student + "WaitList");
        }


    }
}