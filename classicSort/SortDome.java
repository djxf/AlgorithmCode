

public class SortDome{
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,1,1,100,22,11};
        heapSort(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        for(int end = nums.length - 1;end > 0;end--){
            for(int i = 0;i < end;i++){
                if(nums[i] > nums[i + 1]){
                    swap(nums,i,i+1);
                }
            }
        }
    }
    /**
     * 选择排序
     * @param nums
     */
    public static void selectionSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        for(int i = 0;i < nums.length - 1;i++){
            int minIndex = i;
            for(int j = i + 1;j < nums.length;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
    /**
     * 插入排序
     * 最差时间复杂度 O(N^2) 当数组逆序时。
     * 最好时间复杂度 O(n^2) 当数组完全有序时。
     * @param nums
     */
    public static void insertSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        for(int i = 1;i < nums.length;i++){
            for(int j = i - 1;j >= 0 && nums[j] > nums[j + 1];j--){
                swap(nums, j, j + 1);
            }
        }
    }

    /**
     * 额外空间复杂度O(n),稳定排序
     * @param nums
     */
    public static void mergeSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        sortProcess(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序排序过程
     * @param arr 
     * @param l 要排序的左边下标
     * @param r 要排序的右边下标
     */
    public static void sortProcess(int[] arr,int l,int r){
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merger(arr, l, mid, r);
    }



    /**
     * 融合左右两个数组
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    public static void merger(int[] arr,int l,int m,int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; 
        }
        //考虑左右数组的越界
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        //复制回原数组
        for(i = 0;i < help.length;i++){
            arr[l + i] = help[i];
        }
    }

    /**
     * 交换数组中的两个数
     * 
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 三大排序：1 归并排序 2 快速排序 3 堆排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：1 归并排序 O(N) 2 快速排序 O(logN) 3 堆排序 O(1)
     */
    
    /**
     * 堆排序
     * @param nums
     */
    public static void heapSort(int[] nums) {
    	if(nums == null || nums.length < 2) {
    		return;
    	}
    	for(int i = 0;i < nums.length;i++) {
    		heapInsert(nums,i);
    	}
    	int size = nums.length;
    	swap(nums, 0, --size);
    	while(size > 0) {
    		heapify(nums,0,size);
    		swap(nums, 0, --size);
    	}
    }
    /**
     * 堆化操作
     * @param nums 堆结构数组
     * @param index 父节点序号
     * @param size 数组长度
     */
    private static void heapify(int[] nums, int index, int size) {
		 int left = 2 * index + 1;
		 while(left < size) {
			 int largest = left + 1 < size && nums[left + 1] > nums[left] ? left + 1 : left;
			 largest = nums[largest] > nums[index] ? largest : index;
			 //如果比子节点都大。则直接结束。
			 if(largest == index) {
				 break;
			 }
			 
			 //否则交换
			 swap(nums, largest, index);
			 index = largest;
			 left = index * 2 + 1;
		 }
		
	}

	/**
     * 对元素nums[i] 进行上升操作
     * @param nums
     * @param i
     */
	private static void heapInsert(int[] nums, int i) {
		while(nums[i] > nums[(i - 1) / 2]) {
			swap(nums, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
		
	}
}