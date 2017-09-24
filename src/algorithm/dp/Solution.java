package algorithm.dp;

/**
 * Created by Chopin
 * Description: TODO
 * Date: 2017/9/11
 * Time: 20:32
 */
public class Solution {
    public int solue(int a, int b, int cash, int[][] horro, int[][] yyy){
        double max = 0;
        int maxh = -1, maxy = -1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (horro[i][1] + yyy[j][1] <= cash){
                    double x = (double)(horro[i][0] + yyy[i][0]) / (horro[i][1] + yyy[i][1]);
                    if (x > max){
                        maxh = i;
                        maxy = j;
                        max = x;
                    }
                }
            }
        }
        if (max <= 0){
            return -1;
        }
    }
}
