package coinpurse;

public interface Valuable extends Comparable<Object> {
	
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of the object
	 */
	
	public double getValue();
	
	/**
	 * Get the monetary currency of this object, in its own currency.
	 * @return the currency of the object
	 */
	public String getCurrency();
	
	/**
	 * Return String
	 * @return value of the object
	 */
	public String toString();
	
	/**
	 * 
	 * @param object
	 * @return boolean object equals or not
	 */
	public boolean equals(Object object);
	
	public int compareTo(Object obj);
}
