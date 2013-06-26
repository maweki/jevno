package deEn;

public class UnaryMultiply extends AbstractUnary implements Unary {
	final private int number;
	
	UnaryMultiply(int n) {
		this.number = n;
	}
	
	@Override
	protected int action(int o) {
		return o * this.number;
	}
}
