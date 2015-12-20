
public class Evaluator implements Visitor {

	@Override
	public Object visit(PlusExp n) {
		return (Integer)(n.gete1().accept(this))+(Integer)(n.gete2().accept(this));
	}

	@Override
	public Object visit(MinusExp n) {
		return (Integer)(n.gete1().accept(this))-(Integer)(n.gete2().accept(this));
	}

	@Override
	public Object visit(TimesExp n) {
		return (Integer)(n.gete1().accept(this))*(Integer)(n.gete2().accept(this));
	}

	@Override
	public Object visit(DivisionExp n) {
		return (Integer)(n.gete1().accept(this))/(Integer)(n.gete2().accept(this));
	}

	@Override
	public Object visit(NumExp n) {
		return Integer.parseInt(n.getDatum());
	}

	@Override
	public Object visit(VarExp n) {
		return n.getDatum();
	}

}
