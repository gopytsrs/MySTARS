package Control;

import Entity.*;
import Enum.*;

import java.time.DayOfWeek;
import java.time.*;
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
        Lesson L1LEC = new Lesson(10003, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L1TUT = new Lesson(10003, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13.30"), LocalTime.parse("14.30"), "TR+05", Week.EVERY);
        Index I2 = new Index("AB1202","Statistic",10021,"SS04",20);
        Lesson L2LEC = new Lesson(10021, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L2TUT = new Lesson(10021, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("10.30"), LocalTime.parse("11.30"), "TR+07", Week.EVERY);
        Index I3 = new Index("AB1202","Statistic",10024,"SSP3",20);
        Lesson L3LEC = new Lesson(10024, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L3TUT = new Lesson(10024, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("09.30"), LocalTime.parse("10.30"), "TR+10", Week.EVERY);
        c1.setindexlist(I1);
        c1.setindexlist(I2);
        c1.setindexlist(I3);

        Course c2 =  new Course("AB1301","Business Law",3);
        s.setCourseList(c2);
        c2.addLessonType1("Lectures");
        c2.addLessonType1("Tutorial");
        Index I4 = new Index("AB1301","Business Law",10004,"BCG1",20);
        Lesson L4LEC = new Lesson(10004, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L4TUT = new Lesson(10004, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("13.30"), LocalTime.parse("14.30"), "TR+05", Week.EVERY);
        Index I5 = new Index("AB1301","Business Law",10022,"SS03",20);
        Lesson L5LEC = new Lesson(10022, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L5TUT = new Lesson(10022, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("10.30"), LocalTime.parse("11.30"), "TR+07", Week.EVERY);
        Index I6 = new Index("AB1301","Business Law",10025,"SSP2",20);
        Lesson L6LEC = new Lesson(10025, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L6TUT = new Lesson(10025, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("09.30"), LocalTime.parse("10.30"), "TR+10", Week.EVERY);
        c2.setindexlist(I4);
        c2.setindexlist(I5);
        c2.setindexlist(I6);

        Course c3 =  new Course("AB1501","Marketing",3);
        s.setCourseList(c3);
        c3.addLessonType1("Lectures");
        c3.addLessonType1("Tutorial");
        Index I7 = new Index("AB1501","Marketing",10008,"BCG3",20);
        Lesson L7LEC = new Lesson(10008, LessonType.LEC, DayOfWeek.THURSDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L7TUT = new Lesson(10008, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("09.30"), LocalTime.parse("10.30"), "TR+13", Week.EVERY);
        Index I8 = new Index("AB1501","Marketing",10016,"SS07",20);
        Lesson L8LEC = new Lesson(10016, LessonType.LEC, DayOfWeek.THURSDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L8TUT = new Lesson(10016, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("10.30"), LocalTime.parse("11.30"), "TR+15", Week.EVERY);
        Index I9 = new Index("AB1501","Marketing",10048,"SSP5",20);
        Lesson L9LEC = new Lesson(10048, LessonType.LEC, DayOfWeek.THURSDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L9TUT = new Lesson(10048, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "TR+17", Week.EVERY);
        c3.setindexlist(I7);
        c3.setindexlist(I8);
        c3.setindexlist(I9);

        Course c4 =  new Course("AB2101","Managerial Accounting",3);
        s.setCourseList(c4);
        c4.addLessonType1("Lectures");
        c4.addLessonType1("Tutorial");
        Index I10 = new Index("AB2101","Managerial Accounting",10015,"BCG4",20);
        Lesson L10LEC = new Lesson(10015, LessonType.LEC, DayOfWeek.FRIDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L10TUT = new Lesson(10015, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("09.30"), LocalTime.parse("10.30"), "TR+10", Week.EVERY);
        Index I11 = new Index("AB2101","Managerial Accounting",10042,"SS01",20);
        Lesson L11LEC = new Lesson(10042, LessonType.LEC, DayOfWeek.FRIDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L11TUT = new Lesson(10042, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("10.30"), LocalTime.parse("11.30"), "TR+20", Week.EVERY);
        Index I12 = new Index("AB2101","Managerial Accounting",50041,"SSP9",20);
        Lesson L12LEC = new Lesson(50041, LessonType.LEC, DayOfWeek.FRIDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT26", Week.EVERY);
        Lesson L12TUT = new Lesson(50041, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("14.30"), LocalTime.parse("15.30"), "TR+30", Week.EVERY);
        c4.setindexlist(I10);
        c4.setindexlist(I11);
        c4.setindexlist(I12);


        //make SCBE
        LocalDateTime startDate = LocalDateTime.parse("2020-12-06 09:00");
        LocalDateTime endDate = LocalDateTime.parse("2020-12-07 09:00");

        School SCBE = new School("School of Chemical and Biomedical Engineering", new AccessPeriod(startDate, endDate));
        Course c5 = new Course("BG2141", "Mechanics of Material", 3);
        SCBE.setCourseList(c1);
        c1.addLessonType1("Lectures");
        c1.addLessonType1("Tutorial");
        Index I13 = new Index("BG2141", "Mechanics of Material", 12345, "B22", 20);
        Lesson L13LEC = new Lesson(12345, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "LT2A", Week.EVERY);
        Lesson L13TUT = new Lesson(12345, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("08:30"), LocalTime.parse("09.30"), "TR+16", Week.EVERY);
        //I13.setLessons(I13LEC);
        c5.setindexlist(I13);
        Index I131 = new Index("BG2141", "Mechanics of Material", 12346, "B23", 20);
        Lesson L131LEC = new Lesson(12346, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "LT2A", Week.EVERY);
        Lesson L131TUT = new Lesson(12346, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11.30"), "TR+04", Week.EVERY);
        c5.setindexlist(I131);
        Index I132 = new Index("BG2141", "Mechanics of Material", 12347, "B24", 20);
        Lesson L132LEC = new Lesson(12347, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "LT2A", Week.EVERY);
        Lesson L132TUT = new Lesson(12347, LessonType.TUT, DayOfWeek.WEDNESDAY, LocalTime.parse("13.30"), LocalTime.parse("14.30"), "TR+08", Week.EVERY);
        c5.setindexlist(I132);

        Course c6 = new Course("BG2142", "Electronics for Biomedical Engineering", 3);
        SCBE.setCourseList(c2);
        c2.addLessonType1("Lectures");
        c2.addLessonType1("Tutorial");
        Index I14 = new Index("BG2142", "Electronics for Biomedical Engineering", 13692, "B13", 20);
        Lesson L14LEC  = new Lesson(13692, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "LT19A", Week.EVERY);
        Lesson L14TUT = new Lesson(13692, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "TR+20", Week.EVERY);
        Index I141 = new Index("BG2142", "Electronics for Biomedical Engineering", 13693, "B14", 20);
        Lesson L141LEC = new Lesson(13693, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "LT19A", Week.EVERY);
        Lesson L141TUT = new Lesson(13693, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "TR+20", Week.EVERY);
        Index I142 = new Index("BG2142", "Electronics for Biomedical Engineering", 13694, "B15", 20);
        Lesson L142LEC = new Lesson(13694, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "LT19A", Week.EVERY);
        Lesson L142TUT = new Lesson(13694, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("1.30"), LocalTime.parse("2.30"), "TR+20", Week.EVERY);

        Course c7 = new Course("BG2143", "Introduction to Computational Thinking", 3);
        SCBE.setCourseList(c3);
        c3.addLessonType1("Lectures");
        c3.addLessonType1("Tutorial");
        Index I15 = new Index("BG2143", "Introduction to Computational Thinking", 14855, "B01", 20);
        Lesson L15LEC = new Lesson(14855, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT19A", Week.EVERY);
        Lesson L15TUT = new Lesson(14855, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13.30"), LocalTime.parse("14.30"), "TR+05", Week.EVERY);
        Index I151 = new Index("BG2143", "Introduction to Computational Thinking", 14856, "B02", 20);
        Lesson L151LEC = new Lesson(14856, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT19A", Week.EVERY);
        Lesson L151TUT = new Lesson(14856, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13.30"), LocalTime.parse("14.30"), "TR+06", Week.EVERY);
        Index I152 = new Index("BG2143", "Introduction to Computational Thinking", 14857, "B03", 20);
        Lesson L152LEC = new Lesson(14857, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16.30"), LocalTime.parse("17.30"), "LT19A", Week.EVERY);
        Lesson L152TUT = new Lesson(14857, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13.30"), LocalTime.parse("14.30"), "TR+07", Week.EVERY);

        Course c8 = new Course("BG2144", "Biomaterials", 3);
        SCBE.setCourseList(c4);
        c4.addLessonType1("Lectures");
        c4.addLessonType1("Tutorial");
        Index I16 = new Index("BG2144", "Biomaterials", 16777, "B05", 20);
        Lesson L16LEC = new Lesson(16777, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("17.30"), LocalTime.parse("18.30"), "LT19A", Week.EVERY);
        Lesson L16TUT = new Lesson(16777, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("09:30"), LocalTime.parse("10.30"), "TR+05", Week.EVERY);
        Index I161 = new Index("BG2144", "Biomaterials", 16778, "B06", 20);
        Lesson L161LEC = new Lesson(16778, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("17.30"), LocalTime.parse("18.30"), "LT19A", Week.EVERY);
        Lesson L161TUT = new Lesson(16778, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("10.30"), LocalTime.parse("11.30"), "TR+06", Week.EVERY);
        Index I162 = new Index("BG2144", "Biomaterials", 16779, "B07", 20);
        Lesson L162LEC = new Lesson(16779, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("17.30"), LocalTime.parse("18.30"), "LT19A", Week.EVERY);
        Lesson L162TUT = new Lesson(16779, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("11.30"), LocalTime.parse("12.30"), "TR+07", Week.EVERY);

        //Create SCSE Data
        LocalDateTime startDateSCSE = LocalDateTime.parse("2019-12-11T09:00");
        LocalDateTime endDateSCSE = LocalDateTime.parse("2019-12-12T09:00");
        AccessPeriod SCSEAccessPeriod = new AccessPeriod(startDateSCSE,endDateSCSE);
        School SCSE = new School("SCSE",SCSEAccessPeriod);

        Course course1 = new Course("CZ2001","ALGORTIHMS",3);
        course1.addLessonType1("LEC");
        course1.addLessonType1("TUT");
        course1.addLessonType1("LAB");
        course1.setOfferingSchool(SCSE);
        course1.setindexlist(new Index("ALGORITHMS","CZ2001",474,"SP1",20));
        course1.setindexlist(new Index("ALGORITHMS","CZ2001",475,"SP2",20));
        course1.setindexlist(new Index("ALGORITHMS","CZ2001",476,"SP3",20));
        course1.setindexlist(new Index("ALGORITHMS","CZ2001",477,"SP4",20));
        SCSE.setCourseList(course1);

        Course course2 = new Course("CZ2002","OBJECT ORIENTED DESIGN AND PROGRAMMING",3);
        course1.addLessonType1("LEC");
        course1.addLessonType1("TUT");
        course1.addLessonType1("LAB");
        course1.setOfferingSchool(SCSE);
        course1.setindexlist(new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING","CZ2002",342,"SP1",20));
        course1.setindexlist(new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING","CZ2002",343,"SP2",20));
        course1.setindexlist(new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING","CZ2002",344,"SP3",20));
        course1.setindexlist(new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING","CZ2002",345,"SP4",20));
        SCSE.setCourseList(course2);

        Course course3 = new Course("CZ2005","OPERATING SYSTEMS",3);
        course1.addLessonType1("LEC");
        course1.addLessonType1("TUT");
        course1.addLessonType1("LAB");
        course1.setOfferingSchool(SCSE);
        course1.setindexlist(new Index("OPERATING SYSTEMS","CZ2005",681,"SP1",20));
        course1.setindexlist(new Index("OPERATING SYSTEMS","CZ2005",682,"SP2",20));
        course1.setindexlist(new Index("OPERATING SYSTEMS","CZ2005",683,"SP3",20));
        course1.setindexlist(new Index("OPERATING SYSTEMS","CZ2005",684,"SP4",20));
        SCSE.setCourseList(course3);

        Course course4 = new Course("CZ2007","INTRODUCTION TO DATABASES",3);
        course1.addLessonType1("LEC");
        course1.addLessonType1("TUT");
        course1.addLessonType1("LAB");
        course1.setOfferingSchool(SCSE);
        course1.setindexlist(new Index("INTRODUCTION TO DATABASES","CZ2007",366,"SP6",20));
        course1.setindexlist(new Index("INTRODUCTION TO DATABASES","CZ2007",367,"SP7",20));
        course1.setindexlist(new Index("INTRODUCTION TO DATABASES","CZ2007",368,"SP8",20));
        course1.setindexlist(new Index("INTRODUCTION TO DATABASES","CZ2007",369,"SP9",20));
        SCSE.setCourseList(course4);

    }
    //"Nanyang Business School",NBS,"2019-12-13 09:00","2019-12-14 09:00","AB1201 AB1301 AB1501 AD2101"



}