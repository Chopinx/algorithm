package algorithm.dp;

import java.util.function.BiFunction;

import static java.lang.Integer.max;

/**
 * Created by Chopin
 * Description: 有一组高度不定的砖块，用于搭建两个塔，求解合适的搭建方式使得两个塔等高
 * Date: 2017/8/30
 * Time: 11:22
 */
public class AccordantTower {
    /**
     * 等高塔
     *
     * @param array 砖块的高度
     * @return 如果可以搭建等高的两个塔则返回最大高度，否则返回-1
     */
    public int accordantTower(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int sum = 0;
        for (int elem : array) {
            if (elem <= 0) {
                throw new RuntimeException("The elem in array must  no-negative number!");
            }
            sum += elem;
        }
        final int DIF_SIZE = sum * 2 + 1;
        int[][] dp = new int[array.length][DIF_SIZE];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < DIF_SIZE; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < DIF_SIZE; j++) {
                int h1 = 0, h2 = 0;
                if (j - array[i] >= 0 && dp[i][j - array[i]] >= 0) {
                    //在1塔增加砖块
                    if (j - sum - array[i] >= 0) {
                        //在加之前塔1高于塔2
                        h1 = dp[i][j - array[i]] + array[i];
                    } else {
                        //在加之前塔1不高于塔2
                        int oldDif = j - sum - array[i];
                        h1 = dp[i][j - array[i]] + array[i] + oldDif;
                    }
                }
                if (j + array[i] < DIF_SIZE && dp[i][j + array[i]] >= 0) {
                    //在2塔增加砖块
                    if (j - sum + array[i] >= 0) {
                        //在加之前塔1高于塔2
                        int oldDif = j - sum + array[i];
                        h2 = dp[i][j + array[i]] + array[i] - oldDif;
                    } else {
                        //在加之前塔1不高于塔2
                        h2 = dp[i][j + array[i]] + array[i];
                    }
                }
                dp[i + 1][j] = max(dp[i][j], max(h1, h2));
            }
        }
        return dp[array.length][sum] > 0 ? dp[array.length][sum] : -1;
    }
}
