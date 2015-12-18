
public class NumExp extends Exp {
	private String datum;
	
	public NumExp(String datum) {
		this.datum = datum;
	}	
	
	public String getDatum(){
		return this.datum;
	}
	@Override
	public int eval() {
		return Integer.parseInt(this.datum);
	}

}
