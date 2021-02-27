package leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 515 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class 二叉树的后序遍历{
	public static void main(String[] args) {
		Solution solution = new 二叉树的后序遍历().new Solution();
		
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
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root==null) return new LinkedList<>();
		List<Integer> res= new ArrayList<>();
		Stack<TreeNode> stack=new Stack<>();
		TreeNode r=root,pre=null;
		for(;!stack.empty()||pre==null;){ //栈不为空 pre代表前一个输出的节点（pre==null 仅为正确进入第一次循环）
			if(r!=null){//如果r不为空则一直向左入栈
				stack.push(r);
				r=r.left;
			}
			else {
				TreeNode t=stack.pop();
				if(t.right!=null&&t.right!=pre){//如果右子树不空并且右子树也没有被输出（t.right!=pre） 则开始遍历此右子树（）
					r=t.right;//会走上面的循环把左输出
					stack.push(t);
				}else{
					res.add(t.val);//如果右子树已输出，则开始输出根节点 。
					pre=t;
				}
			}
		}
		return res;
		//总结就是 中序和后续都是先用指针把左子树走到底。但是后序需要记录pre（上一个输出的节点）来判断stack弹出的根节点是否被输出
    }
}class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root==null) return new LinkedList<>();
		List<Integer> res= new ArrayList<>();
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		for(;!stack.empty();){
			TreeNode t=stack.pop();
			if(t!=null){
				stack.push(t);
				stack.push(null);
				if(t.right!=null)stack.push(t.right);
				if(t.left!=null)stack.push(t.left);
			}
			else{
				t=stack.pop();
				res.add(t.val);
			}
		}
		return res;
		//学习自代码随想录，使用null来标记已经走过的节点
		//值得注意的是，后序为左右根 则入栈顺序变为根右左，简单易懂
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}