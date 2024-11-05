import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Follower implements PropertyChangeListener {
    private String name;

    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(name + " received post: " + evt.getNewValue());
    }
}