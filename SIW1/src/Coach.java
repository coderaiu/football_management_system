public class Coach extends Person implements Payable, Manageable {
    private String tacticRole;
    private double monthlySalary;

    public Coach(int id, String name, String tacticRole, double monthlySalary) {
        super(id, name);
        this.tacticRole = tacticRole;
        this.monthlySalary = monthlySalary;
    }

    // Dependency
    public void analyzeMatch(MatchReport report) {
        System.out.println(getName() + " is reviewing the match vs " + report.getOpponent() + " (Score: " + report.getFinalScore() + ")");
    }

    @Override
    public double calculateSalary() { return monthlySalary; }

    @Override
    public void performDailyTasks() { System.out.println(getName() + " is analyzing opponent tactics."); }

    @Override
    public void displayRole() { System.out.println("Role: Coach | Tactic: " + tacticRole); }

    @Override
    public void planStrategy() { System.out.println(getName() + " is planning the formation."); }

    @Override
    public void conductTeamTalk() { System.out.println(getName() + " gives the pre-match team talk."); }
}