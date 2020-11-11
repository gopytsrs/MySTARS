package Entity;

import java.util.ArrayList;

public class School {
    private String schoolName;
    private AccessPeriod accessperiod;
    private ArrayList<Course> courseList;

    public String getSchoolName() {
        return schoolName;
    }

    public AccessPeriod getAccessperiod() {
        return accessperiod;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }                                               //1 course or whole list?

    public void setAccessperiod(AccessPeriod accessperiod) {
        this.accessperiod = accessperiod;
    }                                               //is this really how to set the class access period?

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setCourseList(Course course) {
        courseList.add(course);
    }                                           //add 1 course to list so not really setting course list
}
