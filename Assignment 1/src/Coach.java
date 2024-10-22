public class Coach extends Person {

    public enum Role {
        HEAD_COACH,
        ASSISTANT_COACH,
        TRAINER
    }

    private final Role role;

    public Coach(String name, int age, Role role) {
        super(name, age);
        this.role = role;
    }

    // Getters
    public Role getRole() {
        return role;
    }
}