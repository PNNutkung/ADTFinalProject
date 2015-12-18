
public class TreeExp {
	public static void preOrder (Exp root) {
		preOrderhelp(root);
		System.out.println();
	}

	private static void preOrderhelp (Exp node) {
		if (node == null) return;
		System.out.print(node.getDatum() + " ");
		preOrderhelp(node.getLeft());
		preOrderhelp(node.getRight());
	}
	public static void inOrder (Exp root) {
		inOrderhelp(root);
		System.out.println();
	}

	private static void inOrderhelp (Exp node) {
		if (node == null) return;
		if(node.getLeft() != null)System.out.print("(");
		inOrderhelp(node.getLeft());
		System.out.print(node.getDatum() /*+ " "*/);
		inOrderhelp(node.getRight());
		if(node.getRight() != null)System.out.print(")");
	}
	public static void postOrder (Exp root) {
		postOrderhelp(root);
		System.out.println();
	}

	private static void postOrderhelp (Exp node) {
		if (node == null) return;
		postOrderhelp(node.getLeft());
		postOrderhelp(node.getRight());
		System.out.print(node.getDatum() + " ");
	}

	public static Exp makeExpTree(String postfix) {
		final ListStack stack = new ListStack();
		for(int i = 0 ; i < postfix.length() ; ++i){
			char current = postfix.charAt(i);
			if( "+-*/".indexOf(current) != -1) {
				Exp right = (Exp) stack.pop();
				Exp left = (Exp) stack.pop();
				switch(current) {
					case '+': stack.push(new PlusExp(left,right)); break;
					case '-': stack.push(new MinusExp(left,right)); break;
					case '*': stack.push(new TimesExp(left,right)); break;
				}
			} else {
				stack.push(new NumExp(current+""));
			}
		}
		return (Exp) stack.peek();
	}

	public static String IntoPost(String infix) {
		String postfix = new String();
		ListStack stack = new ListStack();
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
			printTree(root5.getRight(), level+1);
			for (int i=0; i<level; i++) System.out.print("  ");
			System.out.println(root5.getDatum());
			System.out.println();
			printTree(root5.getLeft(), level+1);
		}
	}
}
