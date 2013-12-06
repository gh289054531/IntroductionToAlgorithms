/**
 * KMP�㷨ʵ��,ԭʼ����N��ƥ�䴮��M��ʱ�临�Ӷ�O(M+N),�ռ临�Ӷ�O(M). ע��ԭʼ�������ݣ�
 */
public class KMP {

	/**
	 * ʱ�临�Ӷ�O(N),ע��ԭʼ�������ݣ� ���ص�һ��ƥ����±꣬��ƥ�䷵��-1��
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
	 * ����next���飬ʱ�临�Ӷ�O(M)
	 */
	private static int[] CalNext(String target) {
		int[] next = new int[target.length()];
		next[0] = -1;
		int k = -1;
		int i = 0;
		while (i < target.length() - 1) {
			// ���p[i]==p[k]������ǰ׺���׺���ȶ�����1������Ȼ��ȣ���ônext[i+1]=k+1
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
