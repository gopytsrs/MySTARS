package Entity;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private int au;
    private ArrayList<String> lessonType;
    private School offeringSchool;
    private ArrayList<Index> indexList;

    public Course(String courseCode, String courseName, int au)
    {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.au = au;
        lessonType = new ArrayList<>();
        indexList = new ArrayList<>();
    }

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

    public School getOfferingSchool() {
        return offeringSchool;
    }

    public void setOfferingSchool(School offeringSchool) {
        this.offeringSchool = offeringSchool;
    }

    public ArrayList<Index> getIndexList() {
        return indexList;
    }

    public void addIndex(Index I){indexList.add(I);}

    @Override
    public String toString() {
        return courseCode +
                "\t" + courseName +
                "\t" + au +
                "\t" + lessonType +
                "\t" + offeringSchool +
                "\t" + indexList;
    }
}
