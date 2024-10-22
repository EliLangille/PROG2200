import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a name for your team: ");
        String teamName = s.nextLine();
        Team team = new Team(teamName);

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\nMAIN MENU\n1. Add Player \n2. Add Coach \n3. View Team \n4. Remove Member \n5. Exit");
            int choice;
            try {
                choice = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                s.nextLine(); // Consume the leftover newline
                continue;
            }
            s.nextLine(); // Consume the leftover newline

            switch (choice) {
                case 1:
                    addPlayer(s, team);
                    break;
                case 2:
                    addCoach(s, team);
                    break;
                case 3:
                    team.showTeam();
                    break;
                case 4:
                    removeMember(s, team);
                    break;
                case 5:
                    keepGoing = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        s.close();
    }

    private static void addPlayer(Scanner s, Team team) {
        try {
            System.out.print("Enter player name: ");
            String name = s.nextLine();

            System.out.print("Enter player age: ");
            int age = s.nextInt();
            s.nextLine(); // Consume the leftover newline

            System.out.print("Enter player position (GOALIE, CENTER, WING, DEFENSEMAN): ");
            String positionStr = s.next();
            s.nextLine(); // Consume the leftover newline
            Player.Position position = Player.Position.valueOf(positionStr.toUpperCase());

            System.out.print("Enter player jersey number: ");
            int jerseyNumber = s.nextInt();
            s.nextLine(); // Consume the leftover newline

            System.out.print("Enter player games played: ");
            int gamesPlayed = s.nextInt();
            s.nextLine(); // Consume the leftover newline

            Player player = new Player(name, age, position, jerseyNumber, gamesPlayed);
            team.addPlayer(player);
            System.out.println("Player added.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            s.nextLine(); // Consume the leftover input/newline
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid position. Please try again.");
            s.nextLine(); // Consume the leftover input/newline
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            s.nextLine(); // Consume the leftover input/newline
        }
    }

    private static void addCoach(Scanner s, Team team) {
        try {
            System.out.print("Enter coach name: ");
            String name = s.nextLine();

            System.out.print("Enter coach age: ");
            int age = s.nextInt();
            s.nextLine(); // Consume the leftover newline

            System.out.print("Enter coach role (HEAD_COACH, ASSISTANT_COACH, TRAINER): ");
            String roleStr = s.next();
            s.nextLine(); // Consume the leftover newline
            Coach.Role role = Coach.Role.valueOf(roleStr.toUpperCase());

            Coach coach = new Coach(name, age, role);
            team.addCoach(coach);
            System.out.println("Coach added.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            s.nextLine(); // Consume the leftover input/newline
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role. Please try again.");
            s.nextLine(); // Consume the leftover input/newline
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            s.nextLine(); // Consume the leftover input/newline
        }
    }

    private static void removeMember(Scanner s, Team team) {
        try {
            System.out.print("Remove player (p) or coach (c)? ");
            String memberType = s.nextLine();

            if (memberType.equalsIgnoreCase("p")) {
                System.out.print("Enter player jersey number: ");
                int jerseyNumber = s.nextInt();
                s.nextLine(); // Consume the leftover newline
                int index = -1;
                for (int i = 0; i < team.getPlayers().size(); i++) {
                    if (team.getPlayers().get(i).getJerseyNumber() == jerseyNumber) {
                        index = i;
                        break;
                    }
                }
                team.removePlayer(index);
                System.out.println("Player removed.");
            } else if (memberType.equalsIgnoreCase("c")) {
                System.out.print("Enter coach name: ");
                String name = s.nextLine();
                System.out.print("Enter coach role (HEAD_COACH, ASSISTANT_COACH, TRAINER): ");
                String roleStr = s.next();
                s.nextLine(); // Consume the leftover newline
                Coach.Role role = Coach.Role.valueOf(roleStr.toUpperCase());
                int index = -1;
                for (int i = 0; i < team.getCoaches().size(); i++) {
                    if (team.getCoaches().get(i).getName().equalsIgnoreCase(name) && team.getCoaches().get(i).getRole() == role) {
                        index = i;
                        break;
                    }
                }
                team.removeCoach(index);
                System.out.println("Coach removed.");
            } else {
                System.out.println("Invalid member type.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            s.nextLine(); // Consume the leftover input/newline
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role. Please try again.");
            s.nextLine(); // Consume the leftover input/newline
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            s.nextLine(); // Consume the leftover input/newline
        }
    }
}