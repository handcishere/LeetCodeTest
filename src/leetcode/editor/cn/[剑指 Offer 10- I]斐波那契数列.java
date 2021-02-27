package leetcode.editor.cn;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 95 👎 0

import java.util.TreeMap;

class 斐波那契数列{
	public static void main(String[] args) {
		Solution solution = new 斐波那契数列().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		TreeMap<Integer,Integer> dic=new TreeMap();
    public int fib(int n) {
		int f0=0,f1=1;
		if(n==0)return f0;
		if(n==1)return f1;
		int n1,n2;
		if(dic.containsKey(n-1)) n1=dic.get(n-1);
		else n1=fib(n-1);
		if(dic.containsKey(n-2)) n2=dic.get(n-2);
		else n2=fib(n-2);
		int res=(n1+n2)%1000000007;
		dic.put(n,res);
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}