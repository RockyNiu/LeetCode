package leetcode.java;

import java.util.Stack;

public class WordSearch {

	/**
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * 
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 * 
	 * For example, Given board =
	 * 	[	["ABCE"], 
	 * 		["SFCS"], 
	 * 		["ADEE"] ] 
	 * word = "ABCCED", -> returns true, 
	 * word = "SEE", -> returns true, 
	 * word = "ABCB", -> returns false.
	 */
	public static void main(String[] args) {
		String[] strs = {"ABCE","SFCS","ADEE"};
		int len = strs[0].length();
		char[][] board = new char[strs.length][len];
		for (int i = 0; i < strs.length; i++) {
			String string = strs[i];
			board[i] = string.toCharArray();
		}
		String word = "ABCCED";
		Solution079 solution = new Solution079();
		System.out.println(solution.exist(board, word));
	}

}

class Solution079{
	public boolean exist(char[][] board, String word) {
        if(board.length==0){
        	return false;
        }
		if (word.isEmpty()){
        	return true;
        }
        
		int Y = board.length;
		int X = board[0].length;
		boolean[][] used = new boolean[Y][X];
		Stack<int[]> first = new Stack<int[]>();
		Stack<int[]> stack = new Stack<int[]>();
		// find the first position
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (board[i][j] == word.charAt(0)){
					first.push(new int[]{i,j,0});
				}
			}
		}
		if (first.isEmpty()) {
			return false;
		}
		
		while (!first.isEmpty()){
			int[] pos = first.pop();
			int index = 1;
			stack.push(pos);
			used[pos[0]][pos[1]] = true;
			while (!stack.isEmpty() && index < word.length()) {
				int[] pre = stack.pop();
				int x = pre[1];
				int y = pre[0];
				used[y][x] = false;
				
				pre[2] = pre[2]+1;
				char c = word.charAt(index);
				switch (pre[2]){
					//left
					case 1:
						x = x - 1;
						if (x<0 || used[y][x] || board[y][x] != c){
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
						}
						else{
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
							int[] insert = new int[]{y,x,0};
							stack.push(insert);
							used[y][x] = true;
							index++;
						}
						break;
						
					//right
					case 2:
						x = x + 1;
						if (x>=X || used[y][x] || board[y][x] != c){
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
						}
						else{
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
							int[] insert = new int[]{y,x,0};
							stack.push(insert);
							used[y][x] = true;
							index++;
						}
						break;
					
					//up
					case 3:
						y = y - 1;
						if (y<0 || used[y][x] || board[y][x] != c){
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
						}
						else{
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
							int[] insert = new int[]{y,x,0};
							stack.push(insert);
							used[y][x] = true;
							index++;
						}
						break;
						
					//down
					case 4:
						y = y + 1;
						if (y>=Y || used[y][x] || board[y][x] != c){
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
						}
						else{
							stack.push(pre);
							used[pre[0]][pre[1]] = true;
							int[] insert = new int[]{y,x,0};
							stack.push(insert);
							used[y][x] = true;
							index++;
						}
						break;
						
					case 5:
						index--;
						break;
				}
				
			}
			if (!stack.isEmpty()){
				return true;
			}
		}
		return false;
	}
}