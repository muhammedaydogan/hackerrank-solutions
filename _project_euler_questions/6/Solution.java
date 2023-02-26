
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextInt();
    while (in.hasNext()) {
      long n = in.nextLong();
      System.out.println(solve(n));
    }
    in.close();
  }

  private static long solve(long n) {
    long r1 = 0;
    long r2 = 0;
    for (long i = 1; i <= n; i++) {
      r1 += i;
      r2 += i * i;
    }
    r1 *= r1;
    return r1 - r2;
  }
}