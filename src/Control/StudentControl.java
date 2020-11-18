package Control;

import Entity.*;


import java.io.IOException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
    private Student student;
    private ArrayList<Course> courseList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    //Create StudentControl using this constructor
    public StudentControl(String studentname){
        this.student = student;
        String schCode = student.getSchoolName();

        ArrayList<School> schoolList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();

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
        String courseName;
        int indexno;
        Course courseChosen = null;
        Index indexChosen = null;
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
                //system.out.println(" registered ")
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
        ArrayList<CourseRegistration> assigned = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitlist = student.getWaitList();

        CourseRegistration courseR = null;
        Index currentIndex = null;
        Index desiredIndex = null;
        int currentIndexNo = 0;
        int desiredIndexNo = 0;
        boolean validIndex = false;

        while(!validIndex){
            try{
                printRegisteredCourses();
                System.out.println("Enter index no. you want to change");
                currentIndexNo = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid input! Enter an index number.");
            }
            for(CourseRegistration assignedCourse: assigned){
                if(assignedCourse.getIndex().getIndexNo() == currentIndexNo){
                    currentIndex = assignedCourse.getIndex();
                    courseR = assignedCourse;
                    validIndex = true;
                }
            }
            if(!validIndex)
                System.out.println("You are not registered for that index! Enter a valid index number.");
        }
        ArrayList<Index> indexList = null;
        ArrayList<Course> courses =  new ArrayList<Course>(); //This line should load all course from database
        Course course = null;
        for(Course c: courses){
            if(c.getCourseCode().equals(courseR.getCourseCode())){
                indexList = c.getIndexList();
                course = c;
            }
        }

        validIndex = false;

        while(!validIndex){
            try{
                course.printIndexList();
                System.out.println("Enter index no. to change to.");
                desiredIndexNo = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid index number!");
            }

            for(Index index: indexList){
                if(index.getIndexNo() == desiredIndexNo){
                    desiredIndex = index;
                    validIndex = true;
                }
            }
            if(!validIndex){
                System.out.println("That index number does not exist!");
            } else if (desiredIndex.getVacancy() == 0){
                System.out.printf("Index %d has no vacancies",desiredIndex.getIndexNo());
                validIndex = false;
            } else {
                for(CourseRegistration c1: assigned){
                    if(c1.getIndex()==desiredIndex){
                        System.out.println("Already registered for index " + desiredIndex.getIndexNo());
                        validIndex = false;
                        break;
                    } else if(c1.getIndex().checkClash(desiredIndex)){
                        int indexNo = c1.getIndex().getIndexNo();
                        String courseCode = c1.getCourseCode();
                        System.out.printf("Clash found! %d of %s clashes with new index %d of %s.%n",indexNo,courseCode,desiredIndex.getIndexNo(),desiredIndex.getCourseCode());
                        validIndex = false;
                        break;
                    }
                }

            }
            if(validIndex) {
                desiredIndex.assignStudent(student);
                System.out.println(desiredIndex.getCourseCode());
                System.out.printf("Changed from Index %d to Index %d", currentIndexNo, desiredIndexNo);
            }
        }
    }



    public void swapIndex(){
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
        boolean indexfound = false;
        boolean indexswap = false;
        boolean indexClash = false;
        int swapindex= 0;
        int myindex= 0;
        Index toswap = null;

        while(!indexfound || !indexswap) {
            // Get index to swap to
            while (true) {
                try {
                    System.out.println("Enter Index number to swap to:");
                    swapindex = scanner.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a index number.");
                }
            }
            // Get index to swap with
            while (true) {
                try {
                    System.out.println("Enter Index number to swap with:");
                    myindex = scanner.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a index number.");
                }
            }
            if (swapindex == myindex){
                System.out.println("Index already assigned");
                indexfound = true;
                break;
            }
            // Check if swapindex in indexlist
            ArrayList<CourseRegistration> studentassignedList = student.getAssignedCourse();
            for (Index index:indexlist){
                if (swapindex == index.getIndexNo()){
                    indexfound = true;
                    for (CourseRegistration courseAssigned: studentassignedList) {
                        if (!index.checkClash(courseAssigned.getIndex())) {
                            if (myindex == courseAssigned.getIndex().getIndexNo()){
                                courseAssigned.setIndex(index);
                                indexswap = true;
                                break;
                            }
                        }
                        else{
                            System.out.println("Index clashes with existing timetable.");
                            indexClash= true;
                            break;
                        }
                    }
                }
            }
            if (!indexfound){
                System.out.println("Index to swap does not exist. Select new index number.");
            }
            else if (!indexswap){
                System.out.println("Index to swap with does not exists. Select new index number.");
            }
            else if (indexClash){
                System.out.println("Select new index number.");
            }

        }
        
    }

    public void register(){

    }

    private void checkTimeClash(){
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
