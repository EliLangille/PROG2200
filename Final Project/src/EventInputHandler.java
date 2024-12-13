import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventInputHandler {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static Event getEventFromUser() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter event type (Feed, Groom, Health, Play, Train, Vet, Walk, Other):");
        String typeInput = s.nextLine().toUpperCase();
        while (!isValidType(typeInput)) {
            System.out.println("Invalid event type. Please enter again:");
            typeInput = s.nextLine().toUpperCase();
        }
        EventType type = EventType.valueOf(typeInput);

        System.out.println("Enter event name:");
        String name = s.nextLine();
        while (name.isEmpty()) {
            System.out.println("Event name cannot be empty. Please enter again:");
            name = s.nextLine();
        }

        System.out.println("Enter event description (leave blank to skip):");
        String description = s.nextLine();

        System.out.println("Enter event date (yyyy-MM-dd):");
        String date = s.nextLine();
        while (!isValidDate(date)) {
            System.out.println("Invalid date format. Please enter again (yyyy-MM-dd):");
            date = s.nextLine();
        }

        System.out.println("Enter event start time (HH:mm) (leave blank to skip):");
        String startTime = s.nextLine();
        while (!startTime.isEmpty() && !isValidTime(startTime)) {
            System.out.println("Invalid time format. Please enter again (HH:mm):");
            startTime = s.nextLine();
        }

        String endTime = null;
        if (!startTime.isEmpty()) {
            System.out.println("Enter event end time (HH:mm):");
            endTime = s.nextLine();
            while (!isValidTime(endTime)) {
                System.out.println("Invalid time format. Please enter again (HH:mm):");
                endTime = s.nextLine();
            }
        }

        System.out.println("Enter event reminder time for day of event (HH:mm) (leave blank to skip):");
        String reminderTime = s.nextLine();
        while (!reminderTime.isEmpty() && !isValidTime(reminderTime)) {
            System.out.println("Invalid time format. Please enter again (HH:mm):");
            reminderTime = s.nextLine();
        }

        return new Event(type, name, description, date, startTime, endTime, reminderTime);
    }

    public static List<LocalDate> getFilterDatesFromUser() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter start date for filter range (yyyy-MM-dd) (leave blank for current week):");
        String startDate = s.nextLine();
        String endDate;

        if (startDate.isEmpty()) {
            LocalDate startOfWeek = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
            startDate = startOfWeek.format(dateFormatter);
            endDate = startOfWeek.plusDays(6).format(dateFormatter);
            return List.of(LocalDate.parse(startDate, dateFormatter), LocalDate.parse(endDate, dateFormatter));
        }

        while (!isValidDate(startDate)) {
            System.out.println("Invalid date format. Please enter again (yyyy-MM-dd):");
            startDate = s.nextLine();
        }

        System.out.println("Enter end date for filter range (yyyy-MM-dd):");
        endDate = s.nextLine();
        while (!isValidDate(endDate)) {
            System.out.println("Invalid date format. Please enter again (yyyy-MM-dd):");
            endDate = s.nextLine();
        }

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse(startDate, dateFormatter));
        dates.add(LocalDate.parse(endDate, dateFormatter));
        return dates;
    }

    public static List<EventType> getFilterTypesFromUser() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter event types to filter by (Feed, Groom, Health, Play, Train, Vet, Walk, Other) (separate each by a space, or leave blank for all):");

        // All if blank
        String input = s.nextLine();
        if (input.isEmpty()) {
            return List.of(EventType.values());
        }

        // Validate each type
        String[] types = input.toUpperCase().split(" ");
        List<EventType> eventTypes = new ArrayList<>();
        for (String type : types) {
            while (!isValidType(type)) {
                // Tell user which type was invalid and prompt for re-input
                System.out.println(type + " is not a valid event type. Please enter again:");
                type = s.nextLine().toUpperCase();
            }
            eventTypes.add(EventType.valueOf(type));
        }
        return eventTypes;
    }

    private static boolean isValidType(String type) {
        for (EventType eventType : EventType.values()) {
            if (eventType.getName().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static boolean isValidTime(String time) {
        try {
            LocalTime.parse(time, timeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}