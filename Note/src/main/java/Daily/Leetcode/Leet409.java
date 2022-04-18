package Daily.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/4/18 14:25
 */

public class Leet409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
    static public int longestPalindrome(String s) {
        int flag = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()+1);
            if (entry.getValue()%2==1) flag = 1;
            ans = ans + entry.getValue() / 2;
        }
        return ans*2+flag;
    }

}
