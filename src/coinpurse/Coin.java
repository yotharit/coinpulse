package coinpurse;
/**
 * Coin and Value of its
 * @author Tharit Pongsaneh
 * 
 */
public class Coin implements Comparable,Valuable {
	
	/** variable use for coin class */
	private double value;
	private String currency = "Baht";

	/** Constructor of coin class with default currency */	
	Coin(double value) {
		this.value = value;
	}
	
	/** Constructor of coin class with specific currency */	
	Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	/** get value of the coin*/	
	@Override
	public double getValue() {
		return value;
	}
	
	/** get currency of the coin*/
	@Override
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * @return Information of the coin
	 */		
	@Override
	public String toString() {
		return value + "-" + currency ;
	}
	
	/**
	 * check if the coin is equal or not
	 * @return boolean same coin or not
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Coin other = (Coin) obj;
		if(value == other.value && currency.equalsIgnoreCase(other.currency)) return true;
		return false;
	}
	

	@Override
	public int compareTo(Object o) {
		Coin other = (Coin) o;
		if (value > other.value) return 1;
		if (value < other.value) return -1;
		return 0;
	}

	
}
