import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long t = in.nextLong();
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
      if (r < k) {
        l = r = k;
        while (r < n && s.charAt(r) == s.charAt(r - l)) {
          r++;
        }
        Z[k] = r - l;
        r--;
      } else {
        // We are inside l and r boundaries

        // See if current match reaches end?
        int k2 = k - l;
        if (Z[k2] <= r - k) {
          // No, then just copy
          Z[k] = Z[k2];
        } else {
          // Yes, So, we should check how far it goes.
          l = k;
          while (r < n && s.charAt(r) == s.charAt(r - l)) {
            r++;
          }
          Z[k] = r - l;
          r--;
        }
      }
      result += Z[k];
    }
    return result;
  }
}