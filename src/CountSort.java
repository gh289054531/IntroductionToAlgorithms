/**
 * P109，计数排序(counting sort)，时间复杂度O(N+K)， 空间复杂度O(K)。 当K=O(N)时，采用计数排序比采用基于比较的排序更好
 */
public class CountSort {

	public static int[] Sort(int[] input, int k) {
		if (input == null || k < 0) {
			return null;
		}
		int[] count = new int[k];
		for (int i = 0; i < input.length; i++) {// O(N)
			count[input[i]] += 1;
		}
		for (int i = 1; i < k; i++) {// O(K)
			count[i] += count[i - 1];
		}
		int[] result = new int[input.length];
		for (int i = input.length - 1; i >= 0; i--) {// O(N)
			result[count[input[i]] - 1] = input[i];
			count[input[i]] -= 1;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = new int[] { 2, 5, 3, 0, 2, 3, 0, 3 };
		int[] result = CountSort.Sort(test, 6);// 因为5是最大值，所以需要大小为6的数组计数
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
