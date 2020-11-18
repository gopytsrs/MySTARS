package Entity;

import Enum.LessonType;
import Enum.Week;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;


public class Index implements Serializable {

    private String courseName;
    private String courseCode;
    private int indexNo;
    private String groupNo;
    private int vacancy;
    public static Deque<Student> waitList;
    public static ArrayList<Student> assignedStudents;
    private ArrayList<Lesson> lessons;

    public Index() {
    }

    public Index(String courseName, String courseCode, int indexNo, String groupNo, int vacancy) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.indexNo = indexNo;
        this.groupNo = groupNo;
        this.vacancy = vacancy;
        lessons = new ArrayList<Lesson>();
        assignedStudents = new ArrayList<Student>();
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

    public void addToWaitlist(Student student) {

        waitList.add(student);
    }

    public static Deque<Student> getWaitList() {
        return waitList;
    }

    public void removeFromWaitlist(Student student) {
        waitList.remove(student);
    }

//    public LocalDateTime[] getLessonTime(Lesson lessons){
//        return new LocalDateTime[3];
//    }
//
//    public void setLessonTime(Lesson lessons){}


    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Lesson L) {
        lessons.add(L);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public boolean checkClash(Index indexToCheck) {
        for (Lesson lesson : lessons) {
            for (Lesson lesson1 : indexToCheck.getLessons()) {
                if (lesson.getWeeks() == lesson1.getWeeks()) {
                    //Datetime logic needed for range
                    if (lesson.getStartTime().equals(lesson1.getStartTime()) || lesson.getEndTime().isAfter(lesson1.getStartTime())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

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

    public void removeStudentFromAssigned(){

    }
}
