import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ArrayUtils.indexOf;

public class HackerRank {
    public static void main(String[] args) {

    }

    static String twoStrings(String s1, String s2) {
        String result = "NO";
        Set<Character> set1 = s1.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        Set<Character> set2 = s2.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

        for (Character ch : set2) {
            if (set1.contains(ch)) {
                result = "YES";
                break;
            }
        }

        return result;
    }

    static void checkMagazine(String[] magazine, String[] note) {
        String result = "Yes";

        if (note.length > magazine.length) {
            result = "No";
        }

        List<String> list = new ArrayList<>(Arrays.asList(magazine));
        for (String s : note) {
            if (list.remove(s)) {
            } else {
                result = "No";
                break;
            }
        }
        System.out.println(result);
    }

    //Arrays
    /////////////////////////////////////////////////////////////////
    static long arrayManipulation(int n, int[][] queries) {
        if (n < 3 || n > 10e7) {
            return -1;
        }
        long max = 0;

        Map<Integer, Long> map = new HashMap<>();
        for (int[] row : queries) {
            for (int j = row[0] - 1; j < row[1]; j++) {
                if (map.containsKey(j)) {
                    map.replace(j, map.get(j) + row[2]);
                } else {
                    map.put(j, (long) row[2]);
                }
            }
        }

        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }


    static int minimumSwaps(int[] arr) {
        if (arr.length < 1 || arr.length > 10e5) {
            return -1;
        }
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int index = indexOf(arr, i + 1);
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    static void minimumBribes(int[] q) {
        if (q.length < 1 || q.length > 10e5) {
            return;
        }
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            if ((q[i] - (i + 1)) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    static int[] rotLeft(int[] a, int d) {
        if (a.length < 1 || a.length > 10e5) {
            return null;
        }
        if (d < 1 || d > a.length) {
            return null;
        }
        int[] result = new int[a.length];
        System.arraycopy(a, d, result, 0, a.length - d);
        System.arraycopy(a, 0, result, a.length - d, d);
        return result;
    }

    static int hourglassSum(int[][] arr) {
        int max = -63;
        int sumU, sumD;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sumU = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sumD = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = Math.max(max, sumU + arr[i + 1][j + 1] + sumD);
            }
        }
        return max;
    }


    //Warm up
    //////////////////////////////////////////////////////////////////
    static long repeatedString(String s, long n) {
        if (s.length() < 1 || s.length() > 100) {
            return -1;
        }
        if (n < 1 || n > 10e12) {
            return -1;
        }
        long noOfFirstCharInS = s.chars().filter(ch -> ch == 'a').count();
        long noOfCharInN = n / s.length() * noOfFirstCharInS;
        int suffixLength = (int) (n % s.length());
        String suffix = s.substring(0, suffixLength);
        long noOfCharInSuffix = suffix.chars().filter(ch -> ch == 'a').count();
        return noOfCharInN + noOfCharInSuffix;
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
