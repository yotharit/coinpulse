package coinpurse.gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import coinpurse.Purse;

public class PurseObserver extends JFrame implements Observer {
	
	private JPanel panel;
	private JLabel label;
	
	public PurseObserver(){
		super("Purse Balance");
	}
	
	public void run(){
		initComponent();
		this.setVisible(true);
	}
	
	private void initComponent() {
		panel = new JPanel();
		label = new JLabel("0 Baht");
		panel.add(label);
		this.add(panel);
		this.pack();
		label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
	}

	@Override
	public void update(Observable subject, Object info) {
		
		if(subject instanceof Purse){
			Purse purse = (Purse) subject;
			double balance = purse.getBalance();
			label.setText(balance + " Baht");
		}
	
	}

}
