public class MatchReport {
    private String opponent;
    private String finalScore;

    public MatchReport(String opponent, String finalScore) {
        this.opponent = opponent;
        this.finalScore = finalScore;
    }
    public String getOpponent() { return opponent; }
    public String getFinalScore() { return finalScore; }
}