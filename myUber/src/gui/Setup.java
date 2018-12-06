package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Setup {
	
	public static void start() {
		JFrame myFrame =new JFrame("Setup");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setPreferredSize(new Dimension(1000,2000));
		
		
		
		JPanel description = new JPanel();
		description.add(new JLabel("Nous allons commencer par initier le nombre d'objets de notre système"));
		description.setPreferredSize(new Dimension(500, 120));
		
		
		
		JLabel customer = new JLabel("   Nombre de customer : ");
		JLabel standard = new JLabel("   Nombre de voitures Standard : ");
		JLabel van = new JLabel("   Nombre de voitures Van : ");
		JLabel berline = new JLabel("   Nombre de voitures Berline : ");
		
		JTextField nbrC = new JTextField("4", 4);
		JTextField nbrS = new JTextField("1", 4);
		JTextField nbrV = new JTextField("2", 4);
		JTextField nbrB = new JTextField("3", 4);
		
		JButton go = new JButton("Let's go !");
		go.addActionListener(new LancerProgram(nbrC, nbrS, nbrV, nbrB, myFrame));
		
		JPanel action = new JPanel();
		action.setPreferredSize(new Dimension(500,200));
		action.add(customer);
		action.add(nbrC);
		action.add(standard);
		action.add(nbrS);
		action.add(van);
		action.add(nbrV);
		action.add(berline);
		action.add(nbrB);
		action.add(go);
		
		JPanel global = new JPanel();
		global.add(description);
		global.add(action);
		myFrame.add(global);
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
}
