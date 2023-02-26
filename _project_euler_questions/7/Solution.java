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
    long r = 0;
    for (int i = 2; r < n; i++) {
      if (isPrime(i)) {
        r++;
        if (r == n) {
          r = i;
          break;
        }
      }
    }
    return r;
  }

  private static boolean isPrime(int x) {
    if (x < 2) {
      return false;
    }
    if (x == 2)
      return true;
    if (x % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(x); i += 2) {
      if (x % i == 0)
        return false;
    }

    return true;
  }
}