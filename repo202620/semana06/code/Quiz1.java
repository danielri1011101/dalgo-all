public class Quiz1 {
	class LNode {
		int val;
		LNode next;
	}
	class LList {
		LNode head;
	}
	void fooList(LList llist) {
		LNode current= llist.head;
		while (current != null) {
			int cval= current.val;
			System.out.println("foo " + cval);
			current= current.next;
		}
	}
	public static void main(String[] args) {
		Quiz1 q1= new Quiz1();
		LNode nd0= q1.new LNode();
		LNode nd1= q1.new LNode();
		LNode nd2= q1.new LNode();
		nd0.val= 3;
		nd1.val= 5;
		nd2.val= 6;
		nd0.next= nd1;
		nd1.next= nd2;
		LList llist= q1.new LList();
		llist.head= nd0;
		q1.fooList(llist);
	}
}
