package lambdasinaction.chap13;

import java.util.stream.LongStream;


public class Recursion {

    public static void main(String[] args) {
        int n = 20;
        System.out.println(factorialIterative(n));
        System.out.println(factorialRecursive(n));
        System.out.println(factorialStreams(n));
        System.out.println(factorialTailRecursive(n));
    }

    public static long factorialIterative(int n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r*=i;
        }
        return r;
    }

    public static long factorialRecursive(long n) {
        return n == 1 ? 1 : n*factorialRecursive(n-1);
    }

    public static long factorialStreams(long n){
        return LongStream.rangeClosed(1, n)
                         .reduce(1, (long a, long b) -> a * b);
    }

    public static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    public static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }
}
