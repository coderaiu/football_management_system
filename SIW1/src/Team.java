import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> roster; // Aggregation
    private Sponsor mainSponsor; // Association

    public Team(String teamName, Sponsor mainSponsor) {
        this.teamName = teamName;
        this.mainSponsor = mainSponsor;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player p) { roster.add(p); }

    public void displayTeamDetails() {
        System.out.println("\n=== Team: " + teamName + " ===");
        System.out.println("Sponsor: " + mainSponsor.getBrandName() + " (€" + mainSponsor.getFundingAmount() + ")");
        System.out.println("Squad Size: " + roster.size() + " players");
    }
}