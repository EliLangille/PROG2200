public class Player extends Person {

    public enum Position {
        GOALIE,
        CENTER,
        WING,
        DEFENSEMAN
    }

    private final Position position;
    private final int jerseyNumber;
    private final int gamesPlayed;

    public Player(String name, int age, Position position, int jerseyNumber, int gamesPlayed) {
        super(name, age);
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.gamesPlayed = gamesPlayed;
    }

    // Getters
    public Position getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

}
