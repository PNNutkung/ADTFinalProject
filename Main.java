import java.util.Scanner;

public class Main {
	static Visitor evaluator = new Evaluator();
	static Visitor differentiater = new Diff();
	static Visitor simplifier = new Simplify();
	static Visitor mipsGenerator = new MIPSAssemblyGeneration();
	public static void generateMIPS(String equation){
		System.out.println("MIPS Generated: ");
		String postfix = TreeExp.IntoPost(equation);
		Exp root;
		root = TreeExp.makeExpTree(postfix);
		root = (Exp) root.accept(mipsGenerator);
		TreeExp.inOrder(root);
		System.out.println();
	}
	public static void differentiateAndSimplify(String equation){
		String postfix = TreeExp.IntoPost(equation);
		Exp root;
		root = TreeExp.makeExpTree(postfix);
		root = (Exp) root.accept(differentiater);
		root = (Exp) root.accept(simplifier);
		System.out.print("Differentaited and simplified: ");
		TreeExp.inOrder(root);
		System.out.println();
	}
	public static void simplify(String equation){
		String postfix = TreeExp.IntoPost(equation);
		Exp root;
		root = TreeExp.makeExpTree(postfix);
		root = (Exp) root.accept(simplifier);
		System.out.print("Simplified: ");
		TreeExp.inOrder(root);
		System.out.println();
	}
	public static void evaluate(String equation){
		String postfix = TreeExp.IntoPost(equation);
		Exp root;
		root = TreeExp.makeExpTree(postfix);
		System.out.println("Evaluated: "+root.accept(evaluator));
		System.out.println();
	}
	public static void differentiate(String equation){
		String postfix = TreeExp.IntoPost(equation);
		Exp root;
		root = TreeExp.makeExpTree(postfix);
		root = (Exp) root.accept(differentiater);
		System.out.print("Differentaited: ");
		TreeExp.inOrder(root);
		System.out.println();
	}
	public static boolean isEND(String s){
		return s.equals("END");
	}
	public static void main(String[] args) {
		System.out.println("======================== FinalProject =========================");
		System.out.println("============== 5710546372 Pipatpol Tanavongchinda =============");
		while(true){
			System.out.print("Please enter your equation(Type \"END\" to exit).: ");
			Scanner input = new Scanner(System.in);
			String equation = input.nextLine();
			if(isEND(equation)) {
				System.out.println("Thank you for using.");
				System.out.println("======================= End of program ========================");
				break;
			}
			while(true){
				System.out.println("Select mode:");
				System.out.printf("%d \t%s\n%d \t%s\n%d \t%s\n%d \t%s\n%d \t%s\n%d \t%s\n",
						1,"Evaluate.",2,"Differentiate.",3,"Simplify.",4,"Differentiate and simplify.",
						5,"Generate MIPS Assembly.",6,"Input new equation.");
				System.out.print("Enter: ");
				int choice = input.nextInt();
				if(choice == 1){
					evaluate(equation);
				}
				else if(choice == 2){
					differentiate(equation);
				}
				else if(choice == 3){
					simplify(equation);
				}
				else if(choice == 4){
					differentiateAndSimplify(equation);
				}
				else if(choice == 5){
					generateMIPS(equation);
				}
				else if(choice == 6){
					break;
				}
				else {
					System.out.println("Please enter only 1 to 6.\n");
					continue;
				}
			}
		}
	}
}
