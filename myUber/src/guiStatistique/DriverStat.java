package guiStatistique;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myUber.Driver;
import myUber.MyUber;
import myUber.Statistics;

public class DriverStat implements ActionListener {

	JFrame frame;
	public DriverStat(JFrame frame) { this.frame = frame; }


	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel appreciation = new JPanel();
		JPanel time = new JPanel();
		JPanel money = new JPanel();
		JPanel nbrRide = new JPanel();
		appreciation.setPreferredSize(new Dimension(400,250));
		time.setPreferredSize(new Dimension(400,250));
		money.setPreferredSize(new Dimension(400,250));
		nbrRide.setPreferredSize(new Dimension(400,250));
		
		JLabel appreciationLabel = new JLabel("Le classement des Drivers par notes obtenues : ");
		JLabel timeLabel = new JLabel("Le classement des Drivers par temps cumulé : ");
		JLabel moneyLabel = new JLabel("Le classement des Drivers par argent gagné : ");
		JLabel nbrRideLabel = new JLabel("Le classement des Drivers par nombre de trajets : ");
		appreciationLabel.setPreferredSize(new Dimension(400,30));
		timeLabel.setPreferredSize(new Dimension(400,30));
		moneyLabel.setPreferredSize(new Dimension(400,30));
		nbrRideLabel.setPreferredSize(new Dimension(400,30));
		
		appreciation.add(appreciationLabel);
		time.add(timeLabel);
		money.add(moneyLabel);
		nbrRide.add(nbrRideLabel);
		
		ArrayList<Driver> app = Statistics.driversSortedByEvaluation(MyUber.bookOfRides);
		ArrayList<Driver> tim = Statistics.driversSortedByTime(MyUber.bookOfRides);
		ArrayList<Driver> mon = Statistics.driversSortedByRate(MyUber.bookOfRides);
		ArrayList<Driver> nbr = Statistics.driversSortedByNbrRides(MyUber.bookOfRides);
		
		for (int i = 0; i < app.size(); i++) {
			JPanel panelApp = new JPanel();
			JPanel panelTim = new JPanel();
			JPanel panelMon = new JPanel();
			JPanel panelNbr = new JPanel();
			panelApp.setPreferredSize(new Dimension(400,30));
			panelTim.setPreferredSize(new Dimension(400,30));
			panelMon.setPreferredSize(new Dimension(400,30));
			panelNbr.setPreferredSize(new Dimension(400,30));
			
			panelApp.add(new JLabel("Le " + Integer.toString(i+1) + "e est le driver " + app.get(i).getId()));
			panelTim.add(new JLabel("Le " + Integer.toString(i+1) + "e est le driver " + tim.get(i).getId()));
			panelMon.add(new JLabel("Le " + Integer.toString(i+1) + "e est le driver " + mon.get(i).getId()));
			panelNbr.add(new JLabel("Le " + Integer.toString(i+1) + "e est le driver " + nbr.get(i).getId()));
			
			appreciation.add(panelApp);
			time.add(panelTim);
			money.add(panelMon);
			nbrRide.add(panelNbr);
			
		}
		
		//fin
	    JPanel panel = new JPanel ();
	    panel.add(appreciation);
	    panel.add(time);
	    panel.add(nbrRide);
	    panel.add(money);
	    frame.setContentPane(panel);
	    frame.setVisible(true);
	}

}
