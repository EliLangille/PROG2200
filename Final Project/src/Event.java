import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private final EventType type;
    private final String name;
    private final String description;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final LocalTime reminderTime;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private boolean isReminded = false;

    public Event(EventType type, String name, String description, String date, String startTime, String endTime, String reminderTime) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.date = LocalDate.parse(date, dateFormatter);
        this.startTime = (startTime != null && !startTime.isEmpty()) ? LocalTime.parse(startTime, timeFormatter) : null;
        this.endTime = (endTime != null && !endTime.isEmpty()) ? LocalTime.parse(endTime, timeFormatter) : null;
        this.reminderTime = (reminderTime != null && !reminderTime.isEmpty()) ? LocalTime.parse(reminderTime, timeFormatter) : null;
    }

    public EventType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public boolean getRemindedStatus() {
        return this.isReminded;
    }

    public void setRemindedStatus(boolean status) {
        this.isReminded = status;
    }

    @Override
    public String toString() {
        // Format event details
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ").append(type.getName()).append("\n");

        // If no description, don't show
        if (!description.isEmpty()) {
            sb.append(description).append("\n");
        }

        sb.append(date).append("\n");

        // If no start time, don't show start or end time
        if (startTime != null) {
            sb.append(startTime).append(" - ").append(endTime).append("\n");
        }

        // If no reminder, don't show
        if (reminderTime != null) {
            sb.append("Reminder @ ").append(reminderTime);
        }

        return sb.toString().trim();
    }
}