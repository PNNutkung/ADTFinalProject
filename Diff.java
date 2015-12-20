
public class Diff implements Visitor {

	@Override
	public Exp visit(PlusExp n) {
		return new PlusExp((Exp) n.gete1().accept(this), (Exp) n.gete2().accept(this));
	}

	@Override
	public Exp visit(MinusExp n) {
		return new MinusExp((Exp) n.gete1().accept(this), (Exp) n.gete2().accept(this));
	}

	@Override
	public Exp visit(TimesExp n) {
		return new PlusExp(new TimesExp((Exp) n.gete1().accept(this), (Exp) n.gete2()),
				new TimesExp((Exp) n.gete1(), (Exp) n.gete2().accept(this)));
	}

	@Override
	public Exp visit(DivisionExp n) {
		return new DivisionExp(
				new MinusExp(new TimesExp((Exp) n.gete1().accept(this), (Exp) n.gete2()),
						new TimesExp((Exp) n.gete1(), (Exp) n.gete2().accept(this))),
				new TimesExp((Exp) n.gete2(), (Exp) n.gete2()));
	}

	@Override
	public Exp visit(NumExp n) {
		return new NumExp("0");
	}

	@Override
	public Exp visit(VarExp n) {
		return new NumExp("1");
	}

}
