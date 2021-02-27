package leetcode.editor.cn;
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 233 👎 0

class 矩阵中的路径{
	public static void main(String[] args) {
		Solution solution = new 矩阵中的路径().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
    	boolean[][] v=new boolean[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]==word.charAt(0)){
					if(judge(board,word,i,j,0))
						return true;
				}
			}
		}
		return false;
    }
    //n已经找到 找n+1
    public boolean judge(char[][] board, String word, int x, int y,int n){
    	if(n==word.length()-1) return true;
    	boolean flag=false;


    	//下
    	if(x+1<board.length&&board[x+1][y]==word.charAt(n+1)){
			board[x][y]='#';
			if(judge(board,word,x+1,y,n+1)) {
				board[x][y] = word.charAt(n);
				return true;
			}
			board[x][y]=word.charAt(n);
		}
		//左
		if(y-1>=0&&board[x][y-1]==word.charAt(n+1)){
			board[x][y]='#';
			if(judge(board,word,x,y-1,n+1)) {
				board[x][y] = word.charAt(n);
				return true;
			}
			board[x][y]=word.charAt(n);
		}
		//上
		if(x-1>=0&&board[x-1][y]==word.charAt(n+1)){
			board[x][y]='#';
			if(judge(board,word,x-1,y,n+1)==true) {
				board[x][y] = word.charAt(n);
				return true;
			}
			board[x][y] = word.charAt(n);
		}

    	//右
    	if(y+1<board[0].length&&board[x][y+1]==word.charAt(n+1)){
			board[x][y]='#';
			if(judge(board,word,x,y+1,n+1)) {
				board[x][y]=word.charAt(n);
				return true;
			}
			board[x][y]=word.charAt(n);
		}

    	return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}