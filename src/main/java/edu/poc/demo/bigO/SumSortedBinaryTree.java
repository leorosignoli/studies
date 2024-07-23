package edu.poc.demo.bigO;

public class SumSortedBinaryTree {

  // O(n) where n is the number of nodes in the tree, since we are visiting each node once in a
  // linear time
  int sum(Node node) {
    if (node == null) {
      return 0;
    }
    return node.getValue() + sum(node.getLeft()) + sum(node.getRight());
  }

  interface Node {
    int getValue();

    Node getLeft();

    Node getRight();
  }
}
