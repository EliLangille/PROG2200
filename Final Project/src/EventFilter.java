import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventFilter {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static List<Event> filterByType(List<Event> events, List<EventType> types) {
        // Get names of all types
        List<String> typeNames = types.stream()
                .map(EventType::getName)
                .toList();

        // Filter events by type names
        return events.stream()
                .filter(event -> typeNames.contains(event.getType().getName()))
                .toList();
    }

    public static List<Event> filterByTimePeriod(List<Event> events, LocalDate startDate, LocalDate endDate) {
        return events.stream()
                .filter(event -> {
                    LocalDate eventDate = LocalDate.parse(event.getDate().format(dateFormatter), dateFormatter);
                    return !eventDate.isBefore(startDate) && !eventDate.isAfter(endDate);
                })
                .toList();
    }
}