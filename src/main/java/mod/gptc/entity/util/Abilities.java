package mod.gptc.entity.util;

public enum Abilities {
	NONE(-1),
	PYROKINESIS(0);
	
	public int id;
	private static Abilities[] vals = Abilities.values();

	private Abilities(int id) {
		this.id = id;
	}

	public static Abilities getCut(int i) {
		return Abilities.vals[i + 1];
	}
}
