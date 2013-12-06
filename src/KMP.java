/**
 * KMP算法实现,原始串长N，匹配串长M，时间复杂度O(M+N),空间复杂度O(M). 注意原始串不回溯！
 */
public class KMP {

	/**
	 * 时间复杂度O(N),注意原始串不回溯！ 返回第一次匹配的下标，不匹配返回-1。
	 */
	public static int KMPmatch(String source, String target) {
		if (source == null || target == null || source.length() < target.length()) {
			return -1;
		}
		if (target.equals("")) {
			return 0;
		}
		int[] next = KMP.CalNext(target);
		int i = 0, j = 0;
		while (i < source.length()) {
			if (source.charAt(i) == target.charAt(j)) {
				i++;
				j++;
				if (j == target.length()) {
					return i - j;
				}
			} else {
				if (next[j] == -1) {
					i++;
					j = 0;
				} else {
					j = next[j];
				}
			}
		}
		return -1;
	}

	/**
	 * 计算next数组，时间复杂度O(M)
	 */
	private static int[] CalNext(String target) {
		int[] next = new int[target.length()];
		next[0] = -1;
		int k = -1;
		int i = 0;
		while (i < target.length() - 1) {
			// 如果p[i]==p[k]，表明前缀与后缀长度都加了1并且依然相等，那么next[i+1]=k+1
			if (k == -1 || target.charAt(i) == target.charAt(k)) {
				next[++i] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public static void main(String[] args) {

	}

}
