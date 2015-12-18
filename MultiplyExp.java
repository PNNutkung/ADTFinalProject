public class MultiplyExp extends Exp {
	private Exp left, right;
	private String datum;
	public MultiplyExp(Exp a1, Exp a2) { left=a1; right=a2; datum = "*";}
	public Exp getLeft() {return left;}
	public Exp getRight() {return right;}
	public String getDatum() {return datum;}
	public int eval() {
		return left.eval()*right.eval();
	}
} 