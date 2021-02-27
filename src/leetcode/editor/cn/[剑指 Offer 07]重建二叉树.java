package leetcode.editor.cn;
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 303 👎 0



class 重建二叉树{
	public static void main(String[] args) {
		Solution solution = new 重建二叉树().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)

  public class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;

	  TreeNode(int x) {
		  val = x;
	  }
  }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
				return get(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    //左闭右开 [ )
    public TreeNode get(int[] preorder, int[] inorder,int x1,int y1,int x2,int y2){
    	if(x1>y1||x2>y2||x1>=preorder.length||x2>=inorder.length)return null;
    	TreeNode head =new TreeNode(preorder[x1]);
		int index;
		for ( index= x2; index < y2; index++) if(inorder[index]==head.val) break;
		int leftnum=index-x2;
		head.left= get(preorder,inorder,x1+1,x1+1+leftnum,x2,index-1);
		head.right=get(preorder,inorder,x1+1+leftnum,y1,index+1,y2);
		return head;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}