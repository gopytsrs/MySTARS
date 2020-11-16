package Control;

import Entity.AccessPeriod;
import Entity.Course;
import Entity.School;
import Entity.Index;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class makedata {
    public static void main(String args[]){
        LocalDateTime dateTime = LocalDateTime.parse("2019-12-13 09:00");
        LocalDateTime dateTime1 = LocalDateTime.parse("2019-12-14 09:00");
        School s = new School("Nanyang Business School",new AccessPeriod(dateTime,dateTime1));
        Course c1 =  new Course("AB1202","Statistic",3);
        s.setCourseList(c1);
        c1.addLessonType("Lectures");
        c1.addLessonType("Tutorial");
        Index I1 = new Index("AB1202","Statistic",10003,"BCG2",20);
        Index I2 = new Index("AB1202","Statistic",10021,"SS04",20);
        Index I3 = new Index("AB1202","Statistic",10024,"SSP3",20);
        c1.addIndex(I1);
        c1.addIndex(I2);
        c1.addIndex(I3);
        Course c2 =  new Course("AB1301","Business Law",3);
        s.setCourseList(c2);
        c2.addLessonType("Lectures");
        c2.addLessonType("Tutorial");
        Course c3 =  new Course("AB1501","Marketing",3);
        s.setCourseList(c3);
        c3.addLessonType("Lectures");
        c3.addLessonType("Tutorial");
        Course c4 =  new Course("AB2101","Managerial Accounting",3);
        s.setCourseList(c4);
        c4.addLessonType("Lectures");
        c4.addLessonType("Tutorial");

    }
    "Nanyang Business School",NBS,"2019-12-13 09:00","2019-12-14 09:00","AB1201 AB1301 AB1501 AD2101"


}
