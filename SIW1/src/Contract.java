public class Contract {
    private double weeklySalary;
    private double buyoutClause;
    private int durationYears;

    public Contract(double weeklySalary, double buyoutClause, int durationYears) {
        this.weeklySalary = weeklySalary;
        this.buyoutClause = buyoutClause;
        this.durationYears = durationYears;
    }

    public double getWeeklySalary() { return weeklySalary; }
    public double getBuyoutClause() { return buyoutClause; }
    public int getDurationYears() { return durationYears; }

    // Business Logic: Dynamic Financial Adjustment
    public void adjustValue(double percentage) {
        this.weeklySalary += this.weeklySalary * (percentage / 100.0);
        this.buyoutClause += this.buyoutClause * (percentage / 100.0);
    }

    @Override
    public String toString() {
        return String.format("Salary: €%,.0f/wk | Buyout: €%,.0f | Length: %d yrs", weeklySalary, buyoutClause, durationYears);
    }
}