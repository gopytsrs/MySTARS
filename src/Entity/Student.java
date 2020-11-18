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
    private String schoolName;
    private String gender;
    private String nationality;
    private Account account;    //created within this class
    private ArrayList<CourseRegistration> assignedCourse;
    private ArrayList<CourseRegistration> waitList;
    private int noOfAUs = 0;
    private final int MAXAU = 21;

    public Student(String name, String matricNo, String email, int year, String schoolname, String gender,
                   String nationality) {
        //collect all info from control class
        //Initialise all collected attributes
        setName(name);
        setMatricNo(matricNo);
        setEmail(email);
        setYear(year);
        setSchoolName(schoolname);
        setGender(gender);
        setNationality(nationality);
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

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


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

    public ArrayList<CourseRegistration> getWaitList() {
        return this.waitList;
    }

    public void addWaitList(CourseRegistration course) {
        this.waitList.add(course);
    }

    public void removeWaitList(CourseRegistration course) {
        this.waitList.remove(course);
    }

    public int getNoOfAU() {
        return this.noOfAUs;
    }

    public void addNoOfAU(int au) {
        this.noOfAUs += au;
    }

}
