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
        String message = "\nReminder: Your event " + event.getName() + "(" + event.getType() + ")" + " starts at " + event.getStartTime() + " on " + event.getDate();
        support.firePropertyChange("reminder", null, message);
    }

    public void fireStartReminder(Event event) {
        String message = "\nReminder: Your event " + event.getName() + "(" + event.getType() + ") has started";
        support.firePropertyChange("reminder", null, message);
    }

    public void fireEndReminder(Event event) {
        String message = "\nReminder: Your event " + event.getName() + "(" + event.getType() + ") has ended";
        support.firePropertyChange("reminder", null, message);
    }

    public void checkReminder(Event event) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        // If event is not today, skip (reminders only for day of)
        if (!event.getDate().toLocalDate().isEqual(today)) {
            return;
        }

        // Check and fire scheduled reminder (all cant occur at once)
        if (event.getReminderTime() != null && (event.getReminderTime().isBefore(now) || event.getReminderTime().isEqual(now))) {
                fireScheduledReminder(event);
        } else if (event.getStartTime().isBefore(now) || event.getStartTime().isEqual(now)) {
            fireStartReminder(event);
        } else if (event.getEndTime().isBefore(now) || event.getEndTime().isEqual(now)) {
            fireEndReminder(event);
        }
    }

    @Override
    public void run() {
        while (running) {
            for (Event event : eventManager.getEvents()) {
                checkReminder(event);
            }

            // Run checks every minute
            try {
                Thread.sleep(60000);
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
