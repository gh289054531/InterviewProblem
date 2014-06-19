import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * 快速排序的非递归实现
 */
public class QuicksortNonRecursion {

	public static <T extends Comparable<? super T>> void Quicksort(T[] input) {
		assert input != null;
		if (input.length < 2) {
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(input.length - 1);
		while (stack.isEmpty() == false) {
			int right = stack.pop();
			int left = stack.pop();
			int pivotIndex = Partition(input, left, right);
			if (pivotIndex - 1 > left) {
				stack.push(left);
				stack.push(pivotIndex - 1);
			}
			if (pivotIndex + 1 < right) {
				stack.push(pivotIndex + 1);
				stack.push(right);
			}
		}

	}

	private static <T extends Comparable<? super T>> int Partition(T[] input, int low, int high) {
		if (low >= high) {
			return low;
		}
		int pivotIndex = low + new Random().nextInt(high - low + 1);// 随机选元素作为轴，并放到首元素
		Swap(input, low, pivotIndex);
		T pivot = input[low];
		int i = low, j = high;
		while (i < j) {
			while (i < j && input[j].compareTo(pivot) >= 0) {
				j--;
			}
			input[i] = input[j];
			while (i < j && input[i].compareTo(pivot) <= 0) {
				i++;
			}
			input[j] = input[i];
		}
		input[i] = pivot;// 此时low==high
		return i;
	}

	private static <T extends Comparable<? super T>> void Swap(T[] input, int i, int j) {
		T temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] test1 = new Integer[] { 1, 2 };
		Integer[] test2 = new Integer[] { 2, 1 };
		Integer[] test3 = new Integer[] { 1, 2, 3 };
		Integer[] test4 = new Integer[] { 1, 3, 2 };
		Integer[] test5 = new Integer[] { 2, 1, 3 };
		Integer[] test6 = new Integer[] { 2, 3, 1 };
		Integer[] test7 = new Integer[] { 3, 1, 2 };
		Integer[] test8 = new Integer[] { 3, 2, 1 };
		Quicksort(test1);
		System.out.println(Arrays.toString(test1));
		Quicksort(test2);
		System.out.println(Arrays.toString(test2));
		Quicksort(test3);
		System.out.println(Arrays.toString(test3));
		Quicksort(test4);
		System.out.println(Arrays.toString(test4));
		Quicksort(test5);
		System.out.println(Arrays.toString(test5));
		Quicksort(test6);
		System.out.println(Arrays.toString(test6));
		Quicksort(test7);
		System.out.println(Arrays.toString(test7));
		Quicksort(test8);
		System.out.println(Arrays.toString(test8));
	}

}
