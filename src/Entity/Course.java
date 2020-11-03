package Entity;
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int au;
    private ArrayList<String> lessonType;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAu() {
        return au;
    }

    public void setAu(int au) {
        this.au = au;
    }

    public ArrayList<String> getLessonType() {
        return lessonType;
    }

    public void setLessonType(ArrayList<String> lessonType) {
        this.lessonType = lessonType;
    }

    public void addLessonType(String lessonType){
        this.lessonType.add(lessonType);
    }
}
