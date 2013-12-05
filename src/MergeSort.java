/**
 * �鲢���򣬷���˼��divide and conquer�� divide����ԭ���������룻conquer����������ֱ�����merge��������ϲ���
 * �㷨�ȶ�����á�ƽ�����ʱ�临�Ӷȶ���O(N*logN)���ռ临�Ӷ�O(N)�� �鲢�����ǳ��������㷨����Ҫ�Ƚϴ������ٵġ�
 * ��JAVA�У�������бȽϲ������󣬶�����Ԫ���ƶ��ܿ죨��Ϊ�ƶ��������ã����ʺϹ鲢����
 * ��˶���������߼��ϵ�Collections.sort()��Arrays.sort()������һ�ֹ鲢����ĸĽ��汾��
 * ���ǻ��������������������Arrays.sort()�����ǸĽ��Ŀ�������
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
			if (input[i].compareTo(input[j]) <= 0) {// ���ںű�֤���㷨�ȶ�
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
