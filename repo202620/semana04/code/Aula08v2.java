public class Aula08v2 {
	static class LNode {

		//Attributes
		int val;
		LNode next;

		//Constructors
		public LNode(int val) {
			this.val= val;
		}

		//Getters
		int getVal() {
			return this.val;
		}
		LNode getNext() {
			return this.next;
		}
		
		//Setters
		void setNext(LNode next) {
			this.next= next;
		}

	}

	static class LList {

		//Attributes
		LNode head;

		//Constructors
		public LList(LNode head) {
			this.head= head; 
		}

		//Getters
		LNode getHead() {
			return this.head;
		}

		//Setters
		void setHead(LNode head) {
			this.head= head;
		}

		//Modifiers
		void append(LNode node) {
			LNode current= this.head;
			while (current.next != null) {
				current= current.getNext();
			}
			current.setNext(node);
		}
	}

	class Graph {
		LList[] neighbors;
	}

	//Global Methods
	static void fooList(LList llist) {
		LNode current= llist.getHead();
		while (current != null) {
			int cval= current.getVal();
			System.out.println("foo " + cval);
			current= current.getNext();
		}
	}

	//
	//Main method
	//
	public static void main(String[] args) {
		LNode node0= new LNode(3);
		LNode node1= new LNode(5);
		LNode node2= new LNode(6);
		LList llist= new LList(node0);
		llist.append(node1);
		llist.append(node2);
		fooList(llist);
	}
}
