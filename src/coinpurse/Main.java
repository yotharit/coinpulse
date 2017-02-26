package coinpurse;
import java.util.ResourceBundle;
import java.util.Date;

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
			//the object could not be cast to type MoneyFactory
			System.out.println(factoryclass+" is not type MoneyFactory");
		}
		catch (Exception ex) {
			//any other exception mean we could not create an object
			System.out.println("Error creating MoneyFactory"+ex.getMessage());
		}
		//if no factory then quit
		if (instance==null) System.exit(1);
		
		//To Run the code
		Purse purse = new Purse( 10 );
		ConsoleDialog console = new ConsoleDialog( purse );
		console.run();
//				MoneyFactory factory = MoneyFactory.getInstance();
//				Valuable m = factory.createMoney(0.25);
//				System.out.println(m.toString());
//				Valuable m2 = factory.createMoney("100.0");
//				System.out.println(m2.toString());
//				
	}
}
