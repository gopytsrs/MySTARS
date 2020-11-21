package Entity;

import java.io.Serializable;

/**
 * This class represent the data stored in student when they register for course
 */
public class CourseRegistration implements Serializable {
    /**
     * This is the index of the course registered
     */
    private Index index;
    /**
     * Course code of the course registered
     */
    private String courseCode;
    /**
     * Course Name of the course registered
     */
    private String courseName;
    /**
     * No of Aus of the course registered
     */
    private int au;
    /**
     * Student object who registered for the index
     */
    private Student student;

    /**
     *Create a courseRegistration with index,courseCode,courseName,AUs and student
     * @param index
     * @param courseCode
     * @param courseName
     * @param au
     * @param student
     */
    public CourseRegistration(Index index, String courseCode, String courseName, int au, Student student){
        this.index = index;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.au = au;
        this.student = student;
    }

    /**
     * Get Index
     * @return
     */
    public Index getIndex() {
        return index;
    }

    /**
     * Get Course code
     * @return
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Get course name
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Get student
     * @return
     */
    public Student getStudent() {
        return student;
    }

    /**
     * This method allows you to change the course code of the course registered
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * This method allows you to change the course name of the course registered
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * This method allows you to change the index of the course registered
     * @param index
     */
    public void setIndex(Index index) {
        this.index = index;
    }

    /**
     * This method allows you to change the student of the course registered
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * This method allows you to get the AUs of the course registered
     * @return
     */
    public int getAu() {
        return au;
    }

    /**
     * This method allows you to change the AUs of the course registered
     * @param au
     */
    public void setAu(int au) {
        this.au = au;
    }

    /**
     * This method allow you to get a string in the format of courseCode, courseName, IndexNo, au
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%d\t", courseCode, courseName, index.getIndexNo(), au);
    }
}
