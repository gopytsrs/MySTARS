package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccessPeriod implements Serializable {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public AccessPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        System.out.println("Enter start datetime: (Format: yyyy-mm-dd hh:mm)");
        this.startDate = setDateTime();
    }

    public void setEndDate(LocalDateTime endDate) {
        System.out.println("Enter end datetime: (Format: yyyy-mm-dd hh:mm)");
        this.endDate = endDate;
    }

    private static LocalDateTime setDateTime() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), formatter);
        return dateTime;
    }
}
