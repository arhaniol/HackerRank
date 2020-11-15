import java.util.Comparator;

public class Checker implements Comparator<Player> {
    // complete this method
    @Override
    public int compare(Player a, Player b) {

        if (a.score > b.score) {
            return -1;
        }
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        return 1;
    }
}
