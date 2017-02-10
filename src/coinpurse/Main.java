package coinpurse;

public class Main {
	public static void main(String[] args) {
		Purse purse = new Purse( 3 );
		System.out.println(purse.getBalance( )); 
		System.out.println(purse.count( ));
		System.out.println(purse.isFull( ));
		System.out.println(purse.insert(new Coin(5))); 
		System.out.println(purse.insert(new Coin(10))); 
		System.out.println(purse.insert(new Coin(0))); 		
		System.out.println(purse.insert(new Coin(1))); 		
		System.out.println(purse.insert(new Coin(5))); 
		System.out.println(purse.count( )); 
		System.out.println(purse.isFull( )); 
		System.out.println(purse.getBalance()); 
		System.out.println(purse.toString()); 
		purse.withdraw(12); 
		purse.withdraw(11);
	}
}
