
public abstract class Exp {
	private Exp left, right;
	private String datum;
	public abstract int eval();
	public Exp getLeft() {
		return this.left;
	}
	public Exp getRight() {
		return this.right;
		
	}
	public abstract String getDatum();
}
