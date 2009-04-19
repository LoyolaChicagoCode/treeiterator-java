package edu.luc.cs.laufer.cs473.tree;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class Trees {

	public static void main(String[] args) throws java.io.IOException {

		DefaultMutableTreeNode t = new DefaultMutableTreeNode("1");
		DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("4");
		t.add(new DefaultMutableTreeNode("2"));
		t.add(new DefaultMutableTreeNode("3"));
		t.add(t4);
		t4.add(new DefaultMutableTreeNode("5"));

		for (Iterator<TreeNode> i = new TreeIterator(t,
				Collections.asLifoQueue(new LinkedList<TreeNode>())); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		System.out.println();

//		for (Iterator<Tree<String>> i = t.iterator(new Stack<Tree<String>>()); i
//				.hasNext();) {
//			System.out.print(((Tree<String>) i.next()).data() + " ");
//		}
//		System.out.println();
//
//		for (Iterator<Tree<String>> i = t.iterator(new TreePrique<String>()); i
//				.hasNext();) {
//			System.out.print(((Tree<String>) i.next()).data() + " ");
//		}
//		System.out.println();
	}
}
