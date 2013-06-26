package deEn;

import java.util.Random;

public class UnaryFactory {
	private Random randGen;
	
	UnaryFactory() {
		this.randGen = new Random();
	}
	
	public Unary newUnary() {
		switch (this.randGen.nextInt(4)) {
			case 0: return new UnaryAdd(this.randGen.nextInt(100));
			case 1: return new UnarySubtract(this.randGen.nextInt(100));
			case 2: return new UnaryMultiply(this.randGen.nextInt(20)+1);
			case 3: return new UnaryDiv(this.randGen.nextInt(20)+1);
		}
		return new UnaryIdentity();
	}
	
	public Unary buildTree(int depth) {
		if (depth > 1) {
			Unary ret = this.newUnary();
			ret.setLeft(this.buildTree(depth - 1));
			ret.setRight(this.buildTree(depth - 1));
			return ret;
		}
		else {
			return this.newUnary();
		}
	}
	
	public Unary mutateTree(Unary tree, double mutationRate) {
		if (tree == null) {
			return null;
		}
		if (this.randGen.nextDouble() < mutationRate) {
			return this.buildTree(tree.depth());
		}
		else {
			tree.setLeft(this.mutateTree(tree.getLeft(), mutationRate));
			tree.setRight(this.mutateTree(tree.getLeft(), mutationRate));
			return tree;
		}
	}
	
	public int score(Unary tree, int start) {
		int depth = tree.depth();
		int result = 0;
		for (int i = 1; i <= (int) Math.pow(2, depth-1); i++) {
			int val = tree.operate(start, depth);
			if ((val & 1) == 1) {
				result++;
			}
			else {
				result--;
			}
		}
		return Math.abs(result);
	}
	
	public int resolve(Unary tree, int start) {
		int depth = tree.depth();
		return tree.operate(start, depth);
	}
	
	public void randomize(Unary tree) {
		tree.setRandomPath(this.randGen);
	}
}
