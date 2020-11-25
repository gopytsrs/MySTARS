package Control;

import Entity.CourseRegistration;
import Entity.Student;

/**
 * This is an interface class for notifications
 */
public interface Notification {
    /**
     * This abstract method will be implemented by concrete classes to send notifications
     *
     * @param S The student
     * @param C The course registered
     */
    public void sendNotification(Student S, CourseRegistration C);
}
