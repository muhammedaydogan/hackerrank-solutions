import java.util.*;

public class Node {
  char letter;
  int score;
  private Map<Character, Node> successNodes;
  private Node failureNode;

  public Node(char letter, int score) {
    this.letter = letter;
    this.score = score;
    successNodes = new HashMap<Character, Node>();
  }

  public Node get(char letter) {
    return successNodes.get(letter);
  }

  public Node iterate(char letter) {
    Node result = get(letter);
    if (result == null)
      if (failureNode != null) {
        result = failureNode.get(letter);
      }
    return result;

  }

  public Node addSuccessLink(Node node) {
    successNodes.put(node.letter, node);
    return this;
  }

  public Node setFailureLink(Node node) {
    failureNode = node;
    return this;
  }

  public Map<Character, Node> getAllSuccessLinks() {
    return successNodes;
  }

  public Node getFailureLink() {
    return failureNode;
  }
}
