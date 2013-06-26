package deEn;

import java.awt.Font;

import javax.swing.*;

import java.util.Date;

public class Main1 extends JFrame {
	
	private static JLabel label;

	public Main1()
    {
            super("Jevno by maweki");
            setSize(400,200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            label = new JLabel("", SwingConstants.CENTER);
            this.add(label);
            label.setSize(400, 200);
            label.setFont(new Font("Arial", 0, 35));
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main1 g = new Main1();
		
		final int depth = 17;
		final int start = (int) new Date().getTime() & 4095;
		
		
		label.setText("Building Decision Tree");
		
		UnaryFactory fac = new UnaryFactory();
		
		Unary bestSpecimen = fac.buildTree(depth);
		int bestScore = fac.score(bestSpecimen, start);
		
		while (bestScore > 0) {
			Unary newSpecimen = bestSpecimen.clone();
			newSpecimen = fac.mutateTree(newSpecimen, 0.1);
			int newScore = fac.score(newSpecimen, start);
			if (newScore < bestScore) {
				bestScore = newScore;
				bestSpecimen = newSpecimen;
			}
		}
		
		label.setText("Calculating Decision");
		fac.randomize(bestSpecimen);
		int result = fac.resolve(bestSpecimen, (int) new Date().getTime() & 4095);
		
		if ((result & 1) == 1) {
			label.setText("Yes");
		}
		else {
			label.setText("No");
		}
		
	}

}
