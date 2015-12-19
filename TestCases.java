
public class TestCases {
	public static void main(String[] args) {
		System.out.println("========================= Project 2 ===========================");
		System.out.println("============== 5710546372 Pipatpol Tanavongchinda =============");
		String equation1 = "( 8 + 9 * ( 4 + 5 * 7 + 6 ) ) + 3 * 5 + 4";
		System.out.println("Equation : "+equation1);
		System.out.println("Actual : "+((8+9*(4+5*7+6))+3*5+4));
		String postfix1 = TreeExp.IntoPost(equation1);
		System.out.println("IntoPost : "+postfix1);
		Exp root1;
		root1 = TreeExp.makeExpTree(postfix1);
		System.out.println("Result : "+root1.eval());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root1);
		System.out.println("Print tree : ");
		TreeExp.printTree( root1, 0);
		System.out.println("=====================");
		String equation2 = "1 + 8 + 9 * 2";
		System.out.println("Equation : "+equation2);
		System.out.println("Actual : "+(1+8+9*2));
		String postfix2 = TreeExp.IntoPost(equation2);
		System.out.println("IntoPost : "+postfix2);
		Exp root2;
		root2 = TreeExp.makeExpTree(postfix2);
		System.out.println("Result : "+root2.eval());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root2);
		System.out.println("Print tree : ");
		TreeExp.printTree( root2, 0);
		System.out.println("=====================");
		String equation3 = "7*5+(8+9*2)";
		System.out.println("Equation : "+equation3);
		System.out.println("Actual : "+(7*5+(8+9*2)));
		String postfix3 = TreeExp.IntoPost(equation3);
		System.out.println("IntoPost : "+postfix3);
		Exp root3;
		root3 = TreeExp.makeExpTree(postfix3);
		System.out.println("Result : "+root3.eval());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root3);
		System.out.println("Print tree : ");
		TreeExp.printTree( root3, 0);
		System.out.println("=====================");
		String equation4 = "7*5+((8+9)*2)";
		System.out.println("Equation : "+equation4);
		System.out.println("Actual : "+(7*5+((8+9)*2)));
		String postfix4 = TreeExp.IntoPost(equation4);
		System.out.println("IntoPost : "+postfix4);
		Exp root4;
		root4 = TreeExp.makeExpTree(postfix4);
		System.out.println("Result : "+root4.eval());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root4);
		System.out.println("Print tree : ");
		TreeExp.printTree( root4, 0);
		System.out.println("=====================");
		String equation5 = "((5+6*2*(4+8)))*(2+2)";
		System.out.println("Equation : "+equation5);
		System.out.println("Actual : "+(((5+6*2*(4+8)))*(2+2)));
		String postfix5 = TreeExp.IntoPost(equation5);
		System.out.println("IntoPost : "+postfix5);
		Exp root5;
		root5 = TreeExp.makeExpTree(postfix5);
		System.out.println("Result : "+root5.eval());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root5);
		System.out.println("Print tree : ");
		TreeExp.printTree( root5, 0);
		System.out.println("=====================");
	}
}
