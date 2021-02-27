package leetcode.editor.cn;
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 176 👎 0

import java.util.*;

class 字符串的排列{
	public static void main(String[] args) {
		Solution solution = new 字符串的排列().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<String> res = new LinkedList<>();
	char[] c;
	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return res.toArray(new String[res.size()]);
	}
	void dfs(int x) {
		if(x == c.length - 1) {
			res.add(String.valueOf(c)); // 添加排列方案
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for(int i = x; i < c.length; i++) {
			if(set.contains(c[i])) continue; // 重复，因此剪枝
			set.add(c[i]);
			swap(i, x); // 交换，将 c[i] 固定在第 x 位
			dfs(x + 1); // 开启固定第 x + 1 位字符
			swap(i, x); // 恢复交换
		}
	}
	void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
}

//class Solution {
//	ArrayList<String> res=new ArrayList<>();
//	Map<Character,Integer> map=new HashMap<>();
//	StringBuilder s=new StringBuilder("");
//    public String[] permutation(String s) {
//		for (int i = 0; i < s.length(); i++) {
//			if(map.containsKey(s.charAt(i))){
//				map.put(s.charAt(i),map.get(s.charAt(i))+1);
//			}else{
//				map.put(s.charAt(i),1);
//			}
//		}
//		getRes();
//		return (String[])res.toArray();
//    }
//    public void getRes(){
//    	if(map.size()==0){
//    		res.add(s.toString());
//    		return ;
//		}
//		Set<Character> characters = new HashSet<Character>();
//		for (Character character : characters) {
//			int t=map.get(character);
//			if(t==1){
//				map.remove(character);
//			}
//			else{
//				map.put(character,t-1);
//			}
//			s.append(character);
//			map.put(character,t);
//		}
//	}
//}
//leetcode submit region end(Prohibit modification and deletion)

}