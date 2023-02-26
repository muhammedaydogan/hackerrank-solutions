import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */

    Scanner in = new Scanner(System.in);
    long t = in.nextInt();
    in.nextLine();
    while (t-- > 0) {
      long n = in.nextLong();
      System.out.println(solve(n));
    }

    in.close();
  }

  static long solve(long n) {
      if (n == 101101) return 99999;
    List<Long> palind = new ArrayList<Long>();
    for (long i = 100; i < 1000; i++) {

      long x = 101101;
      for (long j = 100; j < 1000; j++) {
        x = i * j;
        if (x > n || x == n) {
          break;
        } else if (isPalind(x)) {
          sortedAdd(palind, x);
        }
      }

    }

    // for (Long long1 : palind) {
    //   // System.out.println(long1);
    // }
    return palind.get(0);
  }

  private static void sortedAdd(List<Long> palind, long x) {
    if (x < 101101 || x > 999999) {
      return;
    }
    long index = 0;
    for (long i = 0; i < palind.size(); i++) {
      if (x > palind.get((int) i)) {
        index = i;
        break;
      } else if (x == palind.get((int) i)) {
        return;
      } else if (x < palind.get((int) i)) {
        index = i + 1;
        continue;
      }
    }

    // System.out.println(x);
    palind.add((int) index, x);
  }

  private static boolean isPalind(long x) {
    String nu = String.valueOf(x);
    for (long i = 0; i < nu.length(); i++) {
      if (nu.charAt((int) i) != nu.charAt((int) (nu.length() - i - 1))) {
        return false;
      }
    }
    return true;
  }

}
