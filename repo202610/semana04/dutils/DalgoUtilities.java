package dutils;

public class DalgoUtilities {
	public static class Queue {
		QNode head;
		QNode tail;

		public Queue(QNode node) {
			this.head= node;
			this.tail= node;
		}

		public boolean isEmpty() {
			return this.head == null;
		}

		public QNode dequeue() {
			QNode ans= this.head;
			if (ans.succ == null) {
				this.head= null;
				this.tail= null;
				return ans;
			}
			QNode nh= ans.succ;
			ans.succ= null;
			nh.pred= null;
			this.head= nh;
			return ans;
		}

		public void enqueue(QNode node) {
			QNode pt= this.tail;
			if (pt == null) {
				this.head= node;
				this.tail= node;
				return;
			}
			pt.succ= node;
			node.pred= pt;
			node.succ= null;
			this.tail= node;
		}

		public void printMe() {
			QNode current= this.head;
			if (current == null) {
				System.out.println();
				return;
			}
			int t= current.ntag;
			while (current.succ != null) {
				System.out.print(t);
				System.out.print(" <-> ");
				current= current.succ;
				t= current.ntag;
			}
			System.out.println(t);
		}
	}

	public static class QNode {
		public int ntag;
		QNode pred;
		QNode succ;

		public QNode(int ntag) {
			this.ntag= ntag;
		}
	}

	public static void main(String[] args) {
		QNode two= new QNode(2);
		QNode three= new QNode(3);
		QNode five= new QNode(5);
		QNode seven= new QNode(7);
		QNode eleven= new QNode(11);

		Queue q= new Queue(two);
		q.printMe();
		q.enqueue(three);
		q.printMe();
		q.enqueue(five);
		q.printMe();
		q.enqueue(seven);
		q.printMe();
		q.enqueue(eleven);
		q.printMe();

		q.dequeue();
		q.printMe();
		q.dequeue();
		q.printMe();
		q.dequeue();
		q.printMe();
		q.dequeue();
		q.printMe();
		q.dequeue();
		q.printMe();

		for (int i= 0; i < 10; i++) {
			QNode node= new QNode((int) Math.pow(2,i));
			q.enqueue(node);
			q.printMe();
		}

		for (int i= 0; i < 10; i++) {
			q.dequeue();
			q.printMe();
		}

		System.out.println("Hola Dalgo!");
	}
}
