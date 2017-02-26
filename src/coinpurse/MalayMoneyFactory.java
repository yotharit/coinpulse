package coinpurse;

import java.util.Arrays;

public class MalayMoneyFactory extends MoneyFactory {

	private final double[] VALUE_CONTAIN = {0.05,0.10,0.20,0.50,1,2,5,10,20,50,100};
	private String MAIN_CURRENCY = "Ringgit";
	private String SECOND_CURRENCY = "Sen";

	private static long nextSerialNumber = 1000000;


	@Override
	public Valuable createMoney(double value) {
		if(isContain(value)){
			if(value>=1) {
				nextSerialNumber++;
				long serialNumber = nextSerialNumber;
				Valuable bank = new BankNote(value,MAIN_CURRENCY,serialNumber);
				return bank;
			}
			else {
				Valuable coin = new Coin(value,MAIN_CURRENCY,SECOND_CURRENCY);
				return coin;
			}
		}
		throw new IllegalArgumentException();
	}

	private boolean isContain(double value){
		for (double v : VALUE_CONTAIN){
			if(v==value){
				return true;
			}
		}
		return false;	
	}

}
