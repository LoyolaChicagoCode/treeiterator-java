package edu.luc.cs.laufer.cs473.tree;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import javax.swing.tree.TreeNode;

public class TreeIterator implements Iterator<TreeNode> {

  final TreeNode subject;
  final Queue<TreeNode> driver;

  public TreeIterator(final TreeNode subject, final Queue<TreeNode> driver) {
    this.subject = subject;
    this.driver = driver;
    this.driver.add(subject);
  }

  public boolean hasNext() {
    return !driver.isEmpty();
  }

  public TreeNode next() throws NoSuchElementException {
    System.out.println("driver = " + driver);
    // remove first element in driver
    final Iterator<TreeNode> i = driver.iterator();
    final TreeNode current = i.next();
    i.remove();
    for (final Enumeration<?> e = current.children(); e.hasMoreElements(); ) {
      driver.add((TreeNode) e.nextElement());
    }
    return current;
  }

  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }
}
