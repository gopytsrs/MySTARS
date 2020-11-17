package Control;

import Entity.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;


public class AdminControl {
    private int adminID;

    private ArrayList<School> schoolList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public AdminControl() {

        String fileName = "database_school.bin"; //purely for testing, dont touch the actual one

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            schoolList = (ArrayList) in.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method should have no parameters
    public void editStudentAccessPeriod() {
        // Check for school inside this method, then get currentaccessdatetime
        int option = -1;
        School temp;


        for (int i = 0; i < schoolList.size(); i++) {

            temp = schoolList.get(i);
            System.out.println(i + ":" + temp.getSchoolName());
        }
        System.out.println("Please key in the number beside the school you select: ");
        do {
            String dummy = sc.next();
            boolean check = isInteger(dummy);
            if (check == false) {
                System.out.println("Input should be an integer.");
                continue;
            }
            option = Integer.parseInt(dummy);
            if (option < 0 || option > schoolList.size()) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (option < 0 || option > schoolList.size());

        temp = schoolList.get(option);
        AccessPeriod ap = temp.getAccessperiod();
        int choice = 0;
        boolean changed = false;
        //LocalDateTime currentDateTime = LocalDateTime.now();

        /*do {
            System.out.println("What school do you want to check?");
            String school = sc.nextInt();
            }
        while (school < 5);*/

        do {
            System.out.println("The current access period is " + ap.getStartDate() + " to " + ap.getEndDate());
            System.out.println("Would you like to change the access period?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Please enter your choice: ");
            do {
                String dummy1 = sc.next();
                boolean check = isInteger(dummy1);
                if (check == false) {
                    System.out.println("Input should be an integer.");
                    continue;
                }
                choice = Integer.parseInt(dummy1);
                if (choice < 1 || choice > 2) {
                    System.out.println("Your data is out of range, try again.");
                }
            } while (choice < 1 || choice > 2);
            switch (choice) {
                case 1:
                    boolean date = false;
                    String changeDateTime;
                    String changeDateTime1;
                    do {
                        System.out.println("Start Date time to change access period to? (YYYY-MM-DDTHH:MM)");
                        changeDateTime = sc.next();
                        date = isdatetime(changeDateTime);
                        if (!date)
                            System.out.println("Datetime in wrong format. Please try again.");
                    } while (!date);

                    date = false;
                    do {
                        System.out.println("End Date time to change access period to? (YYYY-MM-DDTHH:MM)");
                        changeDateTime1 = sc.next();
                        date = isdatetime(changeDateTime1);
                        if (!date)
                            System.out.println("Datetime in wrong format. Please try again.");
                    } while (!date);

                    temp.setAccessPeriod(LocalDateTime.parse(changeDateTime), LocalDateTime.parse(changeDateTime1));
                    ap = temp.getAccessperiod();
                    System.out.println("The current access period is " + ap.getStartDate() + " to " + ap.getEndDate());

                    System.out.println("Access Period Changed");
                    changed = true;
                    break;

                case 2:
                    System.out.println("The current access period is " + ap.getStartDate() + " to " + ap.getEndDate());
                    changed = true;
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        } while (!changed);

        return;         //haven't add changing to txt file
    }

    public void addStudent() {
        String name;
        String matricNo;
        String email;
        int year;
        String gender;
        String nationality;

        //List all students after addition
        // Account for existing student
        // Need to check for invalid data entry!!
        System.out.println("Enter student's Name: ");
        name = sc.nextLine();
        System.out.println("Enter student's Matriculation Number: ");
        matricNo = sc.nextLine();
        for (Student s : studentList) {
            if (matricNo.equals(s.getMatricNo())) {
                System.out.println("Matriculation Number already exists!");
                return;
            }
        }
        //Checked that email is valid
        System.out.println("Enter student's email (Use NTU domain \"@e.ntu.edu.sg\"): ");
        email = sc.nextLine();
        while (!email.contains("@e.ntu.edu.sg")) {
            System.out.println("Invalid Email! Enter email address: ");
            email = sc.nextLine();
        }

        System.out.println("Enter student's year of study: ");
        year = sc.nextInt();
        while (year > 4 || year < 1) {
            System.out.println("Invalid year! Enter again");
            year = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter student's gender (M/F): ");
        gender = sc.nextLine();

        System.out.println("Enter student's nationality: ");
        nationality = sc.nextLine();
        Student stud = new Student(name, matricNo, email, year, gender, nationality);
        System.out.println("Student is created");
        this.studentList.add(stud);
        System.out.println("The existing students are: ");
        for (Student s : studentList) {
            System.out.println(s.getName());
        }
    }

    public void addCourse() {
        int noOfStudent = 0;
        int totalNoOfStudent = 20;
        int choice = 0;

        //Listing of all course after addition
        //Add an existing course

        do {
            System.out.println("Would you like to");
            System.out.println("1. Add a course");
            System.out.println("2. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //Add created course into school
                    System.out.println("Which school does the course belong to?");
                    int noOfSchool = schoolList.size();
                    for (int i = 0; i < noOfSchool; i++) {
                        System.out.println((i + 1) + ":" + schoolList.get(i).getSchoolName());
                    }
                    choice = sc.nextInt();
                    choice -= 1;
                    while (choice < 0 || choice > noOfSchool) {
                        System.out.println("Invalid choice! Select school again: ");
                        choice = sc.nextInt();
                        choice -= 1;
                    }
                    School tempsch = schoolList.get(choice);
                    schoolList.get(choice).addCourse();
                    System.out.println("All courses currently: ");
                    ArrayList<Course> tempCourseList = tempsch.getCourseList();
                    for (Course c : tempCourseList) {
                        System.out.println(c.getCourseName());
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

    public void updateCourse() {
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


    public void checkAvailableSlots() {
        int option = -1;
        int choice = -1;
        ArrayList<Course> C;
        ArrayList<Index> I;
        int total;
        int vacancy;
        for (int i = 0; i < schoolList.size(); i++) {
            System.out.println(i + ":" + schoolList.get(i).getSchoolName());
        }
        System.out.println("Please key in the number beside the school you select: ");
        do {
            String dummy = sc.next();
            boolean check = isInteger(dummy);
            if (check == false) {
                System.out.println("Input should be an integer.");
                continue;
            }
            option = Integer.parseInt(dummy);
            if (option < 0 || option > schoolList.size()) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (option < 0 || option > schoolList.size());
        C = schoolList.get(option).getCourseList();

        for (int j = 0; j < C.size(); j++) {
            System.out.println(j + " : " + C.get(j).getCourseName() + " , " + C.get(j).getCourseCode());
        }
        System.out.println("Please key in the number beside the course you select: ");
        do {
            String dummy = sc.next();
            boolean check = isInteger(dummy);
            if (check == false) {
                System.out.println("Input should be an integer.");
                continue;
            }
            choice = Integer.parseInt(dummy);
            if (choice < 0 || choice > C.size()) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (choice < 0 || choice > C.size());
        I = C.get(choice).getIndexList();
        for (int j = 0; j < I.size(); j++) {
            System.out.println(j + " : " + I.get(j).getIndexNo());
        }
        choice = -1;
        System.out.println("Please key in the number beside the index you select: ");
        do {
            String dummy = sc.next();
            boolean check = isInteger(dummy);
            if (check == false) {
                System.out.println("Input should be an integer.");
                continue;
            }
            choice = Integer.parseInt(dummy);
            if (choice < 0 || choice > C.size()) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (choice < 0 || choice > C.size());
        vacancy = I.get(choice).getVacancy();
        if (I.get(choice).getAssignedStudents() == null)
            total = vacancy;
        else
            total = I.get(choice).getVacancy() + I.get(choice).getAssignedStudents().size();
        System.out.println("The vacancy is " + vacancy + "/" + total);


    }

    public void printStudentByCourse() {

    }

    public void printStudentByIndex() {
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

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    private boolean isdatetime(String str) {
        try {
            LocalDateTime.parse(str);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
