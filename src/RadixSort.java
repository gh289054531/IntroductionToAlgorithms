/**
 * P111,基数排序(RadixSort),稳定。时间复杂度O(d*(n+k)),空间复杂度O(k)。当d为常熟且k=O(n)时计数排序具有线性时间复杂度。
 */
public class RadixSort {
	public static int[] Sort(int[] input, int d) {
		if (input == null) {
			return null;
		}
		int[] digits = new int[input.length];
		for (int position = 0; position < d; position++) {
			for (int i = 0; i < input.length; i++) {// 截取第position位的数字
				digits[i] = GetDigit(input[i], position);
			}
			int[] count = new int[10];
			for (int i = 0; i < digits.length; i++) {// 计数
				count[digits[i]] += 1;
			}
			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}
			int[] temp = new int[input.length];
			for (int i = input.length - 1; i >= 0; i--) {
				temp[count[digits[i]] - 1] = input[i];
				count[digits[i]] -= 1;
			}
			input = temp;
		}
		return input;
	}

	private static int GetDigit(int num, int position) {
		int digit = 0;
		for (int i = 0; i <= position; i++) {
			if (num == 0) {
				return 0;
			}
			digit = num % 10;
			num /= 10;
		}
		return digit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] { 329, 457, 657, 839, 436, 720, 355 };
		int[] result = RadixSort.Sort(test, 4);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
