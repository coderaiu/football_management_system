import java.util.*;

public class ClubManagementService {
    // Block A: Storage
    private List<Person> staffList = new ArrayList<>();

    // Block B: O(1) Indexing & Categorization
    private Map<Integer, Person> personDb = new HashMap<>();
    private Map<String, List<Player>> squadByCategory = new HashMap<>();

    // Block D: Workflow Queue (Teacher's dynamic economy requirement)
    private Queue<MatchPerformance> performanceQueue = new LinkedList<>();

    // Synchronized CRUD: Create
    public void registerPerson(Person p, String category) {
        staffList.add(p);
        personDb.put(p.getId(), p);

        if (p instanceof Player) {
            squadByCategory.putIfAbsent(category, new ArrayList<>());
            squadByCategory.get(category).add((Player) p);
        }
    }

    // Synchronized CRUD: Delete
    public void deletePerson(int id) {
        Person p = personDb.remove(id);
        if (p != null) {
            staffList.remove(p);
            if (p instanceof Player) {
                for (List<Player> categoryList : squadByCategory.values()) {
                    categoryList.remove(p);
                }
            }
            System.out.println("Removed ID " + id + " from all databases.");
        }
    }

    // Analytics: Display Categorization Map
    public void displayPlayersByCategory(String category) {
        System.out.println("\n--- Category: " + category + " ---");
        List<Player> players = squadByCategory.getOrDefault(category, new ArrayList<>());
        for (Player p : players) System.out.println(p);
    }

    // Analytics: Sorting (Natural & Custom)
    public void displayPlayersSorted(Comparator<Player> comparator, String description) {
        List<Player> players = new ArrayList<>();
        for (Person p : staffList) {
            if (p instanceof Player) players.add((Player) p);
        }

        if (comparator == null) {
            System.out.println("\n--- Natural Order (Squad Number) ---");
            Collections.sort(players);
        } else {
            System.out.println("\n--- Custom Order: " + description + " ---");
            players.sort(comparator);
        }

        for (Player p : players) System.out.println(p);
    }

    // Queue: Enqueue Performance Data
    public void logPlayerPerformance(MatchPerformance performance) {
        performanceQueue.offer(performance);
    }

    // Queue: Process Dynamics via poll()
    public void processPostMatchFinancials() {
        System.out.println("\n=== Processing Post-Match Financial Updates ===");
        while (!performanceQueue.isEmpty()) {
            MatchPerformance perf = performanceQueue.poll(); // FIFO
            Player p = perf.getPlayer();
            double rating = perf.getMatchRating();

            System.out.print("Evaluating " + p.getName() + " (Rating: " + rating + ", Goals: " + perf.getGoalsScored() + ") -> ");

            if (rating >= 8.0 || perf.getGoalsScored() > 0) {
                p.getContract().adjustValue(5.0); // +5% for great performance
                System.out.println("VALUE INCREASED (+5%)");
            } else if (rating < 6.0) {
                p.getContract().adjustValue(-5.0); // -5% for poor performance
                System.out.println("VALUE DECREASED (-5%)");
            } else {
                System.out.println("VALUE RETAINED");
            }
            System.out.println("   New " + p.getContract().toString());
        }
    }
}