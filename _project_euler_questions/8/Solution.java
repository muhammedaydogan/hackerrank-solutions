
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextInt();
    while (in.hasNext()) {
      in.nextInt();
      int n = in.nextInt();
      in.nextLine();
      String number = in.nextLine();
      System.out.println(solve(n, number));
    }
    in.close();
  }

  private static int solve(int n, String number) {
    // int r = Integer.parseInt(number, 0, 1, 10) * Integer.parseInt(number, 1, 2,
    // 10)
    // * Integer.parseInt(number, 2, 3, 10) * Integer.parseInt(number, 3, 4, 10)
    // * Integer.parseInt(number, 4, 5, 10);
    // for (int i = n; i < number.length() - n + 1; i++) {
    // int prev = Integer.parseInt(number, i - n, i - n + 1, 10);
    // int next = Integer.parseInt(number, i, i + 1, 10);
    // if (prev == next) {
    // continue;
    // }
    // int r2;
    // if (prev == 0) {
    // int n1 = Integer.parseInt(number, i, i + 1, 10);
    // int n2 = Integer.parseInt(number, i - 1, i, 10);
    // int n3 = Integer.parseInt(number, i - 2, i - 1, 10);
    // int n4 = Integer.parseInt(number, i - 3, i - 2, 10);
    // int n5 = Integer.parseInt(number, i - 4, i - 3, 10);
    // r2 = n1 * n2 * n3 * n4 * n5;
    // } else {
    // r2 = r * next / prev;
    // }
    // if (r2 > r) {
    // r = r2;
    // }
    // }
    // return r;
    int r = 0;
    for (int i = n - 1; i < number.length() - n + 1; i++) {

      int n1 = Integer.parseInt(number, i, i + 1, 10);
      int n2 = Integer.parseInt(number, i - 1, i, 10);
      int n3 = Integer.parseInt(number, i - 2, i - 1, 10);
      int n4 = Integer.parseInt(number, i - 3, i - 2, 10);
      int n5 = Integer.parseInt(number, i - 4, i - 3, 10);
      int r2 = n1 * n2 * n3 * n4 * n5;

      if (r2 > r) {
        r = r2;
      }
    }
    return r;
  }

}