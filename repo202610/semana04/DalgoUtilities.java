public class DalgoUtilities {
	public static class Queue {
		QNode head;
		QNode tail;

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
		int ntag;
		QNode pred;
		QNode succ;
	}

	public static void main(String[] args) {
	}
}
