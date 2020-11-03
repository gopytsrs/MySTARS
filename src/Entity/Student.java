package Entity;

import java.util.ArrayList;

public class Student {
    private String name;
    private String matricNo;
    private String email;
    private int year;
    private String gender;
    private int noOfAUS;
    private School school;
    private ArrayList<Course> plannedCourses;
    private ArrayList<Course> assignedCourses;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNoOfAUS() {
        return noOfAUS;
    }

    public void setNoOfAUS(int noOfAUS) {
        this.noOfAUS = noOfAUS;
    }

    public ArrayList<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public ArrayList<Course> getPlannedCourses() {
        return plannedCourses;
    }

    public void setAssignedCourses(ArrayList<Course> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public void setPlannedCourses(ArrayList<Course> plannedCourses) {
        this.plannedCourses = plannedCourses;
    }

    public void addAssignedCourses(Course course){

    }
    public void addPlannedCourses(Course course) {

    }
    public void removeAssignedCourses(Course course){

    }
    public void addNoOfAU(int au){

    }
}
