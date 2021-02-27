package leetcode.editor.cn;
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回：
//
// [3,9,20,15,7]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索
// 👍 58 👎 0

import java.util.*;

class 从上到下打印二叉树{
	public static void main(String[] args) {
		Solution solution = new 从上到下打印二叉树().new Solution();

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
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	class Solution {
		public int[] levelOrder(TreeNode root) {
			if(root==null) return new int[0];
			Queue<TreeNode> queue=new LinkedList<TreeNode>();
			int[] res=new int[1009];
			int l=0;
			for(queue.add(root);!queue.isEmpty();){
				TreeNode t=queue.poll();
				if(t.left!=null)queue.add(t.left);
				if(t.right!=null)queue.add(t.right);
				res[l++]=t.val;
			}
			return Arrays.copyOf(res,l);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}