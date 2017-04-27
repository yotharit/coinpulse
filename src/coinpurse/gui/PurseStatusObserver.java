package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import coinpurse.Purse;

public class PurseStatusObserver extends JFrame implements Observer {

	private JLabel label;
	private JPanel panel;
	private JProgressBar progress;

	public PurseStatusObserver() {
		super("Purse Status Observer");
	}

	public void run() {
		initcomponent();
		this.setVisible(true);
	}

	private void initcomponent() {
		label = new JLabel("Empty");
		progress = new JProgressBar(0,10);
		panel = new JPanel();
		panel.add(label);
		panel.add(progress);
		this.add(panel);
		this.pack();

	}

	@Override
	public void update(Observable subject, Object info) {

		if(subject instanceof Purse) {
			Purse purse = (Purse) subject;
			double size = purse.count();
			
			if(size != 0 && size != purse.getCapacity()){
				label.setText(""+size+" %");
			}
			else if(size == 0){
				label.setText("Empty");
			}
			else if(purse.isFull()){
				label.setText("Full");
			}
			System.out.println(size);
			progress.setValue((int)size);

		}

	}

}
