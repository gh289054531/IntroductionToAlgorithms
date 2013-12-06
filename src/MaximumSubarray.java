/**
 * P39��������������⣬ʱ�临�Ӷ�O(N)
 * Data_Structures_and_Algorithm_Analysis_in_Java�����е�FindMaxDiff�������ת��Ϊ������������⡣
 */
public class MaximumSubarray {

	public static long cal(int[] input) {
		long sum = 0;
		long maxSum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (sum < 0) {
				sum = 0;
			} else {
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] a1 = new int[] { 1, 3, 7, -9, 2 };
		for (int i = a1.length - 1; i > 0; i--) {
			a1[i] -= a1[i - 1];
		}
		a1[0]=0;
		System.out.println(MaximumSubarray.cal(a1));

		int[] a2 = new int[] { 11, 3, 3, 7, 7, 7, -1, 2, 2 };
		for (int i = a2.length - 1; i > 0; i--) {
			a2[i] -= a2[i - 1];
		}
		a2[0]=0;
		System.out.println(MaximumSubarray.cal(a2));
	}

}
