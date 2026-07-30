package com.linkedlist.elc;

public class LinkedList {

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(2,9);
	
		IO.println(ll);
		
	}
	
	public static boolean isAvaille(int key) {
		return false;
		
	}
	
	
	public class Node {
		
		Node next;
		int item;
		Node head;
		Node tail;
		
		public Node(int item) {
			this.item = item;
			next = null;
		}
		
		public void insertAtStart(int item) {
			Node newNode = new Node(item);
			newNode.next = head;
			head = newNode;
		}
		
		public void insertAtEnd(int item) {
			
			Node newNode = new Node(item);
			
			if(head == null ) {
				head = newNode;
				return;
			} 
			
			Node temp = head;
			while(head.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			
		}
		
		
		
	}
	
	
	
	
	

}

