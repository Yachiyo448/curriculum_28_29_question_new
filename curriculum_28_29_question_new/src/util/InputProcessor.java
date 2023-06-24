package util;

import java.util.Scanner;

/**
 * 特定のフォーマットに従った数字列を入力し、対応した都道府県の情報を出力するクラス
 */

public class InputProcessor {

	/**
	 * メイン メソッド
	 */
	public static void main(String[] args) {

		// 都道府県データを配列から入力
		String[] prefectureArray = {
				"北海道:札幌市:83424",
				"青森県:青森市:9646",
				"岩手県:盛岡市:15275",
				"宮城県:仙台市:7282",
				"秋田県:秋田市:11638",
				"山形県:山形市:9323",
				"福島県:福島市:13784",
				"茨城県:水戸市:6097",
				"栃木県:宇都宮市:6408",
				"群馬県:前橋市:6362",
				"埼玉県:さいたま市:3798"
		};

		// 数字列（配列添え字）の入力

		// コンソール入力用のインスタンスを生成
		Scanner scanner = new Scanner(System.in);
		// 入力を促すメッセージを出力
		System.out.println("数字列を入力してください");
		// コンソールに入力した値を代入
		String inputNums = scanner.nextLine();

		// 入力した文字列が空でないかチェック
		StringValidator.checkNotEmpty(inputNums);

		// 入力した数字列を,で区切り、文字列配列を作成
		String[] resultStr = inputNums.split(",");

		// 作成した文字列配列を、整数にして配列に格納
		int[] resultInt = new int[resultStr.length];
		for (int i = 0; i < resultStr.length; i++) {
			// 要素の文字列が範囲内の整数であるかチェック
			StringValidator.checkInteger(resultStr[i], 0, prefectureArray.length - 1);
			resultInt[i] = Integer.parseInt(resultStr[i]);
		}

		// ソート（昇順・降順）の入力

		// 入力を促すメッセージを出力
		System.out.println("ソート順を入力してください（昇順：0、降順：1）");
		// コンソールに入力した値を代入
		String inputSort = scanner.nextLine();

		// 入力した文字列が0から1の整数かチェックし、整数に変換
		StringValidator.checkInteger(inputSort, 0, 1);
		int inputSortInt = Integer.parseInt(inputSort);

		System.out.println("\nコンソール出力結果\n");

		// 入力内容に応じて、整数配列を昇順か降順にソート
		if (inputSortInt == 0) {
			ArraySorter.sortAscending(resultInt);
		} else {
			ArraySorter.sortDescending(resultInt);
		}

		// ソートされた数字列から都道府県データを逐次出力
		for (int num : resultInt) {
			// 都道府県配列から都道府県エンティティのインスタンスを生成
			StringToPrefectureArray stringToPrefectureArray = new StringToPrefectureArray(prefectureArray[num]);
			// 該当する都道府県のデータをコンソール出力
			System.out.println(stringToPrefectureArray.outputString());

		}

		// 処理終了後にScannerを閉じる
		scanner.close();

	}

}
