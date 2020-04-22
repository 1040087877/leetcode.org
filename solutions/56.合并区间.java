import java.util.*;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (i1, i2) -> {
//             return i1[0] - i2[0];
//         });
//         int[][] merge = new int[intervals.length][];
//         int length = 0;
//         for (int[] pair : intervals) {
//             if (length == 0 || merge[length - 1][1] < pair[0])
//                 merge[length++] = pair;
//             else
//                 merge[length - 1][1] = Math.max(merge[length - 1][1], pair[1]);
//         }
//         int[][] res = new int[length][];
//         System.arraycopy(merge, 0, res, 0, length);
//         return res;
//     }
// }


// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//         ArrayList<int[]> ints = new ArrayList<>();
//         for (int i = 0; i < intervals.length; i++) {
//             int min = intervals[i][0], max=intervals[i][1];
//             while (i < intervals.length - 1 && max >= intervals[i + 1][0] )
//                 max = Math.max(max, intervals[++ i][1]);
//             ints.add(new int[]{min, max});
//         }
//         return ints.toArray(new int[ints.size()][2]);
//     }
// }

// @lc code=start
// @date Apr 16 2020
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i ++) {
            int head = intervals[i][0], tail = intervals[i][1];
            while (i < intervals.length - 1 && tail >= intervals[i + 1][0]) 
                tail = Math.max(tail, intervals[++i][1]);
            res.add(new int[]{head, tail});
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

