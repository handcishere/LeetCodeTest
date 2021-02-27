package leetcode.editor.cn;
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 112 👎 0

class 数值的整数次方{
	public static void main(String[] args) {
		Solution solution = new 数值的整数次方().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
    	if(x==0)return 0;
    	long tn=n;
    	double tx=x;
    	double res=1;
    	if(n<0){
    		tx=1/tx;
    		tn=-tn;
		}
    	for(;tn>0;){
    		if((tn&1)==1)
    			res*=tx;
    		tx*=tx;
    		tn>>=1;
		}
    	return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}