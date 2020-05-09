import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * 堆的插入：
 * 		1 
 * @author 斗酒相逢
 *
 */
public class ToayCoding0509 {
    public static void main(String[] args) {
        
    	//如果不传入比较器 默认是小根堆。
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		priorityQueue.add(333);
		priorityQueue.add(222);
		priorityQueue.add(111);
		priorityQueue.add(1);
		priorityQueue.add(33);
		priorityQueue.add(99);
		 
		int[] diff = {85,47,57};
		int[] profit = {24,66,99};
		int[] work = {40,25,25};
		int res = maxProfitAssignment(diff,profit,work);
		System.out.println(res);
		
    }
    //出现次数的TOP k问题
    //题目8 给定String类型的数组strArr,再给定整数k，请严格按照排名顺序打印出现次数前k名的字符串。
    //拓展：设计并实现TopRecord结构，可以不断地向其中加入字符串。并且可以随时打印加入次数最多前k个字符串。
    //相关Java类 PriorityQueue

    //题目9 有N个长度不一样的数组，所有数组升序排序。请从大到小打印这N个数组整体的前K个数。


    //题目10 有一个源源不断地吐出整数的数据流，假设你有足够的空间来保存吐出的数，请设计一个名叫MedianHolder的结构，可以方便得找到吐出所有得数得中位数。
    

    //题目13 K代表你一共可以选的项目数，W代表你的初始启动资金。
    //       Profits数组代表每个项目的收益，Capital数组代表每个项目需要的启动资金。一个项目能做的条件是你当前的
    //       启动资金大于项目的启动资金。一个项目做完后，该项目的收益会加到你的启动资金上，求你能够获得的最大收益。
    //       要求时间复杂度为O(N * log N)
    /**
     * 
     * @param profits
     * @param capital
     * @param k 
     * @param w
     * @return
     */
    public static int getMaxProfit(int[] profits,int[] capital,int k,int w) {
    	return 0;
    }
    //工作类
    static class Worker implements Comparable<Worker>{
        public int difficulty;
        public int profit;
        Worker(int d,int p){
            this.difficulty = d;
            this.profit = p;
        }
		@Override
		public int compareTo(Worker o) {
			return o.difficulty;
		}
	
		@Override
		public String toString() {
			return "diffcults:" + this.difficulty + "  profits:"+this.profit;
		}
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Worker> priorityQueue = new PriorityQueue<>(new Comparator<Worker>() {

			@Override
			public int compare(Worker o1, Worker o2) {
				return o2.profit - o1.profit;
			}
		});
        for(int i = 0;i < difficulty.length;i++){
            priorityQueue.add(new Worker(difficulty[i],profit[i]));
        }
        int maxProfits = 0;
        for(int i = 0;i < worker.length;i++) {
        	PriorityQueue<Worker> PPQ = new PriorityQueue<>(new Comparator<Worker>() {

    			@Override
    			public int compare(Worker o1, Worker o2) {
    				return o2.profit - o1.profit;
    			}
    		});
        	
        	Iterator<Worker> iterator = priorityQueue.iterator();
        	while(iterator.hasNext()) {
        		Worker worker2 = iterator.next();
        		if (worker[i] >= worker2.difficulty) {
					PPQ.add(worker2);
				}
        	}
        	if (PPQ.peek() != null) {
        		maxProfits += PPQ.peek().profit;
			}
        	
        }
        return maxProfits;
    }
    
    
}