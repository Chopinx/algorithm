package string;

import com.sun.deploy.util.StringUtils;

/**
 * 解压字符串
 * 例如"bb12{efg}3{c3{e4{b2{tdds}}d}}ef"
 */
public class UnZipString {
    public String unZip(String str) {
        int headIndex, subHead = 0, endIndex = 0;
        while (endIndex < str.length())
        {
            if (str.charAt(endIndex) == '{') { subHead = endIndex; }
            if (str.charAt(endIndex) == '}')
            {
                while (subHead >= 0 && str.charAt(subHead) != '{') { subHead--; }
                if (subHead < 0) {
                    return "";
                }
                headIndex = subHead - 1;
                int times = 0, base = 1;
                while (headIndex >= 0 && isNum(str.charAt(headIndex)))
                {
                    times += base * (str.charAt(headIndex--) - '0');
                    base *= 10;
                }
                if (times == 0) {
                    return "";
                }
                headIndex++;
                str = str.substring(0, headIndex) + timesStr(str.substring(subHead + 1, endIndex), times)
                        + str.substring(endIndex + 1);
                endIndex = headIndex + (endIndex - subHead - 1) * times;
            }
            else { endIndex++; }
        }
        return str;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private String timesStr(String str, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++)
        {
            result.append(str);
        }
        return result.substring(0);
    }
}
