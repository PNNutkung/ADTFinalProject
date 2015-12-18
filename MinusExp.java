
public class MinusExp extends Exp {
	private Exp left,right;
	private String datum;
	public MinusExp(Exp a1, Exp a2) {
		this.left = a1;
		this.right = a2;
		this.datum = "-"; 
	}
	public Exp getLeft(){
		return this.left;
	}
	public Exp getRight(){
		return this.right;
	}
	public String getDatum(){
		return this.datum;
	}
	@Override
	public int eval() {
		return this.left.eval() - this.right.eval();
	}

}
