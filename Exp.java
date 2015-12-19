
public abstract class Exp {
	private Exp left, right;
	private String datum;
	public abstract Object accept(Visitor v);
	public Exp getLeft() {
		return this.left;
	}
	public Exp getRight() {
		return this.right;
		
	}
	public abstract int eval();
	public abstract String getDatum();
}
