
public class VarExp extends Exp {	
	public VarExp() {
	}	
	
	public String getDatum(){
		return "X";
	}
	
	public int eval(){
		return 6;
	}
	
	public Object accept(Visitor v){
		return v.visit(this);
	}

}
