package jianzhioffer.step15;

/**
 * 方法 1：循环和位移动
 * 这个方法比较直接。我们遍历数字的 32 位。如果某一位是 11 ，将计数器加一。
 *
 * 我们使用 位掩码 来检查数字的第 i^{th}i
 * th
 *   位。一开始，掩码 m=1m=1 因为 11 的二进制表示是
 *
 * 0000\ 0000\ 0000\ 0000\ 0000\ 0000\ 0000\ 0001
 * 0000 0000 0000 0000 0000 0000 0000 0001
 *
 * 显然，任何数字跟掩码 11 进行逻辑与运算，都可以让我们获得这个数字的最低位。检查下一位时，我们将掩码左移一位。
 *
 * 0000\ 0000\ 0000\ 0000\ 0000\ 0000\ 0000\ 0010
 * 0000 0000 0000 0000 0000 0000 0000 0010
 *
 * 并重复此过程。
 *
 *
 *方法二：巧用 n & (n - 1)
 *(n−1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，此 11 右边的 00 都变成 11 。
 * n &(n - 1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，其余不变。
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int targe = 1;
        for(int i = 0; i < 32; i++){
            if((targe&n) != 0){
                res++;
            }
            targe <<= 1;
        }

        return res;
    }
}
