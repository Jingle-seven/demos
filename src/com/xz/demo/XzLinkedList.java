package com.xz.demo;

public class XzLinkedList {

	private int size = 0;
	private Node head = new Node();
	private Node currentNode = head;
	public void add(Object data) {
		Node newNode = new Node(data);
		currentNode.setNext(newNode);
		currentNode = newNode;
		size++;
	}

	public void display() {
		Node displayNode = head.getNext();
		while(displayNode!=null){
			System.out.println(displayNode.getData());
			displayNode = displayNode.getNext();
		}
	}
	
	public void reverse(){
		Node tempNode = head.getNext();
		Node currentNode,nextNode;
		while(tempNode!=null){
			currentNode = tempNode;
			nextNode = currentNode.getNext();
			tempNode = tempNode.getNext();
		}
	}

}

class Node{
	Node(){}
	Node(Object data){
		this.data = data;
	}
	private Object data;
	private Node next;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
class doublyNode{
	private Object data;
	private Node next;
	private Node last;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	
}