package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class School implements Serializable {


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
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the course code: ");
        String courseCode = sc.next();
        System.out.println("Input the course name: ");
        String courseName = sc.next();
        System.out.println("Input the no. of AUs: ");
        int au = sc.nextInt();
        Course C1 = new Course(courseCode, courseName, au);
        courseList.add(C1);
    }                                           //add 1 course to list so not really setting course list
}
