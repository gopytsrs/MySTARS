package Control;

import Entity.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class AdminControl {
    /**
     * ID of an admin.
     */
    private int adminID;
    /**
     * An object of an admin.
     */
    private Admin admin;
    /**
     * An arraylist/collection of all the schools.
     */
    private ArrayList<School> schoolList = new ArrayList<>();
    /**
     * An arraylist/collection of all the students.
     */
    private ArrayList<Student> studentList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    /**
     * Creates a new admin controller.
     *
     * @param admin is an object of an admin.
     */
    public AdminControl(Admin admin) {
        String schoolFileName = "database_school.bin"; //purely for testing
        String studentFileName = "database_student.bin";
        //Deserialise school data
        try {
            FileInputStream file = new FileInputStream(schoolFileName);
            ObjectInputStream in = new ObjectInputStream(file);
            schoolList = (ArrayList) in.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Deserialise student data
        try {
            FileInputStream file = new FileInputStream(studentFileName);
            ObjectInputStream in = new ObjectInputStream(file);
            studentList = (ArrayList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that changes the student access period for each school.
     */
    // Method should have no parameters
    public void editStudentAccessPeriod() {
        // Check for school inside this method, then get currentaccessdatetime
        int option = -1;
        School temp;


        for (int i = 0; i < schoolList.size(); i++) {

            temp = schoolList.get(i);
            System.out.println((i + 1) + ":" + temp.getSchoolName());
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
            option -= 1;
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
                        System.out.println("Enter start date for access period (YYYY-MM-DD):");
                        String startDate = sc.next();
                        System.out.println("Enter start time to change access period (HH:MM):");
                        String startTime = sc.next();
                        changeDateTime = startDate.concat("T").concat(startTime);
                        date = isDateTime(changeDateTime);
                        if (!date)
                            System.out.println("Datetime in wrong format. Please try again.");
                    } while (!date);

                    date = false;
                    do {
                        System.out.println("End Date to change access period to? (YYYY-MM-DD)");
                        String endDate = sc.next();
                        System.out.println("End Time to change access period to? (HH:MM)");
                        String endTime = sc.next();
                        changeDateTime1 = endDate.concat("T").concat(endTime);
                        date = isDateTime(changeDateTime1);
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

    /**
     * A method that allows the admin to add a student.
     */
    public void addStudent() {
        String name = "";
        String matricNo = "";
        String email = "";
        String finalEmail = "";
        int year = 0;
        String gender = "";
        String nationality = "";
        String schoolName = "";
        int choice = 0;
        int studentChoice = 1;
        int studentAdded = 0;
        boolean addAnotherStudent = true;

        //List all students after addition
        // Account for existing student
        // Need to check for invalid data entry!!

        do {
            System.out.println("Do you want to add a student?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            studentChoice = sc.nextInt();
            if (studentChoice == 1) {
                System.out.print(studentAdded + " student to add! \n");
                System.out.println("Enter student's name: ");
                sc.nextLine();
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
                System.out.println("Enter student's email (NTU domain \"@e.ntu.edu.sg\" already added): ");
                email = sc.nextLine();
                finalEmail = email.concat("@e.ntu.edu.sg");

                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getEmail().equals(finalEmail)) {
                        System.out.println("Already created that email.");
                        return;
                    }
                }
                boolean checkInt = false;

                System.out.println("Enter student's year of study: ");
                while (!checkInt) {
                    try {
                        String dummy = sc.next();
                        year = Integer.parseInt(dummy);
                        checkInt = true;
                    } catch (Exception e) {
                        System.out.println("Input should be an integer! Please try again:");
                    }
                }

                while (year > 4 || year < 1) {
                    System.out.println("Invalid year! Enter again");
                    try {
                        String dummy = sc.next();
                        year = Integer.parseInt(dummy);
                    } catch (Exception e) {
                        System.out.println("Input should be an integer!");
                    }
                }
                sc.nextLine();
                System.out.println("Enter student's gender (M/F): ");
                gender = sc.next();
                while (!gender.equals("M") && !gender.equals("F")) {
                    System.out.println("Invalid gender! Enter again");
                    gender = sc.next();
                }

                System.out.println("Enter student's nationality: ");
                nationality = sc.next();


                System.out.println("Which school will they attend? ");
                for (int p = 0; p < schoolList.size(); p++) {
                    System.out.println((p + 1) + " . " + schoolList.get(p).getSchoolName());
                }
                System.out.println("Enter your choice here: ");

                choice = -1;
                do {
                    String dummy = sc.next();
                    boolean test = isInteger(dummy);
                    if (test == false) {
                        System.out.println("Input should be an integer. Please try again: ");
                        continue;
                    }
                    choice = Integer.parseInt(dummy);
                    if (choice < 1 || choice > schoolList.size())
                        System.out.println("The input is out of range. Please try again.");
                } while (choice < 1 || choice > schoolList.size());
                Student stud = new Student(name, matricNo, finalEmail, year, schoolList.get(choice - 1).getSchoolName(), gender, nationality);
                System.out.println("Student is created");
                studentAdded++;
                this.studentList.add(stud);
                System.out.println("The existing students are: ");
                for (Student s : studentList) {
                    System.out.println(s.getName());
                }
            }
        } while (studentChoice != 2);
    }

    /**
     * A method that allows the admin to add a new course.
     */
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

                    int option = -1;
                    do {
                        System.out.println("Please enter your choice: ");
                        String dummyChoice = sc.next();
                        boolean check = isInteger(dummyChoice);
                        if (!check) {
                            System.out.println("Please enter a valid choice.");
                            continue;
                        }
                        option = Integer.parseInt(dummyChoice);
                        option -= 1;
                        if (option < 0 || option > noOfSchool) {
                            System.out.println("Invalid choice! Select school again: ");
                        }
                    } while (option < 0 || option > noOfSchool);

                    School tempsch = schoolList.get(option);
                    schoolList.get(option).addCourse();
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

    /**
     * A method that allows the admin to update an already made course.
     */
    public void updateCourse() {
        int choice = 0;

        do {
            System.out.println("Would you like to");
            System.out.println("1. Update a course");
            System.out.println("2. Exit");
            System.out.println("Enter your choice here: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    int option = -1;
                    ArrayList<Course> C;
                    for (int i = 0; i < schoolList.size(); i++) {
                        System.out.println((i + 1) + ":" + schoolList.get(i).getSchoolName());
                    }
                    System.out.println("Please key in the number beside the school you select: ");
                    do {
                        String dummy = sc.next();
                        boolean check = isInteger(dummy);
                        if (check == false) {
                            System.out.println("Input should be an integer. Please try again: ");
                            continue;
                        }
                        option = Integer.parseInt(dummy);
                        option -= 1;
                        if (option < 0 || option > schoolList.size() - 1) {
                            System.out.println("Your input is out of range, try again.");
                        }
                    } while (option < 0 || option > schoolList.size() - 1);
                    C = schoolList.get(option).getCourseList();

                    for (int j = 0; j < C.size(); j++) {
                        System.out.println((j + 1) + " : " + C.get(j).getCourseName() + " , " + C.get(j).getCourseCode());
                    }
                    System.out.println("Please key in the number beside the course you select: ");
                    int option1 = -1;
                    do {
                        String dummy = sc.next();
                        boolean check = isInteger(dummy);
                        if (check == false) {
                            System.out.println("Input should be an integer.");
                            continue;
                        }
                        option1 = Integer.parseInt(dummy);
                        option1 -= 1;
                        if (option1 < 0 || option1 > C.size() - 1) {
                            System.out.println("Your data is out of range, try again: ");
                        }
                    } while (option1 < 0 || option1 > C.size() - 1);

                    String oldCourseCode = C.get(option1).getCourseCode();
                    String oldCourseName = C.get(option1).getCourseName();

                    int schoolNotIncluded = 0;
                    int pick = 0;
                    while (pick != 5) {
                        System.out.println("1. Update School");
                        System.out.println("2. Update Course Code");
                        System.out.println("3. Update Index Number");
                        System.out.println("4. Update Vacancy");
                        System.out.println("5. End");
                        System.out.println("Key in the option you would like to use below: ");
                        try {
                            String dummy = sc.next();
                            pick = Integer.parseInt(dummy);
                        } catch (Exception e) {
                            System.out.println("Input should be an integer!");
                            continue;
                        }

                        switch (pick) {
                            case (1): {
                                int option3 = -1;
                                System.out.println("Choose the new school: ");
                                for (int i = 0; i < schoolList.size(); i++) {
                                    if (schoolList.get(i).getSchoolName().equals(schoolList.get(option).getSchoolName())) {
                                        schoolNotIncluded = i;
                                        continue;
                                    } else {
                                        System.out.println((i + 1) + ":" + schoolList.get(i).getSchoolName());
                                    }
                                }
                                do {
                                    System.out.println("Please key in the number beside the school you select (It will save after you exit): ");
                                    String dummy = sc.next();
                                    boolean check = isInteger(dummy);
                                    if (check == false) {
                                        System.out.println("Input should be an integer.");
                                        continue;
                                    }
                                    option3 = Integer.parseInt(dummy);
                                    option3 -= 1;

                                    if (option3 < 0 || option3 > schoolList.size() - 1) {
                                        System.out.println("Your data is out of range, try again.");
                                    }

                                    if (option3 == schoolNotIncluded) {
                                        System.out.println("Cannot change to same school.");
                                    }

                                } while (option3 < 0 || option3 > schoolList.size() - 1 || option3 == schoolNotIncluded);
                                schoolList.get(option3).getCourseList().add(C.get(option1));
                                C.remove(option1);
                                System.out.println("School has been updated");      //not done
                                break;
                            }

                            case (2): {
                                boolean courseexist = false;
                                System.out.println("Please key in new course code: ");
                                String newcoursecode = sc.next();
                                for (Course updatecourse : C) {
                                    if (newcoursecode.equals(updatecourse.getCourseCode())) {
                                        courseexist = true;
                                        System.out.println("The course code already exists.");
                                        break;
                                    }
                                }
                                if (!courseexist) {
                                    Course oldCourse = C.get(option1);
                                    oldCourse.setCourseCode(newcoursecode);

                                    for (Index index : oldCourse.getIndexList()) {
                                        index.setCourseCode(newcoursecode);
                                    }

                                    for (Student student : studentList) {
                                        for (CourseRegistration course : student.getAssignedCourse()) {
                                            if (course.getCourseCode().equals(oldCourseCode))
                                                course.setCourseCode(newcoursecode);
                                            course.getIndex().setCourseCode(newcoursecode);
                                        }
                                        for (CourseRegistration course : student.getWaitList()) {
                                            if (course.getCourseCode().equals(oldCourseCode))
                                                course.setCourseCode(newcoursecode);
                                            course.getIndex().setCourseCode(newcoursecode);
                                        }
                                    }
                                    System.out.println("Course Code has been updated");
                                }
                                break;
                            }
                            case (3): {
                                ArrayList<Index> SelectedIndex = new ArrayList<>();
                                SelectedIndex = C.get(option1).getIndexList();
                                for (int j = 0; j < SelectedIndex.size(); j++) {
                                    System.out.println((j + 1) + " : " + SelectedIndex.get(j).getIndexNo());
                                }
                                System.out.println("Please key in the number beside the index you select: ");
                                int option2 = -1;
                                do {
                                    String dummy = sc.nextLine();
                                    boolean check = isInteger(dummy);
                                    if (check == false) {
                                        System.out.println("Input should be an integer.");
                                        continue;
                                    }
                                    option2 = Integer.parseInt(dummy);
                                    option2 -= 1;
                                    if (option2 < 0 || option2 > SelectedIndex.size() - 1) {
                                        System.out.println("Your data is out of range, try again.");
                                    }
                                } while (option2 < 0 || option2 > SelectedIndex.size() - 1);
                                boolean indexexist = false;
                                System.out.println("Please key in new indexNo: ");
                                int newIndex = sc.nextInt();
                                for (Index I : SelectedIndex) {
                                    if (newIndex == I.getIndexNo()) {
                                        indexexist = true;
                                        System.out.println("The indexNo already exists.");
                                        break;
                                    }
                                }
                                if (!indexexist) {
                                    SelectedIndex.get(option2).setIndexNo(newIndex);
                                    System.out.println("indexNo has been updated");
                                }
                                break;
                            }
                            case (4): {
                                ArrayList<Index> SelectedIndex = new ArrayList<>();
                                SelectedIndex = C.get(option1).getIndexList();
                                for (int j = 0; j < SelectedIndex.size(); j++) {
                                    System.out.println((j + 1) + " : " + SelectedIndex.get(j).getIndexNo());
                                }
                                System.out.println("Please key in the number beside the index you select: ");
                                int option2 = -1;
                                do {
                                    String dummy = sc.nextLine();
                                    boolean check = isInteger(dummy);
                                    if (check == false) {
                                        System.out.println("Input should be an integer.");
                                        continue;
                                    }
                                    option2 = Integer.parseInt(dummy);
                                    option2 -= 1;
                                    if (option2 < 0 || option2 > SelectedIndex.size() - 1) {
                                        System.out.println("Your data is out of range, try again.");
                                    }
                                } while (option2 < 0 || option2 > SelectedIndex.size() - 1);
                                System.out.println("Please key in new Vacancy: ");
                                int newVacancy = sc.nextInt();
                                if (newVacancy < 0 || newVacancy > 30) {
                                    System.out.println("The vacancy is out of range.");
                                    break;
                                } else {
                                    SelectedIndex.get(option2).setVacancy(newVacancy);
                                    System.out.println("Vacancy has been updated");
                                    if (newVacancy > 0 && !SelectedIndex.get(option2).getWaitList().isEmpty()) {
                                        Index indextochange = SelectedIndex.get(option2);
                                        while (!indextochange.getWaitList().isEmpty() && indextochange.getVacancy() > 0) {
                                            Student FirstInlist = indextochange.getWaitList().remove(0);
                                            SelectedIndex.get(option2).assignStudent(FirstInlist);
                                            if (FirstInlist == null) {
                                                System.out.println("Error");
                                                return;
                                            }
                                            Student student1 = null;
                                            for (Student student : studentList) {
                                                if (student.getEmail().equals(FirstInlist.getEmail())) {
                                                    student1 = student;
                                                }
                                            }
                                            CourseRegistration courseToDrop = new CourseRegistration(indextochange, indextochange.getCourseCode(), indextochange.getCourseName(), C.get(option1).getAu(), student1);
                                            if (student1 != null) {
                                                student1.addAssignedCourse(courseToDrop);
                                                student1.removeWaitList(courseToDrop);
                                            }
                                            Notification n = new NotificationControl();
                                            n.sendNotification(FirstInlist, courseToDrop);
                                        }
                                    }
                                }
                                break;
                            }
                            case (5): {
                                System.out.println("Exiting...");
                                break;
                            }
                            default: {
                                System.out.println("Input is out of range");
                            }
                        }
                    }
                    break;
                }
                case 2:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter a valid number. (1 or 2)");
                    break;
            }
        } while (choice != 2);
    }

    /**
     * A method that allows the admin to check the vacancy, and admin has access to all courses.
     */
    public void checkAvailableSlots() {
        int option = -1;
        int choice = -1;
        ArrayList<Course> C;
        ArrayList<Index> I;
        int total;
        int vacancy;
        for (int i = 0; i < schoolList.size(); i++) {
            System.out.println((i + 1) + ":" + schoolList.get(i).getSchoolName());
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
            option -= 1;
            if (option < 0 || option > schoolList.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (option < 0 || option > schoolList.size() - 1);
        C = schoolList.get(option).getCourseList();

        for (int j = 0; j < C.size(); j++) {
            System.out.println((j + 1) + " : " + C.get(j).getCourseName() + " , " + C.get(j).getCourseCode());
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
            choice -= 1;
            if (choice < 0 || choice > C.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (choice < 0 || choice > C.size() - 1);
        I = C.get(choice).getIndexList();
        for (int j = 0; j < I.size(); j++) {
            System.out.println((j + 1) + " : " + I.get(j).getIndexNo());
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
            choice -= 1;
            if (choice < 0 || choice > I.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }

        } while (choice < 0 || choice > I.size() - 1);
        vacancy = I.get(choice).getVacancy();

        if (I.get(choice).getAssignedStudents() == null)
            total = vacancy;
        else
            total = I.get(choice).getVacancy() + I.get(choice).getAssignedStudents().size();
        System.out.println("The vacancy is " + vacancy + "/" + total);


    }

    /**
     * A method that allows the admin to print the student's Name, School, Year of Study, Gender, and Nationality.
     * It allows the admin to print it based on the course that the student has registered for.
     */
    public void printStudentByCourse() {
        int option = -1;
        int choice = -1;
        ArrayList<Course> C;
        ArrayList<Index> I;
        for (int i = 0; i < schoolList.size(); i++) {
            System.out.println((i + 1) + ":" + schoolList.get(i).getSchoolName());
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
            option -= 1;
            if (option < 0 || option > schoolList.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (option < 0 || option > schoolList.size() - 1);
        C = schoolList.get(option).getCourseList();

        for (int j = 0; j < C.size(); j++) {
            System.out.println((j + 1) + " : " + C.get(j).getCourseName() + " , " + C.get(j).getCourseCode());
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
            choice -= 1;
            if (choice < 0 || choice > C.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (choice < 0 || choice > C.size() - 1);
        I = C.get(choice).getIndexList();
        System.out.println(
                "Name\t" +
                        "School\t" +
                        "Year of Study\t" +
                        "Gender\t" +
                        "Nationality\t" +
                        "Status\t");
        for (Index index : I) {
            if (index.getAssignedStudents() == null) {
                System.out.println("There are no students in this index " + index.getIndexNo());
                continue;
            } else {
                for (Student student : index.getAssignedStudents()) {
                    System.out.println(student + "Assigned");
                }
            }

        }
    }

    /**
     * A method that allows the admin to print the student's Name, School, Year of Study, Gender, and Nationality.
     * It allows the admin to print it based on the index of a course, that the student has registered for.
     */
    public void printStudentByIndex() {
        int option = -1;
        int choice = -1;
        ArrayList<Course> C;
        ArrayList<Index> I;
        for (int i = 0; i < schoolList.size(); i++) {
            System.out.println((i + 1) + ":" + schoolList.get(i).getSchoolName());
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
            option -= 1;
            if (option < 0 || option > schoolList.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (option < 0 || option > schoolList.size() - 1);
        C = schoolList.get(option).getCourseList();

        for (int j = 0; j < C.size(); j++) {
            System.out.println((j + 1) + " : " + C.get(j).getCourseName() + " , " + C.get(j).getCourseCode());
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
            choice -= 1;
            if (choice < 0 || choice > C.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (choice < 0 || choice > C.size() - 1);
        I = C.get(choice).getIndexList();
        for (int j = 0; j < I.size(); j++) {
            System.out.println((j + 1) + " : " + I.get(j).getIndexNo());
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
            choice -= 1;
            if (choice < 0 || choice > I.size() - 1) {
                System.out.println("Your data is out of range, try again.");
            }
        } while (choice < 0 || choice > I.size() - 1);
        if (I.get(choice).getAssignedStudents() == null)
            System.out.println("There are no Students in this index");
        else {
            System.out.println(
                    "Name\t" +
                            "School\t" +
                            "Year of Study\t" +
                            "Gender\t" +
                            "Nationality\t" +
                            "Status\t");
            for (Student student : I.get(choice).getAssignedStudents()) {
                System.out.println(student + "Assigned");
            }
        }
    }

    /**
     * A boolean method to check whether an input is an integer.
     *
     * @param str is a string.
     * @return true if it is an integer, false if it is not an integer.
     */
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

    /**
     * A boolean method to check whether the string is in the correct LocalDateTime format.
     *
     * @param str is a string.
     * @return true if it is in the correct LocalDateTime format, false if it is not in the correct LocalDateTime format.
     */
    private boolean isDateTime(String str) {
        try {
            LocalDateTime.parse(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * A method that saves the data to binary files.
     */
    public void saveData() {
        String schoolFileName = "database_school.bin";
        String studentFileName = "database_student.bin";
        //Serialise School data
        try {
            FileOutputStream fileOut = new FileOutputStream(schoolFileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(schoolList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Serialise Student data
        try {
            FileOutputStream fileOut = new FileOutputStream(studentFileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
