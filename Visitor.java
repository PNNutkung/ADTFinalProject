
public interface Visitor {
	public Object visit(PlusExp n);
	public Object visit(MinusExp n);
	public Object visit(TimesExp n);
	public Object visit(DivisionExp n);
	public Object visit(NumExp n);
}
