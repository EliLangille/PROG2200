import java.time.LocalDate;
import java.time.LocalTime;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReminderChecker implements Runnable {
    private final EventManager eventManager;
    private final PropertyChangeSupport support;
    private boolean running;

    public ReminderChecker(EventManager eventManager) {
        this.eventManager = eventManager;
        support = new PropertyChangeSupport(this);
        running = true;
    }

    public void addReminderListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeReminderListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void fireScheduledReminder(Event event) {
        String message = "Reminder: Your event '" + event.getName() + " - " + event.getType() + "' starts";

        // Modify message based on event start time if present
        if (event.getStartTime() != null) {
            message += " at " + event.getStartTime() + " today";
        } else {
            message += " is today";
        }

        // Fire reminder for event if not already fired
        if (!event.getRemindedStatus()) {
            support.firePropertyChange("reminder", null, message);
            event.setRemindedStatus(true);
        }

    }

    public void checkReminder(Event event) {
        LocalTime now = LocalTime.now();
        LocalDate today = LocalDate.now();

        // If event is not today, skip (reminders only for day of)
        if (!event.getDate().isEqual(today)) {
            return;
        }

        // Fire scheduled reminder if now or overdue
        if (event.getReminderTime() != null && (event.getReminderTime().isBefore(now) || event.getReminderTime().equals(now))) {
            fireScheduledReminder(event);
        }
    }

    @Override
    public void run() {
        while (running) {
            for (Event event : eventManager.getEvents()) {
                checkReminder(event);
            }

            // Run checks every 10 seconds
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
            }
            support.firePropertyChange("check", null, null);
        }
    }

    public void stop() {
        running = false;
    }
}
