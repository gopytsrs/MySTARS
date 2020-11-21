package Control;

import Entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
    private Student student;
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<School> schoolList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    Console console = System.console();

    //Create StudentControl using this constructor
    public StudentControl(Student student) {
        String schCode = student.getSchoolName();


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
                this.student = student1;
                break;
            }
        }
        //studentList.remove(student);
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
        int courseName = 0;
        int indexno;
        Course courseChosen = null;
        Index indexChosen = null;
        ArrayList<CourseRegistration> registeredCourse = student.getAssignedCourse();
        ArrayList<CourseRegistration> waitListCourse = student.getWaitList();
        boolean indexExists = false;
        boolean courseExists = false;
        courseName = -1;
        do {
            int i = 0;
            System.out.println("Please enter course code to add course:");
            for (Course courseL : courseList) {
                System.out.println((i + 1) + ": " + courseL.getCourseCode() + " - " + courseL.getCourseName());
                i++; //1, 2, 3, 4
            }
            do {
                System.out.println("Enter your choice here: ");
                String dummy = scanner.next();
                boolean check = isInteger(dummy);
                if (check == false) {
                    System.out.println("Input should be an integer.");
                    continue;
                }
                courseName = Integer.parseInt(dummy);
                courseName -= 1;
                if (courseName >= 0 && courseName < i-1) { //if courseName is 0, 1, 2, 3
                    courseExists = true;
                    courseChosen = courseList.get(courseName);
                }
                else { //if not, it comes here
                    System.out.println("Choice is out of range, try again.");
                }
            } while (courseName < 0 || courseName >= i);

//            for (Course course : courseList) {
//                if (course.getCourseCode().equals(courseName)) {
//                    courseExists = true;
//                    courseChosen = course;
//                    break;
//                }
//            }

//            if (!courseExists) {
//                System.out.println("Please enter valid course code!");
//                continue;
//            }

            if (!registeredCourse.isEmpty())
            {
                for (CourseRegistration alreadyRegisteredCourse : registeredCourse) {
                    if (courseChosen.getCourseCode().equals(alreadyRegisteredCourse.getCourseCode())) {
                        System.out.println("Already registered the course. Index: " + alreadyRegisteredCourse.getIndex().getIndexNo());
                        return;
                    }
                }
            }

            if (!waitListCourse.isEmpty())
            {
                for (CourseRegistration aboutToRegisterCourse : waitListCourse) {
                    if (courseChosen.getCourseCode().equals(aboutToRegisterCourse.getCourseCode())) {
                        System.out.println("Already added this course to the waitlist. Index: " + aboutToRegisterCourse.getIndex().getIndexNo());
                        return;
                    }
                }
            }


        } while (!courseExists);

        ArrayList<Index> indexList = courseChosen.getIndexList();

        do {
            int j = 0;
            int indexName = 0;

            for (Index indexL : indexList) {
                j++;
                System.out.println(j + ": " + indexL.getIndexNo());
            }
            indexName = -1;
            do {
                System.out.println("Please enter index to add: ");
                String dummy = scanner.next();
                boolean check = isInteger(dummy);
                if (check == false) {
                    System.out.println("Input should be an integer.");
                    continue;
                }
                indexName = Integer.parseInt(dummy);
                indexName -= 1;
                if (indexName >= 0 && indexName < j-1) {
                    indexExists = true;
                    indexChosen = indexList.get(indexName);
                } else { //if not, it comes here
                    System.out.println("Choice is out of range, try again.");
                }
            } while (indexName < 0 || indexName >= j);

//            indexno = scanner.nextInt();
//            for (Index index : indexList) {
//                if (index.getIndexNo() == indexno) {
//                    indexExists = true;
//                    indexChosen = index;
//                    break;
//                }
//            }
//            if (!indexExists) {
//                System.out.println("Please enter valid index!");
//            }
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
                    if (!waitListCourse.isEmpty() || !registeredCourse.isEmpty()) {
                        int checkclash = student.checkTimeClash(newCourse.getIndex());
                        if (checkclash == 0) {
                            canAdd = true;
                        }
                        if (canAdd) {
                            if (student.checkAU(newCourse) && indexChosen.assignStudent(student)) {
                                student.addAssignedCourse(newCourse);
                                System.out.println("Successfully registered for course " + newCourse.getCourseName() + ", index " + indexChosen.getIndexNo());
                                return;
                            } else if (!student.checkAU(newCourse)) {
                                break;
                            } else {
                                student.addWaitList(newCourse);
                                indexChosen.addToWaitlist(student);
                                System.out.println("Added to waitlist");
                                return;

                            }
                        }
                    }
                    else if (student.checkAU(newCourse) && indexChosen.assignStudent(student)) {
                        student.addAssignedCourse(newCourse);
                        System.out.println("Successfully registered for course " + newCourse.getCourseName() + ", index " + indexChosen.getIndexNo());
                        return;
                    } else if(student.checkAU(newCourse) && !indexChosen.assignStudent(student)){
                        student.addWaitList(newCourse);
                        indexChosen.addToWaitlist(student);
                        System.out.printf("Added %d of %s to waitlist.%n",indexChosen.getIndexNo(),newCourse.getCourseCode());
                    }

                    break;
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

        int droppingCourse = 0;
        int lastChoice = 0;
        int lastChoice2 = 0;
        int i = 0;

        //Check if course is registered, exits method if course is not registered
        System.out.println("Assigned Courses");
        for (i = 0; i < student.getAssignedCourse().size(); i++) {
            System.out.println((i + 1) + ": " + student.getAssignedCourse().get(i)); //0, 1, 2 = 1, 2, 3
            lastChoice = i; //2
        }

        //i = 3, ...
        System.out.println("WaitList Courses");
        for (i = lastChoice+1; i < lastChoice + 1 + student.getWaitList().size(); i++){
            System.out.println((i + 1) + ": " + student.getWaitList().get(i-lastChoice-1));
            lastChoice2 = i;
        }

        try {
            try {
                while (!courseFound) {
                    System.out.println("Enter the choice of the course you want to drop: ");
                    String dummy = scanner.next();
                    boolean check = isInteger(dummy);
                    if (check == false) {
                        System.out.println("Input should be an integer.");
                        continue;
                    }
                    droppingCourse = Integer.parseInt(dummy);
                    droppingCourse -= 1;       //assuming you pick 3, droppingCourse = 2, lastChoice = 2
                    if (droppingCourse >= 0 && droppingCourse < student.getAssignedCourse().size()) {   //start from 0 to index
                        courseFound = true;
                        courseToDrop = student.getAssignedCourse().get(droppingCourse);

                        // droppingCourse = 3, last choice = 2   droppingCourse = 3, 2 + 1 + 1
                    } else if (droppingCourse >= student.getAssignedCourse().size() && droppingCourse < student.getAssignedCourse().size()+student.getWaitList().size()) {
                        courseFound = true;                      //assuming you choose 4, droppingCourse = 3, lastChoice = 2,
                        courseToDrop = student.getWaitList().get(droppingCourse - student.getAssignedCourse().size());
                    } else {
                        System.out.println("Choice is out of range, please try again.");
                    }

                    Index I1 = new Index();
                    boolean waitlistcheck = false;
                    boolean assignedlistcheck = false;
                    for (Course courses : courseList) {
                        if (courses.getCourseCode().equals(courseToDrop.getCourseCode())) {
                            for (Index I : courses.getIndexList()) {
                                if (I.getIndexNo() == courseToDrop.getIndex().getIndexNo()) {
                                    I1 = I;
                                    if (waitlistCourses.contains(courseToDrop) && (!assignedCourses.contains(courseToDrop))) {
                                        waitlistcheck = true; //edit
                                        break;

                                    } else if (assignedCourses.contains(courseToDrop)) {
                                        //Remove student from index
                                        assignedlistcheck = true;
                                        break;     //edit
                                    }
                                }
                            }

                        }
                    }

                    if (waitlistcheck) {
                        I1.removeFromWaitlist(student);
                        student.removeWaitList(courseToDrop);
                        System.out.printf("Removed %s from waitlist%n", courseToDrop.getCourseCode());
                    } else if (assignedlistcheck) {
                        I1.removeStudentFromAssigned(student);
                        student.removeAssignedCourse(courseToDrop);
                        System.out.printf("Dropped %s from assigned courses%n", courseToDrop.getCourseCode());
                    }

                    if (!I1.getWaitList().isEmpty() && I1.getVacancy() > 0) {
                        Student Firstinlist = I1.getWaitList().remove(0);
                        I1.assignStudent(Firstinlist);
                        if (Firstinlist == null) {
                            System.out.println('a');
                            return;
                        }
                        Student student1 = null;
                        for (Student student : studentList) {
                            if (student.getEmail().equals(Firstinlist.getEmail())) {
                                student1 = student;

                            }
                        }
                        if (student1 != null) {
                            student1.addAssignedCourse(courseToDrop);
                            student1.removeWaitList(courseToDrop);
                        }
                        notificationControl n = new notificationControl();
                        n.sendemail(Firstinlist, courseToDrop);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Choice is out of range.");
            }
        } catch (NullPointerException e) {
            System.out.println("Input should be an integer.");
        }
    }

//                String courseCode = scanner.nextLine();
//
//                for (CourseRegistration course : all) {
//                    if (course.getCourseCode().equals(courseCode)) {
//                        courseToDrop = course;
//                        courseFound = true;
//                        break;
//                    }
//                }
//                if (!courseFound) {
//                    System.out.println("You are not registered for " + courseCode);
//                    return;
//                }

    public void printRegisteredCourses() {

        ArrayList<CourseRegistration> waitListCourses = student.getWaitList();
        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();

        System.out.println("Course Code:\tCourse Name:\tIndex:\tAU:");

        //Go through all the courses, each course is printed on a new line
        System.out.println("Assigned Courses: ");
        if (assignedCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (CourseRegistration course : assignedCourses) {
                System.out.println(course);
            }
        }
        System.out.println("Waitlist Courses: ");
        if (waitListCourses.isEmpty()) {
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
        //Loop through indexList of each course to find if the index exists
        for (Course course : courseList) {
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
                    System.out.println("\n");

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
                System.out.println("\n");
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
            }
//            else if (desiredIndex.getVacancy() == 0) {
//                System.out.printf("Index %d has no vacancies", desiredIndex.getIndexNo());
//                validIndex = false;
//            }
          else {
                for (CourseRegistration c1 : all) {
                    if (c1.getIndex() == desiredIndex) {
                        System.out.println("Already registered for index " + desiredIndex.getIndexNo());
                        validIndex = false;
                        break;
                    } else if (c1.getIndex().checkClash(desiredIndex) && !(c1.getCourseCode().equals(desiredIndex.getCourseCode()))) {
                        int indexNo = c1.getIndex().getIndexNo();
                        String courseCode = c1.getCourseCode();
                        System.out.printf("Clash found! %d of %s clashes with new index %d of %s.%n", indexNo, courseCode, desiredIndex.getIndexNo(), desiredIndex.getCourseCode());
                        validIndex = false;
                        break;
                    }
                }

            }
            if (validIndex) {
                //From assigned in old to assigned in new
                if (currentIndex.getAssignedStudents().contains(student) && desiredIndex.getVacancy() > 0) {
                    System.out.println(desiredIndex.getCourseCode());
                    System.out.printf("Changed from Index %d to Index %d %n", currentIndexNo, desiredIndexNo);
                    currentIndex.removeStudentFromAssigned(student);
                    desiredIndex.assignStudent(student);
                    student.updateIndex(currentIndex,desiredIndex,false);

                //From waitList in old to assigned in new
                } else if (currentIndex.getWaitList().contains(student) && desiredIndex.getVacancy() > 0){
                    System.out.println(desiredIndex.getCourseCode());
                    System.out.printf("Changed from Index %d to Index %d %n", currentIndexNo, desiredIndexNo);
                    currentIndex.removeFromWaitlist(student);
                    desiredIndex.assignStudent(student);
                    student.updateIndex(currentIndex,desiredIndex,true);

                //From waitlist in old to waitlist in new
                } else if (currentIndex.getWaitList().contains(student) && desiredIndex.getVacancy() == 0) {
                    System.out.println(desiredIndex.getCourseCode());
                    System.out.printf("Changed waitlist from Index %d to Index %d %n", currentIndexNo, desiredIndex);
                    currentIndex.removeFromWaitlist(student);
                    desiredIndex.addToWaitlist(student);
                    student.updateIndex(currentIndex,desiredIndex,false);

                //From assigned in old to waitList in new, not allowed
                } else {
                    System.out.println("Not allowed!");
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
//                char [] pw= console.readPassword("Please enter password of student to swap index with:\n");
//                studentpassSwap = String.valueOf(pw);
                System.out.println("Please enter password of student to swap index with:");
                studentpassSwap = scanner.nextLine();
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
                    student.removeAssignedCourse(mycourseSwap);
                    studenttoswap.removeAssignedCourse(hiscourseSwap);

                    int checkmyclash = student.checkTimeClash(hisIndex);
                    int checkhisclash = studenttoswap.checkTimeClash(myindex);
                    if (checkmyclash == 0 & checkhisclash == 0) {
                        canSwap = true;
                    }
                    if (canSwap) {
                        // Editing student data
                        hisIndex.removeStudentFromAssigned(studenttoswap);
                        myindex.removeStudentFromAssigned(student);

                        myindex.assignStudent(studenttoswap);
                        hisIndex.assignStudent(student);

                        // Editing school data
                        boolean assignedM = false;
                        boolean assignedH = false;
                        for (Course c: courseList){
                            if (c.getCourseCode().equals(myindex.getCourseCode())){
                                for (Index i: c.getIndexList()){
                                    if (i.getIndexNo() == myindex.getIndexNo()){
                                        i.removeStudentFromAssigned(student);
                                        assignedM = i.assignStudent(studenttoswap);
                                    }
                                    else if (i.getIndexNo() == hisIndex.getIndexNo()){
                                        i.removeStudentFromAssigned(studenttoswap);
                                        assignedH = i.assignStudent(student);
                                    }

                                    if(assignedM && assignedH){
                                        break;
                                    }
                                }
                            }
                        }

                        student.addAssignedCourse(courseSwaptome);
                        studenttoswap.addAssignedCourse(courseSwaptohim); //working fine

                        student.updateIndex(myindex, hisIndex, false);
                        studenttoswap.updateIndex(hisIndex, myindex, false);

                        System.out.println("Index swap successfully.");             //add changes in student to index
                    } else {
                        System.out.println("Timetable clashes for account");
                        student.addAssignedCourse(mycourseSwap);
                        studenttoswap.addAssignedCourse(hiscourseSwap);
                    }
                    break;
                case 2:
                    System.out.println("Index not swapped!");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        } while (choice != 1 && choice !=2);

    }
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
            //studentList.add(student);
            FileOutputStream fileOut = new FileOutputStream(studentFileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
}
