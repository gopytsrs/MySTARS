package Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class School {
    private String schoolName;
    private AccessPeriod accessperiod;
    private ArrayList<Course> courseList;

    public School(String schoolName,AccessPeriod accessperiod)
    {
        this.schoolName = schoolName;
        this.accessperiod = accessperiod;
        this.courseList = new ArrayList<Course>();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public AccessPeriod getAccessperiod() {
        return accessperiod;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }                                               //1 course or whole list?

    public void setAccessPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        this.accessperiod.setStartDate(startDate);
        this.accessperiod.setEndDate(endDate);
    }                                               //is this really how to set the class access period?

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setCourseList(Course course) {
        courseList.add(course);
    }                                           //add 1 course to list so not really setting course list
}
