package coinpurse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import coinpurse.gui.PurseObserver;
import coinpurse.gui.PurseStatusObserver;
import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;

public class Main {

	private static int CAPACITY = 10;

	public static void main(String[] args) {
		//To use purse.properties required the following code
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory instance = null ;
		try {
			instance = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce) {
			//the object could not be cast tow type MoneyFactory
			System.out.println(factoryclass+" is not type MoneyFactory");
		}
		catch (Exception ex) {
			//any other exception mean we could not create an object
			System.out.println("Error creating MoneyFactory"+ex.getMessage());
		}
		//if no factory then quit
		if (instance==null) System.exit(1);
		
		//To Run the code
		Purse purse = new Purse( CAPACITY );
		PurseObserver observer = new PurseObserver();
		PurseStatusObserver statusobserver = new PurseStatusObserver();
		purse.addObserver(statusobserver);
		purse.addObserver(observer);
		ConsoleDialog console = new ConsoleDialog( purse );
		GreedyWithdraw greedyStrategy = new GreedyWithdraw();
		RecursiveWithdraw recursiveStrategy = new RecursiveWithdraw();
		purse.setWithdrawStrategy(recursiveStrategy);
		observer.run();
		statusobserver.run();
		console.run();
		}
}
