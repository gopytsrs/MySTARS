package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * This class represent the access period of a school
 */
public class AccessPeriod implements Serializable {
    /**
     * This is the start date of the access period
     */
    private LocalDateTime startDate;
    /**
     * This is the end date of the access period
     */
    private LocalDateTime endDate;

    /**
     * Creates a new Access period, must be in localdatetime for startDate and endDate
     * @param startDate
     * @param endDate
     */
    public AccessPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Get the endDate
     * @return
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Get the startDate
     * @return
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Changes the startDate
     * @param startDate
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Changes the endDate
     * @param endDate
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

}
