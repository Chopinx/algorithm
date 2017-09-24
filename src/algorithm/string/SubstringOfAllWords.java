package algorithm.string;

//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//        For example, given:
//        s: "barfoothefoobarman"
//        words: ["foo", "bar"]
//
//        You should return the indices: [0,9].
//        (order does not matter).

import java.util.List;

/**
 * Created by Chopin
 * Description: TODO
 * Date: 2017/9/8
 * Time: 11:09
 */
public class SubstringOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int[] array = new int[words.length];
        return null;
    }

    private void reset(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }
}
