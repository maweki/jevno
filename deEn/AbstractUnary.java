package deEn;

import java.util.Random;

public abstract class AbstractUnary implements Unary, Cloneable {
	
	private Unary current = null;
	public Unary left = null;
	public Unary right = null;
	
	final public Unary setLeft(Unary left) {
		this.left = left;
		return left;
	}
	
	final public Unary setRight(Unary right) {
		this.right = right;
		return right;
	}
	
	final private Unary getNext() {
		if (this.current == null) {
			this.current = this.left;
			return this.current;
		}
		if (this.current == this.left) {
			this.current = this.right;
			return this.current;
		}
		else {
			this.current = this.left;
			return this.current;
		}
	}
	
	final public void setRandomPath(Random r) {
		if (r.nextBoolean()) {
			if (this.getNext() != null) {
				this.current.setRandomPath(r);
			}
		}
		else {
			if (this.current != null) {
				this.current.setRandomPath(r);
			}
		}
	}

	@Override
	public Unary clone() {
		 Unary n;
		try {
			n = (Unary)super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
		if (this.getLeft() != null) {
			n.setLeft(this.getLeft().clone());
		}
		if (this.getRight() != null) {
			n.setRight(this.getRight().clone());
		}
		return n;
	}

	@Override
	public Unary getLeft() {
		return this.left;
	}

	@Override
	public Unary getRight() {
		return this.right;
	}

	protected int action(int o) {
		return o;
	}
	
	final public int operate(int number, int depth) {
		if (depth > 1) {
			return this.action(this.getNext().operate(number, depth - 1));
		}
		else {
			return this.action(number);
		}
	}
	
	final public boolean hasChildren() {
		return ((this.left != null) && (this.right != null));
	}

	@Override
	public String toString() {
		return getClass() + " [left=" + left + ", right=" + right
				+ "]";
	}

	@Override
	public int depth() {
		if (this.left != null) {
			return this.left.depth() + 1;
		}
		else {
			return 1;
		}
	}
}

