package practice;

import list.ArrayList;
import list.List;
import stack.LinkedStack;
import stack.Stack;

/** Solutions to the iterative traversal problems. */
public final class IterativeTraversals {

  private IterativeTraversals() {
    // This class should not be instantiated!
  }

  // Returns the values of the tree rooted at root in pre-order, without
  // recursion. Returns an empty list if root is null.
  public static <T> List<T> preOrder(Node<T> root) {
    List<T> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<Node<T>> stack = new LinkedStack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node<T> node = stack.top();
      stack.pop();
      result.add(node.value);
      if (node.right != null) {
        stack.push(node.right);  // push right first...
      }
      if (node.left != null) {
        stack.push(node.left);   // ...so left ends up on top
      }
    }
    return result;
  }

  // Returns the values of the tree rooted at root in in-order, without
  // recursion. Returns an empty list if root is null.
  public static <T> List<T> inOrder(Node<T> root) {
    List<T> result = new ArrayList<>();
    Stack<Node<T>> stack = new LinkedStack<>();
    Node<T> current = root;
    while (current != null || !stack.isEmpty()) {
      while (current != null) {   // follow the left spine, pushing as we go
        stack.push(current);
        current = current.left;
      }
      current = stack.top();      // the top has no unvisited left — it is ready
      stack.pop();
      result.add(current.value);  // record it
      current = current.right;    // then move into its right subtree
    }
    return result;
  }

  // Returns the values of the tree rooted at root in post-order, without
  // recursion. Returns an empty list if root is null.
  public static <T> List<T> postOrder(Node<T> root) {
    List<T> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<Node<T>> stack = new LinkedStack<>();
    Stack<Node<T>> output = new LinkedStack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node<T> node = stack.top();
      stack.pop();
      output.push(node);             // record onto the second stack
      if (node.left != null) {
        stack.push(node.left);       // push left first...
      }
      if (node.right != null) {
        stack.push(node.right);      // ...then right, so right comes off first
      }
    }
    while (!output.isEmpty()) {       // drain the output stack into the result
      result.add(output.top().value);
      output.pop();
    }
    return result;
  }
}
