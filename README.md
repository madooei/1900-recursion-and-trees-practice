# Recursion and Trees — Practice

Three practice problems: rewrite the recursive pre-order, in-order, and post-order traversals without recursion, using an explicit stack. Each method returns the visited values as a `List<T>` instead of printing them.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      practice/
        IterativeTraversals.java        # iterative pre-, in-, and post-order
      tree/
        Node.java                       # the binary-tree node from the chapter
      stack/
        Stack.java                      # the Stack ADT from the stack chapter
        LinkedStack.java                # the stack the traversals use
      list/
        List.java                       # the List ADT from the list chapter
        ArrayList.java                  # the list the traversals return
      demo/
        IterativeTraversalsDemo.java    # the three traversals on the notes' tree
    test/
      practice/
        PreOrderTest.java
        InOrderTest.java
        PostOrderTest.java
  scripts/
    test.sh                             # compile and run every JUnit test
    run.sh                              # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.InOrderTest` — compiles everything and runs only that test class. Use this while you are working on one traversal and the others are still empty.
- `scripts/run.sh demo.IterativeTraversalsDemo` — compiles everything and runs that one demo. Every class you implement has its own demo, `<Class>Demo`.

## Contents

- `practice.IterativeTraversals` — `preOrder`, `inOrder`, and `postOrder`. Each one returns the values of a binary tree in that order without recursion, and returns an empty list for an empty tree.
- `tree.Node<T>` — the binary-tree node from the chapter, with a value and a left and a right child.
- `demo.IterativeTraversalsDemo` — the demo for `IterativeTraversals`, which runs the three traversals on the tree from the notes.
- `practice.PreOrderTest`, `practice.InOrderTest`, `practice.PostOrderTest` — tests for the three traversals.
- The `tree` package is a copy from the chapter, and the `stack` and `list` packages are copies from earlier chapters. They are included so this code compiles and runs on its own.
