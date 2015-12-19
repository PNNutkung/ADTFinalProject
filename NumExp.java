
public class NumExp extends Exp {
	private String datum;
	
	public NumExp(String datum) {
		this.datum = datum;
	}	
	
	public String getDatum(){
		return this.datum;
	}
	
	public int eval(){
		return Integer.parseInt(this.datum);
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}

}
