package Entity;

import Enum.LessonType;
import Enum.Week;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an Index of a course. A course can have many indexes.
 * Each index belongs to one course.
 */

public class Index implements Serializable {
    /**
     * The name of the course the Index belongs to.
     */
    private String courseName;
    /**
     * The course code of the course the Index belongs to.
     */
    private String courseCode;
    /**
     * The index number of this Index.
     */
    private int indexNo;
    /**
     * The group number of this Index.
     */
    private String groupNo;
    /**
     * The current vacancy of this Index.
     */
    private int vacancy;
    /**
     * The list of Students on the waitlist for this Index.
     */
    public ArrayList<Student> waitList = new ArrayList<>();
    /**
     * The list of Students assigned to this Index.
     */
    public ArrayList<Student> assignedStudents = new ArrayList<>();
    /**
     * The list of lessons that this Index has.
     */
    private ArrayList<Lesson> lessons;

    /**
     * Creates a new Index object.
     */
    public Index() {
    }

    /**
     * Creates a new Index object based on the given course name, course code, index number, group number and vacancy.
     *
     * @param courseName The name of the course.
     * @param courseCode The course code of the course.
     * @param indexNo    The index number of this Index.
     * @param groupNo    The group number of this Index.
     * @param vacancy    The vacancy of this Index.
     */
    public Index(String courseName, String courseCode, int indexNo, String groupNo, int vacancy) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.indexNo = indexNo;
        this.groupNo = groupNo;
        this.vacancy = vacancy;
        lessons = new ArrayList<Lesson>();
    }

    /**
     * Gets the course name of the course of this Index.
     *
     * @return The course name of the course of this Index.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name of the course of this Index.
     *
     * @param courseName The course name of the course of this Index.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the course code of the course of this Index.
     *
     * @return The course code of the course of this Index.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code of the course of this Index.
     *
     * @param courseCode The course code of the course of this Index.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the index number of this Index.
     *
     * @return The index number of this Index.
     */
    public int getIndexNo() {
        return indexNo;
    }

    /**
     * Sets the index number of this Index.
     *
     * @param indexNo The index number of this Index.
     */
    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    /**
     * Gets the group number of this Index.
     *
     * @return The group number of this Index.
     */
    public String getGroupNo() {
        return groupNo;
    }

    /**
     * Sets the group number of this Index.
     *
     * @param groupNo The group number of this Index.
     */
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    /**
     * Gets the current vacancy of this Index.
     *
     * @return The current vacancy of this Index.
     */
    public int getVacancy() {
        return vacancy;
    }

    /**
     * Sets the current vacancy of this Index.
     *
     * @param vacancy The current vacancy of this Index.
     */
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    /**
     * Adds a Student to the waitlist of this Index.
     *
     * @param student The Student to add.
     */
    public void addToWaitlist(Student student) {

        waitList.add(student);
    }

    /**
     * Gets the list of Students on the waitlist of this Index.
     *
     * @return The list of Students on the waitlist of this Index.
     */
    public ArrayList<Student> getWaitList() {
        return waitList;
    }

    /**
     * Removes a student from the list of Students on the waitlist of this Index.
     *
     * @param student A Student to remove.
     */
    public void removeFromWaitlist(Student student) {
        for (int i = 0; i < waitList.size(); i++) {
            if (waitList.get(i).getEmail().equals(student.getEmail())) {
                waitList.remove(i);
            }
        }
    }

    /**
     * Adds a student the list of Students on the assigned list of this Index if there is vacancies.
     *
     * @param student A Student to add.
     * @return true or false depending on whether the student can be added.
     */
    public boolean assignStudent(Student student) {
        if (vacancy != 0) {
            assignedStudents.add(student);
            this.vacancy -= 1;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Gets the list of lessons of this Index.
     *
     * @return The list of lessons of this Index.
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Sets the list of lessons of this Index.
     *
     * @param L The list of lessons of this Index.
     */
    public void setLessons(Lesson L) {
        lessons.add(L);
    }

    /**
     * Checks whether this Index clashes with another Index. It compares the lessons, days and weeks of the indexes.
     *
     * @param indexToCheck The Index to check with.
     * @return true or false depending on whether there is a clash.
     */
    public boolean checkClash(Index indexToCheck) {
        for (Lesson lesson : lessons) {
            for (Lesson lesson1 : indexToCheck.getLessons()) {
                if ((lesson.getWeeks() == lesson1.getWeeks()
                        || (lesson.getWeeks() == Week.EVERY && (lesson1.getWeeks() == Week.ODD || lesson1.getWeeks() == Week.EVEN))
                        || (lesson1.getWeeks() == Week.EVERY && (lesson.getWeeks() == Week.ODD || lesson.getWeeks() == Week.EVEN)))
                        && lesson.getDay() == lesson1.getDay()) {
                    //Datetime logic needed for range
                    if (((lesson.getStartTime().isAfter(lesson1.getStartTime()) || lesson.getStartTime().equals(lesson1.getStartTime())) &&
                            lesson.getStartTime().isBefore(lesson1.getEndTime()))
                            || (lesson.getEndTime().isAfter(lesson1.getStartTime()) &&
                            (lesson.getEndTime().isBefore(lesson1.getEndTime()) || lesson.getEndTime().equals(lesson1.getEndTime())))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Gets the list of Students on the assigned list of this Index.
     *
     * @return The list of Students on the assigned list of this Index.
     */
    public ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

    /**
     * Adds a lesson to this index.
     */
    public void addLesson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Lesson Type in all caps: ");
        String lessonType1 = sc.next();
        LessonType lessonType = null;
        do {
            switch (lessonType1) {
                case ("LECTURE"): {
                    lessonType = LessonType.LEC;
                    break;
                }
                case ("LABORATORY"): {
                    lessonType = LessonType.LAB;
                    break;
                }
                case ("TUTORIAL"): {
                    lessonType = LessonType.TUT;
                    break;
                }
                case ("SEMINAR"): {
                    lessonType = LessonType.SEM;
                    break;
                }
                default:
                    System.out.println("Error in input. Please try again.");
            }
        } while (lessonType == null);
        System.out.println("Input day of week in all caps: ");
        String day1 = sc.next();
        DayOfWeek day = null;
        do {
            switch (day1) {
                case ("MONDAY"): {
                    day = DayOfWeek.MONDAY;
                    break;
                }
                case ("TUESDAY"): {
                    day = DayOfWeek.TUESDAY;
                    break;
                }
                case ("WEDNESDAY"): {
                    day = DayOfWeek.WEDNESDAY;
                    break;
                }
                case ("THURSDAY"): {
                    day = DayOfWeek.THURSDAY;
                    break;
                }
                case ("FRIDAY"): {
                    day = DayOfWeek.FRIDAY;
                    break;
                }
                case ("SATURDAY"): {
                    day = DayOfWeek.SATURDAY;
                    break;
                }
                case ("SUNDAY"): {
                    day = DayOfWeek.SUNDAY;
                    break;
                }
                default: {
                    System.out.println("Error in input.");
                }

            }
        } while (day == null);

        System.out.println("Input Start time of lesson: (HH:MM) ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm.ss.nnn");
        String StartD = sc.next();
        LocalTime StartDate = LocalTime.parse(StartD, formatter);
        System.out.println("Input End time of lesson: (HH:MM) ");
        String EndD = sc.next();
        LocalTime EndDate = LocalTime.parse(EndD, formatter);
        System.out.println("Input Location of lesson: ");
        String location = sc.next();
        System.out.println("Input Weeks of lesson in all caps: ");
        String weeks1 = sc.next();
        Week week = null;
        do {
            switch (weeks1) {
                case ("EVEN"): {
                    week = Week.EVEN;
                    break;
                }
                case ("ODD"): {
                    week = Week.ODD;
                    break;
                }
                case ("EVERY"): {
                    week = Week.EVERY;
                    break;
                }
                default: {
                    System.out.println("Error in input. Please try again.");
                }
            }
        } while (week == null);

        Lesson L = new Lesson(indexNo, lessonType, day, StartDate, EndDate, location, week);
        lessons.add(L);
    }

    /**
     * Removes a student from the list of Students on the assigned list of this Index.
     *
     * @param student A Student to remove.
     */
    public void removeStudentFromAssigned(Student student) {
        for (int i = 0; i < assignedStudents.size(); i++) {
            if (assignedStudents.get(i).getEmail().equals(student.getEmail())) {
                assignedStudents.remove(i);
            }
        }
        //this.assignedStudents.remove(student);
        this.vacancy += 1;
    }
}
