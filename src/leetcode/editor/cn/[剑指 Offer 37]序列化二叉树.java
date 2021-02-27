package leetcode.editor.cn;
//请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/
// Related Topics 树 设计
// 👍 106 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class 序列化二叉树{
    public static void main(String[] args) {
        Solution solution = new 序列化二叉树().new Solution();

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


    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            ArrayList<String> res=new ArrayList<>();
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            for(;!queue.isEmpty();){
                TreeNode r=queue.poll();
                if(r!=null){
                    queue.offer(r.left);
                    queue.offer(r.right);
                    res.add(r.val+"");
                }
                else {
                    res.add("null");
                }
            }
            for(int i=res.size()-1;i>=0;i--){
                if(res.get(i) =="null")
                    res.remove(i);
                else
                    break;
            }
            return "["+String.join(",",res)+"]";
           // return "[1,2,3,null,null,4,5]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==2)return null;
            String s = data.substring(1,data.length()-1);
            String[] split = s.split(",");
            TreeNode res=new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(res);
            boolean f=true;
            TreeNode t=null;
            for(int i=1;i<split.length;i++){

                if(f){
                    t=queue.poll();
                    if(!split[i].equals("null")){
                        TreeNode temp=new TreeNode(Integer.parseInt(split[i]));
                        t.left=temp;
                        queue.offer(temp);
                    }
                    f=!f;
                }
                else{
                    if(!split[i].equals("null")){
                        TreeNode temp=new TreeNode(Integer.parseInt(split[i]));
                        t.right=temp;
                        queue.offer(temp);
                    }
                    f=!f;
                }
            }
            return res;
        }

//        public TreeNode bt(int i,String[] split){
//            if(i>=split.length) return null;
//            if(split[i].equals("null")) return null;
//            int v=Integer.parseInt(split[i]);
//            TreeNode t=new TreeNode(v);
//            if((i*2+1)<split.length)t.left=bt(i*2+1,split);
//            if((i*2+2)<split.length)t.right=bt(i*2+2,split);
//            return t;
//        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}