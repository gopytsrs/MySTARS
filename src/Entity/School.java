package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class School implements Serializable {

    static Scanner sc = new Scanner(System.in);
    private String schoolName;
    private AccessPeriod accessperiod;
    private ArrayList<Course> courseList;

    public School(String schoolName, AccessPeriod accessperiod) {
        this.schoolName = schoolName;
        this.accessperiod = accessperiod;
        this.courseList = new ArrayList<Course>();

    }

    public String getSchoolName() {
        return schoolName;
    }

    public AccessPeriod getAccessperiod() {
        return accessperiod;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }                                               //1 course or whole list?

    public void setAccessPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        this.accessperiod.setStartDate(startDate);
        this.accessperiod.setEndDate(endDate);
    }                                               //is this really how to set the class access period?

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setCourseList(Course C) {
        courseList.add(C);
    }        //purely to generate data in binary file

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
        System.out.println("Enter the course name");
        courseName = sc.nextLine();
        //Should capitalise in order to check
        for (Course c : this.courseList) {
            while (courseName.equals(c.getCourseName())) {
                System.out.println("Course Name already exists! Enter course name again: ");
                courseName = sc.nextLine();
            }
        }

        System.out.print("Enter number of AU for this course: ");
        au = sc.nextInt();
        while (au < 1 || au > 10) {
            System.out.println("Invalid AU count! Enter AU again: ");
            au = sc.nextInt();
        }

        Course C1 = new Course(courseCode, courseName, au);
        courseList.add(C1);

        int choice;
        while(true){
            System.out.println("Key 1 to add index");
            System.out.println("Key 2 to stop");
            choice = sc.nextInt();
            if (choice == 2)
                break;
            C1.addIndex();
        }

    }
}
