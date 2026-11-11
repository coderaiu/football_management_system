public class Main {
    public static void main(String[] args) {
        ClubManagementService service = new ClubManagementService();
        Sponsor flyEmirates = new Sponsor("Fly Emirates", 70000000);
        Team realMadrid = new Team("Real Madrid CF", flyEmirates);

        // 1. Instantiate Personnel
        Coach zidane = new Coach(201, "Zinedine Zidane", "Head Coach", 1000000);
        Player mbappe = new Player(10, "K. Mbappé", 10, 400000, 250000000, 5);
        Player bellingham = new Player(5, "J. Bellingham", 5, 300000, 150000000, 6);
        Player silva = new Player(20, "B. Silva", 20, 250000, 80000000, 3);
        Player guler = new Player(15, "A. Güler", 15, 100000, 50000000, 5);

        // 2. Register into JCF Maps/Lists
        service.registerPerson(zidane, "Staff");
        service.registerPerson(mbappe, "Attacker");
        service.registerPerson(bellingham, "Midfielder");
        service.registerPerson(silva, "Midfielder");
        service.registerPerson(guler, "Midfielder");

        realMadrid.addPlayer(mbappe);
        realMadrid.addPlayer(bellingham);
        realMadrid.displayTeamDetails();

        // 3. Demonstrate Dependency
        MatchReport report = new MatchReport("Juventus FC", "4-1");
        zidane.analyzeMatch(report);

        // 4. JCF Sorting Analytics
        service.displayPlayersSorted(null, "Natural");
        service.displayPlayersSorted(new PlayerComparators.BuyoutClauseComparator(), "By Buyout Clause Descending");

        // 5. Dynamic Queue Processing (Teacher's requirement)
        System.out.println("\n--- Logging Match Performances ---");
        service.logPlayerPerformance(new MatchPerformance(mbappe, 8.4, 2));   // Outstanding
        service.logPlayerPerformance(new MatchPerformance(bellingham, 6.5, 0)); // Average
        service.logPlayerPerformance(new MatchPerformance(silva, 5.5, 0));      // Poor
        service.logPlayerPerformance(new MatchPerformance(guler, 6.0, 0));      // Average

        service.processPostMatchFinancials();

        // 6. Demonstrate Synchronized Deletion
        System.out.println("\n--- Simulating Player Transfer ---");
        service.deletePerson(20); // Transfer B. Silva
        service.displayPlayersByCategory("Midfielder"); // Check Map cleanup
    }
}