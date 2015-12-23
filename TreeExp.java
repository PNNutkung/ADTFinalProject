import java.util.Stack;
public class TreeExp {
	public static void preOrder (Exp root) {
		preOrderhelp(root);
		System.out.println();
	}

	private static void preOrderhelp (Exp node) {
		if (node == null) return;
		System.out.print(node.getDatum() + " ");
		preOrderhelp(node.gete1());
		preOrderhelp(node.gete2());
	}
	public static void inOrder (Exp root) {
		inOrderhelp(root);
		System.out.println();
	}

	private static void inOrderhelp (Exp node) {
		if (node == null) return;
		if(node.gete1() != null)System.out.print("(");
		inOrderhelp(node.gete1());
		System.out.print(node.getDatum() /*+ " "*/);
		inOrderhelp(node.gete2());
		if(node.gete2() != null)System.out.print(")");
	}
	public static void postOrder (Exp root) {
		postOrderhelp(root);
		System.out.println();
	}

	private static void postOrderhelp (Exp node) {
		if (node == null) return;
		postOrderhelp(node.gete1());
		postOrderhelp(node.gete2());
		System.out.print(node.getDatum() + " ");
	}

	public static Exp makeExpTree(String postfix) {
		final Stack<Exp> stack = new Stack<Exp>();
		for(int i = 0 ; i < postfix.length() ; ++i){
			char current = postfix.charAt(i);
			if( "+-*/".indexOf(current) != -1) {
				Exp right = (Exp) stack.pop();
				Exp left = (Exp) stack.pop();
				switch(current) {
					case '+': stack.push(new PlusExp(left,right)); break;
					case '-': stack.push(new MinusExp(left,right)); break;
					case '*': stack.push(new TimesExp(left,right)); break;
					case '/': stack.push(new DivisionExp(left,right)); break;
				}
			} else {
				if(current == 'x'){
					stack.push(new VarExp("x"));
				}
				else {
					stack.push(new NumExp(current+""));
				}
			}
		}
		return (Exp) stack.peek();
	}

	public static String IntoPost(String infix) {
		String postfix = new String();
		Stack stack = new Stack();
		char current;
		for(int i = 0; i < infix.length(); ++i){
			current = infix.charAt(i);
			if(Character.isLetterOrDigit(current)){
				postfix += current;
			}
			else if( current == '('){
				stack.push(current);
			} 
			else if ( "+-*/".indexOf(current) != -1 ) {
				if( "+-".indexOf(current) != -1 ) {
					while( !stack.isEmpty() && ( (char)stack.peek() != '+' || (char)stack.peek() != '-') ) {
						if((char)stack.peek() == '('){
							break;
						}
						else postfix += stack.pop();
					}
					stack.push(current);
				} 
				else if ( "*/".indexOf(current) != -1 ) {
					while( !stack.isEmpty() && ( (char)stack.peek() != '+' || (char)stack.peek() != '-' || (char)stack.peek() != '*' || (char)stack.peek() != '/') ) {
						if((char)stack.peek() == '('){
							break;
						}
						else if((char) stack.peek() == '*' || (char)stack.peek() == '/') postfix += stack.pop();
						else break;
					}
					stack.push(current);
				}
				else stack.push(current);
			}
			else if ( current == ')') {
				while(!stack.isEmpty()) {
					if ( (char)stack.peek() == '(') {
						stack.pop();
						break;
					}
					else postfix += stack.pop();
				}
			}
		}
		while(!stack.isEmpty()){
			postfix += stack.pop();
		}
		return postfix;
	}

	public static void printTree(Exp root5, int level ) {
		if (root5 != null) {
			printTree(root5.gete2(), level+1);
			for (int i=0; i<level; i++) System.out.print("  ");
			System.out.println(root5.getDatum());
			System.out.println();
			printTree(root5.gete1(), level+1);
		}
	}
}
