
public class EvalVisitor {
	public int visit(Exp e){
		if(e instanceof PlusExp) {
			PlusExp t = (PlusExp) e;
			return visit(t.getLeft()) + visit(t.getRight());
		}
		else if( e instanceof MinusExp ){
			MinusExp t = (MinusExp) e;
			return visit(t.getLeft()) - visit(t.getRight());
		}
		else if(e instanceof NumExp){
			NumExp t = (NumExp) e;
			return t.getDatum();
		}
	}
}
