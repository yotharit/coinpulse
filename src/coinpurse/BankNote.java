package coinpurse;

public class BankNote implements Valuable {
	
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	public BankNote(double value){
		this.value = value;
		this.currency = "Baht";
		this.serialNumber = nextSerialNumber;

	}
	public BankNote(double value,String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
	}
	
	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return currency;
	}
	
	@Override
	public String toString(){
		return value + "-" + currency + " note" + "[" + serialNumber + "]";
	}
	
	public long getSerial(){
		return serialNumber;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		BankNote other = (BankNote) obj;
		if(value == other.value && currency.equalsIgnoreCase(other.currency)) return true;
		return false;
	}
	
	

}
