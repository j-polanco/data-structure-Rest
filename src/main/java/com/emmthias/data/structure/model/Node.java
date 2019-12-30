package com.emmthias.data.structure.model;


//Simple class holder to define data structure 
/**
 * @author jpolanco
 *
 */

public class Node {

	private Node nextNode;
	private Integer value;
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(Integer value) {
		super();
		this.value = value;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setChildNode(Node childNode) {
		this.nextNode = childNode;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Node [nextNode=" + nextNode + ", value=" + value + "]";
	}
}
