import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    String input = "6\na b c aa d b\n1 2 3 4 5 6\n3\n1 5 caaab\n0 4 xyz\n2 4 bcdybc";
    InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    Scanner in = new Scanner(stream);
    in.nextLine();
    String[] genes = in.nextLine().split(" ");
    String[] healthString = in.nextLine().split(" ");
    int[] health = new int[healthString.length];
    for (int i = 0; i < healthString.length; i++) {
      health[i] = Integer.parseInt(healthString[i]);
    }

    in.nextLine();
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    while (in.hasNext()) {
      /*
       * String line = in.nextLine();
       * String[] splitted = line.split(" ");
       * int start = Integer.parseInt(splitted[0]);
       * int end = Integer.parseInt(splitted[1]) + 1;
       * String strand = splitted[2];
       */
      int start = in.nextInt();
      int end = in.nextInt() + 1;
      String strand = in.nextLine();
      long result = solve(strand.trim(), Arrays.copyOfRange(genes, start, end),
          Arrays.copyOfRange(health, start, end));
      min = (result < min) ? result : min;
      max = (result > max) ? result : max;
      System.out.println(result);
    }
    System.out.println(min + " " + max);
    in.close();
  }

  private static long solve(String strand, String[] genes, int[] health) {
    // List of of unique pattern characters
    Map<Character, Boolean> letters = new HashMap<Character, Boolean>();

    // Build a tree of nodes with success links.
    Node root = new Node('0', 0);
    for (int i = 0; i < genes.length; i++) {
      Node parent = root;
      Node curr = root;
      String gene = genes[i];
      for (int j = 0; j < gene.length(); j++) {
        char c = gene.charAt(j);
        if (!letters.containsKey(c)) {
          letters.put(c, true);
        }
        int score = (j == gene.length() - 1) ? health[i] : 0;
        Node next = curr.get(c);
        if (next == null) {
          next = new Node(c, score);
          parent = curr;
          curr = next;
          parent.addSuccessLink(next);
        } else {
          if (j == gene.length() - 1) {
            // System.out.println(genes[i]+"__"+i+")"+next.score+" "+health[i]);
            next.score += health[i];
          }
          parent = curr;
          curr = next;
        }
      }
    }

    // show(root, 0, "");

    // Turn the tree into a graph by adding failure links.
    addFailureNodes(root, letters);

    show(root, 0, "");

    // iterate through strand
    int result = 0;
    Node curr = root;
    System.out.print("strand:");
    for (int i = 0; i < strand.length(); i++) {
      char c = strand.charAt(i);
      System.out.print(c + " ");
      curr = curr.iterate(c);
      if (curr == null) {
        curr = root.iterate(c);
      }
      if (curr != null) {
        result += curr.score;
        System.out.print("(" + curr.score + ") ");
      } else {
        curr = root;
        System.out.print("-");
      }
    }
    System.out.println();
    return result;
  }

  private static void addFailureNodes(Node root, Map<Character, Boolean> letters) {
    for (Node node : root.getAllSuccessLinks().values()) {
      doIt(root, letters, node, "");
    }
  }

  /*
   * @param leaf who is a normal node but assumed to be a leaf anyway,
   * Because we dont need it's childs.
   */
  private static void doIt(Node root, Map<Character, Boolean> letters, Node leaf, String sequence) {
    sequence = sequence + leaf.letter;
    Node curr = root;
    if (sequence.length() > 1) {
      System.out.println("case : <" + sequence + ">");
      /*
       * @param i is length of sequence
       * Search for the longest prefix starting from
       * root, that matches suffix of sequence
       * If you find one, establish a link to that node
       * Else, link to root or DO NOTHING maybe
       */
      for (int i = 1; i < sequence.length() && sequence.length() >= 2; i++) {
        String searchKey = sequence.substring(i, sequence.length());

        int j = 0;
        curr = root.get(searchKey.charAt(j));
        while (curr != null) {
          j++;
          if (j < searchKey.length()) {
            curr = curr.get(searchKey.charAt(j));
          } else {
            break;
          }
        }
        if (j == sequence.length() - i) {
          // We found it
          leaf.setFailureLink(curr);
          // System.out.println("found: " + curr.letter + " l:" + j + ", leaf: " +
          // leaf.letter);
          break;
        }
      }
    }

    for (Node node : leaf.getAllSuccessLinks().values()) {
      doIt(root, letters, node, sequence);
    }
  }

  private static void show(Node root, int level, String seq) {
    level++;
    if (root.getFailureLink() != null) {
      // System.out.println("Failure node: " + root.getFailureLink().letter);
      System.out.print("*");
    }
    for (Character c : root.getAllSuccessLinks().keySet()) {
      Node node = root.get(c);
      System.out.println("l:" + level + " " + seq + c + " s" + node.score);
      show(node, level, seq + node.letter);
    }
  }
}