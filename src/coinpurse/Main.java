package coinpurse;

public class Main {

	private static int CAPACITY = 10;

	public static void main(String[] args) {
		Purse purse = new Purse( 10 );
		ConsoleDialog console = new ConsoleDialog( purse );
		console.run();
	}
}
