package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 22. 括号生成
 * 
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 */
public class Q022 {

	public static List<String> generateParenthesis(int n) {
		if(n==0) return null;
		if(n == 1) return Arrays.asList("()");
		Set<String> set = new HashSet<>();
		List<String> child = generateParenthesis(n-1);
		set.addAll(child.stream().map(x->"("+x+")").collect(Collectors.toSet()));
		set.addAll(child.stream().map(x->x+"()").collect(Collectors.toSet()));
		set.addAll(child.stream().map(x->"()"+x).collect(Collectors.toSet()));
		List<String> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}
	
	public static List<String> generateParenthesis_gf(int n) {
		List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis_gf(c))
                    for (String right: generateParenthesis_gf(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static  void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static  boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
	
	public static void main(String[] args) {
			List<String> list = generateParenthesis_gf(4);
//			List<String> ank = Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
			System.out.println(list.size());
			System.out.println(list);
//			for(String  a : ank) {
//				if(!list.contains(a)) {
//					System.out.println(a);
//				}
//			}
	
	}

}
