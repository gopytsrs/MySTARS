package Control;

import java.util.Scanner;
import Entity.*;

public class StudentUI{
    Student student;
    Course course;

    public void studentMenu() {
        Scanner sc = new Scanner(System.in);
        StudentControl scontrol = new StudentControl(student.getName());
        int choice = 0;

        do {
            System.out.println("1. Add course");
            System.out.println("2. Drop course");
            System.out.println("3. Check/Print courses registered");
            System.out.println("4. Check vacancies available");
            System.out.println("5. Change index number of course");
            System.out.println("6. Swap index number with another student");
            System.out.println("7. Logout");
            System.out.println("Enter your choice here: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    scontrol.addCourse();
                    break;

                case 2:
                    scontrol.dropCourse();
                    break;

                case 3:
                    scontrol.printRegisteredCourses();
                    break;

                case 4:
                    scontrol.checkAvailableSlots();
                    break;

                case 5:
                    scontrol.changeIndex();
                    break;

                case 6:
                    scontrol.swapIndex();
                    break;

                case 7:
                    System.out.println("Logging out...");
                    Login l = new Login();
                    break;

                default:
                    System.out.println("Invalid choice. Choices are between 1 to 7.");
            }
        } while (choice != 7);
    }
}
