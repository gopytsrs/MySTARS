package Entity;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a school that students belong to. A school can have many students.
 * A school can have many courses that belong to it.
 */
public class School implements Serializable {

    static Scanner sc = new Scanner(System.in);
    /**
     * The name of the school.
     */
    private String schoolName;
    /**
     * The access period of the school for accessing the system.
     */
    private AccessPeriod accessPeriod;
    /**
     * The list of courses that the school has.
     */
    private ArrayList<Course> courseList;

    /**
     * Creates a new School with the given name, access period, and initialises an empty list of courses.
     * @param schoolName The name of the school.
     * @param accessPeriod The accessperiod of the school.
     */
    public School(String schoolName, AccessPeriod accessPeriod) {
        this.schoolName = schoolName;
        this.accessPeriod = accessPeriod;
        this.courseList = new ArrayList<Course>();

    }

    /**
     * Gets the name of the school.
     * @return The name of the school.
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * The Gets the access period of the school.
     * @return The access period of the school, returns an AccessPeriod object.
     */
    public AccessPeriod getAccessperiod() {
        return accessPeriod;
    }

    /**
     * Gets the list of courses that the school has.
     * @return The list of courses that the school has.
     */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }                                               //1 course or whole list?

    /**
     * Sets the access period of the school based on the start and end date time.
     * @param startDate The start datetime of the access period.
     * @param endDate The end datetime of the access period.
     */
    public void setAccessPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        this.accessPeriod.setStartDate(startDate);
        this.accessPeriod.setEndDate(endDate);
    }                                               //is this really how to set the class access period?

    /**
     * Sets the name of the school.
     * @param schoolName The name to set.
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * Adds a course to the school's course list.
     * @param C The course to add. Should be a Course object.
     */
    public void setCourseList(Course C) {
        courseList.add(C);
    }        //purely to generate data in binary file

    /**
     * Adds a course to the school. Is used by the AdminControl class to add a new course.
     */
    public void addCourse() {
        String courseCode;
        String courseName;
        int au;
        System.out.println("Enter the Course Code (ALL CAPITALISED): ");
        courseCode = sc.nextLine();
        for (Course c : this.courseList) {
            if (courseCode.equals(c.getCourseCode())) {
                System.out.println("Course Code already exists!"); //Exits
                return;
            }
        }
        System.out.println("Enter the course name: ");
        courseName = sc.nextLine();
        //Should capitalise in order to check
        for (Course c : this.courseList) {
            while (courseName.equals(c.getCourseName())) {
                System.out.println("Course Name already exists! Enter course name again: ");
                courseName = sc.nextLine();
            }
        }

        boolean checkAu = false;
        au = -1;
        System.out.print("Enter number of AU for this course: ");
        while (!checkAu) {
            try {
                String dummy = sc.next();
                au = Integer.parseInt(dummy);
                checkAu = true;
            } catch (Exception e) {
                System.out.println("Input should be an integer! Please try again: ");
            }
        }

        while (au < 1 || au > 10) {
            System.out.println("Invalid AU count! Enter AU again: ");
            try {
                String dummy = sc.next();
                au = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Input should be an integer!");
            }
        }

        Course C1 = new Course(courseCode, courseName, au);
        courseList.add(C1);

        boolean doesIndexExist = false;
        while(true){
            if (!doesIndexExist){
                C1.addIndex();
                doesIndexExist = true;
            }
            System.out.println("1. Add More Index");
            System.out.println("2. Stop");
            if (doesIndexExist) {
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
                    if (option < 0 || option > 2) {
                        System.out.println("Invalid choice! Select school again: ");
                    }
                } while (option < 0 || option > 2);

                if (option == 1)
                    C1.addIndex();

                else if (option == 2)
                    break;
            }
        }
    }

    /**
     * Gets the course code of a course in the school's course list.
     * @param i The index of the course in the school's course list.
     * @return The course code of the course at index i in the school's course list.
     */
    public String getCourseCode(int i){
        return courseList.get(i).getCourseCode();
    }

    /**
     * Checks whether the given string can be parsed to an integer. A helper method to verify input in
     * the addCourse method.
     * @param str The string to parse.
     * @return true or false depending on whether the given String can be parsed to an integer.
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
}
