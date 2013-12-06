/**
 * 快速排序，不稳定。这里采用了五分中项的中项算法来求分割点，使得每次划分大致是对半。
 * 最优和平均时间复杂度O(N*logN)，最坏时间复杂度O(N^2)，但是通过采用优化的枢纽点选取方法可以使得最坏情况几乎不能发生，包括： 1.随机化选取
 * 2.三数中值分割算法 3.五分化中项的中项
 */
public class QuickSort {
	private final static int DELT = 10;

	public static <T extends Comparable<? super T>> void Sort(T[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		IterativelySort(input, 0, input.length - 1);
	}

	private static <T extends Comparable<? super T>> void IterativelySort(T[] input, int left, int right) {
		if (right <= left) {
			return;
		}
		if (right - left < DELT) {// 数组长度小时调用插入排序
			InsertionSort(input, left, right);
			return;
		}
		T pivot = FindPivot(input, left, right);// 选取枢纽元，有多种策略
		int i = left, j = right;
		while (i < j) {
			while (input[i].compareTo(pivot) < 0) {
				i++;
			}
			while (input[j].compareTo(pivot) > 0) {
				j--;
			}
			T temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
		IterativelySort(input, left, i - 1);
		IterativelySort(input, i + 1, right);
	}

	/**
	 * 插入排序
	 */
	private static <T extends Comparable<? super T>> void InsertionSort(T[] input, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			T temp = input[i];
			int j = i - 1;
			for (; j >= left && temp.compareTo(input[j]) < 0; j--) {
				input[j + 1] = input[j];
			}
			input[j + 1] = temp;
		}
	}

	/**
	 * 五分化中项的中项
	 */
	private static <T extends Comparable<? super T>> T FindPivot(T[] input, int left, int right) {
		if (right == left) {// 如果只剩一个值，返回它作为pivot
			return input[left];
		}
		int m = 0;// 分为几组
		if (right - left + 1 < 5) {
			m = 1;
		} else {
			m = (right - left + 1) / 5;
		}
		T[] medians = (T[]) new Comparable[m];
		int index = 0;
		for (int i = 0; i < m; i++) { // 选取五分化后的中项
			if (i == m - 1) {
				InsertionSort(input, 5 * i, right);
				medians[index++] = input[(5 * i + right) / 2];
			} else {
				InsertionSort(input, 5 * i, 5 * i + 4);
				medians[index++] = input[5 * i + 2];
			}
		}
		return FindPivot(medians, 0, medians.length - 1); // 递归求五分化后的中项
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 123, 1212, 43242, -123 };
		QuickSort.Sort(test1);
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
	}

}
