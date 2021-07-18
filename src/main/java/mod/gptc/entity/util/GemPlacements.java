package mod.gptc.entity.util;

public enum GemPlacements {
	NONE(-1),
    FOREHEAD(0),
    LEFT_EYE(1),
    RIGHT_EYE(2),
    LEFT_EAR(3),
    RIGHT_EAR(4),
    NOSE(5),
    LEFT_CHEEK(6),
    RIGHT_CHEEK(7),
    BACK_OF_HEAD(8),
    TOP_OF_HEAD(9),
    MOUTH(10),
    LEFT_SHOULDER(11),
    RIGHT_SHOULDER(12),
    BACK(13),
    CHEST(14),
    NAVAL(15),
    LEFT_ARM(16),
    RIGHT_ARM(17),
    LEFT_HAND(18),
    RIGHT_HAND(19),
    LEFT_LEG(20),
    RIGHT_LEG(21);
	
	public int id;
	private static GemPlacements[] vals = GemPlacements.values();

	private GemPlacements(int id) {
		this.id = id;
	}

	public static GemPlacements getCut(int i) {
		return GemPlacements.vals[i + 1];
	}
}
