package com.wong.leetcode;

public class Q010 {
	
	public static boolean isMatch(String s, String p) {
		if(p.indexOf("*") < 0 && p.indexOf(".") < 0) {
			return s.equals(p);
		}
		if(p.equals(".*")) {
			return true;
		}
		int pidx = 0;
		int sidx = 0;
		while (pidx < p.length() && sidx < s.length()) {
			char cp = p.charAt(pidx);
			if (pidx < p.length() - 1 && p.charAt(pidx + 1) == '*') {
				// a*  or .* 
				while (sidx < s.length() && (s.charAt(sidx) == cp || cp == '.')) {
					sidx++;
				}
				pidx = pidx + 2;
			} else if (cp == '.' || s.charAt(sidx) == p.charAt(pidx)) {
				sidx++;
				pidx++;
			} else {
				return false;
			}
		}
		return sidx == s.length() && pidx == p.length();
	}
	
	public static boolean isMatch_Right(String s, String p) {
		if(p.indexOf("*") < 0 && p.indexOf(".") < 0) {
			return s.equals(p);
		}
		if(p.equals(".*")) {
			return true;
		}
		int pidx = p.length() - 1;
		int sidx = s.length() - 1;
		while (pidx >= 0 && sidx >= 0) {
			char cp = p.charAt(pidx);
			if(cp =='*') {
				--pidx;
				cp = p.charAt(pidx);
				while (sidx >=0 && (s.charAt(sidx) == cp || cp == '.')) {
					--sidx;
				}
			}else if (cp == '.' || s.charAt(sidx) == p.charAt(pidx)) {
				--sidx;
				--pidx;
			} else {
				return false;
			}
		}
		return sidx == -1 && pidx == -1;
	}
	
	public static boolean isMatch_(String s, String p) {
		if(p.indexOf("*") < 0 && p.indexOf(".") < 0) {
			return s.equals(p);
		}
		if(p.equals(".*")) {
			return true;
		}
		
		
		int pidx = p.length() - 1;
		int sidx = s.length() - 1;
		while (pidx >= 0 && sidx >= 0) {
			char cp = p.charAt(pidx);
			if(cp =='*') {
				--pidx;
				cp = p.charAt(pidx);
				while (sidx >=0 && (s.charAt(sidx) == cp || cp == '.')) {
					--sidx;
				}
			}else if (cp == '.' || s.charAt(sidx) == p.charAt(pidx)) {
				--sidx;
				--pidx;
			} else {
				return false;
			}
		}
		return sidx == -1 && pidx == -1;
	}
	
	public static boolean isMatch_sys(String s, String p) {
		return s.matches(p);
	}
	
	
	public static void main(String[] args) {
		System.out.println(isMatch("dfsdfdsfsdabc",".*abc"));
		System.out.println(isMatch_sys("aa","a*aaaa*"));
		System.out.println(isMatch_sys("dfsdfdsfsdabb",".*abc"));
		System.out.println(isMatch_sys("dfsdfdsfsdabc",".*abc"));
	}

}
