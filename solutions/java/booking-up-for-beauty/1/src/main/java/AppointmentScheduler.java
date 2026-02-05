import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");
    private static final DateTimeFormatter DESCRIPTION_FORMATTER =
            DateTimeFormatter.ofPattern(
                    "EEEE, MMMM d, yyyy, 'at' h:mm a"
            );
    
    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, FORMATTER);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return hour >= 12 && hour < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on "
                + appointmentDate.format(DESCRIPTION_FORMATTER)
                + ".";
    }

    public LocalDate getAnniversaryDate() {
        int currentYear = Year.now().getValue();
        return LocalDate.of(currentYear, Month.SEPTEMBER, 15);
    }
}
