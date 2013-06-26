package deEn;

public class UnarySubtract extends AbstractUnary implements Unary {
	final private int number;
	
	UnarySubtract(int n) {
		this.number = n;
	}
	
	@Override
	protected int action(int o) {
		return o - this.number;
	}
}
