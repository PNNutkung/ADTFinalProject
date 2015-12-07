
public class Number extends Exp {
	private String datum;
	public Number(String n0){
		this.datum = n0;
	}
	public String getDatum(){
		return this.datum;
	}
	@Override
	public int eval() {
		return Integer.parseInt(this.datum);
	}

}
