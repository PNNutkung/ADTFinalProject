
public class Simplify implements Visitor {
	StringBuffer temp = new StringBuffer();
	public void printInfix(Exp root){
		if(root == null) return;
		printInfix(root.gete1());
		temp.append(root.getDatum());
		printInfix(root.gete2());
	}
	public boolean isEqual(Exp left,Exp right){
		temp = new StringBuffer();
		printInfix(left);
		String temp2 = temp.toString();
		temp = new StringBuffer();
		printInfix(right);
		String temp3 = temp.toString();
		return temp2.equals(temp3);
	}
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
			return (Exp)right.accept(this);
		}
		else if	(right.getDatum().equals("0") ){
			return (Exp)left.accept(this);
		}
		else if(isEqual(left, right)){
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
		else if(isEqual(left, right)){
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
		else if	(left.getDatum().equals("0") ){
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
		else if(isEqual(left, right)){
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
