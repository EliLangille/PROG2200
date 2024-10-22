package SingleResponsibility.Assignment.SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events = new ArrayList<>();

    public void handleSchoolEvents(Event event) {
        events.add(event);
        System.out.println("Event scheduled: " + event.getEventName());
    }
}