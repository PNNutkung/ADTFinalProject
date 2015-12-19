
public class PlusExp extends Exp {
	private Exp e1,e2;
	private String datum;
	public PlusExp(Exp a1, Exp a2) {
		this.e1 = a1;
		this.e2 = a2;
		this.datum = "+"; 
	}
	public Exp gete1(){
		return this.e1;
	}
	public Exp gete2(){
		return this.e2;
	}
	public String getDatum(){
		return this.datum;
	}
	public int eval(){
		return this.e1.eval() + this.e2.eval();
	}
	public Object accept(Visitor v){
		return v.visit(this);
	}

}
