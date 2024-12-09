import java.util.ArrayList;
import java.util.List;

// Singleton pattern for better event memory management and access control
public class EventManager {
    private static EventManager instance;
    private final List<Event> events;

    private EventManager() {
        events = new ArrayList<>();
    }

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    public synchronized void addEvent(Event event) {
        events.add(event);
    }

    public synchronized List<Event> getEvents() {
        return new ArrayList<>(events); // Copy to prevent modification
    }
}
