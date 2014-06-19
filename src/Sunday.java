import java.util.Arrays;

public class Sunday {

	public static int SundayMatch(char[] s, char[] t) {
		if (s == null || t == null || s.length < t.length) {
			return -1;
		}
		if (t.length == 0) {
			return 0;
		}
		int[] move = new int[256];// 限定只有256个ASCII字符
		Arrays.fill(move, -1);
		for (int i = t.length - 1; i >= 0; i--) {
			if (move[(int) t[i] - 1] == -1) {
				move[(int) t[i] - 1] = t.length - 1 - i + 1;
			}
		}
		int i = 0, j = 0;
		int start = 0;
		while (i < s.length) {
			if (s[i] == t[j]) {
				i++;
				j++;
				if (j == t.length) {
					return start;
				}
			} else {
				if (start + t.length >= s.length) {
					return -1;
				}
				if (move[(int) s[start + t.length] - 1] == -1) {
					start += t.length;
					i = start;
					j = 0;
				} else {
					start += move[(int) s[start + t.length] - 1];
					i = start;
					j = 0;
				}
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SundayMatch("OURSTRONGXSEARCH".toCharArray(), "SEARCH".toCharArray()));
		System.out.println(SundayMatch("substring searching algorithm".toCharArray(), "search".toCharArray()));
		System.out.println(SundayMatch("substring searching algorithm".toCharArray(), "algorithm".toCharArray()));
		System.out.println(SundayMatch("s".toCharArray(), "".toCharArray()));
		System.out.println(SundayMatch("s".toCharArray(), "s".toCharArray()));
		System.out.println(SundayMatch("substring".toCharArray(), "substring".toCharArray()));
		System.out.println(SundayMatch("".toCharArray(), "".toCharArray()));
		System.out.println(SundayMatch("abc".toCharArray(), "de".toCharArray()));
	}

}
