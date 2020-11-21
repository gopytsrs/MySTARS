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
    /**
     * This is the location of the lesson
     */
    private String location;
    /**
     * This is the week of the lesson, it can be every, even or odd
     */
    private Week weeks;

    /**
     * Creates a lesson
     */
    public Lesson() {
    }

    /**
     * Creates a lesson with indexNo, lessonType, day,start time, end time, location and week
     * @param indexNo
     * @param lessonType
     * @param day
     * @param startTime
     * @param endTime
     * @param location
     * @param weeks
     */
    public Lesson(int indexNo, LessonType lessonType, DayOfWeek day, LocalTime startTime, LocalTime endTime, String location, Week weeks) {
        this.lessonType = lessonType;
        this.indexNo = indexNo;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.weeks = weeks;
    }

    /**
     * Get IndexNo
     * @return
     */
    public int getIndexNo() {
        return indexNo;
    }

    /**
     * Changes IndexNo
     * @param indexNo
     */
    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    /**
     * Get lessonType, it can be seminars, lectures or tutorials
     * @return
     */
    public LessonType getLessonType() {
        return lessonType;
    }

    /**
     * Changes lessonType, it can be seminars, lectures or tutorials
     * @param lessonType
     */
    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    /**
     * Get Day in week for lesson, it can be monday, tuesday, wednesday, thursday, friday, saturday, sunday
     * @return
     */
    public DayOfWeek getDay() {
        return day;
    }

    /**
     * Change the day in week for the lesson, it can be monday, tuesday, wednesday, thursday, friday, saturday, sunday
     * @param day
     */
    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    /**
     * Get start time of the lesson
     * @return
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Changes Start time of lesson
     * @param startTime
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Get End time of lesson
     * @return
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Change the End time of lesson
     * @param endTime
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Get location of lesson
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * Change location of lesson
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the weeks of the lesson, it can be every,odd or even
     * @return
     */
    public Week getWeeks() {
        return weeks;
    }

    /**
     * Changes the weeks of the lesson, it can be even,odd or every
     * @param weeks
     */
    public void setWeeks(Week weeks) {
        this.weeks = weeks;
    }
}
