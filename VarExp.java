
public class VarExp extends Exp {
	private String datum;
	private int value;
	public VarExp(String datum){
		this.datum = datum;
		this.value = 6;
	}
	public String getDatum(){
		return this.datum;
	}
	
	public int eval(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	public int getValue(){
		return this.value;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}

}
