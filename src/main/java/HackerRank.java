import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HackerRank {
    public static void main(String[] args) {

    }
    static long repeatedString(String s, long n) {
        if(s.length()<1 || s.length()>100){
            return -1;
        }
        if(n<1 || n>10e12){
            return -1;
        }
        long ss= s.chars().filter(ch->ch==s.charAt(0)).count();
        return n/s.length()*ss+s.substring(0, (int) (n%s.length())).chars().filter(ch->ch==s.charAt(0)).count();
    }

    static int jumpingOnClouds(int[] c) {
        if (c.length < 2 || c.length > 100) {
            return -1;
        }
        if (c[0] != 0 && c[c.length - 1] != 0) {
            return -1;
        }
        int jumps = 0;
        boolean wait = false;
        for (int i = 1; i < c.length - 1; i++) {
            if (c[i] == 0) {
                if (wait) {
                    jumps++;
                    wait = false;
                } else {
                    wait = true;
                }
            } else {
                if (wait) {
                    jumps++;
                }
                wait = true;
            }
        }
        jumps++;
        return jumps;
    }

    static String catAndMouse(int x, int y, int z) {
        if (x < 1 || x > 100) {
            return "Error";
        }
        if (y < 1 || y > 100) {
            return "Error";
        }
        if (z < 1 || z > 100) {
            return "Error";
        }
        if (Math.abs(x - z) < Math.abs(y - z)) {
            return "Cat A";
        } else if (Math.abs(x - z) > Math.abs(y - z)) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        if (b < 1 || b > 10e6) {
            return -1;
        }
        if (keyboards.length < 1 || drives.length < 1) {
            return -1;
        }
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        int max = -1;
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                if (keyboard + drive <= b) {
                    max = Math.max(max, keyboard + drive);
                }

            }
        }
        return max;
    }

    static int countingValleys(int steps, String path) {
        if (steps < 2 || steps > 10e6) {
            return 0;
        }
        if (steps % 2 != 0) {
            return 0;
        }
        if (steps != path.length()) {
            return 0;
        }
        int level;
        int valleys = 0;
        if (path.charAt(0) == 'U') {
            level = 1;
        } else {
            level = -1;
        }
        for (int i = 1; i < path.length(); i++) {
            int before = level;
            if (path.charAt(i) == 'U') {
                level++;
            } else {
                level--;
            }
            if (level == 0 && before < 0) {
                valleys++;
            }
        }
        return valleys;
    }

    static int pageCount(int n, int p) {
        if (n < 1 || n > 10e5) {
            return 0;
        }
        if (p < 1 || p > n) {
            return 0;
        }
        if (p < 2) {
            return 0;
        }
        if (n == p || (n % 2 != 0 && (n - 1) == p)) {
            return 0;
        }
        int result;
        int min = Math.min(p / 2, (n - p) / 2);
        if (n % 2 != 0) {
            result = min;
        } else {
            if (p % 2 == 0) {
                result = min;
            } else {
                result = Math.min(p / 2, (n - p) / 2 + 1);
            }
        }
        return result;
    }

    static int sockMerchant(int n, int[] ar) {
        if (n < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ar[i])) {
                map.put(ar[i], map.get(ar[i]) + 1);
            } else {
                map.put(ar[i], 1);
            }
        }
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                pairs += entry.getValue() / 2;
            }
        }
        return pairs;
    }
}
