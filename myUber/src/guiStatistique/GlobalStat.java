package guiStatistique;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myUber.MyUber;
import myUber.Statistics;

public class GlobalStat implements ActionListener {

	JFrame frame;
	public GlobalStat(JFrame frame) { this.frame = frame; }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel time = new JPanel();
		JPanel nbr = new JPanel();
		JPanel money = new JPanel();
		
		time.setPreferredSize(new Dimension(400,50));
		nbr.setPreferredSize(new Dimension(400,50));
		money.setPreferredSize(new Dimension(400,50));
		
		time.add(new JLabel("Le temps total de rides est de " + Double.toString(Statistics.totalTime(MyUber.bookOfRides))));
		nbr.add(new JLabel("Le nombre total de rides est de " + Double.toString(Statistics.totalNumberOfRides(MyUber.bookOfRides))));
		money.add(new JLabel("Les recettes totales sont de " + Double.toString(Statistics.totalRate(MyUber.bookOfRides))));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500,300));
		panel.add(time);
		panel.add(nbr);
		panel.add(money);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

}
