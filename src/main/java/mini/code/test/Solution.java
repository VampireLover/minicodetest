package mini.code.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xiaojun
 * @Date 2019/12/18  15:39
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("请输入一到两个数,以逗号隔开：");
        Scanner in = new Scanner(System.in);
        String[] values = null;
        values = in.next().split(",");
        Integer[] value = new Integer[values.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Integer.valueOf(values[i]);
        }
        System.out.println(s.letterCombinations(value));
    }

    private String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> slist = new ArrayList<String>();
    private char[] str = new char[1000];

    List<String> letterCombinations(Integer[] digits) {
        if (digits.length == 0) {
            return slist;
        }
        int len = digits.length;
        dFS(digits, 0, len);
        return slist;
    }

    void dFS(Integer[] d, int i, int len) {
        if (i == len) {
            char[] temp = str;
            String t = new String(temp);
            t = t.substring(0, i);
            slist.add(t);
            return;
        }
        int index = d[i];
        for (int j = 0; j < nums[index].length(); j++) {
            str[i] = nums[index].charAt(j);
            dFS(d, i + 1, len);
        }
    }
}

