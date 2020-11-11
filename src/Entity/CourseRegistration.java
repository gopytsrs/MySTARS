package Entity;

public class CourseRegistration {
    private Index index;
    private String courseCode;
    private String courseName;
    private Student student;
    public Index getIndex()
    {
        return index;
    }
    public String getCourseCode()
    {
        return courseCode;
    }
    public String getCourseName()
    {
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
}
