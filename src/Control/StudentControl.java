package Control;

import Entity.*;


import java.io.IOException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
    private Student student;
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    //Create StudentControl using this constructor
    public StudentControl(String studentname){
        this.student = student;
        String schCode = student.getSchoolName();

        ArrayList<School> schoolList = new ArrayList<>();

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

        for (Student student: studentList){
            if(student.getName().equals(studentname)){
                this.student =student;
                break;
            }
        }

        for (School school: schoolList){
            if (student.getSchoolName().equals(school.getSchoolName())){
                this.courseList = school.getCourseList();
                break;
            }
        }

    }

    public void addCourse(){
        //go to school -> print course
        //ask for course -> show indexes if correct -> ask if want to add the course and index -> register courses
        // Add to assigned courses if no clash and has vacancy and AU < 21
        String courseName;
        int indexno;
        Course courseChosen = null;
        Index indexChosen = null;
        ArrayList<CourseRegistration> registeredCourse = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitListCourse = student.getWaitList();
        boolean indexExists = false;
        boolean courseExists = false;
        do{
            System.out.println("Please enter course code to add course:");
            for (Course courseL:courseList){
                System.out.println(courseL.getCourseCode() + ": " + courseL.getCourseName());
            }

            courseName = scanner.next();
            if(courseName.isEmpty()) continue;

            for (Course course: courseList){
                if (course.getCourseCode().equals(courseName)) {
                    courseExists = true;
                    courseChosen = course;
                    break;
                }
            }

            for (CourseRegistration aboutToRegisterCourse: registeredCourse){
                if (courseChosen.equals(aboutToRegisterCourse)){
                    System.out.print("Already registered the course. Index: " + aboutToRegisterCourse.getIndex().getIndexNo());
                    break;
                }
            }

            for (CourseRegistration aboutToRegisterCourse: waitListCourse){
                if (courseChosen.equals(aboutToRegisterCourse)){
                    System.out.println("Already added this course to the waitlist. Index: " + aboutToRegisterCourse.getIndex().getIndexNo());
                    break;
                }
            }

            if (!courseExists){
                System.out.println("Please enter valid course code!");
            }

        }while(!courseExists);

        ArrayList<Index> indexList = courseChosen.getIndexList();

        do{
            System.out.println("Please enter index to add:");
            for (Index indexL:indexList){
                System.out.println(indexL.getIndexNo());
            }
            indexno = scanner.nextInt();
            for (Index index: indexList){
                if (index.getIndexNo() == indexno) {
                    indexExists = true;
                    indexChosen = index;
                    break;
                }
            }
            if (!indexExists){
                System.out.println("Please enter valid index!");
            }
        }while(!indexExists);

        CourseRegistration newCourse = new CourseRegistration(indexChosen, indexChosen.getCourseCode(), courseChosen.getCourseName(), courseChosen.getAu(), student);
        int choice = 0;
        do{
            System.out.println("Confirm to add " + indexChosen.getCourseCode() + " index " +indexChosen.getIndexNo() +"?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    student.addWaitList(newCourse);
                    break;
                case 2:
                    System.out.println("Course not added.");
                    break;
                default:
                    break;
            }
        }while (choice<1 || choice>2);
    }

    public void dropCourse() {
        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitlistCourses = student.getWaitList();
        CourseRegistration courseToDrop = null;
        boolean courseFound = false;


        //Check if course is registered, exits method if course is not registered
        while(!courseFound) {
            System.out.println("Enter course code you want to drop:");
            String courseCode = scanner.nextLine();

            for (CourseRegistration course : waitlistCourses) {
                if (course.getCourseCode().equals(courseCode)) {
                    courseToDrop = course;
                    courseFound = true;
                    break;
                }
            }
            if (!courseFound) {
                System.out.println("You are not registered for " + courseCode);
                return;
            }
        }

        for (CourseRegistration waitlistCourse : waitlistCourses) {
            if (waitlistCourse.getCourseCode().equals(courseToDrop.getCourseCode())) {
                Index index = waitlistCourse.getIndex();
                int vacancies = index.getVacancy();

                //Branch to check if course is registered only or assigned.

                if (waitlistCourses.contains(courseToDrop) && (!assignedCourses.contains(courseToDrop))) {
                    index.removeFromWaitlist(student);
                    System.out.printf("Removed %s from waitlist",courseToDrop.getCourseCode());
                    return;

                } else if (assignedCourses.contains(courseToDrop)) {
                    vacancies += 1;
                    index.setVacancy(vacancies);
                    //Remove student from index
                    index.removeStudentFromAssigned(student);
                    student.removeAssignedCourse(courseToDrop);
                    System.out.printf("Dropped %s from assigned courses",courseToDrop.getCourseCode());
                    return;
                }
                break;
            }
        }
    }
    public void printRegisteredCourses(){

        ArrayList<CourseRegistration>waitListCourses = student.getWaitList();
        ArrayList<CourseRegistration>assignedCourses = student.getAssignedCourse();

        System.out.println("Course Code:\tCourse Name:\tIndex:\tAU:");

        //Go through all the courses, each course is printed on a new line
        System.out.println("Assigned Courses: ");
        if (assignedCourses == null){
            System.out.println("No courses registered.");
        } else {
            for (CourseRegistration course : assignedCourses) {
                System.out.print(course);
            }
        }

        System.out.println("Waitlist Courses: ");
        if (waitListCourses == null){
            System.out.println("No courses in the waitlist.");
        } else {
            for (CourseRegistration course : waitListCourses) {
                System.out.println(course);
            }
        }
    }

    public void checkAvailableSlots(){
        int indexNo = 0;
        while (true) {
            try {
                System.out.println("Enter index number:");
                indexNo = Integer.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a index number.");
            }
        }
        ArrayList<Course> courses = new ArrayList<Course>();
        //Loop through indexList of each course to find if the index exists
        for(Course course: courses){
            ArrayList<Index> indexes = course.getIndexList();
            for(Index index: indexes){
                //Index exists, print out the vacancies and exit the method
                if(index.getIndexNo() == indexNo){


                    System.out.printf("The number of available slots in Index %d of %s is %d",index.getIndexNo(),index.getCourseCode(),index.getVacancy());

                    int total;
                    if(index.getAssignedStudents() == null){
                       total = index.getVacancy();
                    } else {
                        total = index.getVacancy() + index.getAssignedStudents().size();
                    }
                    System.out.printf("The number of available slots in Index %d of %s is %d/%d",index.getIndexNo(),index.getCourseCode(),index.getVacancy(),total);

                    return;

                }
            }
        }

        //Loop ends without finding the index
        System.out.println("That index number does not exist");
    }

    public void changeIndex(){
        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitlistCourses = student.getWaitList();
        CourseRegistration course = null;
        Index indexToDrop = null;
        Index indexToAdd = null;
        int currentIndexNo = 0;
        int desiredIndexNo = 0;

        while(true) {
            try {
                System.out.println("Enter current index no:");
                currentIndexNo = Integer.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a index number.");
            }

            // Check if index to drop is in the student's assigned courses
            for(CourseRegistration assignedCourse: assignedCourses) {
                //Index is in assignedCourses, get the index to drop and get the course
                if (assignedCourse.getIndex().getIndexNo() == currentIndexNo) {
                    indexToDrop = assignedCourse.getIndex();
                    course = assignedCourse;
                    //From here need to get the course to see the other indexes
                }
            }
            if(indexToDrop == null) {
                System.out.printf("You are not registered for Index %d. Please enter a valid Index no.",currentIndexNo);
                continue;
            }
            else break;


        }

        //Load the index list of the course
        ArrayList<Index> indexList = new ArrayList<Index>();

        outer:
        while(true) {
            try {
                System.out.println("Enter index no. to change to:");
                desiredIndexNo = Integer.valueOf(scanner.nextLine());
                break;

            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a index number.");

            }

            for(Index index: indexList){
                if(index.getIndexNo() == desiredIndexNo){
                    indexToAdd = index;
                }
            }

            if(indexToAdd == null){
                System.out.printf("Index %d does not exist.%n",desiredIndexNo);
                continue;

            } else if(indexToAdd.getVacancy()==0){
                System.out.println("Index %d has no vacancies. Please choose another index.");
                continue;

            } else {
            //Change registeredCourse to waitlist
                //Check for assignedCourse clash here, need to check for waitlistCourse clash.
                for(CourseRegistration assignedCourse: assignedCourses){
                    if(assignedCourse.getIndex() != indexToDrop){
                        if(assignedCourse.getIndex().checkClash(indexToAdd)){
                            //The information of the assigned course
                            String code = assignedCourse.getCourseCode();
                            int indexNo = assignedCourse.getIndex().getIndexNo();

                            System.out.printf("Index %d of %s clashes with Index %d of %s! Please choose another index.%n",
                                    indexToAdd.getCourseCode(),indexToAdd.getIndexNo(),code,indexNo);
                            continue outer;

                        }
                    }
                    //Logic here to process the changing of index.
                    System.out.printf("Changed from Index %d to Index %d for %s",indexToDrop.getIndexNo(),indexToAdd.getIndexNo(),indexToDrop.getCourseCode());
                    break outer;
                }
            }
        }
    }

    public void swapIndex(){
        // Enter peer's index to swap
        //Check student name to swap, from assigned courses check if index exists
        // If exists and not clash swap.

        boolean studentFound = false;
        boolean passwordcheck = false;
        String studentnameSwap;
        String studentpassSwap;
        Student studenttoswap = null;
        do{
            System.out.println("Please enter username of student to swap index with: ");
            studentnameSwap = scanner.next();
            for (Student student: studentList){
                if (student.getAccount().getUsername().equals(studentnameSwap)){
                    studenttoswap = student;
                    studentFound = true;
                    break;
                }
            }
            if (!studentFound){
                System.out.println("Please enter a valid student username!");
                continue;
            }
            do {
                System.out.println("Please enter password of student to swap index with: ");
                studentpassSwap = scanner.next();
                boolean check = studenttoswap.getAccount().validate(studentnameSwap, studentpassSwap);
                if (check) {
                    passwordcheck = true;
                } else {
                    System.out.println("Student not validated. Please re-enter password!");
                }
            }while(!passwordcheck);

        } while(!studentFound);

        boolean myindexFound =false;
        boolean hisindexFound= false;
        int indextoSwapH;
        int indextoSwapM;
        ArrayList<CourseRegistration> assignedCourseSwap = studenttoswap.getAssignedCourse();
        ArrayList<CourseRegistration> assignedCourse = student.getAssignedCourse();
        CourseRegistration mycourseSwap = null;
        CourseRegistration hiscourseSwap = null;
        CourseRegistration courseSwaptome = null;
        CourseRegistration courseSwaptohim = null;
        while(!hisindexFound) {
            while (true) {
                try {
                    System.out.println("Enter index of student to swap with: ");
                    indextoSwapH = scanner.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a index number.");
                }
            }
            for (CourseRegistration course : assignedCourseSwap) {
                if (course.getIndex().getIndexNo() == indextoSwapH) {
                    hiscourseSwap = course;
                    courseSwaptome = new CourseRegistration(course.getIndex(), course.getCourseCode(), course.getCourseName(), course.getAu(), student);
                    hisindexFound = true;
                    break;
                }
            }
            if (!hisindexFound) {
                System.out.println("Index not found! Please re-enter");
                continue;
            }
        }

        while(!myindexFound) {
            while (true) {
                try {
                    System.out.println("Enter your index to swap: ");
                    indextoSwapM = scanner.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a index number.");
                }
            }
            for (CourseRegistration course : assignedCourse) {
                if (course.getIndex().getIndexNo() == indextoSwapM) {
                    mycourseSwap = course;
                    courseSwaptohim = new CourseRegistration(course.getIndex(), course.getCourseCode(), course.getCourseName(), course.getAu(), studenttoswap);
                    myindexFound = true;
                    break;
                }
            }
            if (!myindexFound) {
                System.out.println("Index not found! Please re-enter");
                continue;
            }
        }

        int choice = 0;
        do{
            System.out.println("Confirm to swap course?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    student.removeAssignedCourse(mycourseSwap);
                    studenttoswap.removeAssignedCourse(hiscourseSwap);
                    student.addAssignedCourse(courseSwaptome);
                    studenttoswap.addAssignedCourse(courseSwaptohim);
                    System.out.println("Index swap successfully.");
                    break;
                case 2:
                    System.out.println("Index not swapped!");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }while (choice != 1|| choice!= 2);


    }
        


    public void register(){

    }

    private void checkTimeClash(String indexno){
        boolean coursefound = false;
        ArrayList<Index> indexlist = null;

        while(!coursefound) {
            System.out.println("Enter course code :");
            String coursecode = scanner.next();

            // Get list of index for course
            for (Course course : courseList) {
                if (course.getCourseCode() == coursecode) {
                    indexlist = course.getIndexList();
                    System.out.println("List of indexes in " + coursecode + " are:");
                    for (Index index : indexlist) {
                        System.out.println(index.getIndexNo());
                    }
                    coursefound = true;
                    break;
                }
            }
            if (!coursefound) {
                System.out.println("Enter a valid course.");
            }

        }

        int checkindex = 0;
        boolean indexExist = false;
        boolean clashAssigned = false;
        boolean clashRegistered = false;

        Index indextoCheck = null;
        ArrayList<CourseRegistration> assignedcourse = student.getAssignedCourse();
        ArrayList<CourseRegistration> registeredcourse = student.getWaitList();

        while(!indexExist) {
            while (true) {
                try {
                    System.out.println("Enter Index number to check:");
                    checkindex = scanner.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a index number.");
                }
            }

            for (Index index : indexlist) {
                if (index.getIndexNo() == checkindex) {
                    indextoCheck = index;
                    indexExist = true;
                    break;
                }
            }
            if (!indexExist){
                System.out.println("Index does not exists");
            }
        }

        // Check clash in assigned course
        for (CourseRegistration courseA: assignedcourse){
            if (courseA.getIndex().checkClash(indextoCheck)){
                System.out.println(indextoCheck.getIndexNo() + " clashes with " + courseA.getIndex().getIndexNo());
                clashAssigned = true;
            }
        }

        // Check clash in registered course
        for(CourseRegistration courseR: registeredcourse){
            if (courseR.getIndex().checkClash(indextoCheck)){
                System.out.println(indextoCheck.getIndexNo() + " clashes with " + courseR.getIndex().getIndexNo());
                clashRegistered = true;
            }
        }

        if (!clashAssigned & !clashRegistered){
            System.out.println("Index does not clash with current timetable.");
        }
        else if (clashAssigned){
            System.out.println("Index clash with assigned timetable.");
        }
        else if(clashRegistered){
            System.out.println("Index clash with registered timetable.");
        }

    }


}
