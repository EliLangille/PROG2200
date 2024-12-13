import java.time.LocalDate;
import java.util.List;

public class EventViewer {

    public static void showEventsByDate(List<Event> events, LocalDate startDate, LocalDate endDate) {
        System.out.println("Showing events from " + startDate + " to " + endDate);
        for (Event event : events) {
            System.out.println(event + "\n");
        }
    }

    public static void showEventsByType(List<Event> events, List<EventType> types) {
        System.out.println("Showing events of types: " + types);
        for (Event event : events) {
            System.out.println(event + "\n");
        }
    }
}