 

public class TodayCoding0519 {

	public static void main(String[] args) {
		 
	}
	/**
	 * 题目6
	 * 使用位运算实现加减乘除。
	 * 参考：系统最小值无法实现绝对值。
	 * Integer.MIN_VALUE - 1 == Integer.MAX_VALUE
	 * Integer.MAX_VALUE + 1 == Integer.MIN_VALUE
	 */
	public static int bitAdd(int a,int b) {
		int sum = 0;
		while(b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}
	
	/**
	 * 取相反数
	 * @param n
	 * @return
	 */
	public static int negNum(int n) {
		return bitAdd(~n, 1);
	}
	
	/**
	 * 位运算实现N皇后问题加速。
	 */
	
	
	/**
	 * 动态规划：把多阶段过程转化为一系列单阶段问题，
	 * 利用各阶段之间的关系，逐个求解，创立了解决这类过程优化问题的新方法——动态规划。
	 * 1 暴力递归。
	 * 2 记忆化搜索。
	 * 3 动态规划。
	 * 题目 17：
	 * 给定一个整数N，求由"0"字符与"1"字符组成为N的所有字符串中，满足"0"字符的左边必有"1"字符的
	 * 字符串数量。
	 * 题目附加：走楼梯问题最佳时间复杂度：O(logN)。
	 * 空间压缩：二维问题只使用一个数组。
	 */
	
}
