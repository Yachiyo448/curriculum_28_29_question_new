package util;

import java.util.Arrays;

/**
 * 渡された配列をソートするクラス
 */
public class ArraySorter {
	/**
	 * 配列を昇順にソート
	 * @param array 配列
	 */
	public static void sortAscending(int[] array) {
		Arrays.sort(array);
	}

	/**
	 * 配列を降順にソート
	 * @param array 配列
	 */
	public static void sortDescending(int[] array) {
		Arrays.sort(array);
		reverseArray(array);
	}

	/**
	 * 配列を逆順にする
	 * @param array
	 */
	private static void reverseArray(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}
}
