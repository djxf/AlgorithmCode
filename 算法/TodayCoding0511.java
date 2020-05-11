package 算法;

import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

/**
 * 二叉树
 * @author 斗酒相逢
 *
 */
public class TodayCoding0511 {

	public static void main(String[] args) {
			

	}
	/**
	 * 题目1：用递归和非递归遍历二叉树
	 * 先，中，后
	 */
	
	//非递归先序遍历
	public static void preOrderUnRecur(Node head) {
		if(head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.add(head);
		while(!stack.isEmpty()) {
			head = stack.pop();
			System.out.println(head.value);
			if(head.right != null) {
				stack.push(head.right);
			}
			if(head.left != null) {
				stack.push(head.left);
			}
		}
	}
	
	//非递归中序遍历
	public static void inOrderUnRecur(Node head) {
		if(head == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty() || head != null) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			}else {
				head = stack.pop();
				System.out.println(head.value);
				head = head.right;
			}
		}
	}
	
}
