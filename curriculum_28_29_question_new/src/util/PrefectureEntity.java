package util;

/**
 * 都道府県のエンティティクラス
 */
public class PrefectureEntity {

	// 都道府県名
	private String name;
	// 県庁所在地
	private String capitalName;
	// 面積(km2)
	private double area;

	// デフォルトコンストラクタ
	public PrefectureEntity() {
	}

	// コンストラクタ
	/**
	 * @param name
	 * @param capitalName
	 * @param area
	 */
	public PrefectureEntity(String name, String capitalName, double area) {
		super();
		this.name = name;
		this.capitalName = capitalName;
		this.area = area;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return capitalName
	 */
	public String getCapitalName() {
		return capitalName;
	}

	/**
	 * @param capitalName セットする capitalName
	 */
	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

	/**
	 * @return population
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param population セットする population
	 */
	public void setArea(double area) {
		this.area = area;
	}

}
