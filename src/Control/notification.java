package Control;

import Entity.CourseRegistration;
import Entity.Student;

public interface notification {
    public void sendnotification(Student S, CourseRegistration C);
}
