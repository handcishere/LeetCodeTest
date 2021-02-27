package leetcode.editor.cn;
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 78 👎 0

class 打印从1到最大的n位数{
	public static void main(String[] args) {
		Solution solution = new 打印从1到最大的n位数().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		StringBuilder s=new StringBuilder("");
		StringBuilder res=new StringBuilder("");
    public int[] printNumbers(int n) {
//		double v = Math.pow(10, n);
//		int[] res=new int[(int) (v-1)];
//		for (int i = 0; i < res.length; i++) {
//			res[i]=i+1;
//		}
//		return res;
		sS(n);
		res.deleteCharAt(res.length()-1);
		System.out.println(res.toString());
		return null;
	}
	public void sS(int n){
    	if(n==0) {
    		if(s.length()!=0) {
				res.append(s);
				res.append(',');
			}
			return ;
		}
		for (int i = 0; i < 10; i++) {
			if(i!=0||s.length()!=0) {
				//System.out.println((char)('0' + i));
				s.append((char)('0' + i));
			}
			sS(n-1);
			if(s.length()!=0)
				s.deleteCharAt(s.length()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}