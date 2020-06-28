package jianzhioffer.step12;


import java.util.Base64;

/**
 * 每个字符存在左、右、上、下四种选择
 * 如果下一步不满足条件、回溯到上一步
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, 0,j, i)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int level, int colu, int row) {
        //判断是否越界
        if (row < 0 || row > board.length - 1
                || colu < 0 || colu > board[0].length - 1
        ) {
            return false;
        }
        char ch = word.charAt(level);
        //判断当前坐标是否相等
        if (ch != board[row][colu]) {
            return false;
        }

        //达到层级
        if (level == word.length() - 1) {
            return true;
        }

        //记录当前位置已经被访问
        char temp = board[row][colu];
        board[row][colu] = '/';
        boolean exist =
                //上
                dfs(board, word, level + 1,  colu, row - 1)
                        //下
                        ||
                        dfs(board, word, level + 1,  colu, row + 1)
                        //左
                        ||
                        dfs(board, word, level + 1,  colu - 1, row)
                        ||
                        //右
                        dfs(board, word, level + 1,  colu + 1, row);

        //reverse status
        board[row][colu] = temp;
        return exist;
    }


}
