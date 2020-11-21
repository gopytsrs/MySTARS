package Entity;

import Enum.LessonType;
import Enum.Week;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Represents a Lesson that belongs to an Index.
 */
public class Lesson implements Serializable {
    /**
     * The index number which the lesson belongs to.
     */
    private int indexNo;
    /**
     * The type of lesson.
     */
    private LessonType lessonType;
    /**
     * The day when the lesson is held.
     */
    private DayOfWeek day;
    /**
     * The start time of the lesson in LocalTime format.
     */
    private LocalTime startTime;
    /**
     * The end time of the lesson in LocalTime format.
     */
    private LocalTime endTime;
    /**
     * The location where the lesson is held.
     */
    private String location;
    /**
     * The weeks in which the lesson are held.
     */
    private Week weeks;

    /**
     * Creates a new Lesson object.
     */
    public Lesson() {
    }

    /**
     * Creates a new Lesson object based on the given index no, lesson type, day of week, start time, end time, location and weeks.
     * @param indexNo The index number the lesson belongs to.
     * @param lessonType The type of lesson.
     * @param day The day the lesson is held.
     * @param startTime The start time of the lesson.
     * @param endTime The end time of the lesson.
     * @param location The location the lesson is held.
     * @param weeks The week(s) the lesson is held.
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
     * Gets the index number the lesson belongs to.
     * @return The index number the lesson belongs to.
     */
    public int getIndexNo() {
        return indexNo;
    }

    /**
     * Sets the index number the lesson belongs to.
     * @param indexNo The index number to set.
     */
    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    /**
     * Gets the type of the lesson.
     * @return A LessonType enum that represents the type of the lesson.
     */
    public LessonType getLessonType() {
        return lessonType;
    }

    /**
     * Sets the type of the lesson.
     * @param lessonType A LessonType enum to set the type of lesson.
     */
    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    /**
     * Gets the day of week the lesson is held.
     * @return A DayOfWeek enum of when the lesson is held.
     */
    public DayOfWeek getDay() {
        return day;
    }

    /**
     * Sets the day of week the lesson is held.
     * @param day A DayOfWeek enum of when the lesson is held.
     */
    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    /**
     * Gets the start time of the lesson.
     * @return A LocalTime object that represents the start time of the lesson.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the lesson.
     * @param startTime A LocalTime object that represents the start time of the lesson.
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time of the lesson.
     * @return A LocalTime object that represents the end time of the lesson.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the lesson.
     * @param endTime A LocalTime object that represents the end time of the lesson.
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the location where the lesson is held.
     * @return The location where the lesson is held.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location where the lesson is held.
     * @param location The location where the lesson is held.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the week(s) the lesson is held on.
     * @return A Week enum that represents the week(s) the lesson is held on.
     */
    public Week getWeeks() {
        return weeks;
    }

    /**
     * Gets the week(s) the lesson is held on.
     * @param weeks A Week enum that represents the week(s) the lesson is held on.
     */
    public void setWeeks(Week weeks) {
        this.weeks = weeks;
    }
}
