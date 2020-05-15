package 算法;

import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.org.apache.bcel.internal.generic.SWAP;

public class TodayCoding0515 {

	public static void main(String[] args) {
		//计算TOP K
		//1 全局排序，利用快速排序等最快可达到N * log N.
		//2 局部排序，利用冒泡排序冒泡k个数字到最后。
		//3 堆，最大的TopK,生成一个小顶堆。N * log K.
		//4 转化为找到第K大的数字，再进行一个partition。N。
		//5 分布式思想。分别找到每台机器的TopK,再进行汇总。
		//涉及：分冶法，减冶法，排序算法，快速排序，堆排序。分布式。
		int[] nums = {5,1,2,3,9,6,7,8,4,100,0,-1};
		quickSort(nums, 0, nums.length - 1);
		for(int item : nums) {
			System.out.print(item + " ");
		}
	}
	
	public static void quickSort(int[] nums,int left,int right) {
		if (nums == null || left == right || left < 0 || right < 0) {
			return;
		}
		quickSortSub(nums,0,nums.length - 1);
	}
	
	/**
	 * 快速排序子排序
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void quickSortSub(int[] nums, int i, int j) {
		 if(i < j) {
			 int pivot = partition(nums, i, j);
			 quickSortSub(nums, i, pivot - 1);
			 quickSortSub(nums, pivot + 1, j);
		 }
		return;
	}

	/**
	 * 交换数组的两个下标
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void swap(int[] nums, int i, int j) {
		 int temp = nums[i];
	     nums[i] = nums[j];
	     nums[j] = temp;
	}
	
	/**
	 * 快速排序 划分函数
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int[] nums,int left,int right) {
		int privt = nums[left];
		int j = left;
		for(int i = left + 1;i <= right;i++) {
			if(nums[i] < privt) {
				swap(nums, ++j, i);
			}
		}
		swap(nums, left, j);
		return j;
	}
	
	
	/**
	 * 题目 11 
	 * 如果一个二叉树节点的结构比普通二叉树节点结构多了一个指向父结点的parent指针。
	 * 头节点指向null.
	 * 找到其后继节点。中序遍历得到的序列。
	 */
	public static Node getNextNode(Node node) {
		if(node == null) {
			return node;
		}
		if(node.right != null) {
			return getLeftMost(node.right);
		}else {
			Node parent = node.parent;
			while(parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	//获取最左的节点
	public static Node getLeftMost(Node node) {
		if(node == null) {
			return node;
		}
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	
	/**
	 * 题目 12 给定一颗二叉树的头节点head,以及这棵树的两个节点o1和o2,
	 * 请返回o1和o2的最近公共祖先节点。
	 */
	
	public static Node lowestAncestor(Node head,Node o1,Node o2) {
		if(head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		if(left != null && right != null) {
			return head;
		}
		return left != null ? left : right;
	}
	
	/**
	 * 统计完全二叉树的节点数。时间复杂度低于O(N)
	 * 
	 */
	public static int nodeNum(Node head) {
		if(head == null) {
			return 0;
		}
		
	}
	/**
	 * 计算节点数
	 * @param node 给定树的头节点
	 * @param l	当前层
	 * @param h 最深层
	 * @return
	 */
	public static int bs(Node node,int l,int h) {
		//如果当前层达到最深层，即叶子节点时 返回 1
		if(l == h) {
			return 1;
		}
		if (mostLeftLevel(node.right, l + 1) == h) {
			return (1 << (h - 1)) + bs(node.right, l + 1, h);
		}else {
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}	
	}
	
	//统计层数
	public static int mostLeftLevel(Node node,int level) {
		while(node != null) {
			level++;
			node = node.left;
		}
		return level;
	}
	
	/**
	 * 题目 14 
	 * 给定一个整数N，如果N < 1,代表空树结构。否则代表中序遍历的结果为{1,2,3,4,5,6,7...N}
	 * .请返回可能的二叉树结构有多少。
	 * 参考：数量是卡特兰数C(2n,n)/(n+1)
	 * 
	 */
	
	
}
