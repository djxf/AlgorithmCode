package 算法;
public class TodayCoding0518 {

	public static void main(String[] args) {
		 

	}
	/**
	 * 一致性哈希算法的基本原理。
	 * 大数据题目6 
	 * 工程师常使用服务器集群来设计和实现数据缓存，以下是常见的策略：
	 * 		1 无论是添加，查询，还是删除数据，都是先将数据的id通过hash函数。转换成一个哈希值。
	 * 			记为key。
	 * 		2 如果目前机器有N台，则计算key%N的值。这个值就是该数据所属的机器的机器编号。无论是添加。
	 * 			删除还是查询操作，都只在这台机器上面进行。
	 * 请分析这种缓存策略可能带来的问题。并提出改进的方案。
	 */
	
	/**
	 * 位运算题目 1
	 * 不用额外变量交换两个整数的值。
	 * 参考：使用异或运算。使用加减法可能会溢出。
	 */
	public static void swap(int a,int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
	
	/**
	 * 位运算题目 2
	 * 给定两个32位整数a和b，返回a和b中最大的，不用任何比较和判断。
	 */
	public static int flip(int n) {
		return n ^ 1;
	}
	
	public static int sign(int n) {
		return flip((n >> 31) & 1);
	}
	
	public static int getMax(int a,int b) {
		int c = a - b;
		int arcA = sign(c);
		int arcB = flip(arcA);
		return a * arcA + b * arcB;
	}
	
	/**
	 * 找出两个只出现一次的数字。
	 * 多进制异或
	 */
	public static void oneTimesTwoNum(int[] nums) {
		int e0 = 0;
		int e1 = 0;
		for(int item : nums) {
			e0 ^= item;
		}
		int rightOne = e0 & (~e0 + 1);
		for(int item : nums) {
			if((item & rightOne) != 0) {
				e1 ^= item;
			}
		}
		e0 ^= e1;
		System.out.println("e0:" + e0 + "e1:" + e1);
	}
}
