package coinpurse;

public abstract class AbstractValuable implements Valuable {
	
	protected final String DEFAULT_CURRENCY = "Baht";
	protected final String SECOND_CURRENCY = "Satang";
	
	
	/** variable use for coin class */
	protected double value;
	protected String currency;
	protected String secondcurrency;
	protected String description;
	

	public AbstractValuable(double value){
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		this.secondcurrency = SECOND_CURRENCY;
	}
	public AbstractValuable(double value,String currency) {
		this.value = value;
		this.currency = currency;
	}

	public AbstractValuable(double value,String currency,String secondcurrency) {
		this.value = value;
		this.currency = currency;
		this.secondcurrency = secondcurrency;
	}

	/** get value of the coin*/
	public double getValue() {
		return value;
	}

	/** get currency of the coin*/
	public String getCurrency() {
		return currency;
	}
	
	public String getSecondCurrency() {
		return secondcurrency;
	}

	/**
	 * check if the coin is equal or not
	 * @return boolean same coin or not
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Valuable other = (Valuable) obj;
		if(getValue() == other.getValue() && currency.equalsIgnoreCase(other.getCurrency())) return true;
		return false;
	}

	public int compareTo(Object obj) {
		Valuable other = (Valuable) obj;
		if(getCurrency()==null){
			if (getValue() > other.getValue()) return 1;
			if (getValue() < other.getValue()) return -1;
		}
		if(getCurrency().compareToIgnoreCase(other.getCurrency())==0){
			if (getValue() > other.getValue()) return 1;
			if (getValue() < other.getValue()) return -1;
		}
		return getCurrency().compareToIgnoreCase(other.getCurrency());

	}

}