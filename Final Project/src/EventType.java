public enum EventType {
    FEED,
    GROOM,
    HEALTH,
    PLAY,
    TRAIN,
    VET,
    WALK,
    OTHER;

    private final String name;

    EventType() {
        this.name = name();
    }

    public String getName() {
        return name;
    }
}