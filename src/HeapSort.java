/**
 * P85����������á�ƽ�����ʱ�临�Ӷȶ���O(N*logN)����һ��ԭַ(in-place)���򣬿ռ临�Ӷ�O(1)�����ȶ�
 */
public class HeapSort {

	/**
	 * ���������ô󶥶����õ��Ľ��������
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
	 * ԭ�ع�����,ʱ�临�Ӷ�O(N)
	 */
	private static <T extends Comparable<? super T>> void BuildMaxHeap(T[] input) {
		for (int i = input.length / 2; i >= 0; i--) {
			MaxHeapify(input, i, input.length);
		}
	}

	/**
	 * ����ĳ��Ԫ��λ�ã���ά�ֶѽṹ��ʱ�临�Ӷ�O(logN)��ע�������length��ı䣬���Բ�����input.length
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
