package com.playtech;

import java.util.LinkedList;
import java.util.List;

public class Tree {
	
	private Node root;
	
	public Tree(Node root) {
		this.root = root;
	}

	public List<Node> traverseTree() {
		List<Node> nodes = new LinkedList<Node>();
		traverseNode(root, nodes);
		return nodes;
	}
	
	private void traverseNode(Node node, List<Node> nodes) {
		if (node != null) {
			nodes.add(node);
			traverseNode(node.left, nodes);
			traverseNode(node.right, nodes);
		}
	}
	
	public static class Node {
		public Object element;
		public Node left;
		public Node right;
		
		public Node(Object element, Node left, Node right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return String.valueOf(element);
		}
	}
}
