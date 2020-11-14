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

    public void dropCourse(Course course) {
        ArrayList<CourseRegistration> assignedCourses = student.getAssignedCourse();
        ArrayList<CourseRegistration> registeredCourses = student.getCourseRegistrationList();

        for (CourseRegistration courseRegistered : registeredCourses) {

            if (courseRegistered.getCourseCode() == course.getCourseCode()) {
                //Check if course is assigned or registered only
                Index index = courseRegistered.getIndex();
                int vacancies = index.getVacancy();

                //Case 1: Course is registered, but not assigned
                if (registeredCourses.contains(courseRegistered) && (!assignedCourses.contains(courseRegistered))) {
                    student.removeCourseRegistration(courseRegistered);
                    index.removeFromWaitlist(student);
                    //Case 2: Course is registered and assigned
                } else if (registeredCourses.contains(courseRegistered) && assignedCourses.contains(courseRegistered)) {
                    vacancies -= 1;
                    index.setVacancy(vacancies);
                    student.removeCourseRegistration(courseRegistered);
                }
                break;
            }


        }
    }
    public void printRegisteredCourses(){
        ArrayList<CourseRegistration>registeredCourses = student.getCourseRegistrationList();
        ArrayList<CourseRegistration>assignedCourses = student.getAssignedCourse();
        System.out.println("Course Code:\tCourse Name:\tIndex:\tAU:\tStatus");
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
        for(Course course: courses){
            ArrayList<Index> indexes = course.getIndexList();
            for(Index index: indexes){
                if(index.getIndexNo() == indexNo){
                    System.out.printf("The number of available slots in Index %d of %s is %d",index.getIndexNo(),index.getCourseCode(),index.getVacancy());
                    return;
                }
            }
        }
        System.out.println("That index number does not exist");
    }

    public void changeIndex(){

    }

    public void swapIndex(){}

    public void register(){

    }

    private void checkTimeClash(){}


}
