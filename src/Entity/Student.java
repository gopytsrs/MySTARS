package Entity;

import java.io.Serializable;
import java.util.ArrayList;

//Important notes:
//Account is created in this class, to update the values passed into account constructor
//Entity should pass all attributes into the constructor of student class
public class Student implements Serializable {

    private String name;
    private String matricNo;
    private String email;
    private int year;
    // private School school;
    private String gender;
    private String nationality;
    private Account account;    //created within this class
    private ArrayList<CourseRegistration> assignedCourse;
    private ArrayList<CourseRegistration> courseRegistrationList;
    private int noOfAUs = 0;
    private final int MAXAU = 23;

    public Student(String name, String matricNo, String email, int year, String gender,
                   String nationality) {    //collect all info from control class
        //Initialise all collected attributes
        setName(name);
        setMatricNo(matricNo);
        setEmail(email);
        setYear(year);
        
        this.email = email;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        //Create new account for student with default username and pw

        this.account = new Account(this.name, "password", "student");    //input
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricNo() {
        return this.matricNo;
    }

    public void setMatricNo(String matric) {
        this.matricNo = matric;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
/*
    public School getSchool() {
        return this.school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
*/

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ArrayList<CourseRegistration> getAssignedCourse() {
        return this.assignedCourse;
    }

    public void addAssignedCourse(CourseRegistration course) {
        this.assignedCourse.add(course);
    }

    public void removeAssignedCourse(CourseRegistration course) {
        this.assignedCourse.remove(course);
    }

    public ArrayList<CourseRegistration> getCourseRegistrationList() {
        return this.courseRegistrationList;
    }

    public void addCourseRegistration(CourseRegistration course) {
        this.courseRegistrationList.add(course);
    }

    public void removeCourseRegistration(CourseRegistration course) {
        this.courseRegistrationList.remove(course);
    }

    public int getNoOfAU() {
        return this.noOfAUs;
    }

    public void addNoOfAU(int au) {
        this.noOfAUs += au;
    }
/*
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t", name, school.getSchoolName(), year, gender, nationality);
    }
*/
}
