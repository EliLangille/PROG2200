import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ReminderPrinter implements PropertyChangeListener {
    private final Queue<String> reminderQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void propertyChange(PropertyChangeEvent pcEvent) {
        if ("reminder".equals(pcEvent.getPropertyName())) {
            reminderQueue.add(pcEvent.getNewValue().toString());
        }
    }

    public void printReminders() {
        while (!reminderQueue.isEmpty()) {
            System.out.println(reminderQueue.poll());
        }
    }
}