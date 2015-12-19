
public class DivisionExp extends Exp {
	private Exp e1,e2;
	private String datum;
	
	public DivisionExp(Exp a1, Exp a2){
		this.e1 = a1;
		this.e2 = a2;
		this.datum = "/";
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public int eval() {
		return this.e1.eval() / this.e2.eval();
	}

	@Override
	public String getDatum() {
		return this.datum;
	}

}
