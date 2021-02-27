package leetcode.editor.cn;
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 68 👎 0

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

class 从上到下打印二叉树III{
	public static void main(String[] args) {
		Solution solution = new 从上到下打印二叉树III().new Solution();
		
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
		boolean flag=true;
		if(root==null) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue= new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		List<Integer> list=new ArrayList<>();
		for(;;){
			TreeNode t=queue.poll();
			if(t==null){
				if(!flag)
					Collections.reverse(list);
					flag=!flag;
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