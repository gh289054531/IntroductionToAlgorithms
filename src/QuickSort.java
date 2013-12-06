/**
 * �������򣬲��ȶ�������������������������㷨����ָ�㣬ʹ��ÿ�λ��ִ����Ƕ԰롣
 * ���ź�ƽ��ʱ�临�Ӷ�O(N*logN)���ʱ�临�Ӷ�O(N^2)������ͨ�������Ż�����Ŧ��ѡȡ��������ʹ�������������ܷ����������� 1.�����ѡȡ
 * 2.������ֵ�ָ��㷨 3.��ֻ����������
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
		if (right - left < DELT) {// ���鳤��Сʱ���ò�������
			InsertionSort(input, left, right);
			return;
		}
		T pivot = FindPivot(input, left, right);// ѡȡ��ŦԪ���ж��ֲ���
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
	 * ��������
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
	 * ��ֻ����������
	 */
	private static <T extends Comparable<? super T>> T FindPivot(T[] input, int left, int right) {
		if (right == left) {// ���ֻʣһ��ֵ����������Ϊpivot
			return input[left];
		}
		int m = 0;// ��Ϊ����
		if (right - left + 1 < 5) {
			m = 1;
		} else {
			m = (right - left + 1) / 5;
		}
		T[] medians = (T[]) new Comparable[m];
		int index = 0;
		for (int i = 0; i < m; i++) { // ѡȡ��ֻ��������
			if (i == m - 1) {
				InsertionSort(input, 5 * i, right);
				medians[index++] = input[(5 * i + right) / 2];
			} else {
				InsertionSort(input, 5 * i, 5 * i + 4);
				medians[index++] = input[5 * i + 2];
			}
		}
		return FindPivot(medians, 0, medians.length - 1); // �ݹ�����ֻ��������
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 123, 1212, 43242, -123 };
		QuickSort.Sort(test1);
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
	}

}
