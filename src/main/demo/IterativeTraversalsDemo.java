package demo;

import list.List;
import practice.IterativeTraversals;
import tree.Node;

/** A demo of IterativeTraversals on the four-node tree from the notes. */
public final class IterativeTraversalsDemo {

  private IterativeTraversalsDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // The tree from the notes: 1 has children 2 and 3, and 2 has a left child 4.
    Node<Integer> root = new Node<>(1);
    root.left = new Node<>(2);
    root.right = new Node<>(3);
    root.left.left = new Node<>(4);

    // Expect 1 2 4 3.
    System.out.print("pre-order:  ");
    printAll(IterativeTraversals.preOrder(root));

    // Expect 4 2 1 3.
    System.out.print("in-order:   ");
    printAll(IterativeTraversals.inOrder(root));

    // Expect 4 2 3 1.
    System.out.print("post-order: ");
    printAll(IterativeTraversals.postOrder(root));
  }

  // Prints the values on one line, separated by spaces.
  private static void printAll(List<Integer> values) {
    for (int i = 0; i < values.size(); i++) {
      System.out.print(values.get(i) + " ");
    }
    System.out.println();
  }
}
