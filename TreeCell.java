public class TreeCell {
	private KINDS kind;
	private int data;	
	private TreeCell left, right;
	public TreeCell(KINDS kind,int x) {
		this.data= x;
		this.kind = kind;
	}
	public TreeCell(KINDS kind,int x, TreeCell lft, TreeCell rgt) {
		this.kind = kind;
		this.data = x;
		this.left = lft;
		this.right = rgt;
	}
	public int getDatum(){
		return this.data;
	}
	public void setDatum(int datum){
		this.data = datum;
	}
	public TreeCell getLeft(){
		return this.left;
	}
	public void setLeft(TreeCell lft){
		this.left = lft;
	}
	public TreeCell getRight(){
		return this.right;
	}
	public void setRight(TreeCell rgt){
		this.right = rgt;
	}
	public KINDS getKind(){
		return this.kind;
	}
	public boolean treeSearch(Object x, TreeCell node){
		if (node == null) return false;
		int obj = (int)x;
		if (node.data == obj) return true;
		if (node.getDatum() > obj) {
			return treeSearch(x, node.left);}
		else return treeSearch(x, node.right);

	}
	public static void preOrder (TreeCell root) {
		preOrderhelp(root);
		System.out.println();
	}

	private static void preOrderhelp (TreeCell node) {
		if (node == null) return;
		System.out.print((char)node.data + " ");
		preOrderhelp(node.left);
		preOrderhelp(node.right);
	}
	public static void inOrder (TreeCell root) {
		inOrderhelp(root);
		System.out.println();
	}

	private static void inOrderhelp (TreeCell node) {
		if (node == null) return;
		if(node.left != null)System.out.print("(");
		inOrderhelp(node.left);
		System.out.print((char)node.data + " ");
		inOrderhelp(node.right);
		if(node.right != null)System.out.print(")");
	}
	public static void postOrder (TreeCell root) {
		postOrderhelp(root);
		System.out.println();
	}

	private static void postOrderhelp (TreeCell node) {
		if (node == null) return;
		postOrderhelp(node.left);
		postOrderhelp(node.right);
		System.out.print((char)node.data + " ");
	}
	public static int eval(TreeCell root) {
		int left_result, right_result;
		if (root.getKind() == KINDS.NUMBER) return root.getDatum()-48;
		left_result = eval(root.left);
		right_result = eval(root.right);
		switch ((char)root.data) {
			case '+' : return left_result + right_result;
			case '*' : return left_result * right_result;
			case '-': return left_result - right_result;
			case '/': return left_result / right_result;
		}
		return root.getDatum();
	}

	public static TreeCell makeExpTree(String postfix) {
		final ListStack stack = new ListStack();
		for(int i = 0 ; i < postfix.length() ; ++i){
			char current = postfix.charAt(i);
			if( "+-*/".indexOf(current) != -1) {
				TreeCell right = (TreeCell) stack.pop();
				TreeCell left = (TreeCell) stack.pop();
				stack.push(new TreeCell(KINDS.OPERATOR,current,left,right));
			} else {
				stack.push(new TreeCell(KINDS.NUMBER,current,null,null));
			}
		}
		return (TreeCell) stack.peek();
	}
	public TreeCell insert(KINDS kind,int x, TreeCell T) {
		if(T == null) {
			T = new TreeCell(kind,x);
			return T;
		}else if (x == T.getDatum())
			return T;
		else if(x < T.getDatum() ) {
			T.left = insert(kind,x,T.left);
		}
		else if(x > T.getDatum()) {
			T.right = insert(kind,x,T.right);
		}
		return T;
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

	public static void printTree(TreeCell root, int level ) {
		if (root != null) {
			printTree(root.right, level+1);
			for (int i=0; i<level; i++) System.out.print("   ");
			System.out.println((char)root.data);
			System.out.println();
			printTree(root.left, level+1);
		}
	}
}
