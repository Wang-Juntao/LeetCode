package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐(难度：困难)
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 说明:
 * 
 * 单词是指由非空格字符组成的字符序列。 每个单词的长度大于 0，小于等于 maxWidth。 输入单词数组 words 至少包含一个单词。
 * 
 * 示例:
 * 
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16 输出: [ "This is an", "example of text", "justification. " ]
 * 
 * 示例 2:
 * 
 * 输入: words = ["What","must","be","acknowledgment","shall","be"] maxWidth = 16
 * 输出: [ "What must be", "acknowledgment ", "shall be " ] 解释: 注意最后一行的格式应为 "shall
 * be " 而不是 "shall be", 因为最后一行应为左对齐，而不是左右两端对齐。 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 
 * 示例 3:
 * 
 * 输入: words =
 * ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"] maxWidth = 20
 * 输出: [ "Science is what we", "understand well", "enough to explain to", "a
 * computer. Art is", "everything else we", "do " ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q068 {
	
	//实际就是文本编辑器的一个必备功能，在宽度改变后自动重排
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int pos = 0;
		while (pos < words.length) {
			int count = 0;
			int end = pos - 1;
			// 贪心算法，先竟可能多的加入单词（不考虑空格），然后再调整
			while (count <= maxWidth && ++end < words.length) {
				count = count + words[end].length();
			}
			// 边界处理
			if (end >= words.length) {
				end = words.length - 1;
			}
			// 看在插入空格的情况下，是否会超长，如果超长，则往前后退一个单词
			while (count + end - pos > maxWidth) {
				count -= words[end].length();
				end--;
			}
			StringBuilder sb = new StringBuilder();
			if (end > pos && end < words.length - 1) {// 多余一个单词且不是最后一行
				int spaces = maxWidth - count;// 总共需要插入的空格数
				int average = spaces / (end - pos);
				int remainder = spaces % (end - pos);
				for (int i = pos; i <= end; i++) {
					sb.append(words[i]);
					if (i != end) {
						for (int j = 0; j < average + (remainder > 0 ? 1 : 0); j++) {
							sb.append(" ");
						}
					}
					remainder--;
				}
			} else {
				int spaces = maxWidth - count - (end - pos);
				for (int i = pos; i <= end; i++) {
					sb.append(words[i]);
					if (i != end) {
						sb.append(" ");
					}
				}
				for (int i = 0; i < spaces; i++) {
					sb.append(" ");
				}
			}
			res.add(sb.toString());
			pos = end + 1;
		}
		return res;
	}

	public static void main(String[] args) {
//		String[] words = new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
//				"to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" };
		String[] words = new String[] { "What" };
		List<String> res = new Q068().fullJustify(words, 2);
		res.forEach(System.out::println);
	}

}
