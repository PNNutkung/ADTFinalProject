
public class VarExp extends Exp {
	private String datum;
	public VarExp(String datum){
		this.datum = datum;
	}
	public String getDatum(){
		return this.datum;
	}
	
	public int eval(){
		return 1;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}

}
