import java.io.*;
import java.util.*;
class Result {

  /*
   * Complete the 'queensAttack' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER k
   * 3. INTEGER r_q
   * 4. INTEGER c_q
   * 5. 2D_INTEGER_ARRAY obstacles
   */

  public static int queensAttack2(int n, int k, int qR, int qC, List<List<Integer>> obstacles) {

    // Closest obstacles
    int rTop = n + 1;
    int rBottom = 0;
    int cRight = n + 1;
    int cLeft = 0;
    int rBottomRight = ((qR + qC) <= n + 1) ? 0 : (qR + qC - n - 1);
    int rBottomLeft = (qR > qC) ? (qR - qC) : 0;
    int rTopRight = (qR >= qC) ? n + 1 : n + 1 - (qC - qR);
    int rTopLeft = ((qR + qC) > n) ? n + 1 : qR + qC;

    System.out.println("v: " + rTop + " " + rBottom + " " + (rTop - rBottom - 2));
    System.out.println("h: " + cRight + " " + cLeft + " " + (cRight - cLeft - 2));
    System.out.println("m: " + rTopRight + " " + rBottomLeft + " " + (rTopRight -
        rBottomLeft - 2));
    System.out.println("c: " + rTopLeft + " " + rBottomRight + " " + (rTopLeft -
        rBottomRight - 2));

    for (int i = 0; i < obstacles.size(); i++) {
      int oR = obstacles.get(i).get(0);
      int oC = obstacles.get(i).get(1);
      if (oR == qR) {
        // System.out.println(oC);
        // Horizontal-
        if (oC > qC) {
          // Right
          if (oC < cRight) {
            cRight = oC;
          }
        } else if (oC < qC) {
          // Left
          if (oC > cLeft) {
            cLeft = oC;
          }
        }
      } else if (oC == qC) { // 2
        // Vertical-
        // System.out.println(oR);
        if (oR > qR) {
          // System.out.println(oR + " " + oC);
          // Top
          if (oR < rTop) {
            rTop = oR;
          }
        } else if (oR < qR) {
          // Bottom
          if (oR > rBottom) {
            rBottom = oR;
          }
        }
      } else if (Math.abs(oR - qR) == Math.abs(oC - qC)) { // 11
        if (oR > qR) { // 5
          // Top-
          if (oC < qC) { // 3
            // TopLeft
            if (oR < rTopLeft) {
              rTopLeft = oR;
            }
          }
          if (oC > qC) { // 2
            // TopRight
            if (oR < rTopRight) {
              rTopRight = oR;
            }
          }
        } else if (oR < qR) { // 6
          // Bottom-
          if (oC < qC) { // 4
            // BottomLeft
            if (oR > rBottomLeft) {
              rBottomLeft = oR;
            }
          }
          if (oC > qC) { // 2
            // BottomRight
            if (oR > rBottomRight) {
              rBottomRight = oR;
            }
          }
        }
      }
    }

    int totalMoves = rTop - rBottom - 2;
    totalMoves += cRight - cLeft - 2;
    totalMoves += rTopRight - rBottomLeft - 2;
    totalMoves += rTopLeft - rBottomRight - 2;

    System.out.println("v: " + rTop + " " + rBottom + " " + (rTop - rBottom - 2));
    System.out.println("h: " + cRight + " " + cLeft + " " + (cRight - cLeft - 2));
    System.out.println("m: " + rTopRight + " " + rBottomLeft + " " + (rTopRight -
        rBottomLeft - 2));
    System.out.println("c: " + rTopLeft + " " + rBottomRight + " " + (rTopLeft -
        rBottomRight - 2));

    return totalMoves;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {

    Scanner in = new Scanner(System.in);

    String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    String[] secondMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");

    int r_q = Integer.parseInt(secondMultipleInput[0]);

    int c_q = Integer.parseInt(secondMultipleInput[1]);

    List<List<Integer>> obstacles = new ArrayList<>();

    while (in.hasNext()) {
      int r = in.nextInt();
      int c = in.nextInt();
      List<Integer> obstacle = new ArrayList<>();
      obstacle.add(r);
      obstacle.add(c);
      obstacles.add(obstacle);
    }

    int result = Result.queensAttack2(n, k, r_q, c_q, obstacles);

    System.out.println(result);

    in.close();
  }
}
