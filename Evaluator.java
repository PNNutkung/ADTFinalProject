
public class Evaluator implements Visitor {

	@Override
	public Object visit(PlusExp n) {
		return (n.eval())+(n.eval());
	}

	@Override
	public Object visit(MinusExp n) {
		return (n.eval())-(n.eval());
	}

	@Override
	public Object visit(TimesExp n) {
		return (n.eval())*(n.eval());
	}

}
