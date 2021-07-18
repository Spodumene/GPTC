package mod.gptc.entity.util;

public enum GemCuts {
	NONE(-1),
	FACETED(0),
	ROUND(1),
	TEARDROP(2),
	RECTANGLE(3),
	HEXAGON(4),
	RHOMBUS(5),
	TRIANGLE(6),
	HEART(7),
	SPADE(8),
	CLUB(9),
	DRUM(10),
	DIAMOND(11);
	public int id;

	private static GemCuts[] vals = GemCuts.values();

	private GemCuts(int id) {
		this.id = id;
	}

	public static GemCuts getCut(int i) {
		return GemCuts.vals[i + 1];
	}
}