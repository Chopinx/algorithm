package algorithm.number;

import java.util.Vector;

/**
 * Created by Chopin
 * Description: TODO
 * Date: 2017/9/8
 * Time: 10:11
 */
public class PalindromeInt {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x, count = 0;
        while (tmp > 0) {
            tmp /= 10;
            count++;
        }
        for (int i = 0; i < count / 2; i++) {
            if (getDigit(x, i) != getDigit(x, count - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private int getDigit(int number, int index) {
        for (int i = 0; i < index; i++) {
            number /= 10;
        }
        return number % 10;
    }
}
