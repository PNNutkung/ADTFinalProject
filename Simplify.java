
public class Simplify implements Visitor {

	@Override
	public Exp visit(PlusExp n) {
		Exp left = ((Exp)(n.gete1().accept(this)));
		Exp right = ((Exp)(n.gete2().accept(this)));
		if( left.getDatum().equals("0") 
				&& right.getDatum().equals("0")
				){
			return new NumExp("0");
		}
		else if( left.getDatum().equals("0")){
			return (Exp)left.accept(this);
		}
		else if	(right.getDatum().equals("0") ){
			return (Exp)right.accept(this);
		}
		else if((left.getDatum()).equals(right.getDatum())){
			return new TimesExp( new NumExp("2"), (Exp)left.accept(this));
		}
		return new PlusExp((Exp)n.gete1().accept(this),(Exp)n.gete2().accept(this));
	}

	@Override
	public Exp visit(MinusExp n) {
		Exp left = ((Exp)(n.gete1().accept(this)));
		Exp right = ((Exp)(n.gete2().accept(this)));
		if( left.getDatum().equals("0") 
				&& right.getDatum().equals("0")
				){
			return new NumExp("0");
		}
		else if	(right.getDatum().equals("0") ){
			return (Exp)left.accept(this);
		}
		else if((left.getDatum()).equals(right.getDatum())){
			return new NumExp("0");
		}
		return new MinusExp((Exp)n.gete1().accept(this),(Exp)n.gete2().accept(this));
	}

	@Override
	public Exp visit(TimesExp n) {
		Exp left = ((Exp)(n.gete1().accept(this)));
		Exp right = ((Exp)(n.gete2().accept(this)));
		if( left.getDatum().equals("0") 
			&& right.getDatum().equals("0")
		  ){
			return new NumExp("0");
		}
		else if	(right.getDatum().equals("0") ){
			return new NumExp("0");
		}
		else if	(right.getDatum().equals("1") ){
			return (Exp)left.accept(this);
		}
		else if	(left.getDatum().equals("1") ){
			return (Exp)right.accept(this);
		}
		else if((left.getDatum()).equals(right.getDatum())){
			return new NumExp("0");
		}
		return new TimesExp((Exp)n.gete1().accept(this),(Exp)n.gete2().accept(this));
	}

	@Override
	public Exp visit(DivisionExp n) {
		Exp left = ((Exp)(n.gete1().accept(this)));
		Exp right = ((Exp)(n.gete2().accept(this)));
		if( left.getDatum().equals("0") 
			&& right.getDatum().equals("0")
		  ){
			return new NumExp("0");
		}
		else if	(left.getDatum().equals("0") ){
			return new NumExp("0");
		}
		else if	(right.getDatum().equals("0") ){
			throw new IllegalArgumentException("Argument 'divisor' is 0");
		}
		else if	(right.getDatum().equals("1") ){
			return (Exp)left.accept(this);
		}
		else if((left.getDatum()).equals(right.getDatum())){
			return new NumExp("1");
		}
		return new DivisionExp((Exp)n.gete1().accept(this),(Exp)n.gete2().accept(this));
	}

	@Override
	public Exp visit(NumExp n) {
		return n;
	}

	@Override
	public Exp visit(VarExp n) {
		return n;
	}

}
