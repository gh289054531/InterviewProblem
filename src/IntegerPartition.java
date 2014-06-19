import java.util.ArrayList;

/**
 * 整数划分问题是算法中的一个经典命题之一，有关这个问题的讲述在讲解到递归时基本都将涉及。所谓整数划分，是指把一个正整数n写成如下形式：
 * 
 * n=m1+m2+...+mi; （其中mi为正整数，并且1 <= mi <= n），则{m1,m2,...,mi}为n的一个划分。
 * 
 * 如果{m1,m2,...,mi}中的最大值不超过m，即max(m1,m2,...,mi)<=m，则称它属于n的一个m划分。这里我们记n的m划分的个数为f(
 * n,m);
 * 
 * http://www.cnblogs.com/hoodlum1980/archive/2008/10/11/1308493.html
 */
public class IntegerPartition {

	public static int DFS(int n, int m) {
		if (n == 1 || m == 1) {
			return 1;
		}
		if (n < m) {
			return DFS(n, n);
		}
		if (n == m) {
			return 1 + DFS(n, m - 1);
		}
		if (n > m) {
			return DFS(n - m, m) + DFS(n, m - 1);
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		System.out.println(DFS(6, 6));
	}

}
