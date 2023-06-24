package util;

/**
 * 特定のフォーマットでできた文字列から都道府県名のデータを生成し、文字列出力するクラス
 */
public class StringToPrefectureArray {

	// フィールド
	// 都道府県エンティティ
	private PrefectureEntity prefectureEntity = new PrefectureEntity();

	// コンストラクタ
	// 都道府県名・県庁所在地・面積で構成された文字列から都道府県のデータを生成
	public StringToPrefectureArray(String formattedStr) {

		// 文字列を:で分割する
		String[] data = formattedStr.split(":");

		// 要素数が3で無い場合はエラーを返す
		if (data.length != 3) {
			throw new IllegalArgumentException("配列の要素数が不正です。");
		}

		// 分割した各文字列についてエラーチェック
		// 文字列が空でないかチェック
		StringValidator.checkNotEmpty(data[0]);
		StringValidator.checkNotEmpty(data[1]);
		// 文字列が整数または小数かチェック
		StringValidator.checkNumeric(data[2]);

		// 各文字列を型変換し、都道府県エンティティクラスのフィールドにセット
		prefectureEntity.setName(data[0]);
		prefectureEntity.setCapitalName(data[1]);
		prefectureEntity.setArea(Integer.parseInt(data[2]));

	}

	/**
	 * 都道府県のデータを文字列として返す
	 */
	public String outputString() {
		String output;
		output = "都道府県名：" + prefectureEntity.getName() + "\n"
				+ "県庁所在地：" + prefectureEntity.getCapitalName() + "\n"
				+ "面積：" + prefectureEntity.getArea() + "km2\n";
		return output;
	}

}
