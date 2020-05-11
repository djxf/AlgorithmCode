package 算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

 

/**
 * 二叉树
 * @author 斗酒相逢
 *
 */
public class TodayCoding0511 {

	public static void main(String[] args) {
			int[] nums = {1,2,3,4,5,6,7};
			MTree mTree = arrayToTree(nums, 0);
			posOrderUnRecur2(mTree); 
			 
	}
	/**
	 * 题目1：用递归和非递归遍历二叉树
	 * 先，中，后
	 */
	
	//非递归先序遍历
	public static void preOrderUnRecur(MTree head) {
		if(head == null) {
			return;
		}
		Stack<MTree> stack = new Stack<>();
		stack.add(head);
		while(!stack.isEmpty()) {
			head = stack.pop();
			System.out.println(head.value);
			if(head.rightTree != null) {
				stack.push(head.rightTree);
			}
			if(head.leftTree != null) {
				stack.push(head.leftTree);
			}
		}
	}
	
	//非递归中序遍历
	public static void inOrderUnRecur(MTree head) {
		if(head == null) {
			return;
		}
		Stack<MTree> stack = new Stack<>();
		while(!stack.isEmpty() || head != null) {
			if(head != null) {
				stack.push(head);
				head = head.leftTree;
			}else {
				head = stack.pop();
				System.out.println(head.value);
				head = head.rightTree;
			}
		}
	}
	
	//按层遍历二叉树
	public static void serialByLevlel(MTree head) {
		if(head == null) {
			return;
		}
		Queue<MTree> queue = new LinkedList<>();
		queue.offer(head);
		while(!queue.isEmpty()) {
			MTree node = queue.poll();
			if(node.leftTree != null) {
				queue.offer(node.leftTree);
			}
			if(node.rightTree != null) {
				queue.offer(node.rightTree);
			}
		}
	}
	//按层遍历并且输出换行，使用两个变量 1个记录当前行还剩多少未输出。另一个记录下一行有多少个节点。
	public static void serialByLevlelInline(MTree head) {
		if(head == null) {
			return;
		}
		int i = 1;//本次还有多少个变量未输出。
		int j = 0;//记录下一行节点个数
		Queue<MTree> queue = new LinkedList<>();
		queue.offer(head);
		while(!queue.isEmpty()) {
			MTree node = queue.poll();
			System.out.print(node.value + " ");
			i--;
			if(node.leftTree != null) {
				queue.offer(node.leftTree);
				j++;
			}
			if(node.rightTree != null) {
				queue.offer(node.rightTree);
				j++;
			}
			if(i == 0) {
				System.out.print("\n");
				i = j;
				j = 0;
			}
		}
	}
	
	
	//两个栈后序遍历
	public static void posOrderUnRecur(MTree head) {
		if(head == null) {
			return;
		}
		Stack<MTree> stack1 = new Stack<>();
		Stack<MTree> stack2 = new Stack<>();
		stack1.push(head);
		while(!stack1.isEmpty()) {
			MTree headTree = stack1.pop();
			stack2.push(headTree);
			if(headTree.leftTree != null) {
				stack1.push(headTree.leftTree);
			}
			if(headTree.rightTree != null) {
				stack1.push(headTree.rightTree);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().value + " ");
		}
		
	}
	
	//一个栈实现后序遍历
	public static void posOrderUnRecur2(MTree head) {
		if(head == null) {
			return;
		}
		Stack<MTree> stack = new Stack<>();
		stack.push(head);
		//用处
		MTree c = null;
		while(!stack.isEmpty()) {
			c = stack.peek();
			if(c.leftTree != null && head != c.leftTree && head != c.rightTree) {
				//这意味着什么呢？
				stack.push(c.leftTree);
			}else if (c.leftTree != null && head != c.rightTree) {
				stack.push(c.rightTree);
			}else {
				System.out.print(stack.pop().value + " ");
				head = c;
			}
		}
	}
	
	
	//树结构
	static class MTree{
		int value;
		MTree leftTree;
		MTree rightTree;
		public MTree() {
			 
		}
		public MTree(int value) {
			this.value = value;
		}
	}
	
	//把数组转换成树
	public static MTree arrayToTree(int[] nums,int index) {
		MTree mTree = new MTree();
		if(index < nums.length) {
			mTree.value = nums[index];
			mTree.leftTree = arrayToTree(nums, index * 2 + 1);
			mTree.rightTree = arrayToTree(nums, index * 2 + 2);
		}else {
			return null;
		}
		
		return mTree;
	}
}
