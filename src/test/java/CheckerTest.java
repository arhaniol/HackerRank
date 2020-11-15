import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void should_compare_return_correct_answer() {
        // given
        String input = "amy 100\n" +
                "david 100\n" +
                "heraldo 50\n" +
                "aakansha 75\n" +
                "aleksa 150";
        String output = "aleksa 150\n" +
                "amy 100\n" +
                "david 100\n" +
                "aakansha 75\n" +
                "heraldo 50";
        int n = 5;
        Player[] players = new Player[n];
        Player[] sortedPlayers = new Player[n];
        Checker checker = new Checker();

        prepareArray(players, input);
        prepareArray(sortedPlayers, output);

        //when
        Arrays.sort(players, checker);

        //then
        assertArrayEquals(sortedPlayers, players);
    }

    private void prepareArray(Player[] players, String input) {
        List<String> list = Stream.of(input.split("\n")).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            String data = list.get(i);
            int pos = data.indexOf(" ");
            players[i] =new Player(data.substring(0, pos), Integer.parseInt(data.substring(pos + 1)));
        }
    }
}