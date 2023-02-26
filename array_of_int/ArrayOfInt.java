package array_of_int;

import java.io.*;
import java.util.*;

public class ArrayOfInt {

  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */
    Scanner in = new Scanner(System.in);
    // while (in.hasNext()) {
      int n = in.nextInt();
      int x = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }
      System.out.println(solve(x, arr));
    // }
    in.close();
  }

  private static int solve(int m, int[] arr) {
    return 1;
  }
}