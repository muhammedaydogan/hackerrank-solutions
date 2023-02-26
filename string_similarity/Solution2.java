import java.util.*;

public class Solution2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // long t = in.nextLong();
    in.nextLine();
    while (in.hasNext()) {
      String s = in.nextLine();
      System.out.println(solve(s));
    }
    in.close();
  }

  private static long solve(String s) {
    int n = s.length(), l = 0, r = 0;
    long result = s.length();
    int Z[] = new int[n];
    Z[0] = n;
    for (int k = 1; k < n; k++) {
      int k2 = k - l;
      if (r >= k && Z[k2] <= r - k) {
        // just copy
        Z[k] = Z[k2];
      } else {

        l = k; // fix l
        r = (r < k) ? k : r; // fix r if it's going forward
        while (r < n && s.charAt(r) == s.charAt(r - l)) { // go forward
          r++;
        }
        Z[k] = r - l;
        r--;
      }
      result += Z[k];
    }
    return result;
  }
}