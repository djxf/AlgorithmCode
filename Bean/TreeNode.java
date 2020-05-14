package Bean;

/**
 * 自定义树
 * @author 斗酒相逢
 *
 */
public class TreeNode {
	
	public TreeNode() {
		super();
	}
	public TreeNode(TreeNode left, TreeNode right, int value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}
	TreeNode(int value){
		this.value = value;
	}
	public TreeNode left;
	public TreeNode right;
	int value;
}
