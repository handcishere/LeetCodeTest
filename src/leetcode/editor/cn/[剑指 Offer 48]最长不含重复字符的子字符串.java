package leetcode.editor.cn;
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 154 👎 0

import java.util.HashSet;
import java.util.Set;

class 最长不含重复字符的子字符串{
	public static void main(String[] args) {
		Solution solution = new 最长不含重复字符的子字符串().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int max=0;
		int n=0;
		Set<Character> characterSet=new HashSet<>();
		int i=0,j=0;
		for(;j<s.length();){
			//System.out.println(j);
			if(!characterSet.contains(s.charAt(j))){
				characterSet.add(s.charAt(j));
				j++;
				n++;
			}
			else{
				for(;s.charAt(i)!=s.charAt(j) && i<s.length();i++){
				//	System.out.println(i);
					characterSet.remove(s.charAt(i));
					n--;
				}
				characterSet.remove(s.charAt(i));
				n--;
				i++;
			}
			max=Math.max(max,n);
		}
		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}