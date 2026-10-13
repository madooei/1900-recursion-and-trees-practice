package practice;

import list.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Tests for the iterative in-order traversal. */
public class InOrderTest {

  @Test
  public void emptyTreeGivesEmptyList() {
    List<Integer> result = IterativeTraversals.inOrder(null);
    assertEquals(0, result.size());
  }

  @Test
  public void singleNodeGivesItsValue() {
    Node<Integer> root = new Node<>(7);
    assertContents(new Integer[] {7}, IterativeTraversals.inOrder(root));
  }

  @Test
  public void leftChainGivesBottomToTop() {
    assertContents(new Integer[] {3, 2, 1},
        IterativeTraversals.inOrder(buildLeftChain()));
  }

  @Test
  public void rightChainGivesTopToBottom() {
    assertContents(new Integer[] {1, 2, 3},
        IterativeTraversals.inOrder(buildRightChain()));
  }

  @Test
  public void fourNodeTreeGivesInOrder() {
    assertContents(new Integer[] {4, 2, 1, 3},
        IterativeTraversals.inOrder(buildFourNodeTree()));
  }

  @Test
  public void nineNodeTreeGivesInOrder() {
    assertContents(new Integer[] {6, 9, 8, 1, 5, 4, 2, 7, 3},
        IterativeTraversals.inOrder(buildNineNodeTree()));
  }

  // Builds 1 with left child 2, which has left child 3.
  private static Node<Integer> buildLeftChain() {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.left.left = new Node<>(3);
    return root;
  }

  // Builds 1 with right child 2, which has right child 3.
  private static Node<Integer> buildRightChain() {
    Node<Integer> root = new Node<>(1);
    root.right = new Node<>(2);
    root.right.right = new Node<>(3);
    return root;
  }

  // Builds 1 with children 2 and 3, where 2 has left child 4.
  private static Node<Integer> buildFourNodeTree() {
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);
    return root;
  }

  // Builds 5 with children 8 and 2; 8 has children 9 and 1; 2 has children 4
  // and 7; 9 has left child 6; 7 has right child 3.
  private static Node<Integer> buildNineNodeTree() {
    Node<Integer> root = new Node<>(5);
    root.left = new Node<>(8);
    root.right = new Node<>(2);
    root.left.left = new Node<>(9);
    root.left.right = new Node<>(1);
    root.right.left = new Node<>(4);
    root.right.right = new Node<>(7);
    root.left.left.left = new Node<>(6);
    root.right.right.right = new Node<>(3);
    return root;
  }

  // Asserts that actual holds exactly the expected values, in order.
  private static void assertContents(Integer[] expected, List<Integer> actual) {
    assertEquals(expected.length, actual.size());
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual.get(i));
    }
  }
}
