package leetcode.editor.cn;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 89 👎 0

import java.util.*;

class 从尾到头打印链表 {
	public static void main(String[] args) {
		Solution solution = new 从尾到头打印链表().new Solution();

	}


	class Solution {
		public class ListNode {
			Stack<ListNode> stack= new Stack<ListNode>();
			int val;
			ListNode next;

			ListNode(int x) {
				val = x;
			}


			Deque<Integer> d = new LinkedList<>();
			int[] res;
			int i = 0;
			int j = 0;

			public int[] reversePrint(ListNode head) {
				solve(head);
				return res;
			}

			public void solve(ListNode head) {
				if (head == null) {
					res = new int[i];
					return;
				}
				i++;
				solve(head.next);
				res[j] = head.val;
				j++;
			}
		}
//leetcode submit region end(Prohibit modification and deletion)

	}
}