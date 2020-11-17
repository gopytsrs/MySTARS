package Control;

import Entity.Admin;
import Entity.Course;
import Entity.Student;

import java.util.Scanner;

public class AdminUI {
    Admin admin;
    Student student;
    Course course;

    public void adminMenu() {
        Scanner sc = new Scanner(System.in);
        AdminControl acontrol = new AdminControl();
        int choice = 0;

        do {
            System.out.println("1. Edit student access periods");
            System.out.println("2. Add a student");
            System.out.println("3. Add/Update a course");
            System.out.println("4. Check available slot for an index number");
            System.out.println("5. Print student list by index number");
            System.out.println("6. Print student list by course");
            System.out.println("7. Logout");
            System.out.println("Enter your choice here: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    acontrol.editStudentAccessPeriod();
                    break;

                case 2:
                    acontrol.addStudent(student);
                    break;

                case 3:
                    acontrol.addCourse();
                    break;

                case 4:
                    acontrol.deleteCourse(course);
                    break;

                case 5:
                    acontrol.printStudentByCourse(student, course);
                    break;

                case 6:
                    acontrol.printStudentByIndex(course);
                    break;

                case 7:
                    //Serialise here
                    System.out.println("Logging out...");
                    Login l = new Login();
                    break;

                default:
                    System.out.println("Invalid choice. Choices are between 1 to 7.");
            }
        } while (choice != 7);
    }
}

