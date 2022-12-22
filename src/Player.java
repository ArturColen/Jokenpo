public class Player {
    // Player Attributes
    private String name;
    private Integer score;

    // Build the object
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // Add one point for the player who wins the round
    public void incrementScore() {
        setScore(getScore() + 1);
    }

    // Accessory methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}