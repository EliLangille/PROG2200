import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SocialMediaFeed {
    private PropertyChangeSupport support;

    public SocialMediaFeed() {
        support = new PropertyChangeSupport(this);
    }

    public void addFollower(PropertyChangeListener follower) {
        support.addPropertyChangeListener(follower);
    }

    public void notifyFollowers(String post) {
        support.firePropertyChange("post", null, post);
    }
}