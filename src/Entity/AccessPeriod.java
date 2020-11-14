package Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccessPeriod {

        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public LocalDateTime getEndDate() {
            return endDate;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public void setStartDate() {
            System.out.println("Enter start datetime: (Format: yyyy-mm-dd hh:mm)");
            this.startDate = setDateTime();
        }

        public void setEndDate() {
            System.out.println("Enter end datetime: (Format: yyyy-mm-dd hh:mm)");
            this.endDate = setDateTime();
        }
        public LocalDateTime setDateTime() {
            Scanner scanner = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm");
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(),formatter);
            return dateTime;
        }
}
