package deEn;

public class UnaryDiv extends AbstractUnary implements Unary {
final private int number;
	
	UnaryDiv(int n) {
		this.number = n;
	}
	
	@Override
	protected int action(int o) {
		return o / this.number;
	}
}
