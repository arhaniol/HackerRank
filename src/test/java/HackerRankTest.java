import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HackerRankTest {

    @Test
    void should_maximumToys_return_correct_answer() {
        assertEquals(3, HackerRank.maximumToys(Arrays.stream("1 2 3 4".split(" ")).mapToInt(Integer::parseInt).toArray(), 7));
        assertEquals(4, HackerRank.maximumToys(Arrays.stream("1 12 5 111 200 1000 10".split(" ")).mapToInt(Integer::parseInt).toArray(), 50));
    }

    @Test
    void should_countSwap_return_correct_answer() {
        //given

        HackerRank.countSwaps(Arrays.stream("1 2 3".split(" ")).mapToInt(Integer::parseInt).toArray());
        HackerRank.countSwaps(Arrays.stream("3 2 1".split(" ")).mapToInt(Integer::parseInt).toArray());
    }

    @Test
    void should_freqQuery_return_correct_answer() {
        //given
        String t1 = "1 5\n" +
                "1 6\n" +
                "3 2\n" +
                "1 10\n" +
                "1 10\n" +
                "1 6\n" +
                "2 5\n" +
                "3 2";

        String t2 = "1 3\n" +
                "2 3\n" +
                "3 2\n" +
                "1 4\n" +
                "1 5\n" +
                "1 5\n" +
                "1 4\n" +
                "3 2\n" +
                "2 4\n" +
                "3 2";
        //when

        //then
        assertIterableEquals(Arrays.asList(0, 1), HackerRank.freqQuery(prepareList(t1)));
        assertIterableEquals(Arrays.asList(0, 1, 1), HackerRank.freqQuery(prepareList(t2)));
    }

    private static List<int[]> prepareList(String text) {
        List<String> list = Stream.of(text.split("\n")).collect(Collectors.toList());
        List<int[]> test = new ArrayList<>();
        for (String s : list) {
            int[] t = new int[2];

            t[0] = Integer.parseInt(s.substring(0, 1));
            t[1] = Integer.parseInt(s.substring(2));
            test.add(t);
        }
        return test;
    }

    @org.junit.jupiter.api.Test
    void should_sockMerchant_return_more_then_zero() {
        //given
        int[] ar1 = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        int[] ar2 = new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
        int[] ar3 = new int[]{1};
        int[] ar4 = new int[]{1, 2, 3};
        int[] ar5 = new int[]{100, 100};

        //when

        //then
        assertEquals(3, HackerRank.sockMerchant(ar1.length, ar1));
        assertEquals(4, HackerRank.sockMerchant(ar2.length, ar2));
        assertEquals(0, HackerRank.sockMerchant(ar3.length, ar3));
        assertEquals(0, HackerRank.sockMerchant(ar4.length, ar4));
        assertEquals(1, HackerRank.sockMerchant(ar5.length, ar5));
    }

    @Test
    void should_pageCount_return_correct_answer_with_even_pages() {
        assertEquals(0, HackerRank.pageCount(6, 6));
        assertEquals(1, HackerRank.pageCount(6, 2));
        assertEquals(1, HackerRank.pageCount(6, 3));
        assertEquals(1, HackerRank.pageCount(6, 4));
        assertEquals(1, HackerRank.pageCount(6, 5));
        assertEquals(2, HackerRank.pageCount(8, 5));
        assertEquals(2, HackerRank.pageCount(10, 4));
        assertEquals(2, HackerRank.pageCount(10, 5));
        assertEquals(2, HackerRank.pageCount(10, 6));
        assertEquals(2, HackerRank.pageCount(10, 7));
        assertEquals(3, HackerRank.pageCount(12, 6));
    }

    @Test
    void should_pageCount_return_correct_answer_with_odd_pages() {
        assertEquals(0, HackerRank.pageCount(1, 1));
        assertEquals(0, HackerRank.pageCount(3, 2));
        assertEquals(0, HackerRank.pageCount(5, 4));
        assertEquals(1, HackerRank.pageCount(5, 2));
        assertEquals(1, HackerRank.pageCount(7, 2));
        assertEquals(1, HackerRank.pageCount(7, 3));
        assertEquals(1, HackerRank.pageCount(7, 4));
        assertEquals(1, HackerRank.pageCount(7, 5));
        assertEquals(2, HackerRank.pageCount(9, 5));
        assertEquals(1, HackerRank.pageCount(9, 6));
        assertEquals(2, HackerRank.pageCount(11, 7));
        assertEquals(3, HackerRank.pageCount(13, 7));
    }

    @Test
    void should_countingValleys_return_zero() {
        assertEquals(0, HackerRank.countingValleys(2, "UD"));
        assertEquals(0, HackerRank.countingValleys(4, "UDUD"));
        assertEquals(0, HackerRank.countingValleys(6, "UUDUDD"));
        assertEquals(0, HackerRank.countingValleys(8, "UUDUDUDD"));
    }

    @Test
    void should_countingValleys_return_positive() {
        assertEquals(1, HackerRank.countingValleys(2, "DU"));
        assertEquals(1, HackerRank.countingValleys(4, "DDUU"));
        assertEquals(1, HackerRank.countingValleys(4, "UDDU"));
        assertEquals(2, HackerRank.countingValleys(4, "DUDU"));
        assertEquals(2, HackerRank.countingValleys(6, "DUUDDU"));
        assertEquals(3, HackerRank.countingValleys(8, "DUDDUUDU"));
    }

    @Test
    void should_getMoneySpent_return_max_value() {
        assertEquals(9, HackerRank.getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
        assertEquals(-1, HackerRank.getMoneySpent(new int[]{4}, new int[]{5}, 5));
    }

    @Test
    void should_jumpingOnClouds_return_correct_result() {
        assertEquals(4, HackerRank.jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        assertEquals(3, HackerRank.jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
    }

    @Test
    void should_repeatedString_return_correct_result() {
        assertEquals(7, HackerRank.repeatedString("aba", 10));
        assertEquals(1000000000000L, HackerRank.repeatedString("a", 1000000000000L));
        assertEquals(4, HackerRank.repeatedString("abaaaaaaaaaa", 5));
        assertEquals(3, HackerRank.repeatedString("abb", 9));
        assertEquals(3, HackerRank.repeatedString("abb", 8));
        assertEquals(3, HackerRank.repeatedString("abb", 7));
        assertEquals(1, HackerRank.repeatedString("abbccc", 1));
        assertEquals(1, HackerRank.repeatedString("abbccc", 2));
        assertEquals(1, HackerRank.repeatedString("abbccc", 3));
        assertEquals(1, HackerRank.repeatedString("abbccc", 6));

    }

    @Test
    void should_hourglassSum_return_correct_result() {
        int[][] arr = new int[][]{{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}};
        assertEquals(19, HackerRank.hourglassSum(arr));
    }

    @Test
    void should_rotLeft_return_correct_result() {
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, HackerRank.rotLeft(new int[]{1, 2, 3, 4, 5}, 4));
    }

    @Test
    void should_minimumBribes_return_correct_result() {
        System.out.print("3 ? => ");
        HackerRank.minimumBribes(new int[]{2, 1, 5, 3, 4});
        System.out.print("Too chaotic ? => ");
        HackerRank.minimumBribes(new int[]{2, 5, 1, 3, 4});
        System.out.print("Too chaotic ? => ");
        HackerRank.minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
        System.out.print("7 ? => ");
        HackerRank.minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
    }

    @Test
    void should_minimumSwaps_return_correct_result() {
        assertEquals(5, HackerRank.minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));
    }

    @Test
    void should_arrayManipulation_return_correct_result() {
        assertEquals(200, HackerRank.arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
    }

    @Test
    void should_checkMagazine_return_correct_result() {
        String s = "give me one grand today night";
        String n = "give one grand today";
        String[] magazine = s.split(" ");
        String[] note = n.split(" ");
        HackerRank.checkMagazine(magazine, note);

        String s1 = "two times three is not four";
        String n1 = "two times two is four";
        String[] magazine1 = s1.split(" ");
        String[] note1 = n1.split(" ");
        HackerRank.checkMagazine(magazine1, note1);

        String s2 = "ive got a lovely bunch of coconuts";
        String n2 = "ive got some coconuts";
        String[] magazine2 = s2.split(" ");
        String[] note2 = n2.split(" ");
        HackerRank.checkMagazine(magazine2, note2);
    }

    @Test
    void should_twoStrings_return_correct_result() {
        assertEquals("YES", HackerRank.twoStrings("hello", "world"));
        assertEquals("NO", HackerRank.twoStrings("hi", "world"));
        assertEquals("YES", HackerRank.twoStrings("herak", "world"));
    }

    @Test
    void should_countTriplets_return_correct_result() {
        assertEquals(2, HackerRank.countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2));
        assertEquals(6, HackerRank.countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));
        assertEquals(4, HackerRank.countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5));
        assertEquals(4, HackerRank.countTriplets(Arrays.asList(1L, 1L, 1L, 1L), 1));
        assertEquals(10, HackerRank.countTriplets(Arrays.asList(1L, 1L, 1L, 1L, 1L), 1));
        assertEquals(1, HackerRank.countTriplets(Arrays.asList(1L, 1L, 1L), 1));
        assertEquals(8, HackerRank.countTriplets(Arrays.asList(1L, 1L, 3L, 3L, 9L, 9L), 3));

        assertEquals(2325652489L, HackerRank.countTriplets(tablica(), 3));
    }

    @Test
    void should_sherlockAndAnagrams_return_correct_result() {
        assertEquals(4, HackerRank.sherlockAndAnagrams("abba"));
        assertEquals(0, HackerRank.sherlockAndAnagrams("abcd"));
        assertEquals(3, HackerRank.sherlockAndAnagrams("ifailuhkqq"));
        assertEquals(10, HackerRank.sherlockAndAnagrams("kkkk"));
        assertEquals(5, HackerRank.sherlockAndAnagrams("cdcd"));
    }

    private List<Long> tablica() {
        String arr = null;
        try {
            arr = new String(Files.readAllBytes(Paths.get("D:\\Mik\\Java\\HackerRank\\src\\test\\test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert arr != null;
        return Stream.of(arr.split(" ")).map(Long::parseLong).collect(Collectors.toList());
    }
}