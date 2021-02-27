package leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 846 👎 0

import java.util.*;

class 二叉树的中序遍历{
	public static void main(String[] args) {
		Solution solution = new 二叉树的中序遍历().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<>();
		Stack<TreeNode> stack=new Stack<>();
		TreeNode r=root;
		for(;!stack.empty()||r!=null;){
			if(r!=null){
				stack.push(r);
				r=r.left;
			}else{
				TreeNode t=stack.pop();
				res.add(t.val);
				r=t.right;
			}
		}
		return res;
    }
    //同后序遍历
}class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
    	if(root==null)return new LinkedList<>();
		List<Integer> res=new ArrayList<>();
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		for(;!stack.empty();){
			TreeNode t=stack.pop();
			if(t==null){
				t=stack.pop();
				res.add(t.val);
				continue;
			}
			if(t.right!=null)stack.push(t.right);
			stack.push(t);
			stack.push(null);
			if(t.left!=null)stack.push(t.left);

		}
		return res;
    }
    //同后序遍历
}
//leetcode submit region end(Prohibit modification and deletion)

}