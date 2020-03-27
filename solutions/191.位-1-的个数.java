/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
// public class Solution {
//     public int hammingWeight(int n) {
//         int cnt = 0;
//         while (n != 0) {
//             n &= (n - 1);
//             cnt ++;
//         }
//         return cnt;
//     }
// }
public class Solution {
    public int hammingWeight(int n ) {
        return n == 0 ? 0 : hammingWeight(n & (n - 1)) + 1;
    }
}
// @lc code=end

