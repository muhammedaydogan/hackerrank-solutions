
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */
    Scanner in = new Scanner(System.in);
    in.nextInt();
    while (in.hasNext()) {
      int n = in.nextInt();
      System.out.println(solve(n));
    }
    in.close();
  }

  private static long solve(int n) {
int result = 1;
for (int i = 1; i <= n; i++) {
  if (isPrime(i)) {
    int r1 = 1;
    while (r1 * i <= n)
      r1 *= i;
    // System.out.println("prime:" + i + "power:" + r1);
    result *= r1;
  }
}
return result;
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