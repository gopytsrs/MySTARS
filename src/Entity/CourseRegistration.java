package Entity;

import java.io.Serializable;

public class CourseRegistration implements Serializable {
    private Index index;
    private String courseCode;
    private String courseName;
    private int au;
    private Student student;

    public CourseRegistration(Index index, String courseCode, String courseName, int au, Student student){
        this.index = index;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.au = au;
        this.student = student;
    }

    public Index getIndex() {
        return index;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Student getStudent() {
        return student;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAu() {
        return au;
    }

    public void setAu(int au) {
        this.au = au;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%d\t", courseCode, courseName, index.getIndexNo(), au);
    }
}
