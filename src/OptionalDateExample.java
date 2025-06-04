import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class OptionalDateExample {
    private Optional<LocalDateTime> optionalDate;

    public OptionalDateExample(Optional<LocalDateTime> optionalDate) {
        this.optionalDate = optionalDate;
    }

    public void printDate() {
        optionalDate.ifPresent(date -> System.out.println("Date: " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
    }
}
