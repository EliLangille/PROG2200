import java.util.ArrayList;
import java.util.List;

public class Team {

    private final String name;
    private final List<Player> players;
    private final List<Coach> coaches;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
        coaches = new ArrayList<>();
    }

    // Getters
    public List<Player> getPlayers() {
        return players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    // Adders
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    // Removers
    public void removePlayer(int index) {
        players.remove(index);
    }

    public void removeCoach(int index) {
        coaches.remove(index);
    }

    // Showers
    // Should list name, age, position, jerseyNumber, gamesPlayed
    public void showPlayers() {
        for(Player player : players) {
            System.out.printf("Player: %s, %d, %s, #%d, %d games played%n",
                    player.getName(), player.getAge(), player.getPosition(), player.getJerseyNumber(),
                    player.getGamesPlayed());
        }
    }

    public void showCoaches() {
        for(Coach coach : coaches) {
            System.out.printf("Coach: %s, %d, %s%n", coach.getName(), coach.getAge(), coach.getRole());
        }
    }

    public void showTeam() {
        System.out.println("Team: " + name);
        showPlayers();
        showCoaches();
    }
}