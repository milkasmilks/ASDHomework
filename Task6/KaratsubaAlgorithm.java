package AiSD.Task6;

import java.util.Scanner;

public class KaratsubaAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(multiply(a,b));

    }

    public static long multiply(long first, long second) {
        if (first < 10 || second < 10) {
            return first * second;
        } else {
            String firstString = String.valueOf(first);
            String secondString = String.valueOf(second);

            long n = Math.max(firstString.length(), secondString.length()) / 2;

            long firstHigh = Integer.parseInt(split(n,firstString)[0]);
            long firstLow = Integer.parseInt(split(n,firstString)[1]);
            long secondHigh = Integer.parseInt(split(n,secondString)[0]);
            long secondLow = Integer.parseInt(split(n,secondString)[1]);

            long z1 = multiply(firstHigh,secondHigh);
            long z2 = multiply(firstLow, secondLow);
            long z3 = multiply((firstLow + firstHigh), (secondLow + secondHigh)) - z1 - z2;

            return (long) (z1 * Math.pow(10,2*n) + z3 * Math.pow(10,n) + z2);
        }
    }

    public static String[] split(long index, String string) {
        StringBuilder high = new StringBuilder();
        StringBuilder low = new StringBuilder();

        for (int i = 0; i < string.length() - index; i++) {
            high.append(string.charAt(i));
        }
        for (int i = (int) (string.length() - index); i < string.length(); i++) {
            low.append(string.charAt(i));
        }

        return new String[] {high.toString(), low.toString()};
    }
}
