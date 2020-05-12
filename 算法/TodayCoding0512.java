package 算法;

public class TodayCoding0512 {

	public static void main(String[] args) {
		
	}
	
	/**
	 * 题目1 最大子序列问题
	 * 
	 */
	int MaxSubsequenceSum(int a[],int n){
	    int ThisSum = 0, MaxSum = 0;    
	    for(int j = 0; j < n; j++){
	        ThisSum += a[j];
	        if(ThisSum > MaxSum){
	            MaxSum = ThisSum;
	        }else if (ThisSum < 0){
	            ThisSum = 0;        //ThisSum < 0，说明跨越a[j]不能使序列和变大
	        }
	    }
	    return MaxSum;
	}
}
