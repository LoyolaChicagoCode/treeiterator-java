package edu.luc.cs.laufer.cs473.tree;

import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class Trees {

	public static void main(String[] args) throws java.io.IOException {

		final DefaultMutableTreeNode t = new DefaultMutableTreeNode("1");
		final DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("2");
		final DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("4");
		t.add(t2);
		t.add(new DefaultMutableTreeNode("3"));
		t.add(t4);
		t2.add(new DefaultMutableTreeNode("5"));
		t2.add(new DefaultMutableTreeNode("6"));
		t4.add(new DefaultMutableTreeNode("7"));

		for (final Iterator<TreeNode> i = new TreeIterator(t,
				Collections.asLifoQueue(new LinkedList<TreeNode>())); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		System.out.println();

		for (final Iterator<TreeNode> i = new TreeIterator(t,
				new LinkedList<TreeNode>()); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		System.out.println();

		final Comparator<TreeNode> bySize = new Comparator<TreeNode>() {
			public int compare(TreeNode left, TreeNode right) {
				return size(left) - size(right);
			}
		};
		for (Iterator<TreeNode> i = new TreeIterator(t,
				new PriorityQueue<TreeNode>(1, bySize)); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
	}

	public static int size(final TreeNode node) {
		if (node == null) {
			throw new IllegalArgumentException("size: node is null");
		}
		int result = 1;
		for (final Enumeration<?> e = node.children(); e.hasMoreElements(); ) {
			result += size((TreeNode) e.nextElement());
		}
		return result;
	}
}
