package leetcode.editor.cn;
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 75 👎 0

import java.util.*;

class 从上到下打印二叉树II{
	public static void main(String[] args) {
		Solution solution = new 从上到下打印二叉树II().new Solution();
		
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
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root==null) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue= new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		List<Integer> list=new ArrayList<>();
		for(;;){
			TreeNode t=queue.poll();
			if(t==null){
				result.add(list);
				if(queue.isEmpty())break;
				list=new ArrayList<>();
				queue.offer(null);
			}
			else{
				if(t.left!=null)queue.offer(t.left);
				if(t.right!=null)queue.offer(t.right);
				list.add(t.val);
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}