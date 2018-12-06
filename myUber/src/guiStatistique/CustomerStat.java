
package guiStatistique;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myUber.Customer;
import myUber.MyUber;
import myUber.Statistics;

public class CustomerStat implements ActionListener {

	JFrame frame;
	public CustomerStat(JFrame frame) { this.frame = frame; }


	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel time = new JPanel();
		JPanel money = new JPanel();
		JPanel nbrRide = new JPanel();
		time.setPreferredSize(new Dimension(400,250));
		money.setPreferredSize(new Dimension(400,250));
		nbrRide.setPreferredSize(new Dimension(400,250));
		
		JLabel timeLabel = new JLabel("Le classement des Customers par temps cumulé : ");
		JLabel moneyLabel = new JLabel("Le classement des Customers par argent dépensé : ");
		JLabel nbrRideLabel = new JLabel("Le classement des Customers par nombre de trajets : ");
		timeLabel.setPreferredSize(new Dimension(400,30));
		moneyLabel.setPreferredSize(new Dimension(400,30));
		nbrRideLabel.setPreferredSize(new Dimension(400,30));
		
		time.add(timeLabel);
		money.add(moneyLabel);
		nbrRide.add(nbrRideLabel);
		
		ArrayList<Customer> tim = Statistics.customersSortedByTime(MyUber.bookOfRides);
		ArrayList<Customer> mon = Statistics.customersSortedByTotalRate(MyUber.bookOfRides);
		ArrayList<Customer> nbr = Statistics.customersSortedByFrequence(MyUber.bookOfRides);
		
		for (int i = 0; i < tim.size(); i++) {
			JPanel panelTim = new JPanel();
			JPanel panelMon = new JPanel();
			JPanel panelNbr = new JPanel();
			panelTim.setPreferredSize(new Dimension(400,30));
			panelMon.setPreferredSize(new Dimension(400,30));
			panelNbr.setPreferredSize(new Dimension(400,30));
			
			panelTim.add(new JLabel("Le " + Integer.toString(i+1) + "e est le customer " + tim.get(i).getId()));
			panelMon.add(new JLabel("Le " + Integer.toString(i+1) + "e est le customer " + mon.get(i).getId()));
			panelNbr.add(new JLabel("Le " + Integer.toString(i+1) + "e est le customer " + nbr.get(i).getId()));
			
			time.add(panelTim);
			money.add(panelMon);
			nbrRide.add(panelNbr);
			
		}
		
		//fin
	    JPanel panel = new JPanel ();
	    panel.add(time);
	    panel.add(nbrRide);
	    panel.add(money);
	    frame.setContentPane(panel);
	    frame.setVisible(true);
	}

}
