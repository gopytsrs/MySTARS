package Control;

import Entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class makedata {
    public static void main(String args[]){
        LocalDateTime dateTime = LocalDateTime.parse("2019-12-13 09:00");
        LocalDateTime dateTime1 = LocalDateTime.parse("2019-12-14 09:00");
        School s = new School("Nanyang Business School",new AccessPeriod(dateTime,dateTime1));
        Course c1 =  new Course("AB1202","Statistic",3);
        s.setCourseList(c1);
        c1.addLessonType1("Lectures");
        c1.addLessonType1("Tutorial");
        Index I1 = new Index("AB1202","Statistic",10003,"BCG2",20);
        Lesson L1 = new Lesson()
        Index I2 = new Index("AB1202","Statistic",10021,"SS04",20);
        Index I3 = new Index("AB1202","Statistic",10024,"SSP3",20);
        c1.setindexlist(I1);
        c1.setindexlist(I2);
        c1.setindexlist(I3);
        Course c2 =  new Course("AB1301","Business Law",3);
        s.setCourseList(c2);
        c2.addLessonType1("Lectures");
        c2.addLessonType1("Tutorial");
        Index I4 = new Index("AB1301","Business Law",10004,"BCG1",20);
        Index I5 = new Index("AB1301","Business Law",10022,"SS03",20);
        Index I6 = new Index("AB1301","Business Law",10025,"SSP2",20);
        c2.setindexlist(I4);
        c2.setindexlist(I5);
        c2.setindexlist(I6);
        Course c3 =  new Course("AB1501","Marketing",3);
        s.setCourseList(c3);
        c3.addLessonType1("Lectures");
        c3.addLessonType1("Tutorial");
        Index I7 = new Index("AB1501","Marketing",10008,"BCG3",20);
        Index I8 = new Index("AB1501","Marketing",10016,"SS07",20);
        Index I9 = new Index("AB1501","Marketing",10048,"SSP5",20);
        c3.setindexlist(I7);
        c3.setindexlist(I8);
        c3.setindexlist(I9);
        Course c4 =  new Course("AB2101","Managerial Accounting",3);
        s.setCourseList(c4);
        c4.addLessonType1("Lectures");
        c4.addLessonType1("Tutorial");
        Index I10 = new Index("AB2101","Managerial Accounting",10015,"BCG4",20);
        Index I11 = new Index("AB2101","Managerial Accounting",10042,"SS01",20);
        Index I12 = new Index("AB2101","Managerial Accounting",50041,"SSP9",20);
        c4.setindexlist(I10);
        c4.setindexlist(I11);
        c4.setindexlist(I12);

    }
    //"Nanyang Business School",NBS,"2019-12-13 09:00","2019-12-14 09:00","AB1201 AB1301 AB1501 AD2101"


}
