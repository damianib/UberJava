package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import myUber.MyUber;

public class LancerProgram implements ActionListener {

	JTextField nbrC;
	JTextField nbrS;
	JTextField nbrV;
	JTextField nbrB;
	JFrame frame;
	
	public LancerProgram(JTextField nbrC2, JTextField nbrS2, JTextField nbrV2, JTextField nbrB2, JFrame frame) {
		this.nbrC = nbrC2;
		this.nbrS = nbrS2;
		this.nbrV = nbrV2;
		this.nbrB = nbrB2;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyUber.setup(Integer.parseInt(nbrS.getText()), Integer.parseInt(nbrV.getText()), Integer.parseInt(nbrB.getText()), Integer.parseInt(nbrC.getText()));
		FramePrincipale.lancer();
		frame.setVisible(false);
		
	}

}
