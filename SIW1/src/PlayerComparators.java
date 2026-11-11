import java.util.Comparator;

public class PlayerComparators {
    public static class BuyoutClauseComparator implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            return Double.compare(p2.getContract().getBuyoutClause(), p1.getContract().getBuyoutClause());
        }
    }

    public static class SalaryComparator implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            return Double.compare(p2.calculateSalary(), p1.calculateSalary());
        }
    }

    public static class NameComparator implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    }
}