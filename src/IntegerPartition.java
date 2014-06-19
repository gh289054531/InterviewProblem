import java.util.ArrayList;

/**
 * ���������������㷨�е�һ����������֮һ���й��������Ľ����ڽ��⵽�ݹ�ʱ���������漰����ν�������֣���ָ��һ��������nд��������ʽ��
 * 
 * n=m1+m2+...+mi; ������miΪ������������1 <= mi <= n������{m1,m2,...,mi}Ϊn��һ�����֡�
 * 
 * ���{m1,m2,...,mi}�е����ֵ������m����max(m1,m2,...,mi)<=m�����������n��һ��m���֡��������Ǽ�n��m���ֵĸ���Ϊf(
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
