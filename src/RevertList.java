/**
 * ·´×ªÁ´±í
 */
public class RevertList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = new int[] {};
		int[] test2 = new int[] { 1 };
		int[] test3 = new int[] { 1, 2 };
		Node head = Generate(test2);
		head = Revert(head);
		Print(head);
	}

	public static Node Generate(int[] vals) {
		if (vals.length == 0) {
			return null;
		}
		Node node = new Node(vals[0]);
		Node head = node;
		for (int i = 1; i < vals.length; i++) {
			node.next = new Node(vals[i]);
			node = node.next;
		}
		return head;
	}

	public static Node Revert(Node head) {
		Node preNode = null;
		Node curNode = head;
		while (curNode != null) {
			Node nextNode = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = nextNode;
		}
		return preNode;
	}

	public static void Print(Node head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}

class Node {
	int val;
	Node next = null;

	public Node(int v) {
		val = v;
	}
}
