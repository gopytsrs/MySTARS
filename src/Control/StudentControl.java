package Control;

import Entity.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
    private Student student;
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    //Create StudentControl using this constructor
    public StudentControl(Student student) {
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

        for (Student student1 : studentList) {
            if (student1.getName().equals(student.getName())) {
                this.student = student;
                break;
            }
        }

        for (School school : schoolList) {
            if (student.getSchoolName().equals(school.getSchoolName())) {
                this.courseList = school.getCourseList();
                break;
            }
        }

    }

    public void addCourse() {
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
        do {
            System.out.println("Please enter course code to add course:");
            for (Course courseL : courseList) {
                System.out.println(courseL.getCourseCode() + ": " + courseL.getCourseName());
            }

            courseName = scanner.next();
            if (courseName.isEmpty()) continue;

            for (Course course : courseList) {
                if (course.getCourseCode().equals(courseName)) {
                    courseExists = true;
                    courseChosen = course;
                    break;
                }
            }

            if (!courseExists) {
                System.out.println("Please enter valid course code!");
                continue;
            }

            if (registeredCourse != null)
            {
                for (CourseRegistration aboutToRegisterCourse : registeredCourse) {
                    if (courseChosen.equals(aboutToRegisterCourse)) {
                        System.out.print("Already registered the course. Index: " + aboutToRegisterCourse.getIndex().getIndexNo());
                        break;
                    }
                }
            }

            if (waitListCourse != null)
            {
                for (CourseRegistration aboutToRegisterCourse : waitListCourse) {
                    if (courseChosen == null)
                        break;
                    else if (courseChosen.equals(aboutToRegisterCourse)) {
                        System.out.println("Already added this course to the waitlist. Index: " + aboutToRegisterCourse.getIndex().getIndexNo());
                        break;
                    }
                }

            }


        } while (!courseExists);

        ArrayList<Index> indexList = courseChosen.getIndexList();

        do {
            System.out.println("Please enter index to add:");
            for (Index indexL : indexList) {
                System.out.println(indexL.getIndexNo());
            }
            indexno = scanner.nextInt();
            for (Index index : indexList) {
                if (index.getIndexNo() == indexno) {
                    indexExists = true;
                    indexChosen = index;
                    break;
                }
            }
            if (!indexExists) {
                System.out.println("Please enter valid index!");
            }
        } while (!indexExists);

        CourseRegistration newCourse = new CourseRegistration(indexChosen, indexChosen.getCourseCode(), courseChosen.getCourseName(), courseChosen.getAu(), student);
        int choice = 0;
        boolean canAdd = false;
        do {
            System.out.println("Confirm to add " + indexChosen.getCourseCode() + " index " + indexChosen.getIndexNo() + "?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    if (waitListCourse != null || registeredCourse != null) {
                        int checkclash = student.checkTimeClash(newCourse.getIndex());
                        if (checkclash == 0) {
                            canAdd = true;
                        }
                        if (canAdd) {
                            if (student.addAssignedCourse(newCourse) && indexChosen.assignStudent(student)) {
                                System.out.println("Successfully registered for course " + newCourse.getCourseName() + ", index " + indexChosen.getIndexNo());
                            } else if (!student.addAssignedCourse(newCourse)) {
                                break;
                            } else {
                                student.addWaitList(newCourse);
                                indexChosen.addToWaitlist(student);
                                System.out.println("Added to waitlist");
                            }
                        }
                    }
                    if (student.addAssignedCourse(newCourse) && indexChosen.assignStudent(student)) {
                        System.out.println("Successfully registered for course " + newCourse.getCourseName() + ", index " + indexChosen.getIndexNo());
                        break;
                    }
                }

                case 2:
                    System.out.println("Course not added.");
                    break;
                default:
                    break;
            }
        }while (choice < 1 || choice > 2);
        }

    public void dropCourse() {
        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitlistCourses = student.getWaitList();
        ArrayList<CourseRegistration> all = new ArrayList<CourseRegistration>();
        all.addAll(assignedCourses);
        all.addAll(waitlistCourses);

        CourseRegistration courseToDrop = null;
        boolean courseFound = false;


        //Check if course is registered, exits method if course is not registered
        while (!courseFound) {
            System.out.println("Enter course code you want to drop:");
            String courseCode = scanner.nextLine();

            for (CourseRegistration course : all) {
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

        for (CourseRegistration course : all) {
            if (course.getCourseCode().equals(courseToDrop.getCourseCode())) {
                Index index = course.getIndex();

                //Branch to check if course is registered only or assigned.

                if (waitlistCourses.contains(courseToDrop) && (!assignedCourses.contains(courseToDrop))) {
                    index.removeFromWaitlist(student);

                    student.removeWaitList(courseToDrop);
                    System.out.printf("Removed %s from waitlist",courseToDrop.getCourseCode());

                    return;

                } else if (assignedCourses.contains(courseToDrop)) {
                    //Remove student from index
                    index.removeStudentFromAssigned(student);
                    student.removeAssignedCourse(courseToDrop);
                    System.out.printf("Dropped %s from assigned courses", courseToDrop.getCourseCode());
                    return;
                }
                break;
            }
        }

        if (courseToDrop.getIndex().getWaitList() != null && courseToDrop.getIndex().getVacancy() > 0)
        {
            Student Firstinlist = courseToDrop.getIndex().getWaitList().remove();
            courseToDrop.getIndex().assignStudent(Firstinlist);
            Firstinlist.addAssignedCourse(courseToDrop);
            Firstinlist.removeWaitList(courseToDrop);
            notificationControl n = new notificationControl(Firstinlist,courseToDrop);
        }
    }

    public void printRegisteredCourses() {

        ArrayList<CourseRegistration> waitListCourses = student.getWaitList();
        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();

        System.out.println("Course Code:\tCourse Name:\tIndex:\tAU:");

        //Go through all the courses, each course is printed on a new line
        System.out.println("Assigned Courses: ");
        if (assignedCourses == null) {
            System.out.println("No courses registered.");
        } else {
            for (CourseRegistration course : assignedCourses) {
                System.out.print(course);
            }
        }

        System.out.println("Waitlist Courses: ");
        if (waitListCourses == null) {
            System.out.println("No courses in the waitlist.");
        } else {
            for (CourseRegistration course : waitListCourses) {
                System.out.println(course);
            }
        }
    }

    public void checkAvailableSlots() {
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
        for (Course course : courses) {
            ArrayList<Index> indexes = course.getIndexList();
            for (Index index : indexes) {
                //Index exists, print out the vacancies and exit the method

                if(index.getIndexNo() == indexNo){

                    int total;
                    if (index.getAssignedStudents() == null) {
                        total = index.getVacancy();
                    } else {
                        total = index.getVacancy() + index.getAssignedStudents().size();
                    }
                    System.out.printf("The number of available slots in Index %d of %s is %d/%d", index.getIndexNo(), index.getCourseCode(), index.getVacancy(), total);

                    return;

                }
            }
        }

        //Loop ends without finding the index
        System.out.println("That index number does not exist");
    }

    public void changeIndex() {
        ArrayList<CourseRegistration> assigned = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitlist = student.getWaitList();
        //Join two together so easier to check clash -> only need one for loop
        ArrayList<CourseRegistration> all = new ArrayList<>();
        all.addAll(assigned);
        all.addAll(waitlist);

        CourseRegistration courseR = null;
        Index currentIndex = null;
        Index desiredIndex = null;
        int currentIndexNo = 0;
        int desiredIndexNo = 0;
        boolean validIndex = false;

        while (!validIndex) {
            try {
                printRegisteredCourses();
                System.out.println("Enter current index no. you have");
                currentIndexNo = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter an index number.");
            }
            for (CourseRegistration courseRegistration : all) {
                if (courseRegistration.getIndex().getIndexNo() == currentIndexNo) {
                    currentIndex = courseRegistration.getIndex();
                    courseR = courseRegistration;
                    validIndex = true;
                }
            }
            if (!validIndex)
                System.out.println("You are not registered for that index! Enter a valid index number.");
        }
        ArrayList<Index> indexList = null;


        Course course = null;
        for(Course c: courseList){
            if(c.getCourseCode().equals(courseR.getCourseCode())){

                indexList = c.getIndexList();
                course = c;
            }
        }

        validIndex = false;

        while (!validIndex) {
            try {
                course.printIndexList();
                System.out.println("Enter index no. to change to.");
                desiredIndexNo = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid index number!");
            }

            for (Index index : indexList) {
                if (index.getIndexNo() == desiredIndexNo) {
                    desiredIndex = index;
                    validIndex = true;
                }
            }
            if (!validIndex) {
                System.out.println("That index number does not exist!");
            } else if (desiredIndex.getVacancy() == 0) {
                System.out.printf("Index %d has no vacancies", desiredIndex.getIndexNo());
                validIndex = false;
            } else {
                for (CourseRegistration c1 : all) {
                    if (c1.getIndex() == desiredIndex) {
                        System.out.println("Already registered for index " + desiredIndex.getIndexNo());
                        validIndex = false;
                        break;
                    } else if (c1.getIndex().checkClash(desiredIndex)) {
                        int indexNo = c1.getIndex().getIndexNo();
                        String courseCode = c1.getCourseCode();
                        System.out.printf("Clash found! %d of %s clashes with new index %d of %s.%n", indexNo, courseCode, desiredIndex.getIndexNo(), desiredIndex.getCourseCode());
                        validIndex = false;
                        break;
                    }
                }

            }
            if (validIndex) {
                desiredIndex.assignStudent(student);
                System.out.println(desiredIndex.getCourseCode());
                System.out.printf("Changed from Index %d to Index %d", currentIndexNo, desiredIndexNo);
                if (currentIndex.getAssignedStudents().contains(student)) {
                    currentIndex.removeStudentFromAssigned(student);
                } else if (currentIndex.getWaitList().contains(student)) {
                    currentIndex.removeFromWaitlist(student);
                }
            }
        }
    }


    public void swapIndex() {
        // Enter peer's index to swap
        //Check student name to swap, from assigned courses check if index exists
        // If exists and not clash swap.

        boolean studentFound = false;
        boolean passwordcheck = false;
        String studentnameSwap;
        String studentpassSwap;
        Student studenttoswap = null;
        do {
            System.out.println("Please enter username of student to swap index with: ");
            studentnameSwap = scanner.next();
            for (Student student : studentList) {
                if (student.getAccount().getUsername().equals(studentnameSwap)) {
                    studenttoswap = student;
                    studentFound = true;
                    break;
                }
            }
            if (!studentFound) {
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
            } while (!passwordcheck);

        } while (!studentFound);

        boolean myindexFound = false;
        boolean hisindexFound = false;
        int indextoSwapH;
        int indextoSwapM;
        Index myindex = null;
        Index hisIndex = null;
        ArrayList<CourseRegistration> assignedCourseSwap = studenttoswap.getAssignedCourse();
        ArrayList<CourseRegistration> assignedCourse = student.getAssignedCourse();
        CourseRegistration mycourseSwap = null;
        CourseRegistration hiscourseSwap = null;
        CourseRegistration courseSwaptome = null;
        CourseRegistration courseSwaptohim = null;
        while (!hisindexFound) {
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
                    hisIndex = course.getIndex();
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

        while (!myindexFound) {
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
                    myindex = course.getIndex();
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
        boolean canSwap = false;
        do {
            System.out.println("Confirm to swap course?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int checkmyclash = student.checkTimeClash(hisIndex);
                    int checkhisclash = studenttoswap.checkTimeClash(myindex);
                    if (checkmyclash == 0 & checkhisclash == 0) {
                        canSwap = true;
                    }
                    if (canSwap) {
                        student.removeAssignedCourse(mycourseSwap);
                        studenttoswap.removeAssignedCourse(hiscourseSwap);
                        student.addAssignedCourse(courseSwaptome);
                        studenttoswap.addAssignedCourse(courseSwaptohim);
                        System.out.println("Index swap successfully.");
                    } else {
                        System.out.println("Timetable clashes for account");
                    }
                    break;
                case 2:
                    System.out.println("Index not swapped!");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        } while (choice != 1 || choice != 2);

    }


}
