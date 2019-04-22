package com.wong.leetcode;

/**
 *
   *    暴力破解 
   *    执行用时 : 419 ms, 在Longest Palindromic Substring的Java提交中击败了19.07% 的用户 内存消耗 : 284.7 MB,
   *     在Longest PalindromicSubstring的Java提交中击败了8.88% 的用户
 * @author weien
 *
 */
public class Q005 {
	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		String reverse = new StringBuilder(s).reverse().toString();
		int maxlen = 1;
		String substr = s.charAt(0) + "";
		int count = 0;
		for (int i = 0; i < s.length(); ++i) {
			for (int j = 0; j < s.length() - i - maxlen; ++j) { // 当i与j直接的字符串长度已小于上一个已验证的子串长度就没必要再比较了
				if (s.charAt(i) == reverse.charAt(j) //首字符不一样肯定不是回文
						&& s.substring(i, s.length() - j - 1).equals(reverse.substring(j, s.length() - i - 1))) {
					if (s.length() - i - j > maxlen) {
						maxlen = s.length() - i - j;
						substr = s.substring(i, s.length() - j);
					}
				}
				++count;
			}
		}
		System.out.println(count);
		return substr;
	}

	public static void main(String[] args) {
//		String str = "baba";
//		String str = "add";
		String str = "whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeefsdfsdfsdfsdfbxbzxcbvcbzxcbxvzxvzxcvcpntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
		System.out.println(longestPalindrome(str));
	}
}
