import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ReminderPrinter implements PropertyChangeListener {
    private boolean doNotDisturb = false;
    private final Queue<String> reminderQueue = new ConcurrentLinkedQueue<>();

    // If dnd is on, add reminder to print queue for later, else print it immediately
    @Override
    public void propertyChange(PropertyChangeEvent pcEvent) {
        if ("reminder".equals(pcEvent.getPropertyName())) {
            if (doNotDisturb) {
                reminderQueue.add(pcEvent.getNewValue().toString());
            } else {
                System.out.println("\n" + pcEvent.getNewValue());
            }
        }
    }

    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public void printQueuedReminders() {
        if (doNotDisturb) {
            return;
        }

        System.out.println();
        while (!reminderQueue.isEmpty()) {
            System.out.println(reminderQueue.poll());
        }
    }
}