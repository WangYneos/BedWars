package misat11.bw.api;

public enum InGameConfigBooleanConstants {
	INHERIT(false, false),
	TRUE(true, true),
	FALSE(true, false);
	
	private final boolean original;
	private final boolean value;
	
	InGameConfigBooleanConstants(boolean original, boolean value) {
		this.original = original;
		this.value = value;
	}
	
	public boolean isInherited() {
		return !original;
	}
	
	public boolean isOriginal() {
		return original;
	}
	
	public boolean getValue() {
		return value;
	}
}
