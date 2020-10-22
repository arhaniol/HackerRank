import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HackerRankTest {

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
        assertEquals(7,HackerRank.repeatedString("aba",10));
        assertEquals(1000000000000L,HackerRank.repeatedString("a",1000000000000L));
        assertEquals(4,HackerRank.repeatedString("abaaaaaaaaaa",5));
    }
}