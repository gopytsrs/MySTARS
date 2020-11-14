package Entity;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Deque;

public class Index {
    private String courseName;
    private String courseCode;
    private int indexNo;
    private String groupNo;
    private int vacancy;
    public static Deque<Student> waitList;
    private Lesson[] lessons = new Lesson[3];

    public Index(){}
    public Index(String courseName, String courseCode, int indexNo, String groupNo, int vacancy){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.indexNo = indexNo;
        this.groupNo = groupNo;
        this.vacancy = vacancy;
    }
    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public void addToWaitlist(Student student){

        waitList.add(student);
    }

    public void removeFromWaitlist(Student student){
        waitList.remove(student);
    }

    public LocalDateTime[] getLessonTime(Lesson lessons){
        return new LocalDateTime[3];
    }

    public void setLessonTime(Lesson lessons){}

    public String getCourseCode() {
        return courseCode;
    }
}
