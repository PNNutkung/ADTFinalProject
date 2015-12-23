
public class Main {
	public static void main(String[] args) {
		System.out.println("========================= Project 2 ===========================");
		System.out.println("============== 5710546372 Pipatpol Tanavongchinda =============");
		String equation1 = "((8+9*(4+5*7+6))+3*5+4)";
		System.out.println("Equation : "+equation1);
		//System.out.println("Actual : "+((8+9*(4+5*7+6))+3*5+4));
		String postfix1 = TreeExp.IntoPost(equation1);
		System.out.println("IntoPost : "+postfix1);
		Exp root1;
		root1 = TreeExp.makeExpTree(postfix1);
		Visitor v = new Evaluator();
		System.out.println("Result : "+root1.accept(v));
		//System.out.println(root1.getLeft().getDatum());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root1);
		//System.out.println("Print tree : ");
		//TreeExp.printTree( root1, 0);
		System.out.println("=====================");
		String equation2 = "x*x+2";
		System.out.println("Equation : "+equation2);
		//System.out.println("Actual : "+((8+9*(4+5*7+6))+3*5+4));
		String postfix2 = TreeExp.IntoPost(equation2);
		System.out.println("IntoPost : "+postfix2);
		Exp root2;
		root2 = TreeExp.makeExpTree(postfix2);
		Visitor diff = new Diff();
		root2 = (Exp) root2.accept(diff);
		//System.out.println(root1.getLeft().getDatum());
		System.out.print("Inorder : ");
		TreeExp.inOrder(root2);
		//System.out.println("Print tree : ");
		//TreeExp.printTree( root1, 0);
		System.out.println("=====================");
		String equation3 = "(x*x) + (2*x) + 3";
		System.out.println("Equation : "+equation3);
		//System.out.println("Actual : "+((8+9*(4+5*7+6))+3*5+4));
		String postfix3 = TreeExp.IntoPost(equation3);
		System.out.println("IntoPost : "+postfix3);
		Exp root3;
		root3 = TreeExp.makeExpTree(postfix3);
		/*Visitor diff2 = new Diff();
		root3 = (Exp) root3.accept(diff);*/
		Visitor simplify = new Simplify();
		//Visitor mips = new MIPSAssemblyGeneration();
		root3 = (Exp) root3.accept(diff);
		System.out.print("diff = ");
		TreeExp.inOrder(root3);
		root3 = (Exp) root3.accept(simplify);
		//System.out.println(root1.getLeft().getDatum());
		System.out.print("Simplify : ");
		TreeExp.inOrder(root3);
		//System.out.println("Print tree : ");
		//TreeExp.printTree( root1, 0);
		System.out.println("=====================");

	}
}
