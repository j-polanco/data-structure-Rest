package com.emmthias.data.structure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmthias.data.structure.model.Node;
import com.emmthias.data.structure.repository.OrderedLinkedList;

/**
 * @author jpolanco
 *
 */

@Service
public class OrderedLinkedListService {
	
	@Autowired
	private OrderedLinkedList orderedLinkedList;

	public Node getAllElements() {
		return orderedLinkedList.getAllElements();
	}
	
	public int add(Node newNode) {
		return orderedLinkedList.addOrderedNode(newNode);
	}

	public String prettyFormat() {
		return orderedLinkedList.prettyFormat();
	}

	public String clear() {
		// TODO Auto-generated method stub
		boolean isEmpty = orderedLinkedList.clear();
		return isEmpty ? "Clear was succesfully apply" :"Something happend" ;
	}
}
