package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a course. A course belongs to one school. A course can have many indexes.
 */
public class Course implements Serializable {
    /**
     * The course code of the Course.
     */
    private String courseCode;
    /**
     * The course name of the Course.
     */
    private String courseName;
    /**
     * The number of AUs of the Course.
     */
    private int au;
    /**
     * The list of lesson types of the Course.
     */
    private ArrayList<String> lessonType;
    /**
     * The School that offers the Course.
     */
    private School offeringSchool;      // comment this out if no need
    // gerpe/ue attribute
    /**
     * The list of Indexes the Course has.
     */
    private ArrayList<Index> indexList;

    /**
     * Creates a new Course object based on the given course code, course name and number of AUs.
     *
     * @param courseCode The course code of the Course.
     * @param courseName The course name of the Course.
     * @param au         The number of AUs of the Course.
     */
    public Course(String courseCode, String courseName, int au) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.au = au;
        lessonType = new ArrayList<>();
        indexList = new ArrayList<>();
    }

    /**
     * Gets the course code of the Course.
     *
     * @return The course code of the Course.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code of the Course.
     *
     * @param courseCode The course code of the Course.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the course name of the Course.
     *
     * @return The course name of the Course.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name of the Course.
     *
     * @param courseName The course name of the Course.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the number of AUs of the Course.
     *
     * @return The number of AUs of the Course.
     */
    public int getAu() {
        return au;
    }

    /**
     * Sets the number of AUs of the Course.
     *
     * @param au The number of AUs of the Course.
     */
    public void setAu(int au) {
        this.au = au;
    }

    /**
     * Gets the list of lesson types of the Course.
     *
     * @return The list of lesson types of the Course..
     */
    public ArrayList<String> getLessonType() {
        return lessonType;
    }

    /**
     * Sets the list of lesson types of the Course.
     *
     * @param lessonType The list of lesson types of the Course.
     */
    public void setLessonType(ArrayList<String> lessonType) {
        this.lessonType = lessonType;
    }

    /**
     * Adds a lesson type to the list of lesson types of the Course.
     */
    public void addLessonType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the lessonType: ");
        String lessonType = sc.next();
        this.lessonType.add(lessonType);
    }

    /**
     * Adds a lesson type to  the list of lesson types of the Course.
     *
     * @param lessonType
     */
    public void addLessonType1(String lessonType)       //use purely for binary
    {
        this.lessonType.add(lessonType);
    }

    /**
     * Gets the School that offers the Course.
     *
     * @return The School that offers the Course.
     */
    public School getOfferingSchool() {
        return offeringSchool;
    }

    /**
     * Sets the School that offers the Course.
     *
     * @param offeringSchool The School that offers the Course.
     */
    public void setOfferingSchool(School offeringSchool) {
        this.offeringSchool = offeringSchool;
    }

    /**
     * Gets the list of Indexes of the Course.
     *
     * @return The list of Indexes of the Course.
     */
    public ArrayList<Index> getIndexList() {
        return indexList;
    }

    /**
     * Adds an Index to the list of Indexes of the Course.
     *
     * @param I The Index to add.
     */
    public void setindexlist(Index I) {
        indexList.add(I);
    }

    /**
     * Adds an Index to the list of Indexes of the Course.
     */
    public void addIndex() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the indexNo: ");
        int indexNo;
        try {
            String dummy = sc.next();
            indexNo = Integer.parseInt(dummy);
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return;
        }
        for (Index J : indexList) {
            while (indexNo == J.getIndexNo()) {
                System.out.println("Index No already exists! ");
                return;
            }
        }
 
        System.out.println("Input the groupNo: ");
        String groupNo = sc.next();
        for (Index I : indexList) {
            while (groupNo.equals(I.getGroupNo())) {
                System.out.println("Group No already exists! ");
                return;
            }
        }
        System.out.println("Input the vacancy: ");
        int vacancy = sc.nextInt();
        while (vacancy < 0 || vacancy > 30) {
            System.out.println("Invalid vacancy! Enter Vacancy again: ");
            vacancy = sc.nextInt();
        }
        Index I = new Index(courseCode, courseName, indexNo, groupNo, vacancy);
        indexList.add(I);
        System.out.println("Index Added");
    }

    /**
     * Prints the list of Indexes of the Course.
     */
    public void printIndexList() {
        if (this.indexList == null) {
            System.out.println("No indexes");
        } else {
            System.out.println(courseCode + "\t" + courseName + "\t" + au + "AU");
            System.out.println("Indexes:\tVacancies");
            for (Index index : indexList) {
                System.out.printf("%d\t%d%n", index.getIndexNo(), index.getVacancy());
            }
        }
    }

    /**
     * Formats the Course object to a String when passed to a print method.
     *
     * @return
     */
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
