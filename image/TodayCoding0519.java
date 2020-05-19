import com.sun.javafx.geom.AreaOp.AddOp;

public class TodayCoding0519 {

	public static void main(String[] args) {
		  
		System.out.println(Integer.MIN_VALUE - 1 == Integer.MAX_VALUE);
	}
	/**
	 * 题目6
	 * 使用位运算实现加减乘除。
	 * 参考：系统最小值无法实现绝对值。
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
	
	public static int negNum(int n) {
		return bitAdd(~n, 1);
	}
	
	
}
