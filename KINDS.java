
public enum KINDS {
	PLUS(2),
	MINUS(3),
	MULTIPLY(4),
	DIVIDE(5),
	OPERATOR(0),
	VARIANCE(6),
	NUMBER(1);
	
	private final int kind;
	KINDS(int kind){
		this.kind = kind;
	}
}
