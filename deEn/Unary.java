package deEn;

import java.util.Random;

public interface Unary extends Cloneable {
	
	public Unary setLeft(Unary left);
	public Unary setRight(Unary right);
	
	public Unary getLeft();
	public Unary getRight();
	
	public void setRandomPath(Random r);
	
	int operate(int number, int depth);
	
	boolean hasChildren();
	
	public int depth();
	public Unary clone();
	
}
