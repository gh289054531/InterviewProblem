/**
 * http://www.cnblogs.com/dolphin0520/archive/2011/08/24/2151846.html
 */
public class KMP {

	public static int KMPMatcher(char[] s, char[] p) {
		assert s != null;
		assert p != null;
		int[] next = new int[p.length];
		GetNext(p, next);
		int i = 0, j = 0;
		while (i < s.length) {
			if (j == -1 || s[i] == p[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
			if (j == p.length) {
				return i - p.length;
			}
		}
		return -1;
	}

	private static void GetNext(char[] p, int[] next) {
		int i, j, temp;
		for (i = 0; i < p.length; i++) {
			if (i == 0) {
				next[i] = -1;
			} else if (i == 1) {
				next[i] = 0;
			} else {
				temp = i - 1;
				for (j = temp; j > 0; j--) {
					if (Equal(p, i, j) == true) {
						next[i] = j;
						break;
					}
				}
				if (j == 0) {
					next[i] = 0;
				}
			}
		}
	}

	private static boolean Equal(char[] p, int i, int j) {
		int m = 0, n = i - j;
		while (m < j) {
			if (p[m] == p[n]) {
				m++;
				n++;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = "ababcababa".toCharArray();
		char[] p = "ababa".toCharArray();
		System.out.println(KMPMatcher(s, p));
	}

}
