import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static <T extends Comparable<? super T>> void Quicksort(T[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		RecursivlySort(input, 0, input.length - 1);
	}

	private static <T extends Comparable<? super T>> void RecursivlySort(T[] input, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotIndex = Partition(input, left, right);
		RecursivlySort(input, left, pivotIndex - 1);
		RecursivlySort(input, pivotIndex + 1, right);
	}

	private static <T extends Comparable<? super T>> int Partition(T[] input, int left, int right) {
		int pivotIndex = Rand(left, right);
		T pivot = input[pivotIndex];
		Swap(input, left, pivotIndex);
		int i = left, j = right;
		while (i < j) {
			while (i < j && input[j].compareTo(pivot) > 0) {
				j--;
			}
			input[i] = input[j];
			while (i < j && input[i].compareTo(pivot) < 0) {
				i++;
			}
			input[j] = input[i];
		}
		input[i] = pivot;
		return i;
	}

	private static <T extends Comparable<? super T>> void Swap(T[] input, int i, int j) {
		T temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	private static int Rand(int i, int j) {
		if (i > j) {
			throw new IllegalArgumentException("i<j!");
		}
		Random r = new Random();
		return r.nextInt(j - i + 1) + i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
