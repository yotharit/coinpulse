package coinpurse;
/**
 * Coin and Value of its
 * @author Tharit Pongsaneh
 * 
 */
public class Coin extends AbstractValuable{
	
	/** Constructor of coin class with default currency */	
	Coin(double value) {
		super(value);
	}
	
	/** Constructor of coin class with specific currency */	
	Coin(double value, String currency, String secondcurrency){
		super(value,currency,secondcurrency);
	}
	
	/**
	 * @return Information of the coin
	 */		
	@Override
	public String toString() {
		if(super.getValue()<1){
			return (super.getValue()*100)+ "-" + super.getSecondCurrency() + " coin";
		}
		else return super.getValue() + "-" + super.getCurrency() + " coin";
	}
}
