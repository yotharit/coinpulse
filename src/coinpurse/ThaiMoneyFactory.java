package coinpurse;

import java.util.Arrays;

public class ThaiMoneyFactory extends MoneyFactory {

	//Value_Contain contain all the available value of thai money
	private final double[] VALUE_CONTAIN = {0.25,0.5,1,2,5,10,20,50,100,500,1000};

	//The final currency
	private final String CURRENCY = "Baht";
	private final String SECOND_CURRENCY = "Satang";

	//static value for the next serialNumber
	private static long nextSerialNumber = 1000000;

	/**
	 * This method use to create Banknote and Coin and generate serial number to the bank
	 * @return Valuable of the money
	 */
	@Override
	public Valuable createMoney(double value) {
		if(isContain(value)){
			if(value>10) {
				nextSerialNumber++;
				long serialNumber = nextSerialNumber;
				Valuable bank = new BankNote(value,CURRENCY,serialNumber);
				return bank;
			}
			else {
				Valuable coin = new Coin(value,CURRENCY,SECOND_CURRENCY);
				return coin;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Use to check that is the value are contain within this country money value
	 * @param value 
	 * @return boolean refer to either is the value in the defaul country money value
	 */
	private boolean isContain(double value){
		for (double v : VALUE_CONTAIN){
			if(v==value){
				return true;
			}
		}
		return false;
	}

}
