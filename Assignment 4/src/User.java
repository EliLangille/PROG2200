public class User {
    private String name;
    private SocialMediaFeed feed;

    public User(String name, SocialMediaFeed feed) {
        this.name = name;
        this.feed = feed;
    }

    public void makePost(String content) {
        String post = name + ": " + content;
        feed.notifyFollowers(post);
    }
}