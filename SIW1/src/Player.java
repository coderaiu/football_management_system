public class Player extends Person implements Trainable, Payable, Comparable<Player> {
    private int squadNumber;
    private Contract contract; // Composition

    public Player(int id, String name, int squadNumber, double weeklySalary, double buyoutClause, int durationYears) {
        super(id, name);
        this.squadNumber = squadNumber;
        this.contract = new Contract(weeklySalary, buyoutClause, durationYears);
    }

    public int getSquadNumber() { return squadNumber; }
    public Contract getContract() { return contract; }

    @Override
    public double calculateSalary() {
        return contract.getWeeklySalary();
    }

    @Override
    public void performDailyTasks() {
        System.out.println(getName() + " is practicing set pieces.");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Player | Squad Number: " + squadNumber);
    }

    @Override
    public void attendTraining() {
        System.out.println(getName() + " is attending team training.");
    }

    @Override
    public void conductFitnessTest() {
        System.out.println(getName() + " passed the medical fitness test.");
    }

    // Critical for Block C: Natural Ordering
    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.squadNumber, other.squadNumber);
    }

    @Override
    public String toString() {
        return String.format("[#%d] %s -> %s", squadNumber, getName(), contract.toString());
    }
}