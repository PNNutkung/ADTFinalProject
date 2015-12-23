
public class MIPSAssemblyGeneration implements Visitor {

	@Override
	public Object visit(PlusExp n) {
		n.gete1().accept(this);
		System.out.println("li $a0 7");
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.gete2().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("add $a0 $t1 $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	@Override
	public Object visit(MinusExp n) {
		n.gete1().accept(this);
		System.out.println("li $a0 7");
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.gete2().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("sub $a0 $t1 $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	@Override
	public Object visit(TimesExp n) {
		n.gete1().accept(this);
		System.out.println("li $a0 7");
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.gete2().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("mult $t1 $a0");
		System.out.println("mfhi $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	@Override
	public Object visit(DivisionExp n) {
		n.gete1().accept(this);
		System.out.println("li $a0 7");
		System.out.println("sw $a0 0($sp)");
		System.out.println("addiu $sp $sp -4");
		n.gete2().accept(this);
		System.out.println("lw $t1 4($sp)");
		System.out.println("div $t1 $a0");
		System.out.println("mflo $a0");
		System.out.println("addiu $sp $sp 4");
		return null;
	}

	@Override
	public Object visit(NumExp n) {
		System.out.println("li $a0 "+n.getDatum());
		return null;
	}

	@Override
	public Object visit(VarExp n) {
		System.out.println("li $a0 "+n.eval());
		return null;
	}

}
