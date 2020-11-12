package Control;

import Entity.*;

import java.util.ArrayList;

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
    public void printRegisteredCourses(ArrayList<Course> courses){}

    public void checkAvailableSlots(){
    }

    public void changeIndex(){
    }

    public void swapIndex(){}

    public void register(){

    }

    private void checkTimeClash(){}


}
