package Entity;
import java.time.LocalDateTime;
public class AccessPeriod {

        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public LocalDateTime getEndDate() {
            return endDate;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
        }
}
