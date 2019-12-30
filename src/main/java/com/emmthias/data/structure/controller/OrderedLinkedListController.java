package com.emmthias.data.structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emmthias.data.structure.model.Node;
import com.emmthias.data.structure.service.OrderedLinkedListService;

@RestController
@RequestMapping(value = "/orderedLinkedList")
public class OrderedLinkedListController {

	@Autowired
	private OrderedLinkedListService orderedLinkedList;

	@GetMapping(value = "/")
	public Node getAllLinkedList() {
		return orderedLinkedList.getAllElements();
	}

	@GetMapping(value = "/string")
	public String getAllLinkedListStringFormat() {
		return orderedLinkedList.prettyFormat();
	}
	
	@PostMapping(value = "/")
	public String addNode(@RequestBody Node newNode) {

		int currentIndex = orderedLinkedList.add(newNode);
		String prettyFormat = orderedLinkedList.prettyFormat();

		String completeOutput = String.format("New node was added succesfully [%d] = %s", currentIndex,
				newNode.getValue()) + "\n" +prettyFormat;
		return completeOutput;
	}
	
	@DeleteMapping(value = "/clearAll")
	public String cleanAllElements() {
		return orderedLinkedList.clear();
	}
}
