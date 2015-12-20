
public abstract class Exp {
	private Exp e1, e2;
	private String datum;
	public abstract Object accept(Visitor v);
	public Exp gete1() {
		return this.e1;
	}
	public Exp gete2() {
		return this.e2;
		
	}
	public abstract int eval();
	public abstract String getDatum();
}
