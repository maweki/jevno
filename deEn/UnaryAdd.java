package deEn;

public class UnaryAdd extends AbstractUnary implements Unary {
	final private int number;
	
	UnaryAdd(int n) {
		this.number = n;
	}
	
	@Override
	protected int action(int o) {
		return o + this.number;
	}
}
