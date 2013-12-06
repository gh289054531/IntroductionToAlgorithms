/**
 * P85，堆排序，最好、平均、最坏时间复杂度都是O(N*logN)，是一种原址(in-place)排序，空间复杂度O(1)。不稳定
 */
public class HeapSort {

	/**
	 * 堆排序，利用大顶堆最后得到的结果是增序
	 */
	public static <T extends Comparable<? super T>> void Sort(T[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		BuildMaxHeap(input);
		for (int len = input.length; len > 1; len--) {
			T temp = input[len - 1];
			input[len - 1] = input[0];
			input[0] = temp;
			MaxHeapify(input, 0, len - 1);
		}
	}

	/**
	 * 原地构建堆,时间复杂度O(N)
	 */
	private static <T extends Comparable<? super T>> void BuildMaxHeap(T[] input) {
		for (int i = input.length / 2; i >= 0; i--) {
			MaxHeapify(input, i, input.length);
		}
	}

	/**
	 * 调整某个元素位置，以维持堆结构，时间复杂度O(logN)。注意这里的length会改变，所以不能用input.length
	 */
	private static <T extends Comparable<? super T>> void MaxHeapify(T[] input, int i, int length) {
		T temp = input[i];
		int child = 2 * i + 1; // left child
		while (child < length) {
			if (child < length - 1 && input[child].compareTo(input[child + 1]) < 0) {
				child++; // change to right child
			}
			if (temp.compareTo(input[child]) < 0) {
				input[i] = input[child];
				i = child;
				child = 2 * i + 1;
			} else {
				break;
			}
		}
		input[i] = temp;
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 1, 2, 4, 654, 123, 643, 213, 432, 65, -635, 42 };
		HeapSort.Sort(test1);
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
	}

}
