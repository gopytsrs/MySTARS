package Entity;

import Enum.LessonType;
import Enum.Week;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * This class represent the lessons that can be taken
 */
public class Lesson implements Serializable {
    /**
     * This is the index no of the lesson
     */
    private int indexNo;
    /**
     * This is the type of lessons which can be seminar, lectures or tutorials
     */
    private LessonType lessonType;
    /**
     * This is the day in the week which can be monday, tuesday, wednesday, thursday, friday, saturday, sunday
     */
    private DayOfWeek day;
    /**
     * This is the start time of the lesson
     */
    private LocalTime startTime;
    /**
     * This is the end time of the lesson
     */
    private LocalTime endTime;
    private String location;
    private Week weeks;

    public Lesson() {
    }

    public Lesson(int indexNo, LessonType lessonType, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location, Week weeks) {
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
