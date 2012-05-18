package com.playtech;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class TreeTest {
	
	@Test
	public void testTreeTraversal() {
		// Given
		Tree.Node C = new Tree.Node("C", null, null);
		Tree.Node E = new Tree.Node("E", null, null);
		Tree.Node D = new Tree.Node("D", C, E);
		Tree.Node A = new Tree.Node("A", null, null);
		Tree.Node B = new Tree.Node("B", A, D);
		Tree.Node H = new Tree.Node("H", null, null);
		Tree.Node I = new Tree.Node("I", H, null);
		Tree.Node G = new Tree.Node("G", null, I);
		Tree.Node F = new Tree.Node("F", B, G);
		Tree tree = new Tree(F);
		
		// When
		List<Tree.Node> orderedNodes = tree.traverseTree();
		
		// Then
		List<Tree.Node> expectedNodes = Arrays.asList(F, B, A, D, C, E, G, I, H);
		Assert.assertTrue(expectedNodes.equals(orderedNodes));
	}
}
