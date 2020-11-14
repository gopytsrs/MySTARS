package Control;

import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentControl {
    Student student;

    //Create StudentControl using this constructor
    public StudentControl(Student student){
        this.student = student;
    }

    public void addCourse(Course course){
        //go to school -> print course
        //ask for course -> show indexes if correct -> ask if want to add the course and index -> register courses
    }

    public void dropCourse() {
        Scanner scanner = new Scanner(System.in);
        String courseCode = scanner.nextLine();
        CourseRegistration courseToDrop = null;

        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();
        ArrayList<CourseRegistration> registeredCourses = student.getCourseRegistrationList();

        //Check if course is registered, exits method if course is not registered
        for(CourseRegistration course: registeredCourses){
            if(course.getCourseCode().equals(courseCode)){
                courseToDrop = course;
            }
            else{
                System.out.println("You are not registered for " + courseCode);
                return;
            }
        }


        for (CourseRegistration courseRegistered : registeredCourses) {

            if (courseRegistered.getCourseCode().equals(courseToDrop.getCourseCode())) {
                Index index = courseRegistered.getIndex();
                int vacancies = index.getVacancy();

                //Branch to check if course is registered only or assigned.
                //Case 1: Course is registered, but not assigned, we need to remove the course from registeredList
                if (registeredCourses.contains(courseToDrop) && (!assignedCourses.contains(courseToDrop))) {
                    student.removeCourseRegistration(courseToDrop);
                    index.removeFromWaitlist(student);
                    System.out.printf("Removed %s from waitlist",courseToDrop.getCourseCode());
                    return;

                    //Case 2: Course is registered and assigned, we need to remove course from registeredList
                    //        assignedList and we need to update vacancy as well
                } else if (registeredCourses.contains(courseToDrop) && assignedCourses.contains(courseToDrop)) {
                    vacancies -= 1;
                    index.setVacancy(vacancies);
                    student.removeCourseRegistration(courseToDrop);
                    student.removeAssignedCourse(courseToDrop);
                    System.out.printf("Dropped %s from assigned courses",courseToDrop.getCourseCode());
                    return;
                }
                break;
            }


        }
    }
    public void printRegisteredCourses(){

        ArrayList<CourseRegistration>registeredCourses = student.getCourseRegistrationList();
        ArrayList<CourseRegistration>assignedCourses = student.getAssignedCourse();

        System.out.println("Course Code:\tCourse Name:\tIndex:\tAU:\tStatus");

        //Go through all the courses, each course is printed on a new line
        for(CourseRegistration course: registeredCourses){
            System.out.printf("%s\t",course.getCourseCode());
            System.out.printf("%s\t",course.getCourseName());
            System.out.printf("%d\t",course.getIndex().getIndexNo());
            System.out.printf("%d\t",course.getAu());
            if(assignedCourses.contains(course)){
                System.out.printf("Assigned");
            } else {
                System.out.printf("On wait list");
            }
            System.out.println("");
        }

    }

    public void checkAvailableSlots(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index number:");

        int indexNo = Integer.valueOf(scanner.nextLine());
        ArrayList<Course> courses = new ArrayList<Course>();

        //Loop through indexList of each course to find if the index exists
        for(Course course: courses){
            ArrayList<Index> indexes = course.getIndexList();
            for(Index index: indexes){
                //Index exists, print out the vacancies and exit the method
                if(index.getIndexNo() == indexNo){
                    System.out.printf("The number of available slots in Index %d of %s is %d",index.getIndexNo(),index.getCourseCode(),index.getVacancy());
                    return;
                }
            }
        }

        //Loop ends without finding the index
        System.out.println("That index number does not exist");
    }

    public void changeIndex(){

    }

    public void swapIndex(){}

    public void register(){

    }

    private void checkTimeClash(){}


}
