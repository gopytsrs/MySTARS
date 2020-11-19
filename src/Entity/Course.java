package Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private int au;
    private ArrayList<String> lessonType;
    private School offeringSchool;      // comment this out if no need
                                        // gerpe/ue attribute
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

    public void addLessonType()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the lessonType: ");
        String lessonType = sc.next();
        this.lessonType.add(lessonType);
    }

    public void addLessonType1(String lessonType)       //use purely for binary
    {
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

    public void setindexlist(Index I){indexList.add(I);}

    public void addIndex()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the indexNo: ");
        int indexNo;
        try{
            String dummy = sc.next();
            indexNo = Integer.parseInt(dummy);
        }catch(Exception e)
        {
            System.out.println("Please enter an integer");
            return;
        }
        for(Index J: indexList) {
            while (indexNo == J.getIndexNo()) {
                System.out.println("Index No already exists! ");
                return;
            }
        }
        System.out.println("Input the groupNo: ");
        String groupNo = sc.next();
        for(Index I: indexList) {
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
        Index I = new Index(courseCode,courseName,indexNo,groupNo,vacancy);
        indexList.add(I);
        System.out.println("Index Added");
    }

    public void printIndexList(){
        if(this.indexList == null){
            System.out.println("No indexes");
        } else {
            System.out.println(courseCode + "\t" + courseName + "\t" + au + "AU");
            System.out.println("Indexes:\tVacancies");
            for(Index index: indexList){
                System.out.printf("%d\t%d%n",index.getIndexNo(),index.getVacancy());
            }
        }
    }

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
