
public interface Visitor {
	public Object visit(PlusExp n);
	public Object visit(MinusExp n);
	public Object visit(TimesExp n);
}
