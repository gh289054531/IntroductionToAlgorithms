import java.util.Random;

/**
 * P71,原地均匀随机排列，时间复杂度O(N)
 */
public class RandomizeInPlace {

	public static void Randomize(Object[] input) {
		if (input == null || input.length < 2) {
			return;
		}
		Random r = new Random();
		for (int i = input.length - 1; i > 0; i--) {
			int index = r.nextInt(i + 1);
			Object temp = input[i];
			input[i] = input[index];
			input[index] = temp;
		}
	}

	public static void main(String[] args) {
		Integer[] test1 = new Integer[] { 46, 132, 56, 44, 6, 13, 46, 46, 41, 56 };
		RandomizeInPlace.Randomize(test1);
		for (Integer i : test1) {
			System.out.println(i);
		}
	}

}
