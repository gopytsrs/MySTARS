package Entity;

import java.io.Serializable;
import java.util.ArrayList;

//Important notes:
//Account is created in this class, to update the values passed into account constructor
//Entity should pass all attributes into the constructor of student class

/**
 * Represents a student enrolled in a school. A student can be enrolled in many courses.
 */
public class Student implements Serializable {
    /**
     * The full name of the student.
     */
    private String name;
    /**
     * The matriculation number of the student.
     */
    private String matricNo;
    /**
     * The email address of the student.
     */
    private String email;
    /**
     * The year of study of the student.
     */
    private int year;
    /**
     * The name of the school that the student belongs to.
     */
    private String schoolName;
    /**
     * The gender of the student.
     */
    private String gender;
    /**
     * The nationality of the student.
     */
    private String nationality;
    /**
     * The account of the student.
     */
    private Account account;    //created within this class
    /**
     * A list of courses that the student is assigned to.
     */
    private ArrayList<CourseRegistration> assignedCourse  = new ArrayList<>();
    /**
     * A list of the course that the student is on the waitlist on.
     */
    private ArrayList<CourseRegistration> waitList  = new ArrayList<>();
    /**
     * The current number of AUs.
     */
    private int noOfAUs = 0;
    /**
     * The maximum number of AUs that the student can take.
     */
    private final int MAXAU = 21;

    /**
     * Creates a new student with the give name, matriculation no., email address, year of study, school name, gender.
     * @param name This student's name.
     * @param matricNo This student's matriculation number.
     * @param email This student's email address.
     * @param year The year of study of this student.
     * @param schoolName The name of the school that this student belongs to.
     * @param gender The gender of this student.
     * @param nationality The nationality of this student.
     */
    public Student(String name, String matricNo, String email, int year, String schoolName, String gender,
                   String nationality) {
        //collect all info from control class
        //Initialise all collected attributes
        setName(name);
        setMatricNo(matricNo);
        setEmail(email);
        setYear(year);
        setSchoolName(schoolName);
        setGender(gender);
        setNationality(nationality);
        //Create new account for student with default username and pw
        this.account = new Account(email.replace("@e.ntu.edu.sg",""), "password", "student");    //input
    }

    /**
     * Gets the name of this student.
     * @return The name of this student.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this student.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the matriculation number of the student.
     * @return The matriculation number of the student.
     */
    public String getMatricNo() {
        return this.matricNo;
    }

    /**
     * Sets the matriculation number of the student.
     * @param matricNo The matriculation number to set.
     */
    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    /**
     * Gets the email address of the student.
     * @return The email address  of the student.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email address of the student.
     * @param email The email address tp set.  Should be in the format ending with "@e.ntu.edu.sg"
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the year of study of the student.
     * @return The year of study of the student.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year of study of the student.
     * @param year The year of study to set. Should be between 1 to 4.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the name of the school that the student belongs to.
     * @return The name of the school that the student belongs to.
     */
    public String getSchoolName() {
        return this.schoolName;
    }

    /**
     * Sets the name of the school that the student belongs to
     * @param schoolName The name of school to set.
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * Gets the gender of the student.
     * @return The gender of the student.
     */

    public String getGender() {
        return this.gender;
    }

    /**
     * Sets the gender of the student.
     * @param gender The gender to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the nationality of the student.
     * @return The nationality to set.
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * Sets the nationality of the student.
     * @param nationality The nationality to set.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets the account of the student.
     * @return The account of the student.
     */
    public Account getAccount() {
        return this.account;
    }

    /**
     * Sets the account of the student.
     * @param account The account to set. Should be an account object with username and password instantiated.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets the list of assigned courses of the student.
     * @return A list of the assigned courses of the student.
     */
    public ArrayList<CourseRegistration> getAssignedCourse() {
        return this.assignedCourse;
    }

    /**
     * Checks whether the AU limit for the student has been reached when adding a course,
     * if within the limit, the current number of AUs the student has is increased by that
     * course's AUs.
     * @param course The course that wants to be added. Should be a CourseRegistration object rather than a Course object.
     * @return true or false depending on whether the course can be added without breaking the max AU limit.
     */
    public boolean checkAU(CourseRegistration course) {
        int newau = this.noOfAUs + course.getAu();
        if (newau<=MAXAU) {

            return true;
        } else{
            System.out.println("Exceeded maximum AU allowable.");
            return false;
        }
    }

    /**
     * Adds a course to the assigned courses list of the student.
     * @param course The course to add. Should be a CourseRegistration object rather a Course object.
     */
    public void addAssignedCourse(CourseRegistration course){

        this.assignedCourse.add(course);
        this.noOfAUs += course.getAu();
    }

    /**
     * Updates the index number of a course in the student's waitlist courses or assigned courses list.
     * It takes the current Index of the course, and the desired Index of the current, and a boolean value to represent
     * whether that index is being moved from the waitlist to the assigned list.
     * @param currentIndex The current Index object of the course.
     * @param desiredIndex The desired Index object to change to.
     * @param waitListToAssigned A boolean value to signify whether the index is being moved from waitlist
     *                           to the assigned list.
     */
    public void updateIndex(Index currentIndex, Index desiredIndex, boolean waitListToAssigned){
        if(waitListToAssigned){
            for(CourseRegistration course: waitList){
                if(course.getIndex().equals(currentIndex)){
                    waitList.remove(course);
                    course.setIndex(desiredIndex);
                    assignedCourse.add(course);
                    return;
                }
            }
        }

        for(CourseRegistration course: assignedCourse){
            if(course.getIndex().equals(currentIndex)){
                course.setIndex(desiredIndex);
                return;
            }
        }

        for(CourseRegistration course: waitList){
            if(course.getIndex().equals(currentIndex)){
                course.setIndex(desiredIndex);
            }
        }

    }

    /**
     * Removes a course from the assigned list of the student.
     * @param course The course to be removed. Should be a CourseRegistration object rather than a Course object.
     */
    public void removeAssignedCourse(CourseRegistration course) {
        this.assignedCourse.remove(course);
        this.noOfAUs -= course.getAu();
    }

    /**
     * Gets the list of courses that the student has on the waitlist. The List contains CourseRegistration objects.
     * @return A list containing CourseRegistration objects that represents the courses the student
     * has on the waitlist.
     */
    public ArrayList<CourseRegistration> getWaitList() {
        return this.waitList;
    }

    /**
     * Adds a course to the list of waitlist courses of the student. Should be a CourseRegistration object rather than a Course object.
     * @param course The course to add to the waitlist of the student. Should be a CourseRegistration object rather than a Course object.
     */
    public void addWaitList(CourseRegistration course) {
        this.waitList.add(course);
    }

    /**
     * Removes a course from the list of waitlist courses of the student.
     * @param course The course to remove from the waitlist of the student. Should be a CourseRegistration object rather than a Course object.
     */
    public void removeWaitList(CourseRegistration course) {
        for (int i = 0; i<waitList.size();i++)
        {
            if (waitList.get(i).getIndex().getIndexNo()== course.getIndex().getIndexNo())
            {
                this.waitList.remove(i);
            }
        }
    }

    /**
     * Gets the number of AU that the student currently has.
     * @return The number of AU the student currently has.
     */
    public int getNoOfAU() {
        return this.noOfAUs;
    }

    /**
     * Increases the number of AU that the student currently has by the provided AUs.
     * @param au The number of AUs to increase by.
     */
    public void addNoOfAU(int au) {
        this.noOfAUs += au;
    }

    /**
     * Checks whether the given index clashes with any of courses that the student currently has in his/her assigned
     * or waitlist course list.
     * @param index The index to check clashes with.
     * @return The clash type. 0 means no clash, 1 means clash with assigned courses, 2 means clash with waitlist course.
     */
    public int checkTimeClash(Index index) {
        int noclash = 0;
        int clashA = 1;
        int clashW = 2;

        int checkindex = 0;
        boolean clashAssigned = false;
        boolean clashWait= false;

        Index indextoCheck = index;
        ArrayList<CourseRegistration> assignedcourse = this.getAssignedCourse();
        ArrayList<CourseRegistration> registeredcourse = this.getWaitList();


        // Check clash in assigned course
        for (CourseRegistration courseA : assignedcourse) {
            if (courseA.getIndex().checkClash(indextoCheck)) {
                System.out.println(indextoCheck.getIndexNo() + " clashes with " + courseA.getIndex().getIndexNo());
                clashAssigned = true;
            }
        }

        // Check clash in registered course
        for (CourseRegistration courseR : registeredcourse) {
            if (courseR.getIndex().checkClash(indextoCheck)) {
                System.out.println(indextoCheck.getIndexNo() + " clashes with " + courseR.getIndex().getIndexNo());
                clashWait = true;
            }
        }

        if (!clashAssigned & !clashWait) {
            System.out.println(this.name + ": Index does not clash with current timetable.");
            return noclash;
        } else if (clashAssigned) {
            System.out.println("Index clash with assigned timetable.");
            return clashA;
        } else if (clashWait) {
            System.out.println("Index clash with waitlist timetable.");
            return clashW;
        } else{
            return clashA;
        }
    }

    /**
     * Returns a formatted string when the Student object is passed into a print statement.
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%s\t%s\t",name,schoolName,year,gender,nationality);
    }
}
