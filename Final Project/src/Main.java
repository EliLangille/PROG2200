import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Event> events;
        List<Event> filteredEvents;
        boolean running = true;

        EventManager eventManager = EventManager.getInstance();
        ReminderChecker reminderChecker = new ReminderChecker(eventManager);

        ReminderPrinter reminderPrinter = new ReminderPrinter();
        reminderChecker.addReminderListener(reminderPrinter);

        Thread checkerThread = new Thread(reminderChecker);
        checkerThread.start();

        while (running) {
            System.out.println("\nDog Activity App\n1. Add Event\n2. View by Week\n3. View by Type\n4. Exit");
            int choice = s.nextInt();

            // do not disturb during actions (avoid creating a mess in console)
            reminderPrinter.setDoNotDisturb(true);

            switch(choice) {
                case 1:
                    Event event = EventInputHandler.getEventFromUser();
                    eventManager.addEvent(event);
                    System.out.println("Event added!");
                    break;
                case 2:
                    events = eventManager.getEvents();
                    if (events.isEmpty()) {
                        System.out.println("No events to show!");
                        break;
                    }

                    filteredEvents = EventFilter.createFilteredList(events);
                    EventViewer.showEventsByDay(filteredEvents);
                    break;
                case 3:
                    events = eventManager.getEvents();
                    if (events.isEmpty()) {
                        System.out.println("No events to show!");
                        break;
                    }

                    filteredEvents = EventFilter.createFilteredList(events);
                    EventViewer.showEventsByType(filteredEvents);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    running = false;
                    reminderChecker.removeReminderListener(reminderPrinter);
                    reminderChecker.stop();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            // Turn off do not disturb after action
            reminderPrinter.setDoNotDisturb(false);

            // Print queued reminders while on the main menu (avoid action interrupt)
            reminderPrinter.printQueuedReminders();
        }

        try {
            checkerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}