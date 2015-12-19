
public class Main {
	public static void main(String[] args) {
		System.out.println("============== 5710546372 Pipatpol Tanavongchinda =============");
		String equation1 = "( 8 + 9 * ( 4 + 5 * 7 + 6 ) ) + 3 * 5 + 4";
		System.out.println("Equation : "+equation1);
		System.out.println("Actual : "+((8+9*(4+5*7+6))+3*5+4));
		String postfix1 = TreeExp.IntoPost(equation1);
		System.out.println("IntoPost : "+postfix1);
		Exp root1;
		root1 = TreeExp.makeExpTree(postfix1);
		
		Visitor v = new Evaluator();
		System.out.println("Exp result is "+root1.accept(v));
		
		String equation2 = "x+2";
		System.out.println("Equation : "+equation2);
		String postfix2 = TreeExp.IntoPost(equation2);
		Exp root2;
		root2 = TreeExp.makeExpTree(postfix2);
		System.out.println("Exp result is "+root2.accept(v));
	}
}
