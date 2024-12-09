import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EventFilter {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static List<Event> filterByType(List<Event> events, String type) {
        return events.stream()
                .filter(event -> event.getType().getName().equalsIgnoreCase(type))
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

    public static List<Event> createFilteredList(List<Event> events) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for event type
        System.out.println("Enter event types to include in filter separated by commas (leave blank for all types):");
        String type = scanner.nextLine();

        // Prompt for time period
        System.out.println("Enter start date (yyyy-MM-dd) (leave blank for current week):");
        String startDateInput = scanner.nextLine();
        while (!startDateInput.isEmpty() && !EventInputHandler.isValidDate(startDateInput)) {
            System.out.println("Invalid date format. Please enter start date again (yyyy-MM-dd):");
            startDateInput = scanner.nextLine();
        }

        // Default to current week if no start date, else get end date
        LocalDate startDate;
        LocalDate endDate;
        if (startDateInput.isEmpty()) {
            LocalDate today = LocalDate.now();
            startDate = today.with(java.time.DayOfWeek.MONDAY);
            endDate = today.with(java.time.DayOfWeek.SUNDAY);
        } else {
            startDate = LocalDate.parse(startDateInput, dateFormatter);
            System.out.println("Enter end date (yyyy-MM-dd):");
            String endDateInput = scanner.nextLine();
            while (!EventInputHandler.isValidDate(endDateInput)) {
                System.out.println("Invalid date format. Please enter end date again (yyyy-MM-dd):");
                endDateInput = scanner.nextLine();
            }
            endDate = LocalDate.parse(scanner.nextLine(), dateFormatter);
        }

        // Create a new filtered list of the events
        List<Event> filteredEvents = events;
        if (!type.isEmpty()) {
            filteredEvents = filterByType(filteredEvents, type);
        }
        filteredEvents = filterByTimePeriod(filteredEvents, startDate, endDate);

        return filteredEvents;
    }
}