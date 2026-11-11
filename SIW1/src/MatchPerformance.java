public class MatchPerformance {
    private Player player;
    private double matchRating;
    private int goalsScored;

    public MatchPerformance(Player player, double matchRating, int goalsScored) {
        this.player = player;
        this.matchRating = matchRating;
        this.goalsScored = goalsScored;
    }

    public Player getPlayer() { return player; }
    public double getMatchRating() { return matchRating; }
    public int getGoalsScored() { return goalsScored; }
}