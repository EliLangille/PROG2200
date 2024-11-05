public class Main {
    public static void main(String[] args) {
        SocialMediaFeed feed = new SocialMediaFeed();

        User user1 = new User("Alice", feed);
        User user2 = new User("Bob", feed);

        Follower follower1 = new Follower("Charlie");
        Follower follower2 = new Follower("Dave");

        feed.addFollower(follower1);
        feed.addFollower(follower2);

        user1.makePost("Hello, this is my first post!");
        user2.makePost("Good morning everyone!");
    }
}