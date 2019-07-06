package com.wong.leetcode.Q001_100;

/**
 * 67. 二进制求和 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1" 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011" 输出: "10101"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q067 {

	public String addBinary(String a, String b) {
		int p = a.length() - 1;
		int q = b.length() - 1;
		char[] tmp = new char[p>q ? p+2 : q+2];
		int delta = 0;
		int pos = tmp.length - 1;
		while (p >= 0 || q >= 0) {
			int ia = p >= 0 ? a.charAt(p) - '0' : 0;
			int ib = q >= 0 ? b.charAt(q) - '0' : 0;
			int res = ia + ib + delta;
			delta = res / 2;
			tmp[pos] =  (char) (( res % 2 ) + '0');
			p--;
			q--;
			pos--;
		}
		if(delta > 0) {
			tmp[0] = '1';
			return new String(tmp);
		}else {
			return new String(tmp,1,tmp.length-1);
		}
	}
	
	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(new Q067().addBinary(a, b));
	}

}
