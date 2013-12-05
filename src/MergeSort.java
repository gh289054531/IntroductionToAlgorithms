/**
 * 归并排序，分治思想divide and conquer。 divide：把原数组拆成两半；conquer：对这两半分别排序；merge：把两半合并。
 * 算法稳定，最好、平均、最坏时间复杂度都是O(N*logN)，空间复杂度O(N)。 归并排序是常用排序算法中需要比较次数最少的。
 * 在JAVA中，对象进行比较操作昂贵，而数组元素移动很快（因为移动的是引用），适合归并排序。
 * 因此对象数组或者集合的Collections.sort()和Arrays.sort()方法是一种归并排序的改进版本；
 * 但是基本数据类型数组的排序Arrays.sort()方法是改进的快速排序。
 */
public class MergeSort {

	public static <T extends Comparable<? super T>> void Sort(T[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		T[] temp = (T[]) new Comparable[input.length];
		RecursivlyMergeSort(input, 0, input.length - 1, temp);
	}

	private static <T extends Comparable<? super T>> void RecursivlyMergeSort(T[] input, int left, int right, T[] temp) {
		if (left >= right) {
			return;
		}
		if (right - left == 1) {
			if (input[left].compareTo(input[right]) > 0) {
				T t = input[left];
				input[left] = input[right];
				input[right] = t;
			}
			return;
		}
		// divide
		int middle = (left + right) / 2;
		// conquer
		RecursivlyMergeSort(input, left, middle - 1, temp);
		RecursivlyMergeSort(input, middle, right, temp);
		// Merge
		int i = left, j = middle;
		int index = left;
		while (i < middle && j <= right) {
			if (input[i].compareTo(input[j]) <= 0) {// 等于号保证了算法稳定
				temp[index++] = input[i++];
			} else {
				temp[index++] = input[j++];
			}
		}
		while (i < middle) {
			temp[index++] = input[i++];
		}
		while (j <= right) {
			temp[index++] = input[j++];
		}
		System.arraycopy(temp, left, input, left, right - left + 1);
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 213, 123, 432, 54, 56765, 5324, 8768, 234 };
		MergeSort.Sort(test1);
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
	}

}
