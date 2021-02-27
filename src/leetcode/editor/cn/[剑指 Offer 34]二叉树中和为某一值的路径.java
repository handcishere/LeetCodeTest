package leetcode.editor.cn;
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 124 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 二叉树中和为某一值的路径{
	public static void main(String[] args) {
		Solution solution = new 二叉树中和为某一值的路径().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
	List<List<Integer>> result=new ArrayList<>();
	List<Integer> path=new ArrayList<>();
	int s=0,target=-1;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if(root==null)return new ArrayList<>();
		target=sum;
		getPath(root);
		return result;
    }
    void getPath(TreeNode root){
    	s+=root.val;
    	path.add(root.val);
    	if(target==s&&root.left==null && root.right==null) {
			result.add(new ArrayList<>(path));
		}
    	else{
    		if(root.left!=null)getPath(root.left);
    		if(root.right!=null)getPath(root.right);
		}
    	path.remove(path.size()-1);
		s-=root.val;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}