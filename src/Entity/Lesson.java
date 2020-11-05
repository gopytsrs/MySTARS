package Entity;
import Enum.LessonType;
import Enum.Week;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class Lesson {
    private int indexNo;
    private LessonType lessonType;
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;
    private Week weeks;

    public Lesson(){}

    public Lesson(int indexNo, LessonType lessonType, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location, Week weeks){
        this.lessonType = lessonType;
        this.indexNo = indexNo;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.weeks = weeks;
    }

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Week getWeeks() {
        return weeks;
    }

    public void setWeeks(Week weeks) {
        this.weeks = weeks;
    }
}
