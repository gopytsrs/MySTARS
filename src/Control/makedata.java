package Control;

import Entity.*;
import Enum.LessonType;
import Enum.Week;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class makedata {
    public static void main(String args[]) {
        LocalDateTime dateTime = LocalDateTime.parse("2019-12-13T09:00");
        LocalDateTime dateTime1 = LocalDateTime.parse("2019-12-14T09:00");
        School nbs = new School("Nanyang Business School", new AccessPeriod(dateTime, dateTime1));
        Course c1 = new Course("AB1202", "Statistic", 3);
        nbs.setCourseList(c1);
        c1.addLessonType1("Lectures");
        c1.addLessonType1("Tutorial");
        Index I1 = new Index("AB1202", "Statistic", 10003, "BCG2", 20);
        Lesson L1LEC = new Lesson(10003, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L1TUT = new Lesson(10003, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+05", Week.EVERY);
        I1.setLessons(L1LEC);
        I1.setLessons(L1TUT);
        Index I2 = new Index("AB1202", "Statistic", 10021, "SS04", 20);
        Lesson L2LEC = new Lesson(10021, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L2TUT = new Lesson(10021, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "TR+07", Week.EVERY);
        I2.setLessons(L2LEC);
        I2.setLessons(L2TUT);
        Index I3 = new Index("AB1202", "Statistic", 10024, "SSP3", 20);
        Lesson L3LEC = new Lesson(10024, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L3TUT = new Lesson(10024, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+10", Week.EVERY);
        I3.setLessons(L3LEC);
        I3.setLessons(L3TUT);
        c1.setindexlist(I1);
        c1.setindexlist(I2);
        c1.setindexlist(I3);

        Course c2 = new Course("AB1301", "Business Law", 3);
        nbs.setCourseList(c2);
        c2.addLessonType1("Lectures");
        c2.addLessonType1("Tutorial");
        Index I4 = new Index("AB1301", "Business Law", 10004, "BCG1", 20);
        Lesson L4LEC = new Lesson(10004, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L4TUT = new Lesson(10004, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+05", Week.EVERY);
        I4.setLessons(L4LEC);
        I4.setLessons(L4TUT);
        Index I5 = new Index("AB1301", "Business Law", 10022, "SS03", 20);
        Lesson L5LEC = new Lesson(10022, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L5TUT = new Lesson(10022, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "TR+07", Week.EVERY);
        I5.setLessons(L5LEC);
        I5.setLessons(L5TUT);
        Index I6 = new Index("AB1301", "Business Law", 10025, "SSP2", 20);
        Lesson L6LEC = new Lesson(10025, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L6TUT = new Lesson(10025, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+10", Week.EVERY);
        I6.setLessons(L6LEC);
        I6.setLessons(L6TUT);
        c2.setindexlist(I4);
        c2.setindexlist(I5);
        c2.setindexlist(I6);

        Course c3 = new Course("AB1501", "Marketing", 3);
        nbs.setCourseList(c3);
        c3.addLessonType1("Lectures");
        c3.addLessonType1("Tutorial");
        Index I7 = new Index("AB1501", "Marketing", 10008, "BCG3", 20);
        Lesson L7LEC = new Lesson(10008, LessonType.LEC, DayOfWeek.THURSDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L7TUT = new Lesson(10008, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+13", Week.EVERY);
        I7.setLessons(L7LEC);
        I7.setLessons(L7TUT);
        Index I8 = new Index("AB1501", "Marketing", 10016, "SS07", 20);
        Lesson L8LEC = new Lesson(10016, LessonType.LEC, DayOfWeek.THURSDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L8TUT = new Lesson(10016, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "TR+15", Week.EVERY);
        I8.setLessons(L8LEC);
        I8.setLessons(L8TUT);
        Index I9 = new Index("AB1501", "Marketing", 10048, "SSP5", 20);
        Lesson L9LEC = new Lesson(10048, LessonType.LEC, DayOfWeek.THURSDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L9TUT = new Lesson(10048, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+17", Week.EVERY);
        I9.setLessons(L9LEC);
        I9.setLessons(L9TUT);
        c3.setindexlist(I7);
        c3.setindexlist(I8);
        c3.setindexlist(I9);

        Course c4 = new Course("AB2101", "Managerial Accounting", 3);
        nbs.setCourseList(c4);
        c4.addLessonType1("Lectures");
        c4.addLessonType1("Tutorial");
        Index I10 = new Index("AB2101", "Managerial Accounting", 10015, "BCG4", 20);
        Lesson L10LEC = new Lesson(10015, LessonType.LEC, DayOfWeek.FRIDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L10TUT = new Lesson(10015, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+10", Week.EVERY);
        I10.setLessons(L10LEC);
        I10.setLessons(L10TUT);
        Index I11 = new Index("AB2101", "Managerial Accounting", 10042, "SS01", 20);
        Lesson L11LEC = new Lesson(10042, LessonType.LEC, DayOfWeek.FRIDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L11TUT = new Lesson(10042, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "TR+20", Week.EVERY);
        I11.setLessons(L11LEC);
        I11.setLessons(L11TUT);
        Index I12 = new Index("AB2101", "Managerial Accounting", 50041, "SSP9", 20);
        Lesson L12LEC = new Lesson(50041, LessonType.LEC, DayOfWeek.FRIDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT26", Week.EVERY);
        Lesson L12TUT = new Lesson(50041, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("14:30"), LocalTime.parse("15:30"), "TR+30", Week.EVERY);
        I12.setLessons(L12LEC);
        I12.setLessons(L12TUT);
        c4.setindexlist(I10);
        c4.setindexlist(I11);
        c4.setindexlist(I12);


        //make SCBE
        LocalDateTime startDate = LocalDateTime.parse("2020-12-06T09:00");
        LocalDateTime endDate = LocalDateTime.parse("2020-12-07T09:00");

        School SCBE = new School("School of Chemical and Biomedical Engineering", new AccessPeriod(startDate, endDate));
        Course c5 = new Course("BG2141", "Mechanics of Material", 3);
        SCBE.setCourseList(c5);

        c5.addLessonType1("Lectures");
        c5.addLessonType1("Tutorial");
        Index I13 = new Index("BG2141", "Mechanics of Material", 12345, "B22", 20);
        Lesson L13LEC = new Lesson(12345, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "LT2A", Week.EVERY);
        Lesson L13TUT = new Lesson(12345, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "TR+16", Week.EVERY);
        I13.setLessons(L13LEC);
        I13.setLessons(L13TUT);
        c5.setindexlist(I13);
        Index I131 = new Index("BG2141", "Mechanics of Material", 12346, "B23", 20);
        Lesson L131LEC = new Lesson(12346, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "LT2A", Week.EVERY);
        Lesson L131TUT = new Lesson(12346, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "TR+04", Week.EVERY);
        I131.setLessons(L131LEC);
        I131.setLessons(L131TUT);
        c5.setindexlist(I131);
        Index I132 = new Index("BG2141", "Mechanics of Material", 12347, "B24", 20);
        Lesson L132LEC = new Lesson(12347, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "LT2A", Week.EVERY);
        Lesson L132TUT = new Lesson(12347, LessonType.TUT, DayOfWeek.WEDNESDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+08", Week.EVERY);
        I132.setLessons(L132LEC);
        I132.setLessons(L132TUT);
        c5.setindexlist(I132);

        Course c6 = new Course("BG2142", "Electronics for Biomedical Engineering", 3);
        SCBE.setCourseList(c6);
        c6.addLessonType1("Lectures");
        c6.addLessonType1("Tutorial");
        Index I14 = new Index("BG2142", "Electronics for Biomedical Engineering", 13692, "B13", 20);
        Lesson L14LEC = new Lesson(13692, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "LT19A", Week.EVERY);
        Lesson L14TUT = new Lesson(13692, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+20", Week.EVERY);
        I14.setLessons(L14LEC);
        I14.setLessons(L14TUT);
        c6.setindexlist(I14);
        Index I141 = new Index("BG2142", "Electronics for Biomedical Engineering", 13693, "B14", 20);
        Lesson L141LEC = new Lesson(13693, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "LT19A", Week.EVERY);
        Lesson L141TUT = new Lesson(13693, LessonType.TUT, DayOfWeek.THURSDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+20", Week.EVERY);
        I141.setLessons(L141LEC);
        I141.setLessons(L141TUT);
        c6.setindexlist(I141);
        Index I142 = new Index("BG2142", "Electronics for Biomedical Engineering", 13694, "B15", 20);
        Lesson L142LEC = new Lesson(13694, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "LT19A", Week.EVERY);
        Lesson L142TUT = new Lesson(13694, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+20", Week.EVERY);
        I142.setLessons(L142LEC);
        I142.setLessons(L142TUT);
        c6.setindexlist(I142);

        Course c7 = new Course("BG2143", "Introduction to Computational Thinking", 3);
        SCBE.setCourseList(c7);
        c7.addLessonType1("Lectures");
        c7.addLessonType1("Tutorial");
        Index I15 = new Index("BG2143", "Introduction to Computational Thinking", 14855, "B01", 20);
        Lesson L15LEC = new Lesson(14855, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT19A", Week.EVERY);
        Lesson L15TUT = new Lesson(14855, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+05", Week.EVERY);
        I15.setLessons(L15LEC);
        I15.setLessons(L15TUT);
        c7.setindexlist(I15);
        Index I151 = new Index("BG2143", "Introduction to Computational Thinking", 14856, "B02", 20);
        Lesson L151LEC = new Lesson(14856, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT19A", Week.EVERY);
        Lesson L151TUT = new Lesson(14856, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+06", Week.EVERY);
        I151.setLessons(L151LEC);
        I151.setLessons(L151TUT);
        c7.setindexlist(I142);
        Index I152 = new Index("BG2143", "Introduction to Computational Thinking", 14857, "B03", 20);
        Lesson L152LEC = new Lesson(14857, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("16:30"), LocalTime.parse("17:30"), "LT19A", Week.EVERY);
        Lesson L152TUT = new Lesson(14857, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("13:30"), LocalTime.parse("14:30"), "TR+07", Week.EVERY);
        I152.setLessons(L152LEC);
        I152.setLessons(L152TUT);
        c7.setindexlist(I152);

        Course c8 = new Course("BG2144", "Biomaterials", 3);
        SCBE.setCourseList(c8);
        c8.addLessonType1("Lectures");
        c8.addLessonType1("Tutorial");
        Index I16 = new Index("BG2144", "Biomaterials", 16777, "B05", 20);
        Lesson L16LEC = new Lesson(16777, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("17:30"), LocalTime.parse("18:30"), "LT19A", Week.EVERY);
        Lesson L16TUT = new Lesson(16777, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+05", Week.EVERY);
        I16.setLessons(L16LEC);
        I16.setLessons(L16TUT);
        c8.setindexlist(I16);
        Index I161 = new Index("BG2144", "Biomaterials", 16778, "B06", 20);
        Lesson L161LEC = new Lesson(16778, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("17:30"), LocalTime.parse("18:30"), "LT19A", Week.EVERY);
        Lesson L161TUT = new Lesson(16778, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "TR+06", Week.EVERY);
        I161.setLessons(L161LEC);
        I161.setLessons(L161TUT);
        c8.setindexlist(I161);
        Index I162 = new Index("BG2144", "Biomaterials", 16779, "B07", 20);
        Lesson L162LEC = new Lesson(16779, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("17:30"), LocalTime.parse("18:30"), "LT19A", Week.EVERY);
        Lesson L162TUT = new Lesson(16779, LessonType.TUT, DayOfWeek.FRIDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+07", Week.EVERY);
        I162.setLessons(L162LEC);
        I162.setLessons(L162TUT);
        c8.setindexlist(I162);

        //Create SCSE Data
        LocalDateTime startDateSCSE = LocalDateTime.parse("2019-12-11T09:00");
        LocalDateTime endDateSCSE = LocalDateTime.parse("2019-12-12T09:00");
        AccessPeriod SCSEAccessPeriod = new AccessPeriod(startDateSCSE, endDateSCSE);
        School SCSE = new School("SCSE", SCSEAccessPeriod);

        Course course1 = new Course("CZ2001", "ALGORTIHMS", 3);
        course1.addLessonType1("LEC");
        course1.addLessonType1("TUT");
        course1.addLessonType1("LAB");
        course1.setOfferingSchool(SCSE);

        Index index1 = new Index("ALGORITHMS", "CZ2001", 474, "SP1", 20);
        Lesson lesson1lec = new Lesson(474, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "LT2A", Week.EVERY);
        Lesson lesson1tut = new Lesson(474, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+01", Week.EVERY);
        Lesson lesson1lab = new Lesson(474, LessonType.LAB, DayOfWeek.MONDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "HWL01", Week.EVEN);
        index1.setLessons(lesson1lec);
        index1.setLessons(lesson1tut);
        index1.setLessons(lesson1lab);
        course1.setindexlist(index1);

        Index index11 = new Index("ALGORITHMS", "CZ2001", 475, "SP2", 20);
        Lesson lesson11lec = new Lesson(475, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "LT2A", Week.EVERY);
        Lesson lesson11tut = new Lesson(475, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+02", Week.EVERY);
        Lesson lesson11lab = new Lesson(475, LessonType.LAB, DayOfWeek.MONDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "HWL01", Week.ODD);
        index11.setLessons(lesson11lec);
        index11.setLessons(lesson11tut);
        index11.setLessons(lesson11lab);
        course1.setindexlist(index11);

        Index index12 = new Index("ALGORITHMS", "CZ2001", 476, "SP3", 20);
        Lesson lesson12lec = new Lesson(476, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "LT2A", Week.EVERY);
        Lesson lesson12tut = new Lesson(476, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+03", Week.EVERY);
        Lesson lesson12lab = new Lesson(476, LessonType.LAB, DayOfWeek.MONDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "SWL01", Week.EVEN);
        index12.setLessons(lesson12lec);
        index12.setLessons(lesson12tut);
        index12.setLessons(lesson12lab);
        course1.setindexlist(index12);

        Index index13 = new Index("ALGORITHMS", "CZ2001", 477, "SP4", 20);
        Lesson lesson13lec = new Lesson(477, LessonType.LEC, DayOfWeek.MONDAY, LocalTime.parse("10:30"), LocalTime.parse("11:30"), "LT2A", Week.EVERY);
        Lesson lesson13tut = new Lesson(477, LessonType.TUT, DayOfWeek.MONDAY, LocalTime.parse("11:30"), LocalTime.parse("12:30"), "TR+04", Week.EVERY);
        Lesson lesson13lab = new Lesson(477, LessonType.LAB, DayOfWeek.MONDAY, LocalTime.parse("14:30"), LocalTime.parse("16:30"), "SWL01", Week.ODD);
        index13.setLessons(lesson13lec);
        index13.setLessons(lesson13tut);
        index13.setLessons(lesson13lab);
        course1.setindexlist(index13);

        SCSE.setCourseList(course1);


        Course course2 = new Course("CZ2002", "OBJECT ORIENTED DESIGN AND PROGRAMMING", 3);
        course2.addLessonType1("LEC");
        course2.addLessonType1("TUT");
        course2.addLessonType1("LAB");
        course2.setOfferingSchool(SCSE);

        Index index2 = new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING", "CZ2002", 342, "SP1", 20);
        Lesson lesson2lec = new Lesson(342, LessonType.LEC, DayOfWeek.TUESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson2tut = new Lesson(342, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+01", Week.EVERY);
        Lesson lesson2lab = new Lesson(342, LessonType.LAB, DayOfWeek.TUESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "HWL01", Week.EVEN);
        index2.setLessons(lesson2lec);
        index2.setLessons(lesson2tut);
        index2.setLessons(lesson2lab);
        course2.setindexlist(index2);

        Index index21 = new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING", "CZ2002", 343, "SP2", 20);
        Lesson lesson21lec = new Lesson(343, LessonType.LEC, DayOfWeek.TUESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson21tut = new Lesson(343, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+02", Week.EVERY);
        Lesson lesson21lab = new Lesson(343, LessonType.LAB, DayOfWeek.TUESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "HWL01", Week.ODD);
        index21.setLessons(lesson21lec);
        index21.setLessons(lesson21tut);
        index21.setLessons(lesson21lab);
        course2.setindexlist(index21);

        Index index22 = new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING", "CZ2002", 344, "SP3", 20);
        Lesson lesson22lec = new Lesson(344, LessonType.LEC, DayOfWeek.TUESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson22tut = new Lesson(344, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+03", Week.EVERY);
        Lesson lesson22lab = new Lesson(344, LessonType.LAB, DayOfWeek.TUESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "SWL01", Week.EVEN);
        index22.setLessons(lesson22lec);
        index22.setLessons(lesson22tut);
        index22.setLessons(lesson22lab);
        course2.setindexlist(index22);

        Index index23 = new Index("OBJECT ORIENTED DESIGN AND PROGRAMMING", "CZ2002", 345, "SP4", 20);
        Lesson lesson23lec = new Lesson(345, LessonType.LEC, DayOfWeek.TUESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson23tut = new Lesson(345, LessonType.TUT, DayOfWeek.TUESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+04", Week.EVERY);
        Lesson lesson23lab = new Lesson(345, LessonType.LAB, DayOfWeek.TUESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "SWL01", Week.ODD);
        index23.setLessons(lesson23lec);
        index23.setLessons(lesson23tut);
        index23.setLessons(lesson23lab);
        course2.setindexlist(index23);

        SCSE.setCourseList(course2);

        Course course3 = new Course("CZ2005", "OPERATING SYSTEMS", 3);
        course3.addLessonType1("LEC");
        course3.addLessonType1("TUT");
        course3.addLessonType1("LAB");
        course3.setOfferingSchool(SCSE);

        Index index3 = new Index("OPERATING SYSTEMS", "CZ2005", 681, "SP1", 20);
        Lesson lesson3lec = new Lesson(681, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson3tut = new Lesson(681, LessonType.TUT, DayOfWeek.WEDNESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+01", Week.EVERY);
        Lesson lesson3lab = new Lesson(681, LessonType.LAB, DayOfWeek.WEDNESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "HWL01", Week.EVEN);
        index3.setLessons(lesson3lec);
        index3.setLessons(lesson3tut);
        index3.setLessons(lesson3lab);
        course3.setindexlist(index3);

        Index index31 = new Index("OPERATING SYSTEMS", "CZ2005", 682, "SP2", 20);
        Lesson lesson31lec = new Lesson(682, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson31tut = new Lesson(682, LessonType.TUT, DayOfWeek.WEDNESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+02", Week.EVERY);
        Lesson lesson31lab = new Lesson(682, LessonType.LAB, DayOfWeek.WEDNESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "HWL01", Week.ODD);
        index31.setLessons(lesson31lec);
        index31.setLessons(lesson31tut);
        index31.setLessons(lesson31lab);
        course3.setindexlist(index31);

        Index index32 = new Index("OPERATING SYSTEMS", "CZ2005", 683, "SP3", 20);
        Lesson lesson32lec = new Lesson(683, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson32tut = new Lesson(683, LessonType.TUT, DayOfWeek.WEDNESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+03", Week.EVERY);
        Lesson lesson32lab = new Lesson(683, LessonType.LAB, DayOfWeek.WEDNESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "SWL01", Week.EVEN);
        index32.setLessons(lesson32lec);
        index32.setLessons(lesson32tut);
        index32.setLessons(lesson32lab);
        course3.setindexlist(index32);

        Index index33 = new Index("OPERATING SYSTEMS", "CZ2005", 684, "SP4", 20);
        Lesson lesson33lec = new Lesson(684, LessonType.LEC, DayOfWeek.WEDNESDAY, LocalTime.parse("08:30"), LocalTime.parse("09:30"), "LT2A", Week.EVERY);
        Lesson lesson33tut = new Lesson(684, LessonType.TUT, DayOfWeek.WEDNESDAY, LocalTime.parse("09:30"), LocalTime.parse("10:30"), "TR+04", Week.EVERY);
        Lesson lesson33lab = new Lesson(684, LessonType.LAB, DayOfWeek.WEDNESDAY, LocalTime.parse("10:30"), LocalTime.parse("12.30"), "SWL01", Week.ODD);
        index33.setLessons(lesson33lec);
        index33.setLessons(lesson33tut);
        index33.setLessons(lesson33lab);
        course3.setindexlist(index33);

        SCSE.setCourseList(course3);

        Course course4 = new Course("CZ2007", "INTRODUCTION TO DATABASES", 3);
        course4.addLessonType1("LEC");
        course4.addLessonType1("TUT");
        course4.addLessonType1("LAB");
        course4.setOfferingSchool(SCSE);
        course4.setindexlist(new Index("INTRODUCTION TO DATABASES", "CZ2007", 366, "SP6", 20));
        course4.setindexlist(new Index("INTRODUCTION TO DATABASES", "CZ2007", 367, "SP7", 20));
        course4.setindexlist(new Index("INTRODUCTION TO DATABASES", "CZ2007", 368, "SP8", 20));
        course4.setindexlist(new Index("INTRODUCTION TO DATABASES", "CZ2007", 369, "SP9", 20));

        SCSE.setCourseList(course4);

        String fileName = "database_school_testing.bin";
        ArrayList<School> schoolList = new ArrayList<School>();
        schoolList.add(nbs);
        schoolList.add(SCSE);
        schoolList.add(SCBE);

        //student0
        Student student = new Student("Sean Goh", "U1920001", "seangoh@e.ntu.edu.sg", 2, "Male", "Singaporean");
        Account account = new Account()
        //student1
        Student student1 = new Student("Chia Wen Cheng", "U1920002", "chiawencheng@e.ntu.edu.sg", 2, "Male", "Singaporean");

        //student2
        Student student2 = new Student("Jun Hao", "U1920003", "junhao@e.ntu.edu.sg", 2, "Male", "Singaporean");

        //student3
        Student student3 = new Student("Lek Zhi Ying", "U1920004", "lekzhiying@e.ntu.edu.sg", 2, "Female", "Singaporean");

        //student4
        Student student4 = new Student("Tchen Jee Wern", "U1920005", "tchenjeewern@e.ntu.edu.sg", 2, "Male", "Singaporean");

        //Serialising
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(schoolList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Deserialising
        ArrayList<School> demoSchoolDeserialise = new ArrayList<School>();
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            demoSchoolDeserialise = (ArrayList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(demoSchoolDeserialise.get(0).getSchoolName());
        System.out.println(demoSchoolDeserialise.get(1).getSchoolName());
        System.out.println(demoSchoolDeserialise.get(2).getSchoolName());

        School NBS = demoSchoolDeserialise.get(0);
        ArrayList<Course> nbscourse = nbs.getCourseList();

        for (Course course : nbscourse) {
            System.out.println(course);
        }
    }


}
