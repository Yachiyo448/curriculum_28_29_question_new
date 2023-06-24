package util;

/**
 * 文字列を受け取り、正しく入力されていなければエラーを返す
 */

public class StringValidator {

	/**
	 * 文字列引数がnullまたは0文字以下の場合、エラーを返す
	 * @param input 文字列
	 */
	public static void checkNotEmpty(String input) {
		if (input == null || input.length() <= 0) {
			throw new IllegalArgumentException("入力文字列は空です。");
		}
	}

	/**
	 * 文字列引数が整数または小数でない場合、エラーを返す
	 * @param input 文字列
	 */
	public static void checkNumeric(String input) {
		// 文字列引数がnullまたは0文字以下の場合、エラーを返す
		checkNotEmpty(input);
		if (!input.matches("-?\\d+(\\.\\d+)?")) {
			throw new NumberFormatException("整数または小数を入力してください。");
		}
	}

	/**
	 * 文字列引数が整数かつ引数の範囲でない場合、エラーを返す
	 * @param input 文字列
	 * @param min 最小値
	 * @param max 最大値
	 */
	public static void checkInteger(String input, int min, int max) {
		// 文字列引数がnullまたは0文字以下の場合、エラーを返す
		checkNotEmpty(input);
		int number;

		// 整数かどうかのチェック
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("整数を入力してください。");
		}

		// 整数引数の範囲内かチェック
		if (number < min || number > max) {
			throw new NumberFormatException(min + " から " + max + " の範囲で入力してください。");
		}
	}

	/**
	 * 文字列引数が整数でない場合、エラーを返す
	 * @param input 文字列
	 */
	public static void checkInteger(String input) {
		checkInteger(input, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
