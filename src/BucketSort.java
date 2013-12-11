import java.util.ArrayList;

/**
 * P113��Ͱ���򣬼ٶ�����������ȷֲ���ƽ������ʱ��ΪO(N)����Ͱ������ΪM����ռ临�Ӷ���O(N+M)
 */
public class BucketSort {
	/**
	 * @param input
	 *            ֵ���� [0.0,1.0)
	 */
	public static double[] Sort(double[] input) {
		if (input == null) {
			return null;
		}
		ArrayList<Double>[] B = new ArrayList[input.length];// Ͱ
		for (int i = 0; i < B.length; i++) {
			B[i] = new ArrayList<Double>();
		}
		for (int i = 0; i < input.length; i++) {// �����������ݵ�Ͱ
			B[(int) (input.length * input[i])].add(input[i]);
		}
		for (int i = 0; i < input.length; i++) {// ÿ��Ͱִ�в�������
			InsertionSort(B[(int) (input.length * input[i])]);
		}
		double[] result = new double[input.length];
		int index = 0;
		for (int i = 0; i < input.length; i++) {// �ϲ�Ͱ
			for (Double cur : B[i]) {
				result[index++] = cur;
			}
		}
		return result;
	}

	private static void InsertionSort(ArrayList<Double> input) {
		for (int i = 1; i < input.size(); i++) {
			Double temp = input.get(i);
			int j = i - 1;
			for (; j >= 0 && input.get(j) > temp; j--) {
				input.set(j + 1, input.get(j));
			}
			input.set(j + 1, temp);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = new double[] { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68 };
		double[] result = BucketSort.Sort(test);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
