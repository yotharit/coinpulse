package coinpurse;

public class BankNote extends AbstractValuable {
	
	private long serialNumber;
	
	public BankNote(double value, long serialNumber){
		super(value);
		this.serialNumber = serialNumber;
	}
	public BankNote(double value,String currency,long serialNumber){
		super(value,currency);
		this.serialNumber = serialNumber;
	}
	
	@Override
	public String toString(){
		return value + "-" + currency + " note" + "[" + serialNumber + "]";
	}
	
	public long getSerial(){
		return serialNumber;
	}
	
	

}
