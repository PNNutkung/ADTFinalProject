public class TimesExp extends Exp {
	private Exp e1, e2;
	private String datum;
	
	public TimesExp(Exp a1, Exp a2) { 
		this.e1 = a1; 
		this.e2 = a2; 
		this.datum = "*";
	}
	public Exp gete1() {
		return this.e1;
	}
	public Exp gete2() {
		return this.e2;
	}
	public String getDatum() {
		return datum;
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	@Override
	public int eval() {
		return this.e1.eval() * this.e2.eval();
	}
} 