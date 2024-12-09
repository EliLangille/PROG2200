import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventViewer {

    public static void showEventsByDay(List<Event> events) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Event event : events) {
            LocalDate eventDate = LocalDate.parse(event.getDate().format(dateFormatter), dateFormatter);
            System.out.println("DATE: " + eventDate);
            System.out.println(event);
        }
    }

    public static void showEventsByType(List<Event> events) {
        for (Event event : events) {
            String eventType = event.getType().getName().toUpperCase();
            System.out.println("TYPE: " + eventType);
            System.out.println(event);
        }
    }
}