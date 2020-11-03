package Entity;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Deque;

public class Index {
    private int indexNo;
    private String groupNo;
    private int vacancy;
    public static Deque<Student> waitList;
    private Lesson lessons;
    private String[] lessonVenue;

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

    public void addToWaitlist(Student student){}

    public void removeFromWaitlist(Student student){}

    public LocalDateTime[] getLessonTime(Lesson lessons){
        return new LocalDateTime[3];
    }

    public void setLessonTime(Lesson lessons){}

    public String[] getLessonVenue(Lesson lessons){
        return new String[3];
    }

    public void setLessonVenue(Lesson lessons){

    }
}
