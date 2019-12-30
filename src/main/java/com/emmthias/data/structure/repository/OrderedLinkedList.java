package com.emmthias.data.structure.repository;

import java.util.StringJoiner;

import org.springframework.stereotype.Repository;

import com.emmthias.data.structure.model.Node;

/**
 * This is the place where the logic was added, since I don-t have persistence
 * layer
 * 
 * 
 * @author jpolanco
 *
 */

@Repository
public class OrderedLinkedList {
	private Node root;

	/*
	 * As root node holds all the pointers to the hierarchy
	 * 
	 * @return root Node
	 */
	public Node getAllElements() {
		return root;
	}

	/*
	 * @param newNode - current node to be added
	 * 
	 * @return index where the new node will be place
	 */
	public int addToEnd(Node newNode) {

		Node currentNode = root;
		int i = 1;

		// This is the first element on linkedList
		if (root == null) {
			root = newNode;
			i = 0;
		} else {
			// evaluate next node before be assigned
			while (currentNode.getNextNode() != null) {
				i++;
				currentNode = currentNode.getNextNode();
			}

			currentNode.setChildNode(newNode);
		}

		return i;
	}

	/**
	 * Add element at Order LinkedList.
	 * 
	 * <b>Steps</b> 
	 * 
	 * insert number  9  in the following
	 *                ||
	 *                 \\
	 *                  \\
	 *                   \\
	 * ===    ===    ===  \\   ===    ====    ====
	 * |2| -> |5| -> |7|   ==> | | -> |10| -> |15|
	 * ===    ===    ===   	   ===    ====    ====    
	 * 
	 * 1) If Linked list is empty then make the node as head and return it.
	 * 2) If the value of the node to be inserted is smaller than the value of the head node, then insert the node 
	 * at the start and make it head.
	 * 3) In a loop, find the appropriate node after which the input node (let 9) is to be inserted. 
	 * To find the appropriate node start from the head, keep moving until you reach a node GN (10 in
	 * the below diagram) who's value is greater than the input node. The node just before GN is the
	 * appropriate node (7).
	 *	4) Insert the node (9) after the appropriate node(7) found in step 3.
	 * 
	 * @param newNode
	 * @return index at the node was added
	 */
	public int addOrderedNode(Node newNode) {

		if (root == null || newNode.getValue() < root.getValue()) {
				newNode.setChildNode(root);
				root = newNode;
				return 0;
			}

			int index = 1;
			Node currentNode = root;

			while (currentNode != null) {
				
				if (currentNode.getNextNode() != null && // insert element in range [n,n+1]
						currentNode.getNextNode().getValue() >= newNode.getValue()) {
					
					Node descendats = currentNode.getNextNode();
					// assign descendants to new node
					newNode.setChildNode(descendats);
					currentNode.setChildNode(newNode);
					break;

				} else if (newNode.getValue() > currentNode.getValue() // greater value added at the end
						&& currentNode.getNextNode() == null) {
					currentNode.setChildNode(newNode);
					break;
				}

				currentNode = currentNode.getNextNode();

				index++;
			}
			return index;
		}

	public String prettyFormat() {
		StringJoiner linkedListFormatted = new StringJoiner(" -> ");

		Node currentNode = root;

		while (currentNode != null) {
			linkedListFormatted.add(currentNode.getValue().toString());
			currentNode = currentNode.getNextNode();
		}

		return linkedListFormatted.toString();
	}

	public boolean clear() {
		root = null;
		return true;
	}
}
